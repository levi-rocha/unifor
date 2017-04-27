package br.unifor.carros.factory;

import br.unifor.carros.entity.CarroPopular;
import br.unifor.carros.entity.CarroSedan;

/**
 * Interface padrao abstract factory method
 *
 */
public interface FabricaDeCarro {
	
	CarroSedan criarCarroSedan();

	CarroPopular criarCarroPopular();
}