package br.unifor.edu.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "funcionarios")
public class FuncionarioList {

	private List<Funcionario> funcionarios;

	@Override
	public String toString() {
		return "FuncionarioList [funcionarios=" + funcionarios + "]";
	}

	@XmlElement(name = "funcionario")
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
