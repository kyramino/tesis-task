/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.validator;

import com.company.tesis.service.CityService;
import com.haulmont.cuba.core.global.AppBeans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sergey.vasilev
 * @version $
 */
public class UniqueCityNameValidator implements ConstraintValidator<Unique, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !AppBeans.get(CityService.class).hasCityWithSuchName(value);
    }
}
