package io.onlinestore.order;

import io.onlinestore.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Order.TABLE_NAME)
public class Order {
    public static final String TABLE_NAME= "ORDERS";
   @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne
    private Customer customer; //we tie the order to a particular customer instance

    public Order() {

    }

    public Order(String id, String name, String description, String customerId) {
        //super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.customer = new Customer(customerId, "", "");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //@Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
