/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */
package com.company.tesis.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@PublishEntityChangedEvents
@NamePattern("%s|name")
@Table(name = "TESIS_CAR_SERVICE_CENTER")
@Entity(name = "tesis_CarServiceCenter")
public class CarServiceCenter extends StandardEntity {

    private static final long serialVersionUID = -3558041929991875742L;

    @NotEmpty
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREATOR_ID")
    protected User creator;

    @Pattern(message = "{msg://tesis_CarServiceCenter.phone.validation.Pattern}", regexp = "\\d+")
    @Column(name = "PHONE")
    protected String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Composition
    @OnDelete(DeletePolicy.UNLINK)
    @OneToMany(mappedBy = "center")
    protected List<Repair> repairs = new ArrayList<>();

    @Column(name = "ADDRESS")
    protected String address;

    @JoinTable(name = "TESIS_CAR_SERVICE_CENTER_CUSTOMER_LINK",
               joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
               inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    protected List<Customer> customers = new ArrayList<>();

    @Composition
    @OnDelete(DeletePolicy.DENY)
    @OneToMany(mappedBy = "center")
    protected List<Employee> employees = new ArrayList<>();

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> employees) {
        this.customers = employees;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
