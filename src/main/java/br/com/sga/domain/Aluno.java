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
@Table(name = "aluno")
@NamedQueries({
		@NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno"),
		@NamedQuery(name = "Aluno.buscarPorCodigo", query = "SELECT aluno FROM Aluno aluno WHERE codigo = :codigo") })
public class Aluno {

	@Id
	@Column(name = "ra")
	private Long ra;

	@Column(name = "nome", length = 255, nullable = false)
	private String nome;

	public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
