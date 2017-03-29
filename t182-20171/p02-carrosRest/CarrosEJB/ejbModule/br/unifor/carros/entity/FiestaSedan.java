package br.unifor.carros.entity;

import java.io.Serializable;

public class FiestaSedan implements CarroSedan, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7255290185177601886L;

	private Long id;
	private boolean ligado = false;
	private boolean freioDeMao = true;
	private String parabrisa = "sujo";

	@Override
	public void exibirInfoSedan() {
		System.out.println("Modelo: Fiesta | F�brica:Ford | Categoria: Sedan");
	}

	@Override
	public void baixarFreioDeMao() {
		System.out.println("FiestaSedan: Freio de mao baixado");
		freioDeMao = false;
	}

	@Override
	public void ligar() {
		System.out.println("FiestaSedan: Ligado");
		ligado = true;
	}

	@Override
	public void limparParabrisa() {
		System.out.println("FiestaSedan: Parabrisa limpo");
		parabrisa = "limpo";
	}

	@Override
	public void dirigir(String destino) {
		System.out.println("FiestaSedan: Dirigindo ate " + destino);
	}

	@Override
	public void buzinar() {
		System.out.println("FiestaSedan: BEEP");
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