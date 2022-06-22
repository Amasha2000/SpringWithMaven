package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    long countByName(String name);

    void deleteByName(String name);

    void removeByName(String name);

     List<Customer> findByName(String name);

     //Native Sql
     @Query(value = "select * from customer",nativeQuery = true)
     List<Customer> getAllCustomers();

     //JPQL(Java Persistence Query Language)
     @Query(value = "select u from Customer u")
     List<Customer> getAllCustomersJPQL();

     //Hibernate Query Language
    @Query(value = "from Customer c")
    List<Customer> getAllCustomersWithHQL();

    //Parameters
    //1. Positional Parameters =?1
    //2. Named Parameters =:name


    //Native Sql with params
    //positional params
    @Query(value = "SELECT * FROM Customer WHERE name=?1",nativeQuery = true)
    Customer searchCustomerByName(String name);

    //named params
    @Query(value = "select * from Customer where name=:name and address=:address",nativeQuery = true)
    Customer searchCustomerNamedParams(@Param("name") String name, @Param("address") String address);

    //JPQL(Java Persistence Query Language)
    //Same in HQL also
    @Query(value = "select u from Customer u where u.name=?1")
    Customer getAllCustomersJPQLPositionalParams(String name);
}
