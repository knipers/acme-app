package com.moacirknipers.app.controllers;

import com.moacirknipers.app.entities.Invoice;
import com.moacirknipers.app.services.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Invoices Service")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @ApiOperation(value = "Invoices list")
    @GetMapping("invoices")
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();

    }

    @ApiOperation(value = "Find invoice by invoice code")
    @GetMapping("invoices/{invoicecode}")
    public Optional<Invoice> getInvoice(@PathVariable String invoiceCode) {
        return service.getByInvoiceCode(invoiceCode);
    }

    @ApiOperation(value = "Find invoices by customer identity document")
    @GetMapping("invoices/identitydocument/{identityDocument}")
    public List<Invoice> getInvoicesByIdentityDocument(@PathVariable String identityDocument) {
        return service.getInvoicesByCustomerIdentityDocument(identityDocument);
    }

    @ApiOperation(value = "Register a new invoice")
    @PostMapping("invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return service.createInvoice(invoice);
    }
}
