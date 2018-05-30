
public class ArvoreAVL {
	private No raiz;
	
	public ArvoreAVL() {
		this.raiz = null;
	}
	
	private int getFator(No no) {
		return altura(no.getFilhoDireito()) - altura(no.getFilhoEsquerdo());
	}
	
	private int altura(No no) {
		if(no == null) {
			return -1;
		}
		return no.getAltura();
	}
	
	public void insere(int dado) throws Exception {
		if(this.raiz == null) {
			raiz = new No(dado);
		}else {
			this.raiz = insere(dado, this.raiz);
		}
	}
	
	private No insere(int dado, No no) throws Exception {
		if(dado > no.getDado()) {
			if(no.getFilhoDireito() == null) {
				no.setFilhoDireito(new No(dado));
			}else {
				no.setFilhoDireito(insere(dado, no.getFilhoDireito()));
			}
		}else if(dado < no.getDado()) {
			if(no.getFilhoEsquerdo() == null) {
				no.setFilhoEsquerdo(new No(dado));
			}else {
				no.setFilhoEsquerdo(insere(dado, no.getFilhoEsquerdo()));
			}
			no = balanceamento(no);
		}else {
			throw new Exception("O dado já existe na árvore!");
		}
		no = balanceamento(no);
		return no;
	}
	
	private No balanceamento(No no) {
		if(getFator(no) == 2) {
			if(getFator(no.getFilhoDireito()) == 1) {
				no = giroCompletoEsquerda(no);
			}else {
				no = giroParcialEsquerda(no);
			}
			
		}else if(getFator(no) == -2) {
			if(getFator(no.getFilhoEsquerdo()) == -1) {
				no = giroCompletoDireita(no);
			}else {
				no = giroParcialDireita(no);
			}
		}
		no.setAltura(Math.max(altura(no.getFilhoDireito()), altura(no.getFilhoEsquerdo())) + 1);
		return no;
	}
	
	//Giro completo à esquerda, usado quando a árvore está desbalanceada para a direita.
	private No giroCompletoEsquerda(No no) {
		No aux = no.getFilhoDireito();
		no.setFilhoDireito(aux.getFilhoEsquerdo());
		aux.setFilhoEsquerdo(no);
		no.setAltura(Math.max(altura(no.getFilhoDireito()), altura(no.getFilhoEsquerdo())) + 1);
		aux.setAltura(Math.max(altura(aux.getFilhoDireito()), no.getAltura()) + 1);
		return aux;
	}
	
	//Giro parcial à esquerda, usado quando a árvore está desbalanceada para a direita, mas possuí um nó com
	//um filho à esquerda
	private No giroParcialEsquerda(No no) {
		no.setFilhoDireito(giroCompletoDireita(no.getFilhoDireito()));
		return giroCompletoEsquerda(no);
	}
	
	//Giro completo à direita, usado quando a árvore está desbalanceada para a esquerda
	private No giroCompletoDireita(No no) {
		No aux = no.getFilhoEsquerdo();
		no.setFilhoEsquerdo(aux.getFilhoDireito());
		aux.setFilhoDireito(no);
		no.setAltura(Math.max(altura(no.getFilhoDireito()), altura(no.getFilhoEsquerdo())) + 1);
		aux.setAltura(Math.max(altura(aux.getFilhoDireito()), no.getAltura()) + 1);
		return aux;
	}
	
	//Já sabe, né?
	private No giroParcialDireita(No no) {
		no.setFilhoEsquerdo(giroCompletoEsquerda(no.getFilhoEsquerdo()));
		return giroCompletoDireita(no);
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
	
	public void exclui(int dado) throws Exception {
		this.raiz = exclui(dado, this.raiz);
	}
	
	private No exclui(int dado, No no) throws Exception {
		if(no == null) {
			throw new Exception("O dado não consta na árvore!");
		}
		
		if(no.getDado() == dado) {
			if(possuiDoisFilhos(no)) {
				No aux = getAntecessorImediato(no.getFilhoEsquerdo());
				exclui(aux.getDado(), this.raiz);
				aux.setFilhoDireito(no.getFilhoDireito());
				aux.setFilhoEsquerdo(no.getFilhoEsquerdo());
				no = aux;
				no = balanceamento(no);
			}else if(possuiFilho(no)) {
				no = getFilho(no);
				no = balanceamento(no);
			}else {
				no = null;
			}
		}else {
			if(dado > no.getDado()) {
				no.setFilhoDireito(exclui(dado, no.getFilhoDireito()));
				no = balanceamento(no);
			}else {
				no.setFilhoEsquerdo(exclui(dado, no.getFilhoEsquerdo()));
				no = balanceamento(no);
			}
		}
		//if(no != null) {
		//	no = balanceamento(no);
		//}
		return no;
	}
	
	private boolean possuiDoisFilhos(No no) {
		if(no.getFilhoDireito() != null && no.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	
	private No getAntecessorImediato(No no) {
		No aux = null;
		if(no.getFilhoDireito() == null) {
			aux = no;
			no = null;
		}else {
			aux = getAntecessorImediato(no.getFilhoDireito());
			//aux = balanceamento(no);
		}
		return aux;
	}
	
	private boolean possuiFilho(No no) {
		if(no.getFilhoDireito() != null || no.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	
	private No getFilho(No no) {
		if(no.getFilhoDireito() != null) {
			no = no.getFilhoDireito();
		}else {
			no = no.getFilhoEsquerdo();
		}
		return no;
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

}
