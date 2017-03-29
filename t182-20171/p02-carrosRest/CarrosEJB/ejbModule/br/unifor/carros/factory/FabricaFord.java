package br.unifor.carros.factory;

import br.unifor.carros.entity.CarroPopular;
import br.unifor.carros.entity.CarroSedan;
import br.unifor.carros.entity.Fiesta;
import br.unifor.carros.entity.FiestaSedan;

public class FabricaFord implements FabricaDeCarro {

	public static FabricaFord instancia;

	protected FabricaFord() {
	}

	public static FabricaFord getInstancia() {
		if (instancia == null)
			instancia = new FabricaFord();
		return instancia;
	}

	@Override
	public CarroSedan criarCarroSedan() {
		return new FiestaSedan();
	}

	@Override
	public CarroPopular criarCarroPopular() {
		return new Fiesta();
	}

}