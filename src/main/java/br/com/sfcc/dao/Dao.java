package br.com.sfcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sfcc.model.Jogador;

public class Dao<T> implements IDao<T> {

	private EntityManager em;
	private Class<T> type;

	public static void main(String[] args) {
		Jogador jog = new Jogador();
		jog.setNome("andrey");

		Dao<Jogador> dao = new Dao<Jogador>(Jogador.class);
		dao.salvar(jog);
		List<Jogador> consultar = dao.consultar();
		for (Jogador p : consultar) {
			System.out.println(p.getNome());
		}
	}

	public Dao(Class<T> type) {
		this.type = type;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_segundonafcc");
		em = emf.createEntityManager();
	}

	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}

	public void salvar(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public T buscar(Long id) {
		return em.find(type, id);
	}

	public List<T> consultar() {
		String sql = "SELECT t FROM " + type.getName() + " t";
		TypedQuery<T> query = em.createQuery(sql, type);
		return query.getResultList();
	}

	public void excluir(Long id) {
		em.getTransaction().begin();
		em.remove(buscar(id));
		em.getTransaction().commit();
	}

}
