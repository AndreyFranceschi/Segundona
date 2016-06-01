package br.com.sfcc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.sfcc.bean.JogadorBean;

public class Equipe2{

	@Id
	@SequenceGenerator(name = "equipe_seq", sequenceName = "equipe_seq", allocationSize = 1)
	@GeneratedValue(generator = "equipe_seq", strategy = GenerationType.SEQUENCE)
	private Long id_equipe;
	
	private String cor;
	
	@Column
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="equipe_jogador",
	      joinColumns={ @JoinColumn(name="id_equipe", referencedColumnName="id_equipe") },
	      inverseJoinColumns={ @JoinColumn(name="id_jogador", referencedColumnName="id_jogador") }
	  )	
	private List<Jogador> jogadores;
	
	/**
	 * @param cor
	 * @param jogadores
	 */
	public Equipe2(String cor, List<Jogador> jogadores) {
		this.cor = cor;
		this.jogadores = jogadores;
	}
	
	public Equipe2() {}
	
	public Equipe2(String pCor) {
		cor = pCor;
	}
	
	public void adicionaJogador(String pJogador){
		Long pJog = Long.parseLong( pJogador );
		JogadorBean jog = new JogadorBean();
		List<Jogador> jogs = jog.getJogadores();
		for (Jogador jogador : jogs) {
			if(jogador.getId_jogador() == pJog){
				jogadores.add(jogador);
			}
		}
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
	 * @return the jogadores
	 */
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	/**
	 * @param jogadores the jogadores to set
	 */
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void imprime() {
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.getNome());
		}
		
	}
	
	
}
