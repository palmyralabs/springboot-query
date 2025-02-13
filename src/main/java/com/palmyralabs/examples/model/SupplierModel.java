package com.palmyralabs.examples.model;

import com.palmyralabs.palmyra.base.annotations.PalmyraType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PalmyraType(type = "Supplier")
public class SupplierModel {
	private Integer id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
}
