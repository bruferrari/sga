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
@Table(name = "turma")
@NamedQueries({
		@NamedQuery(name = "Turma.listar", query = "SELECT turma FROM Turma turma"),
		@NamedQuery(name = "Turma.buscarPorCodigo", query = "SELECT turma FROM Turma turma WHERE codigo = :codigo") })
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "ciclo", length = 11, nullable = false)
	private String ciclo;

	@Column(name = "ano", length = 4, nullable = false)
	private Long ano;

	@Column(name = "periodo", length = 50, nullable = false)
	private String periodo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
