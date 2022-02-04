package com.acme_travel.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

}
