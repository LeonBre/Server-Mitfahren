package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*TODO: Check if findByDestinationArrival works right
 * 
 */

/**
 * Service to interact with the stored drives.
 * @author Leon Johann Brettin
 *
 */
@Stateless
public class DriveService {
	
	/**
	 * Manager who directly interarcts with the database.
	 */
	@PersistenceContext
	protected EntityManager em;
	
	/**
	 * This Constructor is needed for Hypernate or the Persistence API.
	 */
	public DriveService(){}
	
	/**
	 * Stores or updates a drive in the database.
	 * @param drive
	 */
	public void persists(Drive drive){
		em.persist(drive);
	}
	
	/**
	 * Finds a drive in the database with the help of the id.
	 * @param id
	 */
	public void find(int id){
		em.find(entities.Drive.class, id);
	}
	
	 /**
	   * Method to find beacons by their uuid.
	   * @param uuid UUID of the beacon.
	   * @return One beacon instance with the unique uuid.
	   */
	  @SuppressWarnings("unchecked")
	public List<Drive> findByDestinationArrival(String destination, String arrival) {
	    List<Drive> drive = null;
	    try {
	      drive = (List<Drive>)em.createQuery("SELECT e FROM Drive e WHERE e.destination.name LIKE :destinationParamter "
	      		+ "AND e.arrival.name like :arrivalParameter")
	        .setParameter("destinationParameter", destination)
	        .setParameter("arrivalParameter", arrival)
	        .getResultList();
	      
	    } catch (javax.persistence.NoResultException noResultException) {
	      System.out.println("No Entity found");
	    }
	    return drive;
	  }
}
