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

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;

import com.cg.service.IPropertyServiceImpl;

//import com.cg.service.IPropertyServiceImpl;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
	
	@Autowired
	IPropertyServiceImpl iPropertyService;
	
	//Prashant Code your methods above this, I am only definig PropertyCriteria Method here.
//	@Autowired
//	private IPropertyServiceImpl iPropertyService;
//	
	@PostMapping
	public ResponseEntity<Property> addProperty(@RequestBody Property property){
		
		return new ResponseEntity<Property> (iPropertyService.addProperty(property),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Property> editProperty(@RequestBody Property property){
		
		return new ResponseEntity<Property> (iPropertyService.editProperty(property),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Property>> listAllProperties()
	{
		List<Property> propertyList = iPropertyService.listAllProperties();
		ResponseEntity<List<Property>> response = new ResponseEntity<List<Property>>(propertyList,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/{propId}")
	public ResponseEntity<Property> viewProperty(@PathVariable("propId") int propId) throws PropertyNotFoundException{
		
		return new ResponseEntity<Property>(iPropertyService.viewProperty(propId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{propId}")
	public ResponseEntity<Property> deleteProduct(@PathVariable("propId") int propId) throws PropertyNotFoundException {
		return new ResponseEntity<Property>(iPropertyService.removeProperty(propId),HttpStatus.OK);
	}
	
	@GetMapping("/criteria")
	public ResponseEntity<List<Property>> listPropertyByCriteria(@RequestBody PropertyCriteria criteria){
		List<Property> propertyList = iPropertyService.listPropertyByCriteria(criteria);
		ResponseEntity<List<Property>> response = new ResponseEntity<List<Property>>(propertyList, HttpStatus.OK);
		return response;
	}

}
