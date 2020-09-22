package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.List;

public class DBCheckValidator implements
        ConstraintValidator<OccupiedInDB, String> {
    @Autowired
   private SessionFactory factory;

    private Class<?> entity;
    private String property;

    @Override
    public void initialize(OccupiedInDB constraintAnnotation) {
    entity=constraintAnnotation.entity();
    property=constraintAnnotation.property();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext cx) {

        try(Session session=factory.openSession()){

            String query=String.format("FROM %s WHERE %s=:s",entity.getName(),property);
            Query q=session.createQuery(query);
            q.setParameter("s",s);
            List<AccountInfo> list=q.list();

            if(list.isEmpty())
                return true;


            return false;    }//try with resources
   }

}
