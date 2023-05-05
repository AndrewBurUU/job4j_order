package ru.job4j.order.repository;

import ru.job4j.order.model.Order;

import java.util.*;

public interface OrderDTORepository {

    Optional<Order> findById(int id);
}
