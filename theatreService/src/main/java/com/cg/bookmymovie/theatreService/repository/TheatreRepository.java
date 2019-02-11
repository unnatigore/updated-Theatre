package com.cg.bookmymovie.theatreService.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Theatre;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, Integer> {

	//List<Theatre> findTheatreByTheatreName(String theatreName);



	Optional<Theatre> findTheatreByTheatreAddressAndTheatreName(Address address, String theatreName);

	void deleteTheatreByTheatreAddressAndTheatreName(Address address, String theatreName);

}
