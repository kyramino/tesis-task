/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.city;

import com.company.tesis.service.CityService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.City;
import org.springframework.util.StringUtils;

import javax.inject.Inject;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {

    @Inject
    private DataContext dataContext;

    @Inject
    private CityService cityService;


    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        getScreenData().loadAll();
        dataContext.addPreCommitListener(this::checkNameUnique);
    }

    private void checkNameUnique(DataContext.PreCommitEvent event) {
        String name = getEditedEntity().getName();
        if (cityService.hasCityWithSuchName(name)) {
//            notific0ations.create(Notifications.NotificationType.HUMANIZED).withCaption("Город с таким именем уже " +
//                                                                                               "существует").show();

        }
    }
}
