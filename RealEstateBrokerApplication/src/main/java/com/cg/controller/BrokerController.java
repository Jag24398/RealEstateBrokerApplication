package com.cg.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.service.IBrokerServiceImpl;



@RestController
@RequestMapping("/api/v1/broker")
public class BrokerController {
	
	@Autowired
	IBrokerServiceImpl iBrokerService;
	
	@PostMapping
	public ResponseEntity<Broker> addBroker(@RequestBody Broker broker){
		return new ResponseEntity<Broker>(iBrokerService.addBroker(broker), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Broker> editBroker(@RequestBody Broker broker) throws BrokerNotFoundException{
		return new ResponseEntity<Broker>(iBrokerService.editBroker(broker), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Broker> removeBroker(@PathVariable ("id") int broId) throws BrokerNotFoundException{
		return new ResponseEntity<Broker>(iBrokerService.removeBroker(broId), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Broker> viewBroker(@PathVariable ("id") int broId) throws BrokerNotFoundException{
		return new ResponseEntity<Broker>(iBrokerService.viewBroker(broId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Broker>> listAllBrokers(@RequestBody List<Broker> brokers){
		List<Broker> brokerList = iBrokerService.listAllBrokers();
		ResponseEntity<List<Broker>> response = new ResponseEntity<List<Broker>>(brokerList, HttpStatus.OK);
		return response;
	}

}
