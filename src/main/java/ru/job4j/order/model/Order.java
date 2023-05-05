package ru.job4j.order.model;

import lombok.*;

import javax.persistence.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderX")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dish_id")
    private int dishId;

    /**
    private int clientId;

    private int dishCount;

    private String address;

    private String telephoneNumber;

    private Date orderDate;

    private int orderNumber;

    private String status;*/
}
