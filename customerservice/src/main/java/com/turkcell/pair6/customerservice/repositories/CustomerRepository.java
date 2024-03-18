package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select new com.turkcell.pair6.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerNo, c.firstName, c.lastName, c.middleName, c.nationalityId)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityId()} <= 0 or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerNo()} is null or c.customerNo= :#{#request.getCustomerNo()})")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);
}
