package com.restaurantflow.app.config;

import org.springframework.boot.CommandLineRunner;
import com.restaurantflow.app.entity.MenuItem;
import com.restaurantflow.app.repository.MenuItemRepository;

public class DataLoader implements CommandLineRunner{

	private MenuItemRepository menuItemRepository;
	
	@Override
	public void run(String... args) throws Exception 
	{
		// only seed if the table is empty
		// Restaurant analogy: stock the store room only on remaining days
		if(menuItemRepository.count()==0)
		{
			menuItemRepository.save(MenuItem.builder()
					                        .name("Chicken Biryani")
					                        .category("MAIN_COURSE")
					                        .price(200.00)
					                        .available(true)
					                        .description("Aromatic basmati rice with tender chicken")
					                        .prepTimeMinutes(25)
					                        .build());
			
			menuItemRepository.save(MenuItem.builder()
                                            .name("Paneer Butter Masala")
                                            .category("MAIN_COURSE")
                                            .price(220.00)
                                            .available(true)
                                            .description("Creamy tomato gravy with soft paneer")
                                            .prepTimeMinutes(20)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Veg Samosa")
                                            .category("STARTERS")
                                            .price(60.00)
                                            .available(true)
                                            .description("Crispy pastry with spiced potato filling")
                                            .prepTimeMinutes(10)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Mango Lassi")
                                            .category("DRINKS")
                                            .price(80.00)
                                            .available(true)
                                            .description("Fresh mango blended with chilled yoghurt")
                                            .prepTimeMinutes(5)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Gulab Jamun")
                                            .category("DESSERTS")
                                            .price(90.00)
                                            .available(true)
                                            .description("Soft milk dumplings in rose sugar syrup")
                                            .prepTimeMinutes(8)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Chicken 65")
                                            .category("STARTERS")
                                            .price(180.00)
                                            .available(true)
                                            .description("Spicy deep-fried chicken with curry leaves")
                                            .prepTimeMinutes(15)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Masala Chai")
                                            .category("DRINKS")
                                            .price(40.00)
                                            .available(true)
                                            .description("Classic Indian spiced tea")
                                            .prepTimeMinutes(5)
                                            .build());

            menuItemRepository.save(MenuItem.builder()
                                            .name("Dal Makhani")
                                            .category("MAIN_COURSE")
                                            .price(190.00)
                                            .available(false)
                                            .description("Slow-cooked black lentils in butter gravy")
                                            .prepTimeMinutes(30)
                                            .build());
            
            System.out.println("RestaurantFlow: Menu Items Seeded Successfully");

       }
	  else
	   {
		  
		  System.out.println("RestaurantFlow: Menu Items already exists!!");
			
	   }
		
	}
	
}