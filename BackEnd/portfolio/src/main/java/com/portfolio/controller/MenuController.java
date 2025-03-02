package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.service.MenuService;
import com.portfolio.service.MenuServiceImpl;
import com.portfolio.vo.Menu;


@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/menus")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
@GetMapping
public List<Menu> getAllMenus(){
	return menuService.getAllMenus();
}

@PostMapping
public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
    return new ResponseEntity<>(menuService.createMenu(menu), HttpStatus.CREATED);
}

@GetMapping("{menuId}")
public ResponseEntity<Menu> getEmployeeById(@PathVariable("menuId") Integer menuId){
	return ResponseEntity.ok(menuService.getMenuById(menuId));
}

@PutMapping
public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu){
	return new ResponseEntity<>(menuService.updateMenu(menu),HttpStatus.CREATED);
}

@DeleteMapping
public void deleteMenu(@RequestBody Menu menu){
	menuService.deleteMenu(menu);
}
	
}
