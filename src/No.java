
public class No {
	private int dado;
	private int altura;
	private No filhoEsquerdo;
	private No filhoDireito;
	
	public No(int dado) {
		this.setDado(dado);
		this.setAltura(0);
		this.setFilhoEsquerdo(null);
		this.setFilhoDireito(null);
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public No getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public No getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
}
