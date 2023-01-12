package com.bci.usuario.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneDTO {

	private int number;
	private short cityCode;
	private short countryCode;

	@JsonCreator(mode = Mode.PROPERTIES)
	public PhoneDTO(
			@JsonProperty("number") int number, 
			@JsonProperty("citycode") short cityCode, 
			@JsonProperty("countrycode") short countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	public int getNumber() {
		return number;
	}

	public short getCityCode() {
		return cityCode;
	}

	public short getCountryCode() {
		return countryCode;
	}

	@Override
	public String toString() {
		return "Phone: +" + this.countryCode + " (" + this.cityCode + ") " + this.number;
	}
	
}
