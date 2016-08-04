package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MitfahrenUserService {
	/**
	 * Manager who directly interarcts with the database.
	 */
	@PersistenceContext(unitName = "Mitfahren")
	protected EntityManager em;
	
	/**
	 * This Constructor is needed for Hypernate or the Persistence API.
	 */
	public MitfahrenUserService(){}
	
	/**
	 * Stores or updates a User in the database.
	 * @param user
	 */
	public void persists(MitfahrenUser user){
		em.persist(user);
	}
	
	/**
	 * Finds a drive in the database with the help of the id.
	 * @param id
	 */
	public MitfahrenUser find(int id){
		return em.find(entities.MitfahrenUser.class, id);
	}
	
}
