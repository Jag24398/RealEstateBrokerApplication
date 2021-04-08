package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
@Repository
public interface IPropertyRepo extends JpaRepository<Property, Integer> {
	
//	public Property saveProperty(Property property);
//	
//	public Property updateProperty(Property property);
//	
//	public Property deleteProperty(int propId) throws PropertyNotFoundException;
//	
//	public Property fetchProperty(int propId) throws PropertyNotFoundException;
//	
//	public List<Property> fetchAllProperties();
//	
//	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria);
}
