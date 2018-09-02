package com.emarket.entity.product;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emarket.entity.GenericWithIdentifier;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="BRAND",schema = "product")
public class Brand extends GenericWithIdentifier {

	private static final long serialVersionUID = 2672126744820427939L;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Product> products;
	
	public Brand() {
		super();
	}
	
	public Brand(String name, String description) {
		super(name, description);
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
