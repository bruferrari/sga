package br.com.sga.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "questao_topico")
@NamedQueries({ @NamedQuery(name = "Questao_topico.listar", query = "FROM Questao_topico questao_topico") })
public class Questao_topico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "questao_codigo", referencedColumnName = "codigo", nullable = false)
	private Questao questao = new Questao();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topico_codigo", referencedColumnName = "codigo", nullable = false)
	private Topico topico = new Topico();

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

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	

}
