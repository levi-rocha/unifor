package br.unifor.arquitetura.cdi.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {


	@Produces
	@ApplicationScoped
	@DAO
	public EntityManager criaEntityManager(@DAO EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	@Produces
	@ApplicationScoped
	@DAO
	public EntityManagerFactory criaEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("ExemploPU");
	}

}