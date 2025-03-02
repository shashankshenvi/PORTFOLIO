package com.portfolio.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_USER_INSTANCE")
public class UserInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_detail_id")
    private Integer contactDetailId;

    // Corrected: use 'user' to refer to the UserDetails object
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserDetails user; 

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "value", nullable = true)
    private String value; // Actual URL, email, or phone number

    @Column(name = "image_src")
    private String imageSrc; // Path to the contact icon
}