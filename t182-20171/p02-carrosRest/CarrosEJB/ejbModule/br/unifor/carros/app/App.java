package br.unifor.carros.app;

import br.unifor.carros.facade.PopularFacade;
import br.unifor.carros.facade.SedanFacade;

public class App {

	public static void main(String[] args) {
		SedanFacade sedanFacade = new SedanFacade();
		sedanFacade.prepararCarroFiat();
		sedanFacade.buzinar();
		System.out.println();
		sedanFacade.prepararCarroFord();
		sedanFacade.buzinar();
		sedanFacade.dirigir("Unifor");
		
		System.out.println();
		
		PopularFacade popularFacade = new PopularFacade();
		popularFacade.prepararCarroFord();
		popularFacade.buzinar();
		System.out.println();
		popularFacade.prepararCarroFiat();
		popularFacade.buzinar();
		popularFacade.dirigir("Iguatemi");
	}

}
