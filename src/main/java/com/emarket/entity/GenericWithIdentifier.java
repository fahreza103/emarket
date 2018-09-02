package com.emarket.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class GenericWithIdentifier extends Generic {

	private static final long serialVersionUID = -5580584804239990214L;
	
	public GenericWithIdentifier(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public GenericWithIdentifier() {
		super();
	}

	@NotNull(message = "The name must not be null")
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
