package br.unifor.wallet.bo;

import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.wallet.entity.Transaction;

@Remote
public interface TransactionBORemote {

	public Collection<Transaction> list();

	public Transaction findById(Long id);

	public String insert(Transaction transaction);

	public String remove(Long id);

	public String update(Transaction transaction);

}
