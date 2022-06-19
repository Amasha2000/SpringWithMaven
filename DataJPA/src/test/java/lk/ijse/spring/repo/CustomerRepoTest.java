package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
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
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer(){
        Customer customer = new Customer("C001", "Kamal", "Galle", 49349358);
        Customer customer1 = new Customer("C002", "Kamal", "Galle", 49349358);
        customerRepo.save(customer);
        customerRepo.save(customer1);
    }

    @Test
    public void findCustomer(){
        Customer kamal = customerRepo.findCustomerByName("Kamal");
        System.out.println(kamal);
    }

//    @Test
//    public void findCustomerByNameAndAddress(){
//        Customer kamal = customerRepo.findByNameAndAddress("Kamal","Galle");
//        System.out.println(kamal);
//    }

    @Test
    public void searchByName(){
        Customer kamal = customerRepo.searchByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void readByName(){
        Customer kamal = customerRepo.readByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void getByName(){
        Customer kamal = customerRepo.getByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void queryByCustomer(){
        Customer kamal = customerRepo.queryByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void streamByName(){
        Customer kamal = customerRepo.streamByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void existsByName(){
        boolean kamal = customerRepo.existsByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void countByName(){
        int kamal = customerRepo.countByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void findByName(){
        List<Customer> kamal = customerRepo.findByName("Kamal");
        for (Customer customer : kamal) {
            System.out.println(customer);
        }
    }

//    @Test
//    public void deleteByName(){
//        customerRepo.deleteByName("Kamal");
//    }
//
//    @Test
//    public void removeByName(){
//        Customer kamal = customerRepo.removeByName("Kamal");
//        System.out.println(kamal);
//    }

}