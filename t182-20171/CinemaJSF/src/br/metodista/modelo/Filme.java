package br.metodista.modelo;

public class Filme {
  private Long id;
  private String filme;
  private String sinopse;
  private String genero;
  private Integer duracao;
  private String trailer;

  public Filme() {
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFilme() {
    return filme;
  }
  public void setFilme(String filme) {
    this.filme = filme;
  }
  public String getSinopse() {
    return sinopse;
  }
  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }
  public Integer getDuracao() {
    return duracao;
  }
  public void setDuracao(Integer duracao) {
    this.duracao = duracao;
  }
  public String getTrailer() {
    return trailer;
  }
  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }
}