/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.service;

import com.company.tesis.entity.City;

import java.util.UUID;

public interface CityService {

    String NAME = "tesis_CityService";

    City getDefaultCity();

    void resetDefaultCity(City exclusionCity);

    boolean hasCityWithSuchName(UUID id, String name);
}
