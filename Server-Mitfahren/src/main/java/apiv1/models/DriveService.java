package apiv1.models;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DriveService {
	
	@PersistenceContext
	protected EntityManager em;
	
	public DriveService(){}
	
	public void persists(Drive drive){
		em.persist(drive);
	}
	
	public void find(int id){
		em.find(Drive.class, id);
	}
	
	 /**
	   * Method to find beacons by their uuid.
	   * @param uuid UUID of the beacon.
	   * @return One beacon instance with the unique uuid.
	   */
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
