package br.com.sfcc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Partida {

	@Id
	@SequenceGenerator(name = "partida_seq", sequenceName = "partida_seq", allocationSize = 1)
	@GeneratedValue(generator = "partida_seq", strategy = GenerationType.SEQUENCE)
	private Long id_partida;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String tipo;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
	private Equipe equipe1;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
	private Equipe equipe2;
	
	private int vencedor;

	/**
	 * @param numero
	 * @param data
	 * @param tipo
	 * @param equipe1
	 * @param equipe2
	 * @param vencedor
	 */
	public Partida(Date data, String tipo, Equipe equipe1, Equipe equipe2, int vencedor) {
		this.data = data;
		this.tipo = tipo;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.vencedor = vencedor;
	}

	public Partida(){}
	/**
	 * @return the id_partida
	 */
	public Long getId_partida() {
		return id_partida;
	}


	/**
	 * @param id_partida the id_partida to set
	 */
	public void setId_partida(Long id_partida) {
		this.id_partida = id_partida;
	}


	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the equipe1
	 */
	public Equipe getEquipe1() {
		return equipe1;
	}

	/**
	 * @param equipe1
	 *            the equipe1 to set
	 */
	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	/**
	 * @return the equipe2
	 */
	public Equipe getEquipe2() {
		return equipe2;
	}

	/**
	 * @param equipe2
	 *            the equipe2 to set
	 */
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	/**
	 * @return the vencedor
	 */
	public int getVencedor() {
		return vencedor;
	}

	/**
	 * @param vencedor
	 *            the vencedor to set
	 */
	public void setVencedor(int vencedor) {
		this.vencedor = vencedor;
	}

}
