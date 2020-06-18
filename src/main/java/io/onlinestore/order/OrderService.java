package io.onlinestore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders(String customerId){
        List<Order> orders = new ArrayList<>();
        //we need to find the orders by clientId, ordersRepository do not have the embedded method for this
        orderRepository.findByCustomerId(customerId)
        .forEach(orders::add);
        return orders;
    }

    public Order getOrder(String id){
        return orderRepository.findById(id).get();
    }

    public void addOrder(Order orders) {
        orderRepository.save(orders);
    }

    public void updateOrder(Order orders) {
        orderRepository.save(orders);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
