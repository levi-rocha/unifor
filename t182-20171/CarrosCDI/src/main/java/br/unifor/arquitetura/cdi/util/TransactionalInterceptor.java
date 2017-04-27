package br.unifor.arquitetura.cdi.util;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transactional
@Interceptor
public class TransactionalInterceptor {

	@Inject
	@DAO
	private EntityManager entityManager;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		Object retorno = "";
		try {
			entityManager.getTransaction().begin();
			retorno = ctx.proceed();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
