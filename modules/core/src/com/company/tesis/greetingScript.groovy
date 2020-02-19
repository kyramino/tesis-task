package com.company.tesis
/*
 *
 *  Copyright (c) 2019 Haulmont Technology Ltd. All Rights Reserved.
 *  Haulmont Technology proprietary and confidential.
 *  Use is subject to license terms.
 * /
 */

/**
 *
 * @author sergey.vasilev* @version 1
 */
String firstName = binding.getVariable("firstName")
String lastName = binding.getVariable("lastName")
String age = binding.getVariable("age")
String center = binding.getVariable("center")
return "Поздравляем вас с днем рождения, уважаемый " + firstName + " " + lastName + "!\n" +
        "Желаем всего наилучшего в ваши " + age + " лет!\n" +
        "С уважением, коллектив автосервиса \"" + center + "\"."
