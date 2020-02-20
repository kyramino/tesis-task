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
import java.util.UUID;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public City getDefaultCity() {
        EntityManager entityManager = persistence.getEntityManager();
        return entityManager.createQuery("SELECT e FROM tesis_City e where e.isDefault = TRUE", City.class)
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
    public boolean hasCityWithSuchName(UUID id, String name) {
        EntityManager entityManager = persistence.getEntityManager();
        if (!StringUtils.isEmpty(name)) {
            Query query = entityManager.createQuery("SELECT e FROM tesis_City e where e.name like :name AND " +
                                                            "e.id <> :id",
                                                    City.class);
            query.setParameter("name", name);
            query.setParameter("id", id);
            return !query.getResultList().isEmpty();
        }
        return false;
    }

}
