package com.ryde.sg.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;



public class User {
	
	private Integer id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	@NotBlank(message = "Address is mandatory")
	private String address;
	@NotBlank(message = "Description is mandatory")
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
