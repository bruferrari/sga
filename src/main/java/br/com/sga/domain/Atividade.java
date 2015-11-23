package br.com.sga.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "atividade")
@NamedQueries({
		@NamedQuery(name = "Atividade.listar", query = "SELECT atividade FROM Atividade atividade"),
		@NamedQuery(name = "Atividade.buscarPorCodigo", query = "SELECT atividade FROM Atividade atividade WHERE codigo = :codigo") })
public class Atividade {

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "inicio", length = 19, nullable = false)
	private Date inicio;

	@Column(name = "fim", length = 19, nullable = false)
	private Date fim;

	@Column(name = "tipo", length = 1, nullable = false)
	private String tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "turma_codigo", referencedColumnName = "codigo", nullable = false)
	private Turma turma = new Turma();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
