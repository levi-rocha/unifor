package br.unifor.arquitetura.entidades;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bandas")
public class BandaList {
	@Override
	public String toString() {
		return "BandaList [bandas=" + bandas + "]";
	}

	private List<Banda> bandas;

	@XmlElement(name="banda")
	public List<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}
}