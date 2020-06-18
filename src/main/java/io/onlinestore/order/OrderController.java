package io.onlinestore.order;

import io.onlinestore.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @RequestMapping("/customers/{id}/orders")
    public List<Order> getAllOrders(@PathVariable String id){
        return orderService.getAllOrders(id);
    }

    @RequestMapping("/customers/{customerId}/orders/{id}")
    public Order getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{customerId}/orders")
    public void addOrder(@RequestBody Order order, @PathVariable String customerId){
        order.setCustomer(new Customer(customerId, "", ""));
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{customerId}/orders/{id}")
    public void updateOrder(@RequestBody Order order, @PathVariable String id, @PathVariable String customerId){
        order.setCustomer(new Customer(customerId, "", ""));
        orderService.updateOrder(order);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerId}/orders/{id}")
    public void deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
    }

}
