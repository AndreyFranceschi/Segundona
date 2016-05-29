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
public class Equipe{

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
	
	/**
	 * @param cor
	 * @param jogadores
	 */
	public Equipe(String cor, Jogador jogador) {
		System.out.println("public Equipe cor jogador");
		this.cor = cor;
		jogador1 = jogador;
	}
	
	public Equipe() {System.out.println("public Equipe");}
	
	public Equipe(String pCor) {
		System.out.println("public Equipe cor");
		cor = pCor;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id_equipe;
	}
	
	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}
	/**
	 * @param cor the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * @return the jogador1
	 */
	public Jogador getJogador1() {
		if(jogador1 == null){
			return new Jogador();
		}else
		return jogador1;
	}

	/**
	 * @param jogador1 the jogador1 to set
	 */
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}
	
	public void imprime(){
		System.out.println(jogador1.getNome()+jogador1.getNome());
	}

	public void setJogador2(Jogador pJogador2) {
		jogador2 = pJogador2;
		
	}
	
}
