package com.palmyralabs.examples.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private String errorCode;
	private String errorMessage;
}
