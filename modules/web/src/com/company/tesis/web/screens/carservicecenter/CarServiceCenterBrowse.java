/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.carservicecenter;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.CarServiceCenter;


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
}
