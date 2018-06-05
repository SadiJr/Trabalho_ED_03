import java.util.Scanner;

public class Tela {
	private Scanner sc;
	private ArvoreAVL arvore;
	
	public Tela() {
		this.sc = new Scanner(System.in);
		this.arvore = new ArvoreAVL();
	}
	
	public void tela() {
		try {
			int opcao = 0;
			do {
				System.out.println("Bem-vindo(a)\nEscolha uma das opções a seguir:");
				System.out.println("0 - Sair\n1 - Inserir elementos\n2 - Excluir elementos"
						+ "\n3 - Buscar elementos\n4 - Listar árvore");
				opcao = sc.nextInt();
				switch(opcao) {
					case 0:
						System.out.println("Até logo!");
						break;
					case 1:
						inserir();
						break;
					case 2:
						excluir();
						break;
					case 3:
						buscar();
						break;
					case 4:
						listar();
						break;
					default:
						System.out.println("A opção escolhida é inválida!\nTente novamente");
				}
			}while(opcao != 0);
		}catch(Exception e) {
			System.out.println("Digite apenas números inteiros!");
			sc.nextLine();
			tela();
		}
	}
	
	private void inserir() {
		System.out.println("Digite o valor a ser inserido");
		try {
			int dado = sc.nextInt();
			arvore.insere(dado);
		}catch(Exception e) {
			System.out.println("Digite apenas números inteiros!");
			sc.nextLine();
			inserir();
		}
	}
	
	private void excluir() {
		System.out.println("Digite o valor a ser excluido");
		try {
			int dado = sc.nextInt();
			arvore.exclui(dado);
		}catch(Exception e) {
			System.out.println("Digite apenas números inteiros!");
			sc.nextLine();
			excluir();
		}
	}
	
	private void buscar() {
		System.out.println("Digite o valor a ser buscado");
		try {
			int dado = sc.nextInt();
			System.out.println(arvore.busca(dado));
		}catch(Exception e) {
			System.out.println("Digite apenas números inteiros!");
			sc.nextLine();
			buscar();
		}
	}
	
	private void listar() {
		arvore.listarArvore();
	}
 
}
