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
@Table(name = "atividade_questao")
@NamedQueries({ @NamedQuery(name = "Atividade_questao.listar", query = "FROM Atividade_questao atividade_questao") })
public class Atividade_questao {

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "questao_codigo", referencedColumnName = "codigo", nullable = false)
	private Questao questao = new Questao();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "atividade_codigo", referencedColumnName = "codigo", nullable = false)
	private Atividade atividade = new Atividade();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}
