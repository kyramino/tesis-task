/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "ID")
@Table(name = "TESIS_CUSTOMER_COMPANY")
@DiscriminatorValue("COMPANY_CUSTOMER")
@Entity(name = "tesis_Company")
public class Company extends Customer {

    private static final long serialVersionUID = -6050677497929965795L;

    @NotBlank
    @NotNull
    @Pattern(message = "INN must contains only numbers", regexp = "/d+")
    @Column(name = "INN")
    protected String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
