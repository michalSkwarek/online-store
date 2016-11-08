package com.skwarek.onlineStore.data.entity.user;

import com.skwarek.onlineStore.data.entity.address.Address;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -188553511107544419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "{Customer.firstName.validation.notEmpty}")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "{Customer.lastName.validation.notEmpty}")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "{Customer.birthDate.validation.notEmpty}")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "{Customer.birthDate.validation.pattern}")
    @Column(name = "birth_date")
    private String birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "number_of_orders")
    private Integer numberOfOrders;

    @Transient
    private Account account;

    public Customer() { }

    public Customer(String firstName, String lastName, String birthDate, String phoneNumber, Integer numberOfOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.numberOfOrders = numberOfOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(customer.birthDate) : customer.birthDate != null) return false;
        return phoneNumber != null ? phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", birthDate=" + birthDate +
                ", billingAddress=" + billingAddress +
                ", phoneNumber=" + phoneNumber +
                ", numberOfOrders=" + numberOfOrders +
                '}';
    }
}
