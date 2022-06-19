package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    Customer findCustomerByName(String name);


    Customer findByNameAndAddress(String name,String address);

    Customer searchByName(String name);

    Customer readByName(String name);

    Customer getByName(String name);

    Customer queryByName(String name);

    Customer streamByName(String name);

    boolean existsByName(String name);

    int countByName(String name);

    void deleteByName(String name);

    void removeByName(String name);

     List<Customer> findByName(String name);

}
