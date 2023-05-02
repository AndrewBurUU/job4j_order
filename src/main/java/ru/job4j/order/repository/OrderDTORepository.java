package ru.job4j.order.repository;

import ru.job4j.order.model.OrderDTO;

import java.util.*;

public interface OrderDTORepository {

    Optional<OrderDTO> findById(int id);
}
