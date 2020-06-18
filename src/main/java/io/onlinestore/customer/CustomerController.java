package io.onlinestore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//spring initializes an instance of the CustomerController
//after that it looks if any of the members has a dependency to the ClientsService
@RestController
public class CustomerController {

    //here we declare dependency
    @Autowired //this annotations means here is something that needs dependency injection
    private CustomerService customerService;//the program already created an instance of CustomerService
    //through it's class (by annotation @service). So the program takes that instance and injects to this

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
        //if names of the variables don't match, we can implement the next code
        //@RequestMapping("/clients/{not id}")
        //public Clients getCustomer(@PathVariable("not id") String id)
        //but it's not recommended
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer){ //with this annotation we tell spring to
        //pick the data from request body and convert into Clients object
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String id){
        customerService.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

}
