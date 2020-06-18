package io.onlinestore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//it is business service class
//in spring they are typically singletons
//so the program creates only one instance of the class
@Service
public class CustomerService {

    //we need to get a CustomerRepository instance into the CustomerService
    //to call the CustomerRepository from CustomerService, so we need to autowiring it:
    @Autowired
    private CustomerRepository customerRepository;
    //it injects the CustomerRepository instance here

    /*
    private List<Customer> clients = new ArrayList<>(Arrays.asList(
            new Customer("spring", "spring framework", "description"),
            new Customer("java", "core java", "description"),
            new Customer("javascript", "javascript", "description")
    ));
     */


    public List<Customer> getAllCustomers(){
        //return customers;
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll() //findAll is iterable so we need to convert it to the List
        .forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(String id){
        //.stream for have an ability to filter (by id)
        //return clients.stream().filter(t -> t.getId().equals(id)).findFirst().get();

        return customerRepository.findById(id).get();
    }

    public void addCustomer(Customer customer) {
        //clients.add(clients);
        customerRepository.save(customer);
    }

    public void updateCustomer(String id, Customer customer) {
        /*for (int i = 0; i < clients.size(); i++){
            Customer t = clients.get(i);
            if (t.getId().equals(id)){
                clients.set(i, customer);
                return;
            }
        }*/
        customerRepository.save(customer); //if there is no object with this id, it creates this object
        //else it updates it
    }

    public void deleteCustomer(String id) {
        //clients.removeIf(t -> t.getId().equals(id));

        customerRepository.deleteById(id);
    }
}
