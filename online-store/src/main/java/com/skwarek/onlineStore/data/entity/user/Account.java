package com.skwarek.onlineStore.data.entity.user;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "account")
public class Account extends BaseEntity implements Serializable {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    private static final long serialVersionUID = 1237200494497518900L;

    @Size(min = 3, max = 5, message = "{Account.username.validation.size}")
    @Column(name = "username")
    private String username;

    @Size(min = 3, max = 5, message = "{Account.password.validation.size}")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @NotNull(message = "{Account.email.validation.notNull}")
    @Pattern(regexp = "[a-zA-Z0-9.]+@[a-zA-Z0-9.]+", message = "{Account.email.validation.pattern}")
    @Column(name = "email")
    private String email;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @Column(name = "role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return username != null ? username.equals(account.username) : account.username == null;

    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username=" + username +
                ", password=" + password +
                ", email=" + email +
                ", dateCreated=" + dateCreated +
                ", role=" + role +
                ", customer=" + customer +
                '}';
    }
}