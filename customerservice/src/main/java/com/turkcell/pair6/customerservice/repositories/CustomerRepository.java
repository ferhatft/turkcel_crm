package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<IndividualCustomer, Integer> {

    Page<IndividualCustomer> findAllByIsActiveTrue(Pageable pageable);

    @Query("Select new com.turkcell.pair6.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerNo, c.firstName, c.lastName, c.middleName, c.nationalityId)" +
            " from IndividualCustomer c" +
            " where (:#{#request.getNationalityId()} is null or c.nationalityId = :#{#request.getNationalityId()} or :#{#request.getNationalityId()} = '')" +
            " and (:#{#request.getFirstName()} is null or c.firstName = :#{#request.getFirstName()} or :#{#request.getFirstName()} = '')" +
            " and (:#{#request.getCustomerNo()} is null or c.customerNo = :#{#request.getCustomerNo()} or :#{#request.getCustomerNo()} = '')" +
            " and (:#{#request.getLastName()} is null or c.lastName = :#{#request.getLastName()} or :#{#request.getLastName()} = '')" +
            " and ((:#{#request.getMiddleName()} is null or c.middleName = :#{#request.getMiddleName()}) or :#{#request.getMiddleName()} = '')" +
            " and c.isActive = true")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);


    @Query("Select c FROM IndividualCustomer c WHERE c.nationalityId = :nationalityId AND c.isActive = true ")
    Optional<IndividualCustomer> findActiveCustomerByNationalityId(String nationalityId);

    @Query("Select c FROM IndividualCustomer c WHERE c.id = :id AND c.isActive = true ")
    Optional<IndividualCustomer> findActiveCustomerById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE IndividualCustomer c SET c.isActive = false, c.deletedDate = CURRENT_TIMESTAMP WHERE c.nationalityId = :nationalityId")
    void deactivateByNationalityId(@Param("nationalityId") String nationalityId);
}
