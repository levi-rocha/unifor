package br.unifor.arquitetura.cdi.services;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.arquitetura.cdi.dao.CarroDAO;
import br.unifor.arquitetura.cdi.entidades.Carro;
import br.unifor.arquitetura.cdi.util.DAO;
import br.unifor.arquitetura.cdi.util.ContextA;
import br.unifor.arquitetura.cdi.util.EntityManagerUtil;
import br.unifor.arquitetura.cdi.util.Transactional;
import br.unifor.arquitetura.cdi.util.TransactionalInterceptor;

@RunWith(CdiRunner.class)
// Runs the test with CDI-Unit
@AdditionalClasses({ CarroDAO.class, EntityManagerUtil.class,
		CarroController.class, TransactionalInterceptor.class, ContextA.class,
		DAO.class, Transactional.class })
public class ProdutoControllerTest {

	@Inject
	@ContextA
	private CarroController produtoController;

	@Test
	public void test() {
		Carro produto = new Carro();
		// produto.setCodigo(1);
		produto.setNome("IMPRESSORA LASER 1234");
		produto.setPreco(700.99);
		Integer id = produtoController.inserir(produto);
		assertNotNull(id);
	}

}
