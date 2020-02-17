/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.City;


/**
 *
 * @author sergey.vasilev
 * @version $Id$
 */
@UiController("tesis_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
}
