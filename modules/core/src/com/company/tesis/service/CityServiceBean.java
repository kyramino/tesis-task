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
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public City getDefaultCity() {
        EntityManager entityManager = persistence.getEntityManager();
        return entityManager.createQuery("SELECT e FROM tesis_City e where e.isDefault IS TRUE", City.class)
                            .getFirstResult();
    }

    @Transactional
    @Override
    public void resetDefaultCity(City exclusionCity){
        EntityManager entityManager = persistence.getEntityManager();
        Query query;
        if(exclusionCity != null) {
            query = entityManager.createQuery("UPDATE tesis_City e SET e.isDefault = FALSE WHERE e.id <> :id");
            query.setParameter("id", exclusionCity.getId());
        } else {
            query = entityManager.createQuery("UPDATE tesis_City e SET e.isDefault = FALSE");
        }
        query.executeUpdate();
    }

    @Transactional
    @Override
    public boolean hasCityWithSuchName(String name) {
        EntityManager entityManager = persistence.getEntityManager();
        if (!StringUtils.isEmpty(name)) {
            Query query = entityManager.createQuery("SELECT e FROM tesis_City e where e.name like ?1", City.class);
            query.setParameter(1, name);
            return !query.getResultList().isEmpty();
        }
        return false;
    }

}
