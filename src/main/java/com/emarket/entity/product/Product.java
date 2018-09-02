package com.emarket.entity.product;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emarket.entity.GenericWithIdentifier;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorColumn(name="product_type")
@DiscriminatorValue("Physical")
@Table(name="PRODUCT",schema = "product")
public class Product extends GenericWithIdentifier {

	public Product() {
		super();
	}
	
	public Product(String name, String description) {
		super(name, description);
	}

	private static final long serialVersionUID = -4418329007867668069L;

	@ManyToOne
	@JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "product_brand_id_fk"))
	@JsonBackReference
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public Product setBrand(Brand brand) {
		this.brand = brand;
		return this;
	}
	
	
}
