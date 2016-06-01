package br.com.sfcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Jogador {

	@Id
	@SequenceGenerator(name = "jogador_seq", sequenceName = "jogador_seq", allocationSize = 1)
	@GeneratedValue(generator = "jogador_seq", strategy = GenerationType.SEQUENCE)
	private Long id_jogador;

	private String nome;
	private double nota;
	private String posicao;
	private int jogos;
	private int vitorias;

	/**
	 * @param nome
	 * @param nota
	 * @param posicao
	 * @param jogos
	 * @param vitorias
	 */
	public Jogador(String nome, double nota, String posicao, int jogos, int vitorias) {
		this.nome = nome;
		this.nota = nota;
		this.posicao = posicao;
	}

	public Jogador() {
	}

	public Jogador(String pNome) {
		nome = pNome;
	}


	/**
	 * @return the id_jogador
	 */
	public Long getId_jogador() {
		return id_jogador;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * @return the posicao
	 */
	public String getPosicao() {
		return posicao;
	}

	/**
	 * @param posicao
	 *            the posicao to set
	 */
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	/**
	 * @return the jogos
	 */
	public int getJogos() {
		return jogos;
	}

	/**
	 * @param jogos
	 *            the jogos to set
	 */
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}

	/**
	 * @return the vitorias
	 */
	public int getVitorias() {
		return vitorias;
	}

	/**
	 * @param vitorias
	 *            the vitorias to set
	 */
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

}
