/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */
package com.company.tesis.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "TESIS_CITY")
@Entity(name = "tesis_City")
public class City extends StandardEntity {

    private static final long serialVersionUID = -2557385710735762265L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "city")
    protected List<CarServiceCenter> centers;

    @Column(name = "CODE")
    protected Long code;

    public List<CarServiceCenter> getCenters() {
        return centers;
    }

    public void setCenters(List<CarServiceCenter> centers) {
        this.centers = centers;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
