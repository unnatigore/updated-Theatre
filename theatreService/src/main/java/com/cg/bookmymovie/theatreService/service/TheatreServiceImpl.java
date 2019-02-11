package com.cg.bookmymovie.theatreService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Theatre;
import com.cg.bookmymovie.theatreService.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public void addNewTheatre(Theatre theatre) {
		theatreRepository.save(theatre);
	}

	@Override
	public List<Theatre> getAllTheatres() {
		return theatreRepository.findAll();
	}

	@Override
	public Optional<Theatre> getParticularTheatre(Address address, String theatreName) {
		Optional<Theatre> theatre = theatreRepository.findTheatreByTheatreAddressAndTheatreName(address, theatreName);
		if (!(theatre).isPresent()) {
			return null; 
			}
		
		return theatre;
	}

	/*
	 * @Override public void deleteTheatre(Address address, String theatreName) {
	 * Optional<Theatre> theatre =
	 * theatreRepository.findTheatreByTheatreAddressAndTheatreName(address,
	 * theatreName); theatreRepository.delete(theatre); }
	 */
	
	/*
	 * @Override public void updateTheatre(Address address, String theatreName) {
	 * Theatre theatre =
	 * theatreRepository.findTheatreByTheatreAddressAndTheatreName(address,
	 * theatreName); theatre.setTheatreName(theatreName);
	 * theatreRepository.save(theatre); }
	 */
	/*
	 *
	 */
	/*
	 * @Override public void deleteTheatre(Theatre theatre) {
	 * theatreRepository.delete(theatre);
	 * 
	 * }
	 * 
	 * @Override public void updateTheatre(String theatreName) { Theatre theatre =
	 * theatreRepository.findTheatreByTheatreName(theatreName).get();
	 * theatre.setTheatreName(theatreName); theatreRepository.save(theatre); }
	 */
	/*
	 * @Override public List<Theatre> findTheatreByName(String theatreName) {
	 * List<Theatre> theatre =
	 * theatreRepository.findTheatreByTheatreName(theatreName); if (!((Theatre)
	 * theatre).isPresent()) { return null; } return
	 * theatreRepository.findTheatreByTheatreName(theatreName);
	 * 
	 * }
	 */
}
