/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sergey.vasilev
 * @version 1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCityNameValidator.class)
public @interface UniqueCityName {

    String message() default "{msg://com.company.tesis.entity/cityUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
