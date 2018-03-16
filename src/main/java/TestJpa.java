import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Client;
import model.Emprunt;
import model.Livre;

/**
 * 
 */

/**
 * @author Alexis Darcy
 *
 */
public class TestJpa {
	public static void main(String[] args){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		List<Livre> listLivre = new ArrayList<Livre>();
		
		TypedQuery<Livre> livreQuery = em.createQuery("select l from Livre l", Livre.class);
		listLivre = livreQuery.getResultList();
		
		System.out.println("_______________________________________________________________________________________________________________________\n");
		for(Livre l : listLivre){
			System.out.println(l);
			for (Emprunt e : l.getEmprunts()) {
				System.out.println(e);
			}
		}
		

		Livre livre = em.find(Livre.class, 4);
		System.out.println("_______________________________________________________________________________________________________________________\n");
		System.out.println(livre);
		
		livreQuery = em.createQuery("select l from Livre l where l.titre = :titreLivre", Livre.class);
		livreQuery.setParameter("titreLivre", "Guerre et paix");
		livre = livreQuery.getSingleResult();
		System.out.println("_______________________________________________________________________________________________________________________\n");
		System.out.println(livre);		
		
		List<Emprunt> listEmprunt= new ArrayList<Emprunt>();
		
		TypedQuery<Emprunt> empruntQuery = em.createQuery("select e from Emprunt e", Emprunt.class);
		listEmprunt = empruntQuery.getResultList();
		
		System.out.println("_______________________________________________________________________________________________________________________\n");
		for(Emprunt e : listEmprunt){
			System.out.println(e);
		}
		
		empruntQuery = em.createQuery("select e from Emprunt e where e.id = :idEmprunt", Emprunt.class);
		empruntQuery.setParameter("idEmprunt", 2);
		Emprunt emprunt = empruntQuery.getSingleResult();
		System.out.println("_______________________________________________________________________________________________________________________\n");
		System.out.println(emprunt);
		for(Livre l : emprunt.getLivres()){
			System.out.println(l);
		}
		
		TypedQuery<Client> clientQuery = em.createQuery("select c from Client c where id = :idClient", Client.class);
		clientQuery.setParameter("idClient", 3);
		Client client = clientQuery.getSingleResult();
		
		List<Emprunt> listEmprunt2= new ArrayList<Emprunt>();
		
		empruntQuery = em.createQuery("select e from Emprunt e where e.client.id = :idClient", Emprunt.class);
		empruntQuery.setParameter("idClient", client.getId());
		listEmprunt2 = empruntQuery.getResultList();
		System.out.println("_______________________________________________________________________________________________________________________\n");
		for(Emprunt e : listEmprunt2){
			System.out.println(e);
		}
		em.close();
		entityManagerFactory.close();
	}
}
