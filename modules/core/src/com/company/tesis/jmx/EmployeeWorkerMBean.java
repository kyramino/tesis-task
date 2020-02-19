/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

package com.company.tesis.jmx;

import com.haulmont.cuba.core.sys.jmx.JmxBean;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@JmxBean(module = "greetings", alias = "EmployeeWorkerMBean")
@ManagedResource(description = "JMX bean for greetings")
public interface EmployeeWorkerMBean {

    @ManagedOperation(description = "Send greeting to employees")
    void sendGreetings();
}
