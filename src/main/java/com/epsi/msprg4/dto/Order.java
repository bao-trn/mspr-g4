package com.epsi.msprg4.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Order {

    private Date creationDate;
    private int id;
    private int customerId;

}
