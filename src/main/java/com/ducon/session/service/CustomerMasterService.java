package com.ducon.session.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ducon.session.domain.CustomerMaster;
import com.ducon.session.exception.DucanExceptionResponse;
import com.ducon.session.exception.DuconAppApiException;
import com.ducon.session.repository.CustomerMasterRepository;

@Service
public class CustomerMasterService {

	@Autowired
	CustomerMasterRepository customerMasterRepository;

	public List<CustomerMaster> getById(Integer id) throws DuconAppApiException {
		if (id == null) {
			List<CustomerMaster> customerMasterList = customerMasterRepository.findAll();
			return customerMasterList;
		}
		CustomerMaster customerMaster = null;
		try {
			customerMaster = customerMasterRepository.findByCustomerID(id);
		} catch (Exception e) {
			throw new DuconAppApiException("Unable to process request", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		if (customerMaster == null) {
			throw new DuconAppApiException("Customer with id " + id + " does not exists", HttpStatus.NOT_FOUND.value());
		}
		return Arrays.asList(customerMaster);

	}

	public DucanExceptionResponse saveCustomerMaster(CustomerMaster customerMaster) throws DuconAppApiException {
		if (customerMaster != null && customerMaster.getCustomerID() == null) {
			throw new DuconAppApiException("Id Invalid Or Null", HttpStatus.BAD_REQUEST.value());
		}
		CustomerMaster idCheck = customerMasterRepository.findByCustomerID(customerMaster.getCustomerID());
		if (idCheck != null) {
			throw new DuconAppApiException("Customer with id " + customerMaster.getCustomerID() + " already exists",
					HttpStatus.CONFLICT.value());
		}
		customerMaster.setInsertedTime(new Date());
		try {
			idCheck = customerMasterRepository.save(customerMaster);
			return new DucanExceptionResponse(HttpStatus.CREATED.value(), "Registration Completed Suceefully!!");
		} catch (Exception e) {
			throw new DuconAppApiException("Unable to process Request", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
