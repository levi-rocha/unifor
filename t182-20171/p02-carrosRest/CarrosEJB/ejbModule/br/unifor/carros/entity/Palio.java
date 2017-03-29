package br.unifor.carros.entity;

import java.io.Serializable;

public class Palio implements CarroPopular, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1659509030864811040L;

	private Long id;
	private boolean ligado = false;
	private boolean freioDeMao = true;
	private String parabrisa = "sujo";

	@Override
	public void exibirInfoPopular() {
		System.out.println("Modelo: Palio | Fábrica: Fiat | Categoria: Popular");
	}

	@Override
	public void baixarFreioDeMao() {
		System.out.println("Palio: Freio de mao baixado");
		freioDeMao = false;
	}

	@Override
	public void ligar() {
		System.out.println("Palio: Ligado");
		ligado = true;
	}

	@Override
	public void limparParabrisa() {
		System.out.println("Palio: Parabrisa limpo");
		parabrisa = "limpo";
	}

	@Override
	public void dirigir(String destino) {
		System.out.println("Palio: Dirigindo ate " + destino);
	}

	@Override
	public void buzinar() {
		System.out.println("Palio: BEEP");
	}
	
	public boolean isLigado() {
		return ligado;
	}

	public boolean isFreioDeMao() {
		return freioDeMao;
	}

	public String getParabrisa() {
		return parabrisa;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}