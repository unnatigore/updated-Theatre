
package com.cg.bookmymovie.theatreService.service;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Auditorium;
import com.cg.bookmymovie.theatreService.entity.Seat;
import com.cg.bookmymovie.theatreService.entity.Theatre;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TheatreServiceImplIntegrationTest {

	@Autowired(required = true)
	private TheatreService theatreService;

	Theatre theatre, theatre2;

	@Before
	public void addTheatreFailedTest() {

		Set<Seat> seatSet = new HashSet<Seat>();

		Set<Auditorium> auditoriumSet = new HashSet<Auditorium>();

		seatSet.add(new Seat("Gold", "F", 15));
		seatSet.add(new Seat("Platinum", "P", 65));
		auditoriumSet.add(new Auditorium("alpha", seatSet));
		auditoriumSet.add(new Auditorium("beta", seatSet));

		Address address = new Address("Maharashtra", "Mumbai", "Thane");

		Address address2 = new Address("Rajasthan", "Kota", "Nayapura");

		theatre = new Theatre(1, "HyperCinema", address, auditoriumSet);
		theatre2 = new Theatre(2, "HyperCinema", address2, auditoriumSet);

	}

	@Test

	@Ignore
	public void testgetAllTheatreQuantity() {
		assertEquals(2, theatreService.getAllTheatres().size());
	}

	
	/*
	 * @Test
	 * 
	 * @Ignore public void testGetTheatreByWrongName() { assertEquals(null,
	 * theatreService.findTheatreByName("Mangala")); }
	 */

	
	  @Test
	  public void testGetTheatreByRightName() {
		  Address address2 = new Address("Rajasthan", "Kota", "Nayapura");

	  assertEquals(theatreService.getParticularTheatre(address2, "HyperCinema").get().getTheatreName(),
	  theatre2.getTheatreName()); }
	 
	
	/*
	 * @Test public void testDeleteTheatreByCorrectName() { Address address = new
	 * Address("Maharashtra", "Mumbai", "Thane");
	 * 
	 * theatreService.deleteTheatre(address, "HyperCinema"); assertEquals(null,
	 * theatreService.getParticularTheatre(address, "HyperCinema")); }
	 */
	 
	/*
	 * @Test
	 * 
	 * @Ignore public void testDeleteTheatreByWrongName() {
	 * theatreService.deleteTheatre(theatre); assertEquals(null,
	 * theatreService.findTheatreByName("mangala")); }
	 */

	/*
	 * @Test
	 * 
	 * @Ignore public void addNewTheatres() {
	 * theatreService.addNewTheatre(theatre2); System.out.println("Entering " +
	 * theatreService.findTheatreByName("Kota").getTheatreAddress().getCity());
	 * theatreService.findTheatreByName("HyperCinema").getTheatreName(); }
	 */

	/*
	 * @Test
	 * 
	 * @Ignore public void testAddNewTheatre() {
	 * theatreService.addNewTheatre(theatre2); assertEquals("Kota",
	 * theatreService.findTheatreByName("HyperCinema")); }
	 */

}
