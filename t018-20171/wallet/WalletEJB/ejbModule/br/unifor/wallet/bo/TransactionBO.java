package br.unifor.wallet.bo;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.wallet.dao.TransactionDAO;
import br.unifor.wallet.entity.Transaction;

@Stateless
public class TransactionBO implements TransactionBORemote {

	@EJB
	private TransactionDAO transactionDao;

	public TransactionBO() {

	}

	@Override
	public Collection<Transaction> list() {
		return transactionDao.list();
	}

	@Override
	public Transaction findById(Long id) {
		return transactionDao.findById(id);
	}

	@Override
	public String insert(Transaction transaction) {
		return transactionDao.insert(transaction);
	}
	
	@Override
	public String update(Transaction transaction) {
		return transactionDao.update(transaction);
	}

	@Override
	public String remove(Long id) {
		return transactionDao.remove(id);
	}

}
