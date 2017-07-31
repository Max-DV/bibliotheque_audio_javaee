package fr.sopra.pox3.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.sopra.pox3.entities.MaisonDeDisque;

@Stateless
public class MaisonDeDisqueDAO {

	@PersistenceContext
	private EntityManager em;
	
	public MaisonDeDisque findById(int id){
		TypedQuery<MaisonDeDisque> q = em.createQuery("from maisons_de_disque m left join fetch m.auteurs where m.id= :id", MaisonDeDisque.class);
		q.setParameter("id", 322);
		return q.getSingleResult();
	}

	public List<MaisonDeDisque> findAll() {
		
		return em.createQuery("from maisons_de_disque m", MaisonDeDisque.class).getResultList();
	}
	
	public void add (MaisonDeDisque maisonDeDisque)
	{
		em.persist(maisonDeDisque);
	}
	
	public void update(MaisonDeDisque maisonDeDisque)
	{
		em.merge(maisonDeDisque);
	}
	public void deleteById(int id) {
	
		MaisonDeDisque maison = em.find(MaisonDeDisque.class, id);
		if(maison != null)
			em.remove(maison);
	}
	
}
