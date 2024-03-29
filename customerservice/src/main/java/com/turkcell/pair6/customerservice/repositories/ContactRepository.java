package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
