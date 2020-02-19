/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.carservicecenter;

import com.company.tesis.entity.Employee;
import com.company.tesis.web.screens.employee.EmployeeEdit;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.CarServiceCenter;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_CarServiceCenter.browse")
@UiDescriptor("car-service-center-browse.xml")
@LookupComponent("carServiceCentersTable")
@LoadDataBeforeShow
public class CarServiceCenterBrowse extends StandardLookup<CarServiceCenter> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Table<CarServiceCenter> carServiceCentersTable;

    @Inject
    private UserSession userSession;

    @Subscribe("carServiceCentersTable.create")
    protected void onEmployeesTableCreateActionPerformed(Action.ActionPerformedEvent event) {
        CarServiceCenter carServiceCenter = new CarServiceCenter();
        carServiceCenter.setCreator(userSession.getCurrentOrSubstitutedUser());
        screenBuilders.editor(carServiceCentersTable)
                      .newEntity().newEntity(carServiceCenter)
                      .withScreenClass(CarServiceCenterEdit.class)     // specific editor screen
                      .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                      .build()
                      .show();
    }
}
