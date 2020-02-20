/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.validator;

import com.company.tesis.entity.City;
import com.company.tesis.service.CityService;
import com.haulmont.cuba.core.global.AppBeans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sergey.vasilev
 * @version 1
 */
public class UniqueCityNameValidator implements ConstraintValidator<UniqueCityName, City> {

    @Override
    public boolean isValid(City value, ConstraintValidatorContext context) {
        return !AppBeans.get(CityService.class).hasCityWithSuchName(value.getId(), value.getName());
    }
}
