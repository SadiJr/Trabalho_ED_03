
public class ArvoreAVL {
	private No raiz;

	public ArvoreAVL() {
		raiz = null;
	}
	
	public void insere(int dado) throws Exception {
		if(raiz == null) {
			raiz = new No(dado);
		}else {
			insere(dado, raiz);
		}
	}
		
	private void insere(int dado, No raiz) throws Exception {
		
		if(dado < raiz.getDado()) {
			
			if(raiz.getFilhoEsquerdo() == null) {
				raiz.setFilhoEsquerdo(new No(dado));
			}else {
				insere(dado, raiz.getFilhoEsquerdo());
			}
			raiz.setAltura(raiz.getAltura() - 1);
			balanceamento(raiz);
		}else if(dado > raiz.getDado()) {
			
			if(raiz.getFilhoDireito() == null) {
				raiz.setFilhoDireito(new No(dado));
			}else {
				insere(dado, raiz.getFilhoDireito());
			}
			raiz.setAltura(raiz.getAltura() + 1);
			balanceamento(raiz);
		}else {
			throw new Exception("O dado já existe na árvore!");
		}
	}
	
	public void exclui(int dado) throws Exception {
		exclui(dado, raiz);
	}
	
	private void exclui(int dado, No raiz) throws Exception {
		if(raiz == null) {
			throw new Exception("O dado não consta na árvore!");
		}
		
		if(raiz.getDado() == dado) {
			if(possuiDoisFilhos(raiz)) {
				No novaRaiz = getAntecessorImediato(raiz);
				No subArvoreEsquerda = raiz.getFilhoEsquerdo();
				No subArvoreDireita = raiz.getFilhoDireito();
				raiz = novaRaiz;
				raiz.setFilhoDireito(subArvoreDireita);
				raiz.setFilhoEsquerdo(subArvoreEsquerda);
			}else {
				No novaRaiz = queFilhoPossui(raiz);
				No subArvoreEsquerda = raiz.getFilhoEsquerdo();
				No subArvoreDireita = raiz.getFilhoDireito();
				raiz = novaRaiz;
				raiz.setFilhoDireito(subArvoreDireita);
				raiz.setFilhoEsquerdo(subArvoreEsquerda);
			}
			//Lembrar de fazer a verificação do balanceamento
		}else {
			if(dado > raiz.getDado()) {
				exclui(dado, raiz.getFilhoDireito());
			}else {
				exclui(dado, raiz.getFilhoEsquerdo());
			}
		}
	}
	
	private boolean possuiDoisFilhos(No raiz) {
		if(raiz.getFilhoDireito() != null && raiz.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	
	private No queFilhoPossui(No raiz) {
		if(raiz.getFilhoDireito() != null) {
			return raiz.getFilhoDireito();
		}
		return raiz.getFilhoEsquerdo();
	}
	
	private No getAntecessorImediato(No raiz) {
		No novaRaiz = null;
		if(raiz.getFilhoDireito().getFilhoDireito() == null) {
			novaRaiz = raiz.getFilhoDireito();
			if(raiz.getFilhoDireito().getFilhoEsquerdo() != null) {
				raiz.setFilhoDireito(raiz.getFilhoDireito().getFilhoEsquerdo());
				novaRaiz.setFilhoEsquerdo(null);
			}else {
				raiz.setFilhoDireito(null);
			}
			//raiz.setAltura(raiz.getAltura() - 1);
			return novaRaiz;
		}else {
			return getAntecessorImediato(raiz.getFilhoDireito());
		}
	}
	
	public boolean busca(int dado) {
		return busca(dado, raiz);
	}
	
	private boolean busca(int dado, No raiz) {
		if(raiz == null) {
			return false;
		}
		
		if(raiz.getDado() == dado) {
			return true;
		}
		
		if(dado > raiz.getDado()) {
			return busca(dado, raiz.getFilhoDireito());
		}else {
			return busca(dado, raiz.getFilhoEsquerdo());
		}
	}
	
	private void balanceamento(No no) {
		if(no.getAltura() == -2) {
			if(raiz.getFilhoEsquerdo().getAltura() == -1) {
				giroCompletoEsquerda(no);
			}else {
				giroParcialEsquerda(no);
				giroCompletoEsquerda(no);
			}
		}else if(no.getAltura() == 2) {
			if(no.getFilhoDireito().getAltura() == -1) {
				giroParcialDireita(no);
				giroCompletoDireita(no);
			}else {
				giroCompletoDireita(no);
			}
		}
	}
	
	private void giroCompletoEsquerda(No no) {
		No filhoDireito = no;
		filhoDireito.setAltura(0);
		No filhoEsquerdo = no.getFilhoEsquerdo().getFilhoEsquerdo();
		filhoEsquerdo.setAltura(0);
		no = no.getFilhoEsquerdo();
		filhoDireito.setFilhoEsquerdo(null);
		no.setFilhoDireito(filhoDireito);
		no.setFilhoEsquerdo(filhoEsquerdo);
		no.setAltura(0);
	}
	
	private void giroParcialEsquerda(No no) {
		No filhoEsquerda = no.getFilhoEsquerdo().getFilhoDireito();
		No neto = no.getFilhoEsquerdo();
		filhoEsquerda.setAltura(0);
		neto.setAltura(0);
		neto.setFilhoDireito(null);
		no.setFilhoEsquerdo(filhoEsquerda);
		no.getFilhoEsquerdo().setFilhoEsquerdo(neto);
		no.setAltura(0);
	}
	
	private void giroCompletoDireita(No no) {
		No filhoEsquerdo = no;
		No filhoDireito = no.getFilhoDireito().getFilhoDireito();
		no = no.getFilhoDireito();
		filhoEsquerdo.setAltura(0);
		filhoEsquerdo.setFilhoDireito(null);
		filhoDireito.setAltura(0);
		no.setFilhoDireito(filhoDireito);
		no.setFilhoEsquerdo(filhoEsquerdo);
		no.setAltura(0);
	}
	
	private void giroParcialDireita(No no) {
		No filhoDireito = no.getFilhoDireito().getFilhoEsquerdo();
		No neto = no.getFilhoDireito();
		neto.setFilhoEsquerdo(null);
		no.setFilhoDireito(filhoDireito);
		no.getFilhoDireito().setFilhoDireito(neto);
		filhoDireito.setAltura(1);
		neto.setAltura(0);
	}
	
	public void listarArvore() {
		if(raiz == null) {
			System.out.println("Árvore vazia");
			return;
		}
		
		String separador = String.valueOf("  |__");
		System.out.println(raiz.getDado() + "(" + raiz.getAltura() + ")");
		listarSubArvore(raiz, raiz.getFilhoEsquerdo(),  separador);
		listarSubArvore(raiz, raiz.getFilhoDireito(), separador);
	}
	
	private void listarSubArvore(No raiz, No raizLista, String separador) {
		if(raizLista != null) {
			if(raizLista.getDado() < raiz.getDado()) {
				System.out.println(separador + raizLista.getDado()+"("+raizLista.getAltura()+")"+" (ESQ)");
			}else {
				System.out.println(separador+raizLista.getDado()+"("+raizLista.getAltura()+")"+" (DIR)");
			}
			listarSubArvore(raizLista, raizLista.getFilhoEsquerdo(),  "     "+separador);
			listarSubArvore(raizLista, raizLista.getFilhoDireito(), "     "+separador);
		}
	}
	//Implementar operações de balanceamento depois
	// Temos um pequeno problema: eu não lembro como é
	// feito o balanceamento
}
