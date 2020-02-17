package com.company.tesis.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s|name")
@Table(name = "TESIS_CUSTOMER")
@Entity(name = "tesis_Customer")
public class Customer extends StandardEntity {

    private static final long serialVersionUID = -8237751636988546541L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "TESIS_CUSTOMER_CAR_SERVICE_CENTER_LINK",
               joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
               inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"))
    @ManyToMany
    protected List<CarServiceCenter> centers;

    @Column(name = "PHONE")
    protected String phone;

    @Column(name = "EMAIL")
    protected String email;

    public List<CarServiceCenter> getCenters() {
        return centers;
    }

    public void setCenters(List<CarServiceCenter> centers) {
        this.centers = centers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
