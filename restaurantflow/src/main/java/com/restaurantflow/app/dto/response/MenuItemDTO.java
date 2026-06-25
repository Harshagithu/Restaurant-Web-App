package com.restaurantflow.app.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MenuItemDTO {

	private Long id;
	
	private String name;
	
	private String category;
	
	private Double price;
	
	private Boolean available;
	
	private String description;
	
	private Integer prepTimeMinutes;
	
}
