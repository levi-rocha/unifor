package br.unifor.wallet.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.wallet.entity.Transaction;

@Stateless
public class TransactionDAO {

	@PersistenceContext
	private EntityManager manager;

	public Collection<Transaction> list() {
		return manager.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList();
	}

	public Transaction findById(Long id) {
		return (Transaction) manager.createQuery("SELECT t FROM Transaction t WHERE t.id = :id", Transaction.class)
				.setParameter(":id", id).getSingleResult();
	}

	public String insert(Transaction transaction) {
		try {
			manager.persist(transaction);
			return transaction.getTitle() + " inserted";
		} catch (PersistenceException e) {
			return "could not insert data " + e;
		}
	}

	public String update(Transaction transaction) {

		try {
			Transaction detached = manager.find(Transaction.class, transaction.getId());

			if (detached == null)
				return "no transaction found with id " + transaction.getId();

			Transaction managed = manager.merge(detached);

			managed.setTitle(transaction.getTitle());
			managed.setValue(transaction.getValue());

			return transaction.getTitle() + " updated";
		} catch (PersistenceException e) {
			return "could not update data " + e;
		}
	}

	public String remove(Long id) {
		try {
			Transaction transaction = manager.find(Transaction.class, id);
			manager.remove(transaction);
			return transaction.getTitle() + " removed";
		} catch (PersistenceException e) {
			return "could not remove data " + e;
		}
	}

}
