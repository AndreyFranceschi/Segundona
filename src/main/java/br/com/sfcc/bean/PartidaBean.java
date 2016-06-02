package br.com.sfcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sfcc.dao.Dao;
import br.com.sfcc.dao.IDao;
import br.com.sfcc.model.Equipe;
import br.com.sfcc.model.Jogador;
import br.com.sfcc.model.Partida;
import br.com.tt.util.faces.UtilMessage;

@ManagedBean
@SessionScoped
public class PartidaBean {

	private Partida partida;
	private List<Partida> partidas;
	private IDao<Partida> dao;
	private IDao<Equipe> daoEquipe;
	private String equipe1;
	private String equipe2;
	
	@PostConstruct
	private void init(){
		System.out.println("private void init partidabean");
		dao = new Dao<Partida>(Partida.class);
		daoEquipe = new Dao<Equipe>(Equipe.class);
		partidas = new ArrayList<Partida>();
		partidas = dao.consultar();
		partida = new Partida();
		equipe1 = "";
		equipe2 = "";
	}
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public void salvar() {
		Equipe equipe = new Equipe();
		dao.salvar(partida);
		if (equipe1 != "") {
			equipe = daoEquipe.buscar(Long.parseLong(equipe1));
			equipe.setPartida(partida);
			partida.setEquipe1(equipe);
			daoEquipe.salvar(equipe);
		}
		if (equipe2 != "") {
			equipe = daoEquipe.buscar(Long.parseLong(equipe2));
			equipe.setPartida(partida);
			partida.setEquipe2(equipe);
			daoEquipe.salvar(equipe);
		}
		dao.salvar(partida);
		partida = new Partida();
		UtilMessage.info("Partida Salva", "Partida Salva com sucesso");
		partidas = dao.consultar();
		equipe1 = "";
		equipe2 = "";
	}

	public List<Partida> getPartidas() {
		return partidas;
	}
	
	public void alterar(Partida pPartida) {
		partida = pPartida;
		if (partida.getEquipe1() != null)
			equipe1 = partida.getEquipe1().getId_equipe().toString();
		if (partida.getEquipe2() != null)
			equipe2 = partida.getEquipe2().getId_equipe().toString();
	}

	public void excluir(Partida pPartida) {
		UtilMessage.warn("", pPartida.getId_partida()+" Foi Excluida!");
		dao.excluir(pPartida.getId_partida());
		partidas = dao.consultar();
	}
	
	public void cancelar() {
		System.out.println("public void cancelar equipebean");
		partida = new Partida();
		partidas = dao.consultar();
		equipe1 = "";
		equipe2 = "";
	}
	
	/**
	 * @return the equipe1
	 */
	public String getEquipe1() {
		return equipe1;
	}
	/**
	 * @param equipe1 the equipe1 to set
	 */
	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}
	/**
	 * @return the equipe2
	 */
	public String getEquipe2() {
		return equipe2;
	}
	/**
	 * @param equipe2 the equipe2 to set
	 */
	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}
	

}
