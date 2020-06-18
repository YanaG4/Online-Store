package io.onlinestore.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

//we need to map this class to database table -> using annotation
@Entity
public class Customer {

    //and we should set the primary key
   @Id
    private String id;
    private String name;
    private String address;

    public Customer() {

    }

    public Customer(String id, String name, String address) {
        //super();
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
