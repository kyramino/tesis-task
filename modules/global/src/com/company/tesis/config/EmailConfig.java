/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

/**
 * @author sergey.vasilev
 * @version $
 */
@Source(type = SourceType.DATABASE)
public interface EmailConfig extends Config {

    @Property("email.from")
    @Default("sergey.vasilev@haulmont.com")
    String getEmailAddressFrom();
}
