package com.moacirknipers.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Installation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address installationAddress;

    @JsonBackReference
    @OneToMany(mappedBy = "installation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoiceList = new ArrayList<Invoice>();

    private String installationCode;
    private Date installationDate;

    public Installation() {
    }

    public Installation(Customer customer, Address installationAddress, List<Invoice> invoiceList, String installationCode, Date installationDate) {
        this.customer = customer;
        this.installationAddress = installationAddress;
        this.invoiceList = invoiceList;
        this.installationCode = installationCode;
        this.installationDate = installationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(Address installationAddress) {
        this.installationAddress = installationAddress;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getInstallationCode() {
        return installationCode;
    }

    public void setInstallationCode(String installationCode) {
        this.installationCode = installationCode;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Installation{" +
                "id=" + id +
                ", client=" + customer +
                ", installationAddress=" + installationAddress +
                ", invoiceList=" + invoiceList +
                ", installationCode='" + installationCode + '\'' +
                ", installationDate=" + installationDate +
                '}';
    }
}
