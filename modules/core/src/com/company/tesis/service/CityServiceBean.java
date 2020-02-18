/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.service;

import com.company.tesis.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public City getDefaultCity() {
        EntityManager entityManager = persistence.getEntityManager();
        return entityManager.createNativeQuery("SELECT * FROM TESIS_CITY where IS_DEFAULT IS TRUE", City.class).getFirstResult();
    }

    @Transactional
    public void resetDefaultCity(City exclusionCity){
        EntityManager entityManager = persistence.getEntityManager();
        Query query;
        if(exclusionCity != null) {
            query = entityManager.createNativeQuery("UPDATE TESIS_CITY SET IS_DEFAULT = FALSE WHERE ID != ?1");
            query.setParameter(1, exclusionCity.getId());
        } else {
            query = entityManager.createNativeQuery("UPDATE TESIS_CITY SET IS_DEFAULT = FALSE");
        }
        query.executeUpdate();
    }

}
