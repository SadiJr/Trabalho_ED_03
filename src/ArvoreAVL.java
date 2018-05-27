
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
			//Continuar o método depois
			//Lembrar de verificar se o nó a ser excluído tem filhos
		}else {
			if(dado > raiz.getDado()) {
				exclui(dado, raiz.getFilhoDireito());
			}else {
				exclui(dado, raiz.getFilhoEsquerdo());
			}
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
	
	//Implementar operações de balanceamento depois
	// Temos um pequeno problema: eu não lembro como é
	// feito o balanceamento
}
