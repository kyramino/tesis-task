/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.employee;

import com.company.tesis.entity.CarServiceCenter;
import com.company.tesis.entity.City;
import com.haulmont.cuba.gui.components.OptionsList;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Employee;


/**
 *
 * @author sergey.vasilev
 * @version $Id$
 */
@UiController("tesis_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

    @Subscribe("centersField")
    private void onOptionsListChanging(OptionsList.ValueChangeEvent<CarServiceCenter> event) {
        getEditedEntity().setCenter(event.getComponent().getValue());
    }

}
