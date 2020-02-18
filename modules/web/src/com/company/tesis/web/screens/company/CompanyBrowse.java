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
 * @version 1
 */
@UiController("tesis_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companiesTable")
@LoadDataBeforeShow
public class CompanyBrowse extends StandardLookup<Company> {
}
