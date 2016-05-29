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
import br.com.tt.util.faces.UtilMessage;

@ManagedBean
@SessionScoped
public class EquipeBean {

	private Equipe equipe;
	private List<Equipe> equipes;
	private IDao<Equipe> dao;

	@PostConstruct
	private void init() {
		System.out.println("private init equipebean");
		dao = new Dao<Equipe>(Equipe.class);
		equipes = new ArrayList<Equipe>();
		equipes = dao.consultar();
		equipe = new Equipe();
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe pEquipe) {
		equipe = pEquipe;
	}

	public void salvar() {
		System.out.println("public void salvar equipebean");
		/*if (equipe.getJogador1().getId() > 0) {
			List<Jogador> jogs = new JogadorBean().getJogadores();
			for (Jogador jogador : jogs) {
				System.out.println("imprimindo");
				System.out.println(jogador.getNome());
			}
		}*/
		Dao<Jogador> jogi = new Dao<Jogador>(Jogador.class);
		Jogador jog = jogi.buscar(Long.parseLong("2"));
		equipe.setJogador1(jog);
		dao.salvar(equipe);
		equipe = new Equipe();
		UtilMessage.info("Equipe Salva", "Equipe Salva com sucesso");
		equipes = dao.consultar();
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void alterar(Equipe pEquipe) {
		System.out.println("public void alterar equipebean");
		equipe = pEquipe;
	}

	public void excluir(Equipe pEquipe) {
		UtilMessage.warn("", pEquipe.getCor() + " Foi Excluido!");
		dao.excluir(pEquipe.getId());
		equipes = dao.consultar();
	}

}
