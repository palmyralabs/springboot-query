package com.palmyralabs.examples.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palmyralabs.examples.model.SupplierModel;
import com.palmyralabs.palmyra.core.rest.service.ModelQueryService;
import com.palmyralabs.palmyra.core.rest.service.RequestParams;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("supplier")
public class SupplierController {
	private final ModelQueryService queryService;

	@GetMapping("")
	public void querySuppliers(@RequestParam Map<String, String> paramsMap) {
		RequestParams params = queryService.getRequestParams(SupplierModel.class, paramsMap);		
		queryService.executeAndSendListResponse(params);
	}
}
