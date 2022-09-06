package com.samsung.service.dto;

public class Quotation {

	private String fromCurrencyCode;
	private String toCurrencyCode;
	private float cotacao;
	private String dataHoraCotacao;

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public float getCotacao() {
		return cotacao;
	}

	public void setCotacao(float cotacao) {
		this.cotacao = cotacao;
	}

	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

}
