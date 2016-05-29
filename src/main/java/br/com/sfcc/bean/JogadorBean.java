package br.com.sfcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sfcc.dao.Dao;
import br.com.sfcc.dao.IDao;
import br.com.sfcc.model.Jogador;
import br.com.tt.util.faces.UtilMessage;

@ManagedBean
@SessionScoped
public class JogadorBean {

	private Jogador jogador;
	private List<Jogador> jogadores;
	private IDao<Jogador> dao;
	
	@PostConstruct
	private void init(){
		System.out.println("private void init jogadorbean");
		dao = new Dao<Jogador>(Jogador.class);
		jogadores = new ArrayList<Jogador>();
		jogadores = dao.consultar();
		jogador = new Jogador();
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public void salvar() {
		System.out.println("public void salvar jogadorbean");
		dao.salvar(jogador);
		jogador = new Jogador();
		UtilMessage.info("Jogador Salvo", "Jogador Salvo com sucesso");
		jogadores = dao.consultar();
	}

	public List<Jogador> getJogadores() {
		System.out.println("public List jogadores");
		return jogadores;
	}
	
	public void alterar(Jogador pJogador) {
		System.out.println("public void alterar jogador");
		jogador = pJogador;
	}

	public void excluir(Jogador pJogador) {
		UtilMessage.warn("", pJogador.getNome()+" Foi Excluido!");
		dao.excluir(pJogador.getId());
		jogadores = dao.consultar();
	}
	

}
