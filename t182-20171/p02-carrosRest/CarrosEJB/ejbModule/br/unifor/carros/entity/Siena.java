package br.unifor.carros.entity;

import java.io.Serializable;

public class Siena implements CarroSedan, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8776958055918998889L;

	private Long id;
	private boolean ligado = false;
	private boolean freioDeMao = true;
	private String parabrisa = "sujo";

	@Override
	public void exibirInfoSedan() {
		System.out.println("Modelo: Siena | F�brica: Fiat | Categoria: Sedan");
	}

	@Override
	public void baixarFreioDeMao() {
		System.out.println("Siena: Freio de mao baixado");
		freioDeMao = false;
	}

	@Override
	public void ligar() {
		System.out.println("Siena: Ligado");
		ligado = true;
	}

	@Override
	public void limparParabrisa() {
		System.out.println("Siena: Parabrisa limpo");
		parabrisa = "limpo";
	}

	@Override
	public void dirigir(String destino) {
		System.out.println("Siena: Dirigindo ate " + destino);
	}

	@Override
	public void buzinar() {
		System.out.println("Siena: BEEP");
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