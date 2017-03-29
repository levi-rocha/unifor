package br.unifor.carros.entity;

import java.io.Serializable;

public class Fiesta implements CarroPopular, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646689591558366913L;

	private Long id;
	private boolean ligado = false;
	private boolean freioDeMao = true;
	private String parabrisa = "sujo";

	@Override
	public void exibirInfoPopular() {
		System.out.println("Modelo: Fiesta | F�brica: Ford | Categoria: Popular");
	}

	@Override
	public void baixarFreioDeMao() {
		System.out.println("Fiesta: Freio de mao baixado");
		freioDeMao = false;
	}

	@Override
	public void ligar() {
		System.out.println("Fiesta: Ligado");
		ligado = true;
	}

	@Override
	public void limparParabrisa() {
		System.out.println("Fiesta: Parabrisa limpo");
		parabrisa = "limpo";
	}

	@Override
	public void dirigir(String destino) {
		System.out.println("Fiesta: Dirigindo ate " + destino);
	}

	@Override
	public void buzinar() {
		System.out.println("Fiesta: BEEP");
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

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public void setFreioDeMao(boolean freioDeMao) {
		this.freioDeMao = freioDeMao;
	}

	public void setParabrisa(String parabrisa) {
		this.parabrisa = parabrisa;
	}

}