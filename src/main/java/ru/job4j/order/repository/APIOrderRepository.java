package ru.job4j.order.repository;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.*;
import ru.job4j.order.model.*;

import java.util.*;

@Data
public class APIOrderRepository implements OrderDTORepository {

    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    @Override
    public Optional<OrderDTO> findById(int id) {
        Dish dish = client.getForEntity(
                String.format("%s/findById?=%s", url, id),
                Dish.class).getBody();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDish(dish);
        return Optional.of(orderDTO);
    }
}
