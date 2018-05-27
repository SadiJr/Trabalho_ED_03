
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
					//Lembrar de verificar o balanceamento
		}else if(dado > raiz.getDado()) {
			
			if(raiz.getFilhoDireito() == null) {
				raiz.setFilhoDireito(new No(dado));
			}else {
				insere(dado, raiz.getFilhoDireito());
			}
			
			raiz.setAltura(raiz.getAltura() + 1);
		
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
			//Continuar o método depois
			//Lembrar de verificar se o nó a ser excluído tem filhos
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
			}
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
	
	private void balanceamento(No raiz) {
		if(raiz.getAltura() == -2) {
			if(raiz.getFilhoEsquerdo().getAltura() == -1) {
				giroCompletoEsquerda(raiz);
			}else {
				giroParcialEsquerda(raiz);
				giroCompletoEsquerda(raiz);
			}
		}else if(raiz.getAltura() == 2) {
			if(raiz.getFilhoDireito().getAltura() == -1) {
				giroParcialDireita(raiz);
				giroCompletoDireita(raiz);
			}else {
				giroCompletoDireita(raiz);
			}
		}
	}
	
	private void giroCompletoEsquerda(No raiz) {
		No filhoDireito = raiz;
		No filhoEsquerdo = raiz.getFilhoEsquerdo().getFilhoEsquerdo();
		raiz = raiz.getFilhoEsquerdo();
		raiz.setFilhoDireito(filhoDireito);
		raiz.setFilhoEsquerdo(filhoEsquerdo);
	}
	
	private void giroParcialEsquerda(No raiz) {
		No filhoEsquerda = raiz.getFilhoEsquerdo().getFilhoDireito();
		No neto = raiz.getFilhoEsquerdo();
		raiz.setFilhoEsquerdo(filhoEsquerda);
		raiz.getFilhoEsquerdo().setFilhoEsquerdo(neto);
	}
	
	private void giroCompletoDireita(No raiz) {
		No filhoEsquerdo = raiz;
		No filhoDireito = raiz.getFilhoDireito().getFilhoDireito();
		raiz = raiz.getFilhoDireito();
		raiz.setFilhoDireito(filhoDireito);
		raiz.setFilhoEsquerdo(filhoEsquerdo);
	}
	
	private void giroParcialDireita(No raiz) {
		No filhoDireito = raiz.getFilhoDireito().getFilhoEsquerdo();
		No neto = raiz.getFilhoDireito();
		raiz.setFilhoDireito(filhoDireito);
		raiz.getFilhoDireito().setFilhoDireito(neto);
	}
	//Implementar operações de balanceamento depois
	// Temos um pequeno problema: eu não lembro como é
	// feito o balanceamento
}
