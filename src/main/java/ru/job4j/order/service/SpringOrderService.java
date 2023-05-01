package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.*;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.*;
import ru.job4j.order.repository.OrderRepository;

import javax.transaction.*;
import java.util.*;

@Service
@AllArgsConstructor
public class SpringOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public boolean update(Order order) {
        var res = orderRepository.findById(order.getId());
        if (res.isEmpty()) {
            return false;
        }
        orderRepository.save(order);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        var res = orderRepository.findById(id);
        if (res.isEmpty()) {
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll();
    }
}
