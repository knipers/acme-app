package com.moacirknipers.app.repositories;

import com.moacirknipers.app.entities.Installation;
import com.moacirknipers.app.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public Optional<Invoice> findByInvoiceCode(String invoiceCode);
    public List<Invoice> findByInstallation(Installation installation);
}
