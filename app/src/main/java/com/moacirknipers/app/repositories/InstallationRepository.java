package com.moacirknipers.app.repositories;

import com.moacirknipers.app.entities.Customer;
import com.moacirknipers.app.entities.Installation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstallationRepository extends JpaRepository<Installation, Long> {
    public Optional<Installation> findByInstallationCode(String installationCode);
    public List<Installation> findByCustomer(Customer customer);
}
