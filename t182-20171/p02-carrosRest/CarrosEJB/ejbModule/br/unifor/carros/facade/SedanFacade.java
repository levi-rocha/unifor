package br.unifor.carros.facade;

import br.unifor.carros.entity.Carro;
import br.unifor.carros.entity.CarroSedan;
import br.unifor.carros.factory.FabricaFiat;
import br.unifor.carros.factory.FabricaFord;

public class SedanFacade {

	private CarroSedan carro;

	public void prepararCarroFiat() {
		carro = FabricaFiat.getInstancia().criarCarroSedan();
		carro.exibirInfoSedan();
		carro.ligar();
		carro.limparParabrisa();
		carro.baixarFreioDeMao();
	}

	public void prepararCarroFord() {
		carro = FabricaFord.getInstancia().criarCarroSedan();
		carro.exibirInfoSedan();
		carro.ligar();
		carro.limparParabrisa();
		carro.baixarFreioDeMao();
	}

	public Carro getCarro() {
		return carro;
	}

	public void dirigir(String destino) {
		carro.dirigir(destino);
	}

	public void buzinar() {
		carro.buzinar();
	}

}
