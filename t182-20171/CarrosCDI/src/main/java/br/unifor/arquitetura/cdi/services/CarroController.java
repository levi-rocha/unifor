package br.unifor.arquitetura.cdi.services;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.unifor.arquitetura.cdi.dao.CarroDAO;
import br.unifor.arquitetura.cdi.entidades.Carro;
import br.unifor.arquitetura.cdi.util.DAO;
import br.unifor.arquitetura.cdi.util.ContextA;
import br.unifor.arquitetura.cdi.util.Transactional;

@ContextA
//@Transacional
public class CarroController {
	@Inject
	@DAO
	private CarroDAO dao;
	private static CarroController instance;

	// Singleton
	protected CarroController() {
	}

	@Produces
	public static CarroController getInstance() {
		if (instance==null)
			instance = new CarroController();
		return instance;
	}

	public Integer inserir(Carro produto) {
		Integer id = dao.adiciona(produto);
		return id;
	}
}