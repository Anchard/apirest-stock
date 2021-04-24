package com.stock.apistock.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_QUOTE")
public class Quote implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@NotNull
	private BigDecimal value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
