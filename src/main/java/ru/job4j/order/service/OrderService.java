package ru.job4j.order.service;

import ru.job4j.order.model.Order;

import java.util.*;

public interface OrderService {

    Order create(Order order);

    boolean update(Order order);

    boolean delete(int id);

    Collection<Order> findAll();

}
