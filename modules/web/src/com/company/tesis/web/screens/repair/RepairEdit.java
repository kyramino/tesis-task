/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Repair;


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
}
