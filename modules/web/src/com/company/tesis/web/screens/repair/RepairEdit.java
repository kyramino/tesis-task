/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.repair;

import com.company.tesis.entity.CarServiceCenter;
import com.company.tesis.entity.Employee;
import com.company.tesis.web.screens.employee.EmployeeEdit;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Repair;

import javax.inject.Inject;
import java.util.List;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {

    @Inject
    private LookupField<CarServiceCenter> centerField;

    @Inject
    private LookupField<Employee> employeeField;

    @Inject
    private DataContext dataContext;

    @Inject
    private CollectionLoader<Employee> employeesDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent  event) {
        employeesDl.setParameter("center", getEditedEntity().getCenter());
        getScreenData().loadAll();
        dataContext.addChangeListener(changeEvent -> updateEmployeeField());
    }

    private void updateEmployeeField(){
        CarServiceCenter carServiceCenter = centerField.getValue();
        if(carServiceCenter != null){
            List<Employee> employees = carServiceCenter.getEmployees();
            if(!employees.contains(employeeField.getValue())){
                employeeField.setValue(null);
            }
            employeeField.setOptionsList(employees);

        }
    }
}
