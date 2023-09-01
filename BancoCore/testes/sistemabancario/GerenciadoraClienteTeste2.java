package sistemabancario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * *Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerencIadora Clientes}
 * 
 * @author Clayton Chagas
 * @date 18/08/2023
 */


public class GerenciadoraClienteTeste2 {
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	/**
	 * Anotação que roda a montagem do cenário antes de chamr todo método com @teste
	 */
	
	@Before
	public void setUp() {
		/*---------Montagem do cenário de teste======*/
		Cliente cliente01 = new Cliente(1, "João da Silva", 20, "joaodasilva@gmail.com",1, true);
		Cliente cliente02 = new Cliente(2, "Mary da Silva", 20, "marysilva@gmail.com",1, true);
		
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	}
	
	@After
	public void tearDown() {
		//***********Desmontagem do cenário global********//
		gerClientes.limpa();
	}
	
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Clayton Chagas
	 * @date 18/08/2023
	 */
	
	@Test
	public void testePesquisaCliente() {
//		/*---------Montagem do cenário de teste======*/
//		//criando alguns clientes
//		int idCliente01 = 1;
//		int idCliente02 = 2;
//		
//		
////		Cliente cliente01 = new Cliente(1, "João da Silva", 20, "joaodasilva@gmail.com",1, true);
////		Cliente cliente02 = new Cliente(2, "Mary da Silva", 20, "marysilva@gmail.com",1, true);
//		Cliente cliente01 = new Cliente(1, "João da Silva", 20, "joaodasilva@gmail.com",1, true);
//		Cliente cliente02 = new Cliente(2, "Mary da Silva", 20, "marysilva@gmail.com",1, true);
//		
//		
//		//inserindo os clientes criados na lista de clientes do banco
//		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
		
		//GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*=======Execução do Teste========*/
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/*======Verificação e Avaliação do Teste========*/
		assertThat(cliente.getId(), is(idCliente01));
		
	}
	
	/**
	 * Teste básico da remoção do cliente a partir do ID
	 * 
	 * @author Daniel Farrulla
	 * @Date 25-08-2023
	 */
	@Test
	public void testremoveCliente() {
	
		/* ===========Montagem do meu cenário de teste=========*/
		 
		Cliente cliente01 = new Cliente(1, "João da Silva", 200, "joaodasilva@gmail.com",1, true);
		Cliente cliente02 = new Cliente(2, "Mary da Silva", 0, "marysilva@gmail.com",1, true);
		
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		/*============Preparação para execução=========*/
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*Execução da regra de negócio a ser testada==========*/
		boolean resultadoRemocaoCliente = gerClientes.removeCliente(2);
		
		/*Execução dos testes pelo JUnit para Análises e Verificação=====*/
		assertThat(resultadoRemocaoCliente, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
		
	}
	
	@Test
	public void TestRemoveClienteInexistente() {
		/*************Montagem do cenário é chamada automaticamente pelo @Before************/
		
		/*****Execução******/
		boolean resultadoRemocaoCliente = gerClientes.removeCliente(10);
		
		/*=========Análises e Verificação=====*/
		assertThat(resultadoRemocaoCliente, is(false));
		assertFalse(resultadoRemocaoCliente);
		assertThat(gerClientes.getClientesDoBanco().size(),is(2));
		
	}

}





