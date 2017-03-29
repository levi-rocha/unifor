package br.unifor.carros.resource;

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

import br.unifor.carros.app.CarrosBORemote;
import br.unifor.carros.entity.Fiesta;

@Stateless
@Path("/carros")
public class CarrosResource {

	@EJB
	private CarrosBORemote carrosBO;

	@GET
	@Produces("application/json")
	public Collection<Fiesta> listCarros() {
		return carrosBO.listCarros();
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addCarro(Fiesta carro) {
		return carrosBO.addCarro(carro);
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String updateCarro(Fiesta carro) {
		return carrosBO.updateCarro(carro);
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeCarro(@PathParam("id") Long id) {
		return carrosBO.removeCarro(id);
	}

}
