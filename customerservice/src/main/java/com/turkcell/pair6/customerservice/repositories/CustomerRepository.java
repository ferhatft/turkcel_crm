package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select new com.turkcell.pair6.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerNo, c.firstName, c.lastName, c.middleName, c.nationalityId)" +
            " from Customer c" +
            " where (:#{#request.getNationalityId()} is null or c.nationalityId = :#{#request.getNationalityId()} or :#{#request.getNationalityId()} = '')" +
            " and (:#{#request.getFirstName()} is null or c.firstName = :#{#request.getFirstName()} or :#{#request.getFirstName()} = '')" +
            " and (:#{#request.getCustomerNo()} is null or c.customerNo = :#{#request.getCustomerNo()} or :#{#request.getCustomerNo()} = '')" +
            " and (:#{#request.getLastName()} is null or c.lastName = :#{#request.getLastName()} or :#{#request.getLastName()} = '')" +
            " and ((:#{#request.getMiddleName()} is null or c.middleName = :#{#request.getMiddleName()}) or :#{#request.getMiddleName()} = '')")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);


    Optional<Customer> findByNationalityId(String nationalityId);

}
