package br.unifor.carros.app;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;

import br.unifor.carros.entity.Fiesta;
import br.unifor.carros.facade.PopularFacade;
import br.unifor.carros.factory.FabricaFord;

@Stateless
public class CarrosBO implements CarrosBORemote {

	public CarrosBO() {
	}

	private static ArrayList<Fiesta> carros;

	static {
		carros = new ArrayList<Fiesta>();

		// criar carro preparado usando facade popular
		PopularFacade popularFacade = new PopularFacade();
		popularFacade.prepararCarroFord();
		Fiesta carro = (Fiesta) popularFacade.getCarro();
		carro.setId(Long.valueOf(carros.size()));
		carros.add(carro);

		// carro default, sem uso de facade
		carro = (Fiesta) FabricaFord.getInstancia().criarCarroPopular();
		carro.setId(Long.valueOf(carros.size()));
		carros.add(carro);
	}

	@Override
	public Collection<Fiesta> listCarros() {
		return this.carros;
	}

	@Override
	public String addCarro(Fiesta carro) {
		carro.setId(Long.valueOf(this.carros.size()));
		this.carros.add(carro);
		return "carro adicionado";
	}

	@Override
	public String removeCarro(Long id) {
		if (this.carros.remove(findById(id)))
			return "carro removido";
		else
			return "carro nao encontrado";
	}

	@Override
	public String updateCarro(Fiesta carro) {
		Fiesta old = findById(carro.getId());
		if (this.carros.remove(old)) {
			this.carros.add(carro);
			return "carro updateado";
		} else {
			return "carro nao encontrado";
		}

	}

	private Fiesta findById(Long id) {
		for (Fiesta carro : this.carros) {
			if (carro.getId().equals(id))
				return carro;
		}
		return null;
	}

}
