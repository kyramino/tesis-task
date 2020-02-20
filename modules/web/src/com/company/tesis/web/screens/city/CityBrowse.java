/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.city;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.City;

import javax.inject.Inject;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Table<City> citiesTable;

    @Inject
    private CollectionLoader<City> citiesDl;


    @Subscribe("citiesTable.edit")
    protected void onEditActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.editor(citiesTable)
                      .withListComponent(citiesTable)
                      .withScreenClass(CityEdit.class)
                      .withLaunchMode(OpenMode.DIALOG)
                      .build()
                      .show().addAfterCloseListener(afterCloseEvent -> citiesDl.load());
    }
}
