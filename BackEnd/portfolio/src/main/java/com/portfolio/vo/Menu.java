package com.portfolio.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TBL_MENU")
@Getter
@Setter
@ToString
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MENU_ID")
	private Integer menuId;
	
	@Column(nullable=false, name="MENU_NAME")
	private String menuName;
	
	@Column(columnDefinition="TEXT",name="MENU_DESCRIPTION")
	private String description;
	
	@Column(name="IS_ACTIVE",columnDefinition="CHAR(1) DEFAULT 'Y'")
	private Character isActive='Y';
	
	
	private String url;
	

}
