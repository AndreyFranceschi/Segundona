package br.com.sfcc.model;

import java.util.ArrayList;

public class Calendario {

	private ArrayList<Partida> partidas;

	/**
	 * @param partidas
	 */
	public Calendario(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	public void imprimeTimeVencedor(int numero){
		if (partidas.get(numero-1).getVencedor() == 1) {
			System.out.println("imprime time 1");
			partidas.get(numero).getEquipe1().imprime();
		}else {
			if(partidas.get(numero).getVencedor() == 2){
				System.out.println("imprime time 2");
				partidas.get(numero).getEquipe2().imprime();
			}else {
				System.out.println("A partida ainda não foi realizada ou não cadastrado o vencedor!");
			}
		}
	}
	/**
	 * @return the partidas
	 */
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	
}
