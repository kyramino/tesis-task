/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.jmx;

import com.company.tesis.config.EmailConfig;
import com.company.tesis.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component("tesis_EmployeeWorker")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    protected Persistence persistence;

    @Inject
    protected TimeSource timeSource;

    @Inject
    protected Scripting scripting;

    @Inject
    private EmailService emailService;

    @Inject
    private EmailConfig emailConfig;

    @Transactional
    public void sendGreetings() {
        Date date = timeSource.currentTimestamp();
        List<Employee> employees = getEmployee(date);
        for (Employee employee : employees) {
            if (!StringUtils.isEmpty(employee.getEmail())) {
                Calendar today = new GregorianCalendar();
                today.setTime(date);
                Calendar birthday = new GregorianCalendar();
                birthday.setTime(employee.getBirthDate());
                Binding binding = new Binding();
                binding.setVariable("firstName", employee.getFirstName());
                binding.setVariable("lastName", employee.getSecondName());
                binding.setVariable("age", today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR));
                binding.setVariable("center", employee.getCenter().getName());
                String greeting = scripting.runGroovyScript("com/company/tesis/greetingScript.groovy", binding);
                EmailInfo info = new EmailInfo(
                        employee.getEmail(),
                        "Greetings",
                        emailConfig.getEmailAddressFrom(),
                        greeting, null
                );
                try {
                    emailService.sendEmail(info);
                } catch (EmailException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Employee> getEmployee(Date date) {
        TypedQuery<Employee> query = persistence.getEntityManager().createNativeQuery(
                "SELECT * FROM TESIS_EMPLOYEE WHERE EXTRACT(DAY FROM BIRTH_DATE) = EXTRACT(DAY FROM CAST(?1 AS " +
                        "DATE)) AND " +
                        "EXTRACT(MONTH FROM BIRTH_DATE) = EXTRACT(MONTH FROM CAST(?2 AS DATE))", Employee.class);
        query.setParameter(1, date);
        query.setParameter(2, date);
        return query.getResultList();
    }
}
