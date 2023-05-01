package org.example.persistence.dao;

import jakarta.transaction.Transactional;
import org.example.model.Employee;
import org.example.persistence.CRUDOperation;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao implements CRUDOperation<Employee> {
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public List<Employee> findAll() {
        String query = "from employee e";
        //HibernateTemplate hibernateTemplate = getHibernateTemplate();
        List<Employee> employees = (List<Employee>) hibernateTemplate.find(query);
        return employees;
    }

    @Override
    public Optional<Employee> findById(int id) {
        Session session = localSessionFactoryBean.getObject().openSession();
        Employee employee = session.find(Employee.class, id);
        return Optional.of(employee);
    }

    @Override
    public Optional<Employee> update(Employee entity, int id) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee entity) {
        return hibernateTemplate.execute(new HibernateCallback<Employee>() {
            @Override
            public Employee doInHibernate(Session session) throws HibernateException {
                session.beginTransaction();
                System.out.println("before adding employee entity");
                session.setFlushMode(FlushMode.COMMIT);
                session.save(entity);
                //session.flush();
                System.out.println("before committing");
                session.getTransaction().commit();
                return entity;
            }
        });
    }

    @Transactional
    public Employee saveByTransactionManagement(Employee entity) {
        hibernateTemplate.save(entity);
        return entity;
    }

    @Override
    public int delete(int id) {
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                Employee employee = hibernateTemplate.get(Employee.class, id);
                System.out.println(employee.toString());
                hibernateTemplate.delete(employee);
                return 1;
            }
        });
    }
}
