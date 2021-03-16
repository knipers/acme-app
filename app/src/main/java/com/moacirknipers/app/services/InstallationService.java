package com.moacirknipers.app.services;

import com.moacirknipers.app.entities.Customer;
import com.moacirknipers.app.entities.Installation;
import com.moacirknipers.app.exceptions.InstallationException;
import com.moacirknipers.app.repositories.CustomerRepository;
import com.moacirknipers.app.repositories.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class InstallationService {

    private InstallationRepository repository;
    private CustomerRepository customerRepository;

    @Autowired
    public InstallationService(InstallationRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    public List<Installation> getAllInstallations() {
        List<Installation> list;
        try {
            list = repository.findAll();
        } catch (Exception e) {
            throw new InstallationException("Find all installations error");
        }
        return list;
    }

    public Optional<Installation> getByInstallationCode(String installationCode) {
        Optional<Installation> installation = null;
        try {
            installation = repository.findByInstallationCode(installationCode);
            if (!installation.isPresent()) {
                throw new InstallationException(String.format("Installation code invalid - %s", installationCode));
            }
        } catch (Exception e) {
            throw new InstallationException(String.format("Installation code invalid - %s", installationCode));
        }
        return installation;
    }

    public List<Installation> getInstallationsByCustomerIdentityDocument(String identityDocument) {
        Optional<Customer> customer;
        List<Installation> list = null;
        try {
            customer = customerRepository.findByIdentityDocument(identityDocument);
            if (!customer.isPresent()) {
                throw new InstallationException(String.format("Customer not found: %s", identityDocument));
            }
            list = repository.findByCustomer(customer.get());
        } catch (Exception e) {
            throw new InstallationException(String.format("Customer not found: %s", identityDocument));

        }
        return list;
    }

    public ResponseEntity<Installation> registerNewInstallation(Installation installation) {
        Installation newInstallation;
        URI location = null;
        try {
            Optional<Customer> customer = customerRepository.findByIdentityDocument(installation.getCustomer().getIdentityDocument());
            if (!customer.isPresent()) {
                throw new InstallationException(String.format("Customer not found: %s", installation.getCustomer().getIdentityDocument()));
            }
            installation.setCustomer(customer.get());
            newInstallation = repository.save(installation);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newInstallation.getId()).toUri();
        } catch (Exception e) {
            throw new InstallationException("Installation register error", e);
        }
        return ResponseEntity.created(location).build();
    }
}
