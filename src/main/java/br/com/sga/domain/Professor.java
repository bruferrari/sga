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
@Table(name = "professor")
@NamedQueries({
		@NamedQuery(name = "Professor.listar", query = "SELECT professor FROM Professor professor"),
		@NamedQuery(name = "Professor.buscarPorCodigo", query = "SELECT professor"
				+ " FROM Professor professor WHERE professor.profCod = :profCod") })
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profCod")
	private Long profCod;

	@Column(name = "profNome", length = 255, nullable = false)
	private String profNome;

	@Column(name = "profAreaAtuacao", length = 50, nullable = false)
	private String ProfAreaAtuacao;

	@Column(name = "profCampus", length = 50, nullable = false)
	private String profCampus;

	@Column(name = "profSenha", length = 50, nullable = false)
	private String profSenha;

	// @ManyToMany
	// @JoinTable(name = "professor_disciplina", joinColumns = @JoinColumn(name
	// = "professor_id"), inverseJoinColumns = @JoinColumn(name =
	// "disciplina_id"))
	// private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	/*
	 * public List<Disciplina> getDisciplinas() { return disciplinas; }
	 * 
	 * public void setDisciplinas(List<Disciplina> disciplinas) {
	 * this.disciplinas = disciplinas; }
	 */

	public Long getProfCod() {
		return profCod;
	}

	public void setProfCod(Long profCod) {
		this.profCod = profCod;
	}

	public String getProfNome() {
		return profNome;
	}

	public void setProfNome(String profNome) {
		this.profNome = profNome;
	}

	public String getProfAreaAtuacao() {
		return ProfAreaAtuacao;
	}

	public void setProfAreaAtuacao(String profAreaAtuacao) {
		ProfAreaAtuacao = profAreaAtuacao;
	}

	public String getProfCampus() {
		return profCampus;
	}

	public void setProfCampus(String profCampus) {
		this.profCampus = profCampus;
	}

	public String getProfSenha() {
		return profSenha;
	}

	public void setProfSenha(String profSenha) {
		this.profSenha = profSenha;
	}

	@Override
	public String toString() {
		return "Professor [profCod=" + profCod + ", profNome=" + profNome
				+ ", ProfAreaAtuacao=" + ProfAreaAtuacao + ", profCampus="
				+ profCampus + ", profSenha=" + profSenha + "]";
	}

	/*
	 * private Long profCod; private String profNome; private String
	 * profAreaAtuacao; private String profCampus; private String profSenha;
	 * 
	 * public Long getProfCod() { return profCod; }
	 * 
	 * public void setProfCod(Long profCod) { this.profCod = profCod; }
	 * 
	 * public String getProfNome() { return profNome; }
	 * 
	 * public void setProfNome(String profNome) { this.profNome = profNome; }
	 * 
	 * public String getProfAreaAtuacao() { return profAreaAtuacao; }
	 * 
	 * public void setProfAreaAtuacao(String profAreaAtuacao) {
	 * this.profAreaAtuacao = profAreaAtuacao; }
	 * 
	 * public String getProfCampus() { return profCampus; }
	 * 
	 * public void setProfCampus(String profCampus) { this.profCampus =
	 * profCampus; }
	 * 
	 * public String getProfSenha() { return profSenha; }
	 * 
	 * public void setProfSenha(String profSenha) { this.profSenha = profSenha;
	 * }
	 */

}
