/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Individual;


/**
 *
 * @author sergey.vasilev
 * @version 1
 */
@UiController("tesis_Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
@LoadDataBeforeShow
public class IndividualEdit extends StandardEditor<Individual> {
}
