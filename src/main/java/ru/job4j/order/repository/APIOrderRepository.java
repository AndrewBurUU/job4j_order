package ru.job4j.order.repository;

import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.order.model.*;

import java.util.*;

@Repository
public class APIOrderRepository implements OrderDTORepository {

    @Value("${api-url}")
    private String url;
    /**private String url = "http://localhost:8080/dish";*/

    @Autowired
    private final RestTemplate client;

    public APIOrderRepository(RestTemplate client) {
        this.client = client;
    }

    @Override
    public Optional<Order> findById(int id) {
        Order order = client.getForEntity(
                String.format("%s/%s", url, id),
                Order.class).getBody();
        return Optional.of(order);
    }

}
