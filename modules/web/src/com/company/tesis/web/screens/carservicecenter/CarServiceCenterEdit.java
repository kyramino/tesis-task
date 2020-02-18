/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.carservicecenter;

import com.company.tesis.entity.*;
import com.company.tesis.service.CityService;
import com.company.tesis.web.screens.employee.EmployeeEdit;
import com.company.tesis.web.screens.individual.IndividualEdit;
import com.company.tesis.web.screens.repair.RepairEdit;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.TableItems;
import com.haulmont.cuba.gui.components.data.table.ContainerTableItems;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_CarServiceCenter.edit")
@UiDescriptor("car-service-center-edit.xml")
@EditedEntityContainer("carServiceCenterDc")
@LoadDataBeforeShow
public class CarServiceCenterEdit extends StandardEditor<CarServiceCenter> {

    @Inject
    private Table<Employee> employeesDcTable;

    @Inject
    private Table<Repair> repairsDcTable;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private CityService cityService;

    @Subscribe("cityField")
    private void onOptionsListChanging(OptionsList.ValueChangeEvent<City> event) {
        getEditedEntity().setCity(event.getComponent().getValue());
    }

    @Subscribe("employeesDcTable.create")
    protected void onEmployeesTableCreateActionPerformed(Action.ActionPerformedEvent event) {
        Employee employee = new Employee();
        employee.setCenter(getEditedEntity());
        screenBuilders.editor(employeesDcTable)
                      .newEntity().newEntity(employee)
                      .withScreenClass(EmployeeEdit.class)     // specific editor screen
                      .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                      .build()
                      .show();
    }

    @Subscribe("repairsDcTable.create")
    protected void onRepairsTableCreateActionPerformed(Action.ActionPerformedEvent event) {
        Repair repair = new Repair();
        repair.setCenter(getEditedEntity());
        screenBuilders.editor(repairsDcTable)
                      .newEntity().newEntity(repair)
                      .withScreenClass(RepairEdit.class)     // specific editor screen
                      .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                      .build()
                      .show();
    }

    @Subscribe
    protected void onInitEntity(InitEntityEvent<CarServiceCenter> event){
        event.getEntity().setCity(cityService.getDefaultCity());
    }
}
