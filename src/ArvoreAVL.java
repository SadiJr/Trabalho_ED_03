
public class ArvoreAVL {
	private No raiz;

	public ArvoreAVL() {
		raiz = null;
	}
	
	public void insere(int dado) throws Exception {
		if(this.raiz == null) {
			this.raiz = new No(dado);
		}else {
			this.raiz = insere(dado, this.raiz);
		}
	}
		
	private No insere(int dado, No no) throws Exception {
		
		if(dado < no.getDado()) {
			
			if(no.getFilhoEsquerdo() == null) {
				no.setFilhoEsquerdo(new No(dado));
			}else {
				no.setFilhoEsquerdo(insere(dado, no.getFilhoEsquerdo()));
			}
			no.setAltura(no.getAltura() - 1);
			no = balanceamento(no);
			return no;
		}else if(dado > no.getDado()) {
			
			if(no.getFilhoDireito() == null) {
				no.setFilhoDireito(new No(dado));
			}else {
				 no.setFilhoDireito(insere(dado, no.getFilhoDireito()));
			}
			no.setAltura(no.getAltura() + 1);
			no = balanceamento(no);
			return no;
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
	
	private No balanceamento(No no) {
		if(no.getAltura() == -2) {
			if(no.getFilhoEsquerdo().getAltura() == -1) {
				no = giroCompletoEsquerda(no);
			}else {
				no = giroParcialEsquerda(no);
				no = giroCompletoEsquerda(no);
			}
		}else if(no.getAltura() == 2) {
			if(no.getFilhoDireito().getAltura() == -1) {
				no = giroParcialDireita(no);
				no = giroCompletoDireita(no);
			}else {
				no = giroCompletoDireita(no);
			}
		}
		return no;
	}
	
	private No giroCompletoEsquerda(No no) {
		No novoNo = no.getFilhoEsquerdo();
		novoNo.setFilhoDireito(no);
		novoNo.setFilhoEsquerdo(no.getFilhoEsquerdo().getFilhoEsquerdo());
		novoNo.setAltura(0);
		novoNo.getFilhoDireito().setAltura(0);
		novoNo.getFilhoDireito().setFilhoEsquerdo(null);
		return novoNo;
	}
	
	private No giroParcialEsquerda(No no) {
		No novoNo = no;
		No filhoEsquerda = no.getFilhoEsquerdo().getFilhoDireito();
		No neto = no.getFilhoEsquerdo();
		novoNo.setFilhoEsquerdo(filhoEsquerda);
		novoNo.getFilhoEsquerdo().setFilhoEsquerdo(neto);
		return novoNo;
	}
	
	private No giroCompletoDireita(No no) {
		No novoNo = no.getFilhoDireito();
		novoNo.setFilhoEsquerdo(no);
		novoNo.setFilhoDireito(novoNo.getFilhoDireito());
		novoNo.setAltura(0);
		novoNo.getFilhoEsquerdo().setAltura(0);
		novoNo.getFilhoEsquerdo().setFilhoDireito(null);
		return novoNo;
	}
	
	private No giroParcialDireita(No no) {
		No novoNo = no;
		No filhoDireito = novoNo.getFilhoDireito().getFilhoEsquerdo();
		No neto = no.getFilhoDireito();
		novoNo.setFilhoDireito(filhoDireito);
		novoNo.getFilhoDireito().setFilhoDireito(neto);
		return novoNo;
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
