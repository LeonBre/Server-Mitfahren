package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CityService {

	/**
	 * Manager who directly interarcts with the database.
	 */
	@PersistenceContext(unitName = "Mitfahren")
	protected EntityManager em;
	
	/**
	 * This Constructor is needed for Hypernate or the Persistence API.
	 */
	public CityService(){}
	
	/**
	 * Stores or updates a User in the database.
	 * @param user
	 */
	public void persists(City city){
		em.persist(city);
	}
	
	/**
	 * Finds a drive in the database with the help of the id.
	 * @param id
	 */
	public City find(int id){
		return em.find(entities.City.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public City find(String cityName) {
		List<City> cities = null;
	    try {
	      cities = (List<City>)em.createQuery("FROM city c WHERE c.name = '" + cityName + "' ")
	        .getResultList();
	    } catch (javax.persistence.NoResultException noResultException) {
	      System.out.println("No Entity found");
	    }
	    return cities.get(0);
	}
}
