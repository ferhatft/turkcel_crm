package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
