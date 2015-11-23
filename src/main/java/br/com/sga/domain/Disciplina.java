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
@Table(name = "disciplina")
@NamedQueries({
		@NamedQuery(name = "Disciplina.listar", query = "SELECT disciplina FROM Disciplina disciplina"),
		@NamedQuery(name = "Disciplina.buscarPorCodigo", query = "SELECT disciplina FROM Disciplina disciplina WHERE codigo = :codigo") })
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", descricao=" + descricao
				+ "]";
	}

}
