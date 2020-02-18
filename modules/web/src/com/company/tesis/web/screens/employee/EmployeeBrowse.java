/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Employee;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}
