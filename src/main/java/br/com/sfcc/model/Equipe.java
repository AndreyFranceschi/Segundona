package br.com.sfcc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Equipe {

	@Id
	@SequenceGenerator(name = "equipe_seq", sequenceName = "equipe_seq", allocationSize = 1)
	@GeneratedValue(generator = "equipe_seq", strategy = GenerationType.SEQUENCE)
	private Long id_equipe;

	private String cor;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador1;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador2;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador3;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador5;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador6;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Jogador jogador7;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Partida partida;

	/**
	 * @param cor
	 * @param jogadores
	 */
	public Equipe(String cor, Jogador jogador) {
		System.out.println("public Equipe cor jogador");
		this.cor = cor;
		jogador1 = jogador;
	}

	public Equipe() {
		System.out.println("public Equipe");
	}

	public Equipe(String pCor) {
		System.out.println("public Equipe cor");
		cor = pCor;
	}

	/**
	 * @return the id_equipe
	 */
	public Long getId_equipe() {
		return id_equipe;
	}

	/**
	 * @return the partida
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * @param partida
	 *            the partida to set
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @param cor
	 *            the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * @return the jogador1
	 */
	public Jogador getJogador1() {
		return jogador1;
	}

	/**
	 * @param jogador1
	 *            the jogador1 to set
	 */
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public void imprime() {
		System.out.println(jogador1.getNome() + jogador1.getNome());
	}

	/**
	 * @return the jogador2
	 */
	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador pJogador2) {
		jogador2 = pJogador2;

	}

	/**
	 * @return the jogador3
	 */
	public Jogador getJogador3() {
		return jogador3;
	}

	/**
	 * @param jogador3
	 *            the jogador3 to set
	 */
	public void setJogador3(Jogador jogador3) {
		this.jogador3 = jogador3;
	}

	/**
	 * @return the jogador4
	 */
	public Jogador getJogador4() {
		return jogador4;
	}

	/**
	 * @param jogador4
	 *            the jogador4 to set
	 */
	public void setJogador4(Jogador jogador4) {
		this.jogador4 = jogador4;
	}

	/**
	 * @return the jogador5
	 */
	public Jogador getJogador5() {
		return jogador5;
	}

	/**
	 * @param jogador5
	 *            the jogador5 to set
	 */
	public void setJogador5(Jogador jogador5) {
		this.jogador5 = jogador5;
	}

	/**
	 * @return the jogador6
	 */
	public Jogador getJogador6() {
		return jogador6;
	}

	/**
	 * @param jogador6
	 *            the jogador6 to set
	 */
	public void setJogador6(Jogador jogador6) {
		this.jogador6 = jogador6;
	}

	/**
	 * @return the jogador7
	 */
	public Jogador getJogador7() {
		return jogador7;
	}

	/**
	 * @param jogador7
	 *            the jogador7 to set
	 */
	public void setJogador7(Jogador jogador7) {
		this.jogador7 = jogador7;
	}

	public String imprimeEquipe() {
		String time = new String();
		if (jogador1 != null)
			time = time + jogador1.getNome();
		if (jogador2 != null)
			time = time + " - \n" + jogador2.getNome();
		if (jogador3 != null)
			time = time + " - \n" + jogador3.getNome();
		if (jogador4 != null)
			time = time + " - \n" + jogador4.getNome();
		if (jogador5 != null)
			time = time + " - \n" + jogador5.getNome();
		if (jogador6 != null)
			time = time + " - \n" + jogador6.getNome();
		if (jogador7 != null)
			time = time + " - \n" + jogador7.getNome();
		return time;
	}
}
