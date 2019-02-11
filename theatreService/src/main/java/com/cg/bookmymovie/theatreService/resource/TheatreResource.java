package com.cg.bookmymovie.theatreService.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Theatre;
import com.cg.bookmymovie.theatreService.service.TheatreService;

@RestController
@RequestMapping("/theatres")
public class TheatreResource {

	@Autowired
	private TheatreService theatreService;

	@PostMapping
	public void addMovies(@RequestBody Theatre theatre) {
		theatreService.addNewTheatre(theatre);
	}

	@GetMapping
	public ResponseEntity<List<Theatre>> getALLTheatre() {
		List<Theatre> theatres = theatreService.getAllTheatres();
		return new ResponseEntity<>(theatres, HttpStatus.OK);
	}

	@GetMapping("/specific")
	public ResponseEntity<List<Theatre>> getSpecificTheatre(@RequestParam String state, @RequestParam String city,
			@RequestParam String street, @RequestParam String theatreName) {
		Address address = new Address();
		address.getState();
		address.setCity(city);
		address.setStreet(street);
		Optional<Theatre> theatre = theatreService.getParticularTheatre(address, theatreName);
		return new ResponseEntity<List<Theatre>>(HttpStatus.OK);

	}

	/*
	 * @PutMapping("/{theatreName}") public ResponseEntity<Theatre>
	 * updateTheatre(@RequestParam String state, @RequestParam String city,
	 * 
	 * @RequestParam String street, @RequestParam String theatreName) {
	 * 
	 * Address address = new Address(); address.getState(); address.setCity(city);
	 * address.setStreet(street); Theatre theatre =
	 * theatreService.getParticularTheatre(address, theatreName); if
	 * (!theatre.isPresent()) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * theatreService.updateTheatre(address, theatreName); return new
	 * ResponseEntity<>(HttpStatus.OK); }
	 */

	/*
	 * @DeleteMapping("/{theatreName}") public ResponseEntity<String>
	 * deleteTheatre(@RequestParam String state, @RequestParam String city,
	 * 
	 * @RequestParam String street, @RequestParam String theatreName) {
	 * 
	 * Address address = new Address(); address.getState(); address.setCity(city);
	 * address.setStreet(street); Optional<Theatre> theatre =
	 * theatreService.getParticularTheatre(address, theatreName); if
	 * (!theatre.isPresent()) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * theatreService.deleteTheatre(address, theatreName); return new
	 * ResponseEntity<>("Theatre Deleted SuccessFully", HttpStatus.OK); }
	 */

}
