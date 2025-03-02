package com.portfolio.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDetailsDTO {
	
    private Integer userId;
    private String firstName;
    private String lastName;
    private Character isActive;
    private List<ContactDTO> contacts;

}
