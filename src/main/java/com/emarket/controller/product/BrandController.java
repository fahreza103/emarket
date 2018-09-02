package com.emarket.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emarket.controller.CrudController;
import com.emarket.entity.product.Brand;
import com.emarket.repository.product.BrandRepository;




@RestController
@RequestMapping(value = "product/brand")
public class BrandController extends CrudController<Brand> {
	

	@Autowired
	public BrandController(BrandRepository brandRepository) {
		super(brandRepository);
	}
}
