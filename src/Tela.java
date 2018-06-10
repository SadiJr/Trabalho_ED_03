import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

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
						sc.nextLine();
						inserir();
						break;
					case 2:
						sc.nextLine();
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
			String input = sc.nextLine();
			int dado = Integer.parseInt(input);
			arvore.insere(dado);
		} catch(NumberFormatException e) {
			System.out.println("Digite apenas números inteiros!");
			//sc.nextLine();
			inserir();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//sc.nextLine();
			inserir();
		}
	}
	
	private void excluir() {
		try {
			System.out.println("Digite o valor a ser excluido");
			String input = sc.nextLine();
			int dado = Integer.parseInt(input);
			arvore.exclui(dado);
		} catch(NumberFormatException e) {
			System.out.println("Digite apenas números inteiros!");
			//sc.nextLine();
			excluir();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			//sc.nextLine();
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
