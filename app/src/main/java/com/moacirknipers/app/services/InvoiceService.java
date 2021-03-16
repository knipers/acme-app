package com.moacirknipers.app.services;

import com.moacirknipers.app.entities.Customer;
import com.moacirknipers.app.entities.Installation;
import com.moacirknipers.app.entities.Invoice;
import com.moacirknipers.app.exceptions.InvoiceException;
import com.moacirknipers.app.repositories.CustomerRepository;
import com.moacirknipers.app.repositories.InstallationRepository;
import com.moacirknipers.app.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private InvoiceRepository repository;
    private CustomerRepository customerRepository;
    private InstallationRepository installationRepository;

    @Autowired
    public InvoiceService(InvoiceRepository repository, CustomerRepository customerRepository, InstallationRepository installationRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.installationRepository = installationRepository;
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> list;
        try {
            list = repository.findAll();
        } catch (Exception e) {
            throw new InvoiceException("Find all invoices error");
        }
        return list;
    }

    public Optional<Invoice> getByInvoiceCode(String invoiceCode) {
        Optional<Invoice> invoice = null;
        try {
            invoice = repository.findByInvoiceCode(invoiceCode);
            if (!invoice.isPresent()) {
                throw new InvoiceException(String.format("Invoice code invalid - %s", invoiceCode));
            }
        } catch (Exception e) {
            throw new InvoiceException(String.format("Invoice code invalid - %s", invoiceCode));
        }
        return invoice;
    }

    public List<Invoice> getInvoicesByCustomerIdentityDocument(String identityDocument) {
        List<Installation> installationList = getInstallationByIdentityDocument(identityDocument);
        List<Invoice> invoices = new ArrayList<>();
        for (Installation x : installationList) {
            invoices.addAll(x.getInvoiceList());
        }
        return invoices;
    }

    private List<Installation> getInstallationByIdentityDocument(String identityDocument) {
        Optional<Customer> customer = null;
        try {
            customer = customerRepository.findByIdentityDocument(identityDocument);
            if (!customer.isPresent()) {
                throw new InvoiceException(String.format("Customer not found: %s", identityDocument));
            }
            return installationRepository.findByCustomer(customer.get());
        } catch (Exception e) {
            throw new InvoiceException(String.format("Customer not found: %s", identityDocument));
        }
    }

    public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
        Optional<Installation> installation;
        URI location = null;
        try {
            installation = installationRepository.findByInstallationCode(invoice.getInstallation().getInstallationCode());
            if (!installation.isPresent()) {
                throw new InvoiceException(String.format("Installation not found: %s", invoice.getInstallation().getInstallationCode()));
            }
            invoice.setInstallation(installation.get());
            Invoice newInvoice = repository.save(invoice);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newInvoice.getId()).toUri();
        } catch (Exception e) {
            throw new InvoiceException("Invoice register error.", e);
        }
        return ResponseEntity.created(location).build();
    }

}
