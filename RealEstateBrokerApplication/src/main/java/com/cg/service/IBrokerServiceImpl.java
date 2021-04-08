package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.repository.IBrokerRepo;
import com.cg.service.IBrokerService;

public class IBrokerServiceImpl implements IBrokerService {
	
	@Autowired
	IBrokerRepo iBrokerRepo;
	
	//Adding Broker in
	@Override
	public Broker addBroker(Broker bro) {
		// TODO Auto-generated method stub
		Broker broSaved = iBrokerRepo.save(bro);
		return broSaved;
	}

	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		if(bro != null) {
			Broker broSaved = iBrokerRepo.save(bro);
			return broSaved;
		}
		else {
			throw new BrokerNotFoundException("Broker not found");
		}
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Broker broRemoved = viewBroker(broId);
		iBrokerRepo.deleteById(broId);
		return broRemoved;
		
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Broker> broOpt = iBrokerRepo.findById(broId);
		if(broOpt.isPresent()) {
			Broker broSaved = broOpt.get();
			return broSaved;
		}
		else {
			throw new BrokerNotFoundException("Broker not found with the Id :"+broId);
		}
		
	}

	@Override
	public List<Broker> listAllBrokers() {
		// TODO Auto-generated method stub
		List<Broker> brokers = iBrokerRepo.findAll();
		return brokers;
	}

}
