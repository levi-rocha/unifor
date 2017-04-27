package br.unifor.arquitetura.cdi.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unifor.arquitetura.cdi.entidades.Carro;
import br.unifor.arquitetura.cdi.util.DAO;

@DAO
public class CarroDAO {
	@Inject
	@DAO
	private EntityManager entityManager;

	public Integer adiciona(Carro produto) {
		entityManager.persist(produto);
		return produto.getCodigo();
	}
}
