/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.carservicecenter;

import com.company.tesis.entity.City;
import com.company.tesis.entity.Employee;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.OptionsList;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.CarServiceCenter;

import javax.inject.Inject;



/**
 *
 * @author sergey.vasilev
 * @version $Id$
 */
@UiController("tesis_CarServiceCenter.edit")
@UiDescriptor("car-service-center-edit.xml")
@EditedEntityContainer("carServiceCenterDc")
@LoadDataBeforeShow
public class CarServiceCenterEdit extends StandardEditor<CarServiceCenter> {

    @Inject
    private CollectionLoader<Employee> employeesDl;

    @Subscribe("cityField")
    private void onOptionsListChanging(OptionsList.ValueChangeEvent<City> event) {
        getEditedEntity().setCity(event.getComponent().getValue());
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event){
        employeesDl.setParameter("center", getEditedEntity());
        getScreenData().loadAll();
    }
}
