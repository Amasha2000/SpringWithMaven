package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;


    public CustomerDTO addTestCustomers(){
        CustomerDTO customerDTO = new CustomerDTO("C001", "Kamal", "Galle", 373498);
        return customerDTO;
    }

    public void addCustomers(){
        CustomerDTO customerDTO1 = new CustomerDTO("C001", "Kamal", "Galle", 373498);
        CustomerDTO customerDTO2 = new CustomerDTO("C002", "Nimal", "Galle", 373498);
        CustomerDTO customerDTO3 = new CustomerDTO("C003", "Amal", "Galle", 373498);
        customerService.saveCustomer(customerDTO1);
        customerService.saveCustomer(customerDTO2);
        customerService.saveCustomer(customerDTO3);
    }


    @Test
    void saveCustomer() {
        //if the customer data should add to the database
        CustomerDTO customerDTO = addTestCustomers();

        assertDoesNotThrow(()->{
            customerService.saveCustomer(customerDTO);
        });



        //If the customer is already in the database it should test this will throw an exception
        CustomerDTO customerDTO1 = new CustomerDTO("C001", "Nimal", "Galle", 373498);

        assertThrows(RuntimeException.class,()->{
            customerService.saveCustomer(customerDTO1);
        });
    }

    @Test
    void deleteCustomer() {
        //add Multiple customers
        addCustomers();

        //delete an existing customer
        assertDoesNotThrow(()->{
            customerService.deleteCustomer("C001");
        });

        assertThrows(RuntimeException.class,()->{
           customerService.deleteCustomer("C002");
        });


    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = addTestCustomers();
        customerService.updateCustomer(customerDTO);

        //Update an existing customer
        assertDoesNotThrow(()->{
            customerService.updateCustomer(new CustomerDTO("C001", "Kamal", "Galle", 373498));
        });

        //Throw Exceptions when updating customer who does not exists in the database
        assertThrows(RuntimeException.class,()->{
            customerService.updateCustomer(new CustomerDTO("C002", "Kamal", "Galle", 373498));
        });

    }

    @Test
    void searchCustomer() {
        CustomerDTO customerDTO = addTestCustomers();
        customerService.saveCustomer(customerDTO);

        CustomerDTO c001 = customerService.searchCustomer("C001");

        assertNotNull(c001);


        assertThrows(RuntimeException.class,()->{
            CustomerDTO c002 = customerService.searchCustomer("C002");
        });
    }

    @Test
    void getAllCustomers() {
        //Add Multiple customers
        addCustomers();

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
        //Test customer availability
        assertNotNull(allCustomers);
    }
}