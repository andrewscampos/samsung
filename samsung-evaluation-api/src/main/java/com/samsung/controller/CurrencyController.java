package com.samsung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.service.CurrencyService;
import com.samsung.service.dto.Currency;
import com.samsung.service.dto.Document;
import com.samsung.service.dto.Filter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CurrencyController {

	
	@Autowired
	private CurrencyService service;
	
	@PostMapping("/evaluation/docs")
	public ResponseEntity<List<Document>> docs(@RequestBody Filter filter) {
		return service.docs(filter);
	}
	
	@CrossOrigin(origins = "*" )
	@RequestMapping(method = RequestMethod.GET, path ="/evaluation/currencys/" )
	public @ResponseBody Currency[] currency() {
		return service.currency().getBody();
	}
}
