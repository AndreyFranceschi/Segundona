package br.com.sfcc.fabrica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sfcc.model.Equipe;
import br.com.sfcc.model.Jogador;

public class Fabrica {
	public static void main(String[] args) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_segundonafcc");
        EntityManager em = emf.createEntityManager();
 
        try {
        	em.getTransaction().begin();
        	 
            Equipe customer = new Equipe();
            customer.setCor("John Doe");
 
            Jogador user = new Jogador();
            user.setNome("Andrey");
            user.setNota(8);
 
            Jogador user2 = new Jogador();
            user2.setNome("bite");
            user2.setNota(5);
            
            customer.setJogador1(user);
            customer.setJogador2(user2);
            
            em.persist(user);
            em.persist(user2);
            em.persist(customer);
 
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
 
        System.out.println("It is over");
		
		
		/*Jogador jog1 = new Jogador("Andrey", 7, null, 0, 0);
		Jogador jog2 = new Jogador("Bite", 5, null, 0, 0);
		Jogador jog3 = new Jogador("Carioca", 8, null, 0, 0);
		Jogador jog4 = new Jogador("Thomas", 6, null, 0, 0);
		
		JogadorBean jogBean = new JogadorBean();
		jogBean.init();
		jogBean.setJogador(jog1);
		jogBean.salvar();
		jogBean.setJogador(jog2);
		jogBean.salvar();
		jogBean.setJogador(jog3);
		jogBean.salvar();
		jogBean.setJogador(jog4);
		jogBean.salvar();
		
		Equipe eq1 = new Equipe("amarelo");
		
		EquipeBean equBean = new EquipeBean();
		equBean.init();
		equBean.setEquipe(eq1);
		equBean.salvar();
		
		List<Jogador> jogeq1 = new ArrayList<Jogador>();
		jogeq1.add(jog1);
		jogeq1.add(jog4);
		
		List<Jogador> jogeq2 = new ArrayList<Jogador>();
		jogeq2.add(jog2);
		jogeq2.add(jog3);
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		Date dataUsuario = sdf1.parse("29/04/2016");
		Partida partida1 = new Partida(dataUsuario, "Classico", eq1, eq2, 1);
		Partida partida2 = new Partida(dataUsuario, "Classico", eq1, eq2, 2);
		
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		partidas.add(partida1);
		partidas.add(partida2);
		
		Calendario calendario = new Calendario(partidas);
		calendario.imprimeTimeVencedor(1);*/
	}
}
