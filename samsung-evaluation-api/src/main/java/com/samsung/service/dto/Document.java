package com.samsung.service.dto;

public class Document {

	private Integer documentId;
	private String documentNumber;
	private String notaFiscal;
	private String documentDate;
	private Double documentValue;
	private String currencyCode;
	private String currencyDesc;
	private Double valueUSD;
	private Double valuePEN;
	private Double valueBRL;
	
	
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public String getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}
	public Double getDocumentValue() {
		return documentValue;
	}
	public void setDocumentValue(Double documentValue) {
		this.documentValue = documentValue;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
 
	public Double getValueBRL() {
		return valueBRL;
	}
	public void setValueBRL(Double valueBRL) {
		this.valueBRL = valueBRL;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	public Double getValueUSD() {
		return valueUSD;
	}
	public void setValueUSD(Double valueUSD) {
		this.valueUSD = valueUSD;
	}
	public Double getValuePEN() {
		return valuePEN;
	}
	public void setValuePEN(Double valuePEN) {
		this.valuePEN = valuePEN;
	}
	 
	
	 
	
	
	
}
