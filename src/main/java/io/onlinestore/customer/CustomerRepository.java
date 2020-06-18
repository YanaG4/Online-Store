package io.onlinestore.customer;

import org.springframework.data.repository.CrudRepository;

//we need to have a data service
public interface CustomerRepository extends CrudRepository<Customer, String>{

    // getAllCustomers()
    //getCustomer(String id)
    //updateCustomer(Clients t, String id)
    //deleteCustomer(String id)
    //but they are very similar. So what should we do for not building tha same methods for every entity?
    //We need to use JPA: the framework already knows that we have the class with the variables
    //Thus we convert class ClientsRepository into the interface
    //the spring data JPA comes with one common repository CrudRepository, which contains the logic for any entity class
    //so extend our interface with CrudRepository
    //CrudRepository is also a generic type so we need to provide that generic type information
    //a couple of generic types particularly: 1) what is the entity class you are working with
    //2) what the id does this generic class have - <Customer, String>

}
