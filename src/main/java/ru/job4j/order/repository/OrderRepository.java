package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.order.model.Order;

import java.util.*;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    Collection<Order> findAll();

}
