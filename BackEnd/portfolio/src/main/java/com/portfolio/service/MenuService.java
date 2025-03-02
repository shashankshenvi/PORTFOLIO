package com.portfolio.service;

import java.util.List;

import com.portfolio.vo.Menu;

public interface MenuService {
	
	
	List<Menu> getAllMenus();

	Menu createMenu(Menu menu);
	
	Menu getMenuById(Integer menuId);
	
	Menu updateMenu(Menu menu);
	
	void deleteMenu(Menu menu);
	

}
