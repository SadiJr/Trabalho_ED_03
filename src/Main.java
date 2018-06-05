import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

	public static void main(String[] args) {
		try {
			JUnitCore junit = new JUnitCore();
			ArvoreAVLTest teste = new ArvoreAVLTest();
			Result result = junit.run(teste.getClass());
            System.out.println("\n\nForam efetuados " + result.getRunCount() + " testes em "+ result.getRunTime() + "ms");
            if (result.wasSuccessful()) {
                System.out.println("Até Logo");
                //System.out.println("\nAll tests were successfull!");
            }else {
                System.err.println(result.getFailureCount() + "Falhas:");
                for (Failure fail: result.getFailures()){
                    System.err.println("Falhou em: "+ fail.getTestHeader());
                    System.err.println(fail.getMessage());
                    System.err.println(fail.getTrace());
                    System.out.println();
                }
                if(result.getIgnoreCount() > 0) {
                    System.out.println("E " + result.getIgnoreCount() + " testes ignorados");
                }
            }
            
            System.out.println("\nATENÇÃO:\nPara testes manuais, descomente as linhas 30 e 31 da classe Main!");
            //Tela tela = new Tela();
            //tela.tela();
            /*
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
			a.listarArvore();*/
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
