package edu.pucrs.verval.DTO;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;

import com.fasterxml.jackson.datatype.joda.ser.LocalDateSerializer;

public class ResourcesDTO {
	
	private Integer resource_id;
	
	private Integer amount;
	
	private Double unity_price;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate initial_date;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate end_date;

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getUnity_price() {
		return unity_price;
	}

	public void setUnity_price(Double unity_price) {
		this.unity_price = unity_price;
	}

	public LocalDate getInitial_date() {
		return initial_date;
	}

	public void setInitial_date(LocalDate initial_date) {
		this.initial_date = initial_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

}
