package com.turkcell.pair6.invoiceservice.repositories;


import com.turkcell.pair6.invoiceservice.entities.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Page<Account> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT a FROM Account a WHERE a.id = :accountId AND a.isActive = true")
    Optional<Account> findActiveAccountById(@Param("accountId") int accountId);


    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.isActive = false, a.deletedDate = CURRENT_TIMESTAMP WHERE a.id = :accountId")
    void deactivateByAccountId(@Param("accountId") int accountId);
}
