package com.moacirknipers.app.repositories;

import com.moacirknipers.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByIdentityDocument(String identityDocument);
}
