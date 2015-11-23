package br.com.sga.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "questao")
@NamedQueries({
		@NamedQuery(name = "Questao.listar", query = "SELECT questao FROM Questao questao"),
		@NamedQuery(name = "Questao.buscarPorCodigo", query = "SELECT questao FROM Questao questao WHERE codigo = :codigo") })
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "assunto", length = 99, nullable = false)
	private String assunto;

	@Column(name = "dificuldade", length = 1, nullable = false)
	private int dificuldade;

	@Column(name = "enunciado", columnDefinition = "TEXT", nullable = false)
	private String enunciado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

}
