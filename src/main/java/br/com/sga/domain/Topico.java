package br.com.sga.domain;

import javax.persistence.Column;
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
@Table(name = "topico")
@NamedQueries({
		@NamedQuery(name = "Topico.listar", query = "SELECT topico FROM Topico topico"),
		@NamedQuery(name = "Topico.buscarPorCodigo", query = "SELECT topico FROM Topico topico WHERE codigo = :codigo") })
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "disciplina_codigo", referencedColumnName = "codigo", nullable = false)
	private Disciplina disciplina = new Disciplina();

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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Topico [codigo=" + codigo + ", descricao=" + descricao
				+ ", disciplina=" + disciplina + "]";
	}

}
