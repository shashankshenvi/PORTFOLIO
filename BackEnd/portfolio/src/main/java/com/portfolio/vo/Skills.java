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

@Getter
@Setter
@ToString
@Entity
@Table(name="TBL_SKILLS")
public class Skills {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SKILL_ID")
	private Integer skillId;
	
	@Column(nullable=false, name="TITLE")
	private String title;
	
	@Column(name="SOURCE")
	private String imageSrc;
	
	@Column(name="IS_ACTIVE",columnDefinition="CHAR(1) DEFAULT 'Y'")
	private Character isActive='Y';

}
