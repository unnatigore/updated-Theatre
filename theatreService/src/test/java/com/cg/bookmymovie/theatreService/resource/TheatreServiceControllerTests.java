package com.cg.bookmymovie.theatreService.resource;

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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Auditorium;
import com.cg.bookmymovie.theatreService.entity.Seat;
import com.cg.bookmymovie.theatreService.entity.Theatre;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TheatreServiceControllerTests {

	Theatre theatre;
	Theatre theatre2;

	@Autowired
	private TestRestTemplate testRestTemplate;


	@Before
	public void input() throws Exception {

		Set<Seat> seatSet = new HashSet<Seat>();

		Set<Auditorium> auditoriumSet = new HashSet<Auditorium>();

		seatSet.add(new Seat("Gold", "F", 15));
		seatSet.add(new Seat("Platinum","P", 65));
		auditoriumSet.add(new Auditorium("alpha", seatSet));
		auditoriumSet.add(new Auditorium("beta", seatSet));

		Address address = new Address("Maharashtra", "Mumbai", "Thane");

		Address address2 = new Address("Rajasthan", "Kota", "Nayapura");

		theatre = new Theatre(1, "HyperCinema", address, auditoriumSet);
		theatre2 = new Theatre(2, "HyperCinema", address2, auditoriumSet);

	}

	@Test
	@Ignore
	public void noControllerTest() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres", Resource.class);

		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
	}

	@Test
	@Ignore
	public void controllerWithNoUrlTest() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres", Resource.class);

		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
	}

	@Test
	@Ignore
	public void controllerWithWrongUrlTest() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres", Resource.class);

		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
	}

	@Test
	@Ignore
	public void controllerWithoutMapping() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres", Resource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Test
	@Ignore
	public void getMethodByIdPresentTest() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres/1",
				Resource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	

	@Test
	@Ignore
	public void getAllTheatresTest() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres",
				Resource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	@Ignore
	public void getAllTheatresTestWithWrongMapping() throws Exception {
		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatre",
				Resource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}


	@Test
	@Ignore
	public void getMethodByIdDoesNotExistTest() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres/2", Resource.class);
		assertEquals((responseEntity.getStatusCode()), HttpStatus.NOT_FOUND);
	}
	
	@Test
	@Ignore
	public void getMethodByIdWithWrongDataTypeTest() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/theatres/ONE", Resource.class);
		assertEquals((responseEntity.getStatusCode()), HttpStatus.BAD_REQUEST);
	}


	@Test
	@Ignore
	public void postMappingExistTest() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.postForEntity("/theatres", theatre, null);
		assertEquals((responseEntity.getStatusCode()), HttpStatus.OK);
	}
	
	@Test
	@Ignore
	public void deleteMapping() throws Exception {
		testRestTemplate.delete("/theatres/1");
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/theatres/1", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	@Ignore
	public void testUpdateTheatreName() {
		testRestTemplate.put("/theatres/2?theatreName=Cenapolis", null);
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/theatres/2", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
}

