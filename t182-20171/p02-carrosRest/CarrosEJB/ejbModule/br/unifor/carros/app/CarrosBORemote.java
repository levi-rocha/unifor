package br.unifor.carros.app;

import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.carros.entity.Fiesta;

@Remote
public interface CarrosBORemote {

	public Collection<Fiesta> listCarros();

	public String addCarro(Fiesta carro);

	public String removeCarro(Long id);

	public String updateCarro(Fiesta carro);

}
