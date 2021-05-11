package com.ducon.session.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CustomerMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMaster {
	
	  @Id
	  @JsonProperty("customerID")
	  private Integer customerID;
	  
	  @Column(name = "CustomerName")
	  private String customerName;
	  
	  @Column(name = "Phone")
	  private String phone;
	  
	  @Column(name = "DateOfBirth")
	  private Date dob;
	  
	  @Column(name = "Address")
	  private String address;
	  
	  @Column(name = "InsertedTime")
	  private Date insertedTime;
}
