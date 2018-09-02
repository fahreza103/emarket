package com.emarket.repository.seeder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarket.entity.product.Brand;
import com.emarket.entity.product.Product;
import com.emarket.repository.product.BrandRepository;
import com.emarket.repository.product.ProductRepository;

@Component
public class ProductSeeder {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	private Logger logger = LoggerFactory.getLogger(ProductSeeder.class);
	
	public void seedProduct() {
		logger.info("Seed Brand Table");
		List<Brand> brandList = new ArrayList<Brand>();
		brandList.add(new Brand("Indosat", "Indosat Ooredo"));
		brandList.add(new Brand("Telkomsel", "Telkomsel"));
		brandList.add(new Brand("Huawei", "Huawei Modem Products"));
		
		brandRepository.saveAll(brandList);
		logger.info("Success Seeding Brand Data, size :"+brandList.size());
		
		logger.info("Seed Product Table");
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Pulsa 10K","Pulsa 10 ribu Indosat Ooredo").setBrand(brandList.get(0)));
		productList.add(new Product("Pulsa 15K","Pulsa 15 ribu Indosat Ooredo").setBrand(brandList.get(0)));
		productList.add(new Product("Pulsa 20K","Pulsa 20 ribu Indosat Ooredo").setBrand(brandList.get(0)));
		
		productList.add(new Product("Pulsa 10K","Pulsa 10 ribu Voucher").setBrand(brandList.get(1)));
		productList.add(new Product("Pulsa 25K","Pulsa 25 ribu Voucher").setBrand(brandList.get(1)));
		productList.add(new Product("Pulsa 50K","Pulsa 50 ribu Voucher").setBrand(brandList.get(1)));
		
		productRepository.saveAll(productList);
		logger.info("Success Seeding Product Data, size :"+productList.size());
	}
}
