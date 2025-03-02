package com.portfolio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactDTO {
    private String type;
    private String value;
    private String imageSrc;
}