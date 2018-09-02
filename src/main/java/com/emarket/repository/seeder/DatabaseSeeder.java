package com.emarket.repository.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

	@Autowired
	private ProductSeeder productSeeder;
	
    @EventListener
    public void seed(ContextRefreshedEvent event) {
    		productSeeder.seedProduct();
    }
}
