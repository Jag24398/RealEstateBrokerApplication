package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
@Repository
public interface IBrokerRepo extends JpaRepository<Broker, Integer> {
	
//	public Broker saveBroker(Broker bro);
//	
//	public Broker updateBroker(Broker bro);
//	
//	public Broker deleteBroker(int broId) throws BrokerNotFoundException;
//	
//	public Broker fetchBroker(int broId) throws BrokerNotFoundException;
//	
//	public List<Broker> fetchAllBrokers();
}
