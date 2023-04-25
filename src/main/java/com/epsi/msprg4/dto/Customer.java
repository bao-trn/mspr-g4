package com.epsi.msprg4.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Customer {

    private Date creationDate;
    private String name;
    private String userName;
    private String firstName;
    private String lastName;
    private Address address;
    private String profileFirstName;
    private String profileLastName;
    private String companyName;
    private int id;
    private List<Order> orders;

}
