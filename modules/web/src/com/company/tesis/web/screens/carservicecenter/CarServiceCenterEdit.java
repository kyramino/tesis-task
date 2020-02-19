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
import com.company.tesis.web.screens.repair.RepairEdit;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;


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
    private Table<Customer> customersDcTable;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private CityService cityService;

    @Inject
    private TabSheet tabSheet;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private DataContext dataContext;

    @Inject
    private MessageBundle messageBundle;


    @Subscribe
    private void onInit(InitEvent event) {
        customersDcTable.addGeneratedColumn(messageBundle.getMessage("typeClientColumnName"), entity -> {
            Label<String> label = uiComponents.create(Label.NAME);
            if (entity instanceof Individual) {
                label.setValue(messageBundle.getMessage("individualClient"));
            } else {
                label.setValue(messageBundle.getMessage("companyClient"));
            }
            return label;
        });
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent  event) {
        getScreenData().loadAll();
        refreshTabCaption();
        dataContext.addChangeListener(changeEvent -> refreshTabCaption());

    }

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

    private void refreshTabCaption(){
        for(TabSheet.Tab tab : tabSheet.getTabs()) {
            if ("tab_clients".equals(tab.getName())) {
                int size = getEditedEntity().getCustomers() != null ? getEditedEntity().getCustomers().size() : 0;
                tab.setCaption("Clients (" + size + ")");
            }
        }
    }
}
