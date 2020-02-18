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
 * @version 1
 */
@UiController("tesis_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
}
