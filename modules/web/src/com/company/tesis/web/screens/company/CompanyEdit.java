/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.tesis.entity.Company;


/**
 *
 * @author sergey.vasilev
 * @version $Id$
 */
@UiController("tesis_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}
