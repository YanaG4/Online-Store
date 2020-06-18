package io.onlinestore.order;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order, String>{

    public List<Order> findByCustomerId(String customerId);
}
