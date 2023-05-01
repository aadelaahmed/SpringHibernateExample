package org.example;

import org.example.config.ApplicationConfig;
import org.example.model.Employee;
import org.example.persistence.CRUDOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CRUDOperation<Employee> employeeDao = context.getBean("employeeDao",CRUDOperation.class);*/
        //use first way as normal localsessionfactory
        /*Employee employee = employeeDao.findById(10).get();
        System.out.println(employee);
*/
        //use HibernateTemlate
        //System.out.println(employeeDao.findAll());

        //use hibernatetemplate callback
        /*Employee employee = new Employee(
          1666,
          "hibernate first",
          "hibernate middle",
          "hibernate last",
          "hh100@gmail.com",
          0117L,
          3687,
          290000L
        );
        employeeDao.save(employee);*/

        //delete by transactiotemplate
//        employeeDao.delete(1333);

        //save bu transactional
        /*Employee employee = new Employee(
                1355,
                "hibernate first",
                "hibernate middle",
                "hibernate last",
                "hh100@gmail.com",
                0117L,
                3687,
                290000L
        );
        employeeDao.save(employee);*/
    }
}