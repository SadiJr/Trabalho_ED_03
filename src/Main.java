
public class Main {

	public static void main(String[] args) {
		try {
			ArvoreAVL a = new ArvoreAVL();
			a.insere(1);
			a.insere(2);
			a.insere(3);
			a.insere(4);
			a.insere(5);
			a.insere(6);
			a.insere(7);
			a.listarArvore();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
