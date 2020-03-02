package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class CustomerApiController {
    @Autowired
    private CustomerService customerService;

    /***
     * localhost:8080/api/customers
     * @return A list of customers in the database
     */
    @RequestMapping(path = "/customers")
    public @ResponseBody List<Customer> get() {
        return customerService.findAll();
    }
}
