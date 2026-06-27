package com.restaurantflow.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.restaurantflow.app.service.MenuItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuItemService menuItemService;
	
	@GetMapping("/menu")
	public String showMenu(Model model)
	{
		// Captain routes request to waiter
		// Waiter fetches menu card (DTO) from service
		model.addAttribute("menuItems",menuItemService.getAllAvailableItems());
		model.addAttribute("pageTitle","Our Menu");
		
		return "menu"; //ViewResolver finds /WEB-INF/views/menu.jsp
	}
	
	@GetMapping("/")
	public String home()
	{
		return "redirect:/menu";
	}
}
