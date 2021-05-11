package com.ducon.session.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducon.session.domain.CustomerMaster;
import com.ducon.session.exception.DucanExceptionResponse;
import com.ducon.session.exception.DuconAppApiException;
import com.ducon.session.service.CustomerMasterService;

@RestController
@RequestMapping(value = "/api/v1")
public class DconController {

	@Autowired
	CustomerMasterService customerMasterService;

	@GetMapping("/ducon")
	public ResponseEntity<List<CustomerMaster>> getDataById(@RequestParam(value = "id",required = false) Integer id) throws DuconAppApiException {
	  return ResponseEntity.status(HttpStatus.OK).body(customerMasterService.getById(id));
	}
	
	@PostMapping("/ducon/registration")
	public ResponseEntity<DucanExceptionResponse> createCustomer(@RequestBody CustomerMaster customerMaster) throws DuconAppApiException {
	  return ResponseEntity.status(HttpStatus.OK).body(customerMasterService.saveCustomerMaster(customerMaster));
	}
	
}
