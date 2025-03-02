package com.portfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.repository.MenuRepository;
import com.portfolio.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService{
	
	private static final Logger logger =LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> getAllMenus(){
		return menuRepository.findByIsActive('Y');
	}

	@Override
	public Menu createMenu(Menu menu) {
		logger.info("menu : "+menu.toString());
		return menuRepository.save(menu);
	}

	@Override
	public Menu getMenuById(Integer menuId) {
		
		Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));

		return menu;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		Menu updatedMenu = menuRepository.save(menu);
		return updatedMenu;
	}

	@Override
	public void deleteMenu(Menu menu) {
		 menuRepository.findById(menu.getMenuId()).ifPresent(menuNew->{
			 menuNew.setIsActive('N');
			menuRepository.save(menuNew);
		});
	}
}
