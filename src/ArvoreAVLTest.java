import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ArvoreAVLTest {
	//Árvore usada para testes de exceção
	private ArvoreAVL excecao;
	//Árvore usada para o resto
	private static ArvoreAVL teste;
	
	@Rule public TestName name = new TestName();


	@Test
	public void test1() {
		System.err.println("Iniciando os testes de Exceções!\n");
		System.out.println("Teste 01:\n");
		System.out.println("Testando se é lançada exceção ao tentar inserir um dado já existente na árvore:\n"
				+ "Mensagem esperada: O dado já existe na árvore!");
		try {
			excecao = new ArvoreAVL();
			excecao.insere(1);
			excecao.insere(1);
			fail("O teste falhou. Nenhuma exceção foi lançada\n");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("O dado já existe na árvore!", e.getMessage());
			System.out.println("O teste passou!\n");
		}
	}
	
	@Test
	public void test2() {
		System.out.println("Teste 02:\n");
		System.out.println("Testando se é lançada exceção ao excluir um dado que não consta na árvore:\n"
				+ "Mensagem esperada: O dado não consta na árvore!");
		try {
			excecao = new ArvoreAVL();
			excecao.insere(2);
			excecao.insere(1);
			excecao.insere(3);
			excecao.exclui(5);
			fail("O teste falhou! Uma exceção deveria ser lançada!\n");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("O dado não consta na árvore!", e.getMessage());
			System.out.println("O teste passou!\n");
		}
	}
	
	@Test
	public void test3() {
		System.err.println("Fim dos testes das Exceções!\n\nIniciando testes de funcionamento do algoritmo AVL!");
		System.out.println("Teste 03:\n");
		System.out.println("Testando se a inserção e a busca estão funcionando:");
		try {
		teste = new ArvoreAVL();
		teste.insere(1);
		teste.insere(2);
		assertEquals(true, teste.busca(2));
		assertEquals(false, teste.busca(23));
		System.out.println("O teste passou!\n");
		}catch(Exception e) {
			fail("O teste falhou!\nUma exceção inesperado foi lançada!\n");
		}
	}
	
	@Test
	public void test4() {
		System.out.println("Teste 04:\n");
		System.out.println("Testando se o balanceamento ocorre corretamente:\n"
				+ "Para esse teste, a cada inserção a árvore será impressa para avaliação.");
		try {
			System.out.println();
			teste.listarArvore();
			teste.insere(3);
			System.out.println();
			teste.listarArvore();
			teste.insere(4);
			System.out.println();
			teste.listarArvore();
			teste.insere(5);
			System.out.println();
			teste.listarArvore();
			teste.insere(6);
			System.out.println();
			teste.listarArvore();
			teste.insere(7);
			System.out.println();
			teste.listarArvore();
			System.out.println();
			System.out.println("O teste passou!\n");
		}catch(Exception e) {
			fail("O teste falhou!\nUma exceção inesperada foi lançada!\n");
		}
	}
	
	@Test
	public void test5() {
		System.out.println("Teste 05:\n");
		System.out.println("Testando se a exclusão ocorre corretamente:\n"
				+ "Para esse teste, a cada exclusão a árvore será impressa para avaliação.");
		try {
			System.out.println();
			teste.exclui(4);
			teste.listarArvore();
			System.out.println();
			teste.exclui(7);
			teste.listarArvore();
			System.out.println();
			System.out.println("O teste passou!");
		}catch(Exception e) {
			fail("O teste falhou!\nUma exceção inesperada foi lançada!");
		}
	}

}
