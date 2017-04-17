package br.unifor.wallet.resource;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unifor.wallet.bo.TransactionBORemote;
import br.unifor.wallet.entity.Transaction;

@Stateless
@Path("/transactions")
public class TransactionResource {

	@EJB
	private TransactionBORemote transactionBO;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction findById(@PathParam("id") Long id) {
		return transactionBO.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Transaction> list() {
		return transactionBO.list();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(Transaction transaction) {
		return transactionBO.insert(transaction);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Transaction transaction) {
		return transactionBO.update(transaction);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String remove(@PathParam("id") Long id) {
		return transactionBO.remove(id);
	}

}
