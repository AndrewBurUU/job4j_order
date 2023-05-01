package ru.job4j.order.model;

import lombok.*;

import javax.persistence.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int clientId;

    private int dishCode;

    private int dishCount;

    private String address;

    private String telephoneNumber;

    private Date orderDate;

    private int orderNumber;

    private String status;
}
