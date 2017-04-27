package br.unifor.carros.factory;

import br.unifor.carros.entity.CarroPopular;
import br.unifor.carros.entity.CarroSedan;
import br.unifor.carros.entity.Palio;
import br.unifor.carros.entity.Siena;

/**
 * Implementacao da interface fabrica de carro para carros marca ford
 */
public class FabricaFiat implements FabricaDeCarro {

	public static FabricaFiat instancia;

	protected FabricaFiat() {
	}
/**
 * 
 * @return instancia de fabrica fiat
 */
	public static FabricaFiat getInstancia() {
		if (instancia == null)
			instancia = new FabricaFiat();
		return instancia;
	}

	@Override
	public CarroSedan criarCarroSedan() {
		return new Siena();
	}

	@Override
	public CarroPopular criarCarroPopular() {
		return new Palio();
	}

}