/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.entity;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NamePattern("%s|name")
@DiscriminatorValue("CUSTOMER_INDIVIDUAL")
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "ID")
@Table(name = "TESIS_CUSTOMER_INDIVIDUAL")
@Entity(name = "tesis_Individual")
public class Individual extends Customer {

    private static final long serialVersionUID = 989733407613167618L;

    @Pattern(message = "Individual customers passport number can contains only number", regexp = "\\d+")
    @NotBlank
    @NotNull
    @Column(name = "PASSPORT_NO", nullable = false)
    protected String passportNo;

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}
