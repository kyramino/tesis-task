/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.listeners;

import com.company.tesis.entity.City;
import com.company.tesis.service.CityService;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("tesis_CityChangedListener")
public class CityChangedListener implements BeforeUpdateEntityListener<City> {

    @Inject
    private CityService cityService;


    @Override
    public void onBeforeUpdate(City entity, EntityManager entityManager) {
        if(entity.getIsDefault()) {
            cityService.resetDefaultCity(entity);
        }
    }
}
