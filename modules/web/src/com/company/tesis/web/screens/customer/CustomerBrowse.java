/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.customer;

import com.company.tesis.entity.Individual;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Customer;

import javax.inject.Inject;


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

    @Inject
    private Table<Customer> customersTable;

    @Inject
    private MessageBundle messageBundle;

    @Inject
    private UiComponents uiComponents;

    @Subscribe
    private void onInit(InitEvent event) {
        customersTable.addGeneratedColumn(messageBundle.getMessage("typeClientColumnName"), entity -> {
            Label<String> label = uiComponents.create(Label.NAME);
            if (entity instanceof Individual) {
                label.setValue(messageBundle.getMessage("individualClient"));
            } else {
                label.setValue(messageBundle.getMessage("companyClient"));
            }
            return label;
        });
    }
}
