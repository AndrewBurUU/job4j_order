package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.*;
import ru.job4j.order.repository.*;

import javax.transaction.*;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class SpringOrderService implements OrderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderRepository orderRepository;
    private final OrderDTORepository orderDTORepository;

    @Override
    @Transactional
    public Order create(Order order) {
        var savedOrder = orderRepository.save(order);
        /**kafkaTemplate.send("job4j_orders", savedOrder);*/
        kafkaTemplate.send("preorder", savedOrder);
        return savedOrder;
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

    public Optional<Order> findById(int id) {
        return orderDTORepository.findById(id);
    }

    @KafkaListener(topics = "cooked_order")
    public void receiveOrder(String message) {
        log.debug(message);
    }

}
