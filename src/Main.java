
public class Main {

	public static void main(String[] args) {
		try {
		ArvoreAVL t = new ArvoreAVL();
	        t.insere(1);
	        t.insere(2);
	        t.insere(3);
	        t.insere(4);
	        t.insere(5);
	        t.insere(6);
	        t.insere(7);
	        t.insere(8);
	        t.insere(9);
	        t.listarArvore();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
