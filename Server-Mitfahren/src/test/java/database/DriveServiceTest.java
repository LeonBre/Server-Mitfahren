package database;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;

import entities.City;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;

public class DriveServiceTest {
	
	//TODO Check how to test the database with junit
	
//	@Inject
//	DriveService df;
//	
////	@org.junit.Test
////	public void test_Initialization() {
////		DriveService df = new DriveService();
////		
////		assertTrue(true);
////	}
//////	
////	@org.junit.Test
////	public void test_Persist() {
////		
////	}
////	
////	@org.junit.Test
////	public void test_Find() {
////		
////	}
//	
//	@org.junit.Test
//	public void test_FindByDestinationArrival() {
//		DriveService df = new DriveService();
//		
//		Drive drive = new Drive(new City("Leer"), new City("Spetzerfehn"), new Date(System.currentTimeMillis()), new User());
//		df.persists(drive);
//		
//		int succesCount = df.findByDestinationArrival("Leer", "Spezteferfehn").size();
//		System.out.println(succesCount);
//		assertEquals(1, succesCount);
//	}
}

