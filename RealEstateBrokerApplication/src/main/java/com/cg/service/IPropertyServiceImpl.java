package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.IPropertyRepo;
import com.cg.service.IPropertyService;

public class IPropertyServiceImpl implements IPropertyService {
	@Autowired
	IPropertyRepo iPropertyRepo;

	public Property addProperty(Property property) {

		Property propSaved = iPropertyRepo.save(property);
		return propSaved;
	}

	public Property editProperty(Property property) {

		Property propSaved = iPropertyRepo.save(property);
		return propSaved;
	}

	public Property viewProperty(int propId) throws PropertyNotFoundException {
		Optional<Property> propOp = iPropertyRepo.findById(propId);
		// System.out.println("ID Find");
		if (propOp.isPresent()) {
			Property property = propOp.get();
			return property;
		} else {
			throw new PropertyNotFoundException("Product not found with the given id : " + propId);
		}
	}

	public List<Property> listAllProperties() {
		List<Property> properties = iPropertyRepo.findAll();
		return properties;
	}

	public Property removeProperty(int propId) throws PropertyNotFoundException {
		Property property = viewProperty(propId);
		iPropertyRepo.deleteById(propId);
		return property;
	}

	@Override
	public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {
		// TODO Auto-generated method stub
		List<Property> property = iPropertyRepo.findAll();
		return property;
	}

}
