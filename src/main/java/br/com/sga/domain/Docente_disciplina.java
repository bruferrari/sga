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
@Table(name = "docente_disciplina")
@NamedQueries({
		@NamedQuery(name = "Docente_disciplina.listar", query = "FROM Docente_disciplina docente_disciplina") })
public class Docente_disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "professor_codigo", referencedColumnName = "profCod", nullable = false)
	private Professor professor = new Professor();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "disciplina_codigo", referencedColumnName = "codigo", nullable = false)
	private Disciplina disciplina = new Disciplina();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Docente_disciplina [codigo=" + codigo + ", professor="
				+ professor + ", disciplina=" + disciplina + "]";
	}

}
