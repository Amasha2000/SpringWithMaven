package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer(){
//        Customer customer = new Customer("C001", "Kamal", "Galle", 49349358);
//        Customer customer1 = new Customer("C002", "Kamal", "Galle", 49349358);
        Customer customer1 = new Customer("C003", "Nimal", "Galle", 49349358);
//        customerRepo.save(customer);
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
        long kamal = customerRepo.countByName("Kamal");
        System.out.println(kamal);
    }

    @Test
    public void findByName(){
        List<Customer> kamal = customerRepo.findByName("Kamal");
        for (Customer customer : kamal) {
            System.out.println(customer);
        }
    }

    @Test
    public void getAllCustomers(){
        List<Customer> allCustomers = customerRepo.getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
        }
    }

    @Test
    public void getAllCustomersWithJPQL(){
        List<Customer> allCustomersJPQL = customerRepo.getAllCustomersJPQL();
        for (Customer customer : allCustomersJPQL) {
            System.out.println(customer);
        }
    }

    @Test
    public void getAllCustomersHQL(){
        List<Customer> allCustomersWithHQL = customerRepo.getAllCustomersWithHQL();
        for (Customer customer : allCustomersWithHQL) {
            System.out.println(customer);
        }
    }

    @Test
    public void searchCustomerFromNamePositionalParams(){
        Customer nimal = customerRepo.searchCustomerByName("Nimal");
        System.out.println(nimal);
    }

    @Test
    public void searchCustomerNamedParams(){
        Customer customer = customerRepo.searchCustomerNamedParams("Nimal", "Galle");
        System.out.println(customer);
    }

    @Test
    public void getAllCustomersWithJPQLPositionalParams(){
        Customer nimal = customerRepo.getAllCustomersJPQLPositionalParams("Nimal");
        System.out.println(nimal);
    }

    @Test
    public void checkPageableFeatures(){
       // PageRequest pr=PageRequest.of(0,3);
        PageRequest pr=PageRequest.of(0,3, Sort.by("id").descending());
        Page<Customer> all = customerRepo.findAll(pr);
        all.forEach(v->{
            System.out.println(v.toString());
        });
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