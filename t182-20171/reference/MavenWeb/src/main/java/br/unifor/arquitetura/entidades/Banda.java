package br.unifor.arquitetura.entidades;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Banda {
	private String nome;
	@Override
	public String toString() {
		return "Banda [nome=" + nome + ", anoDeFormacao=" + anoDeFormacao + ", id=" + id + "]";
	}

	private int anoDeFormacao;
	private int id;

	// getters e setters
	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlAttribute
	public int getAnoDeFormacao() {
		return anoDeFormacao;
	}

	public void setAnoDeFormacao(int anoDeFormacao) {
		this.anoDeFormacao = anoDeFormacao;
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}