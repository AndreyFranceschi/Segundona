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
//import br.com.tt.util.faces.UtilMessage;

@ManagedBean
@SessionScoped
public class EquipeBean {

	private Equipe equipe;
	private List<Equipe> equipes;
	private IDao<Equipe> dao;
	private IDao<Jogador> daoJog;
	private String jogador1;
	private String jogador2;
	private String jogador3;
	private String jogador4;
	private String jogador5;
	private String jogador6;
	private String jogador7;

	@PostConstruct
	private void init() {
		System.out.println("private init equipebean");
		dao = new Dao<Equipe>(Equipe.class);
		daoJog = new Dao<Jogador>(Jogador.class);
		equipes = new ArrayList<Equipe>();
		equipes = dao.consultar();
		equipe = new Equipe();
		jogador1 = "";
		jogador2 = "";
		jogador3 = "";
		jogador4 = "";
		jogador5 = "";
		jogador6 = "";
		jogador7 = "";
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe pEquipe) {
		equipe = pEquipe;
	}

	public void salvar() {
		System.out.println("public void salvar equipebean");
		Jogador jog;
		if (jogador1 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador1));
			equipe.setJogador1(jog);
		}
		if (jogador2 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador2));
			equipe.setJogador2(jog);
		}
		if (jogador3 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador3));
			equipe.setJogador3(jog);
		}
		if (jogador4 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador4));
			equipe.setJogador4(jog);
		}
		if (jogador5 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador5));
			equipe.setJogador5(jog);
		}
		if (jogador6 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador6));
			equipe.setJogador6(jog);
		}
		if (jogador7 != "") {
			jog = daoJog.buscar(Long.parseLong(jogador7));
			equipe.setJogador7(jog);
		}
		dao.salvar(equipe);
		equipe = new Equipe();
	//	UtilMessage.info("Equipe Salva", "Equipe Salva com sucesso");
		equipes = dao.consultar();
		jogador1 = "";
		jogador2 = "";
		jogador3 = "";
		jogador4 = "";
		jogador5 = "";
		jogador6 = "";
		jogador7 = "";
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void alterar(Equipe pEquipe) {
		System.out.println("public void alterar equipebean");
		equipe = pEquipe;
		if (equipe.getJogador1() != null)
			jogador1 = equipe.getJogador1().getId_jogador().toString();
		if (equipe.getJogador2() != null)
			jogador2 = equipe.getJogador2().getId_jogador().toString();
		if (equipe.getJogador3() != null)
			jogador3 = equipe.getJogador3().getId_jogador().toString();
		if (equipe.getJogador4() != null)
			jogador4 = equipe.getJogador4().getId_jogador().toString();
		if (equipe.getJogador5() != null)
			jogador5 = equipe.getJogador5().getId_jogador().toString();
		if (equipe.getJogador6() != null)
			jogador6 = equipe.getJogador6().getId_jogador().toString();
		if (equipe.getJogador7() != null)
			jogador7 = equipe.getJogador7().getId_jogador().toString();
	}
	
	public void cancelar() {
		System.out.println("public void cancelar equipebean");
		equipe = new Equipe();
		equipes = dao.consultar();
		jogador1 = "";
		jogador2 = "";
		jogador3 = "";
		jogador4 = "";
		jogador5 = "";
		jogador6 = "";
		jogador7 = "";
	}

	public void excluir(Equipe pEquipe) {
		//UtilMessage.warn("", pEquipe.getCor() + " Foi Excluida!");
		dao.excluir(pEquipe.getId_equipe());
		equipes = dao.consultar();
	}

	/**
	 * @return the jogador1
	 */
	public String getJogador1() {
		return jogador1;
	}

	/**
	 * @param jogador1
	 *            the jogador1 to set
	 */
	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}

	/**
	 * @return the jogador2
	 */
	public String getJogador2() {
		return jogador2;
	}

	/**
	 * @param jogador2
	 *            the jogador2 to set
	 */
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}

	/**
	 * @return the jogador3
	 */
	public String getJogador3() {
		return jogador3;
	}

	/**
	 * @param jogador3
	 *            the jogador3 to set
	 */
	public void setJogador3(String jogador3) {
		this.jogador3 = jogador3;
	}

	/**
	 * @return the jogador4
	 */
	public String getJogador4() {
		return jogador4;
	}

	/**
	 * @param jogador4
	 *            the jogador4 to set
	 */
	public void setJogador4(String jogador4) {
		this.jogador4 = jogador4;
	}

	/**
	 * @return the jogador5
	 */
	public String getJogador5() {
		return jogador5;
	}

	/**
	 * @param jogador5
	 *            the jogador5 to set
	 */
	public void setJogador5(String jogador5) {
		this.jogador5 = jogador5;
	}

	/**
	 * @return the jogador6
	 */
	public String getJogador6() {
		return jogador6;
	}

	/**
	 * @param jogador6
	 *            the jogador6 to set
	 */
	public void setJogador6(String jogador6) {
		this.jogador6 = jogador6;
	}

	/**
	 * @return the jogador7
	 */
	public String getJogador7() {
		return jogador7;
	}

	/**
	 * @param jogador7
	 *            the jogador7 to set
	 */
	public void setJogador7(String jogador7) {
		this.jogador7 = jogador7;
	}

}
