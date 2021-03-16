package com.moacirknipers.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address invoiceAddress;

    @JsonBackReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Installation> installationList = new ArrayList<Installation>();

    private String name;
    private String identityDocument;
    private Date birthdayDate;

    public Customer() {
    }

    public Customer(Address invoiceAddress, List<Installation> installationList, String name, String identityDocument, Date birthdayDate) {
        this.invoiceAddress = invoiceAddress;
        this.installationList = installationList;
        this.name = name;
        this.identityDocument = identityDocument;
        this.birthdayDate = birthdayDate;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public List<Installation> getInstallationList() {
        return installationList;
    }

    public void setInstallationList(List<Installation> installationList) {
        this.installationList = installationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", invoiceAddress=" + invoiceAddress +
                ", installationList=" + installationList +
                ", name='" + name + '\'' +
                ", identityDocument='" + identityDocument + '\'' +
                ", birthdayDate=" + birthdayDate +
                '}';
    }
}
