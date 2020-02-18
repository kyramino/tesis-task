/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Customer;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}
