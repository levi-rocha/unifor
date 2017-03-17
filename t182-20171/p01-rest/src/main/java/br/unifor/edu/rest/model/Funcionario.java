package br.unifor.edu.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement
public class Funcionario {

  private String nome;
  private int cdFuncionario;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @XmlElement
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @XmlElement
  public int getCdFuncionario() {
    return cdFuncionario;
  }

  public void setCdFuncionario(int cdFuncionario) {
    this.cdFuncionario = cdFuncionario;
  }

}
