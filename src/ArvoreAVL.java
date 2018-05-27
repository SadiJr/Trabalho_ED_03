
public class ArvoreAVL {
	private No raiz;

	public ArvoreAVL() {
		raiz = null;
	}
	
	public void insere(int dado) {
		if(raiz == null) {
			raiz = new No(dado);
		}else {
			insere(dado, raiz);
		}
	}
	
	public void exclui(int dado) {
		
	}
	
	public boolean busca(int dado) {
		if(raiz.getDado() == dado) {
			return true;
		}else {
			return busca(dado, raiz);
		}
	}
	
	private void insere(int dado, No raiz) {
		
	}
	
	private void exclui(int dado, No raiz) {
		
	}
	
	private boolean busca(int dado, No raiz) {
		return false;
	}
	
	//Implementar operações de balanceamento depois
}
