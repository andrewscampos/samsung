package com.samsung.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samsung.service.dto.Currency;
import com.samsung.service.dto.Document;
import com.samsung.service.dto.Filter;
import com.samsung.service.dto.Quotation;

@Service
public class CurrencyService {
	
	@Autowired
	Environment environment;
	
	
	private RestTemplate restTemplate = new RestTemplate();
	

	public ResponseEntity<Quotation[]> quotation() {  
		return restTemplate.getForEntity(environment.getProperty("url.quotation"), Quotation[].class); 
	}
	
	public ResponseEntity<List<Document> > docs(Filter filter) { 
		ResponseEntity<Document[]> response = restTemplate.getForEntity(environment.getProperty("url.docs"), Document[].class);
		List<Currency> currencys = Arrays.asList(currency().getBody());
		List<Document> documents = filter(filter, response.getBody());
		List<Quotation> quotations = Arrays.asList(quotation().getBody());
		for (Document document : documents) {
			Optional<Currency> optional = currencys.stream().filter(a -> a.getCurrencyCode().equals(document.getCurrencyCode())).findFirst();
			if(optional.isPresent()) {
				document.setCurrencyDesc(optional.get().getCurrencyDesc());
			}
			List<Quotation> list = quotations.stream().filter(a -> a.getFromCurrencyCode().equals(document.getCurrencyCode())).collect(Collectors.toList());
			
			document.setValuePEN( document.getDocumentValue());
			document.setValueUSD( document.getDocumentValue());
			document.setValueBRL( document.getDocumentValue());
			
			for (Quotation quotation : list) {
				double total = quotation.getCotacao() * document.getDocumentValue();
				if(quotation.getToCurrencyCode().equals("PEN")) {
					document.setValuePEN(total);
				}
				if(quotation.getToCurrencyCode().equals("USD")) {
					document.setValueUSD(total);
				}
				if(quotation.getToCurrencyCode().equals("BRL")) {
					document.setValueBRL(total);
				}
			}
			
			 
		}
		
		return ResponseEntity.ok(documents);
		
		
	}
	
	public List<Document> filter(Filter filter, Document[] documents) {
		List<Document> list = Arrays.asList(documents);

		if (filter.getCurrencyCode() != null && !filter.getCurrencyCode().isEmpty()) {

			list = list.stream().filter(a -> a.getCurrencyCode().equals(filter.getCurrencyCode()))
					.collect(Collectors.toList());
		}

		if (filter.getDocNumber() != null && !filter.getDocNumber().isBlank()) {

			list = list.stream().filter(a -> a.getDocumentNumber().equals(filter.getDocNumber().toString()))
					.collect(Collectors.toList());
		}

		if (filter.getStartDate() != null && ajusteDate(filter.getStartDate()) > 0) {
			long ajusteDate = ajusteDate(filter.getStartDate());
			list = list.stream().filter(a ->  ajusteDate(a.getDocumentDate()) >= ajusteDate)
					.collect(Collectors.toList());
		}
		
		if (filter.getEndDate() != null && ajusteDate(filter.getEndDate()) > 0 ) {
			long ajusteDate = ajusteDate(filter.getEndDate());
			list = list.stream().filter(a ->  ajusteDate(a.getDocumentDate()) <= ajusteDate)
					.collect(Collectors.toList());
		}
	 
		return list;
	}
	
	private long ajusteDate(String str) {
		return str == null || str.isEmpty() ? 0: Long.parseLong(str.replaceAll("[^0-9]", ""));
	}

	public ResponseEntity<Currency[]> currency() { 
		return restTemplate.getForEntity(environment.getProperty("url.currency"), Currency[].class);
	}
	

}
