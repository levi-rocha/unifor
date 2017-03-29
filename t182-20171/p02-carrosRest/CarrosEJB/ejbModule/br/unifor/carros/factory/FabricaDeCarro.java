package br.unifor.carros.factory;

import br.unifor.carros.entity.CarroPopular;
import br.unifor.carros.entity.CarroSedan;

public interface FabricaDeCarro {
	
	CarroSedan criarCarroSedan();

	CarroPopular criarCarroPopular();
}