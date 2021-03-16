package com.moacirknipers.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_installation")
    private Installation installation;

    private String invoiceCode;
    private Date readDate;
    private Date dueDate;
    private int readNumber;
    private double invoiceValue;

    public Invoice() {
    }

    public Invoice(Installation installation, String invoiceCode, Date readDate, Date dueDate, int readNumber, double invoiceValue) {
        this.installation = installation;
        this.invoiceCode = invoiceCode;
        this.readDate = readDate;
        this.dueDate = dueDate;
        this.readNumber = readNumber;
        this.invoiceValue = invoiceValue;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(int readNumber) {
        this.readNumber = readNumber;
    }

    public double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", installation=" + installation +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", readDate=" + readDate +
                ", dueDate=" + dueDate +
                ", readNumber=" + readNumber +
                ", invoiceValue=" + invoiceValue +
                '}';
    }
}
