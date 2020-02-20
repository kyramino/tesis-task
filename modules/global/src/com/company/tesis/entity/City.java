/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */
package com.company.tesis.entity;

import com.company.tesis.validator.UniqueCityName;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.config.defaults.Default;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.core.global.validation.groups.UiCrossFieldChecks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@UniqueCityName(groups = {Default.class, UiCrossFieldChecks.class})
@PublishEntityChangedEvents
@NamePattern("%s|name")
@Table(name = "TESIS_CITY")
@Entity(name = "tesis_City")
@Listeners("tesis_CityChangedListener")
public class City extends StandardEntity {

    private static final long serialVersionUID = -2557385710735762265L;

    @NotBlank
    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @Column(name = "IS_DEFAULT")
    protected Boolean isDefault = false;

    @OneToMany(mappedBy = "city")
    @OnDelete(DeletePolicy.DENY)
    protected List<CarServiceCenter> centers;

    @Pattern(message = "Code of the city contains only number", regexp = "\\d+")
    @Column(name = "CODE")
    protected String code;

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public List<CarServiceCenter> getCenters() {
        return centers;
    }

    public void setCenters(List<CarServiceCenter> centers) {
        this.centers = centers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
