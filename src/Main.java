
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
			System.out.println(a.busca(1));
			System.out.println(a.busca(6));
			System.out.println(a.busca(8));
			a.exclui(6);
			a.listarArvore();
			a.exclui(2);
			a.listarArvore();
			a.exclui(4);
			a.listarArvore();
			a.exclui(3);
			a.listarArvore();
			a.exclui(5);
			a.listarArvore();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
