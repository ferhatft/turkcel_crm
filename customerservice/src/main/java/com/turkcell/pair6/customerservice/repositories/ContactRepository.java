package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.entities.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ContactRepository extends JpaRepository<Contact, Integer> {


    Page<Contact> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT c FROM Contact c WHERE c.id = :contactId AND c.isActive = true")
    Optional<Contact> findActiveContactById(@Param("contactId") int contactId);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.isActive = false, c.deletedDate = CURRENT_TIMESTAMP WHERE c.id = :contactId")
    void deactivateByContactId(@Param("contactId") int contactId);

    @Query("SELECT c FROM Contact c WHERE c.customer.id = :customerId AND c.isActive = true")
    Optional<Contact> findActiveContactByCustomerId(@Param("customerId") int customerId);

}
