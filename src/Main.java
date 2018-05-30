
public class Main {

	public static void main(String[] args) {
		try {
			ArvoreAVL a = new ArvoreAVL();
			a.insere(1);
			a.listarArvore();
			a.insere(2);
			a.listarArvore();
			a.insere(3);
			a.listarArvore();
			a.insere(4);
			a.listarArvore();
			a.insere(5);
			a.listarArvore();
			a.insere(6);
			a.listarArvore();
			a.insere(7);
			a.listarArvore();
			System.out.println(a.busca(1));
			System.out.println(a.busca(6));
			System.out.println(a.busca(8));
			a.exclui(5);
			a.listarArvore();
			a.exclui(7);
			a.listarArvore();
			a.exclui(3);
			a.listarArvore();
			a.exclui(1);
			a.listarArvore();
			a.exclui(2);
			a.listarArvore();
			a.exclui(6);
			a.listarArvore();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
