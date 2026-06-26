package com.restaurantflow.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restaurantflow.app.dto.response.MenuItemDTO;
import com.restaurantflow.app.entity.MenuItem;
import com.restaurantflow.app.repository.MenuItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuItemService {
	
	private final MenuItemRepository menuItemRepository;
	
	public List<MenuItemDTO> getAllAvailableItems()
	{
		return menuItemRepository.findByAvailableTrue()
				                 .stream()
				                 .map(this::toDTO)
				                 .collect(Collectors.toList());
	}
	
	public List<MenuItemDTO> getAllItems()
	{
		return menuItemRepository.findAll()
				                 .stream()
				                 .map(this::toDTO)
				                 .collect(Collectors.toList());
	}
	
	private MenuItemDTO toDTO(MenuItem item)
	{
		return MenuItemDTO.builder()
				.id(item.getId())
				.name(item.getName())
				.category(item.getCategory())
				.price(item.getPrice())
				.available(item.getAvailable())
				.description(item.getDescription())
				.prepTimeMinutes(item.getPrepTimeMinutes())
				.build();
	}
}
