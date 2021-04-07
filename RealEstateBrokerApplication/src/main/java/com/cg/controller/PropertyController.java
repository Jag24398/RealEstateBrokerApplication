package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.IPropertyService;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
	
	@Autowired
	IPropertyService iPropertyService;
	
	//Prashant Code your methods above this, I am only definig PropertyCriteria Method here.
	@GetMapping("/criteria")
	public ResponseEntity<List<Property>> listPropertyByCriteria(PropertyCriteria criteria){
		List<Property> plist = iPropertyService.listPropertyByCriteria(criteria);
		ResponseEntity<List<Property>> response = new ResponseEntity<List<Property>>(plist, HttpStatus.OK);
		return response;
	}

}
