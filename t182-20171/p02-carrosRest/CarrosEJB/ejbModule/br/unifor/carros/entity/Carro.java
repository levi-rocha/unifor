package br.unifor.carros.entity;

public interface Carro {

	void baixarFreioDeMao();

	void ligar();

	void limparParabrisa();

	void dirigir(String destino);

	void buzinar();

	Long getId();

	void setId(Long id);

}
