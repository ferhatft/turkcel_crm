package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCustomerIdAndIsprimaryTrue(int customerId);


    Page<Address> findAllByIsActiveTrue(Pageable pageable);


    @Query("SELECT a FROM Address a WHERE a.id = :addressId AND a.isActive = true")
    Optional<Address> findActiveAddressById(@Param("addressId") int addressId);


    @Modifying
    @Transactional
    @Query("UPDATE Address a SET a.isActive = false, a.deletedDate = CURRENT_TIMESTAMP WHERE a.id = :addressId")
    void deactivateByAddressId(@Param("addressId") int addressId);





}
