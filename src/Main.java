
public class Main {

	public static void main(String[] args) {
		try {
			ArvoreAVL a = new ArvoreAVL();
			a.insere(1);
			a.listarArvore();
			System.out.println();
			a.insere(2);
			a.listarArvore();
			System.out.println();
			a.insere(3);
			a.listarArvore();
			System.out.println();
			a.insere(4);
			a.listarArvore();
			System.out.println();
			a.insere(5);
			a.listarArvore();
			System.out.println();
			a.insere(6);
			a.listarArvore();
			System.out.println();
			a.insere(7);
			a.listarArvore();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
