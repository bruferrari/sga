package br.com.sga.domain;

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
@Table(name = "resposta")
@NamedQueries({
		@NamedQuery(name = "Resposta.listar", query = "SELECT resposta FROM Resposta resposta"),
		@NamedQuery(name = "Resposta.buscarPorCodigo", query = "SELECT resposta FROM Resposta resposta WHERE codigo = :codigo") })
public class Resposta {

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aluno_codigo", referencedColumnName = "ra", nullable = false)
	private Aluno aluno = new Aluno();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "atividade_codigo", referencedColumnName = "codigo", nullable = false)
	private Atividade atividade = new Atividade();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}
