package repository;

import model.AccountInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
   private SessionFactory factory;

private Transaction transaction;



    @Override
    public void saveDB(AccountInfo user) {
    factory.getCurrentSession().save(user);
    }

    @Override
    public List<AccountInfo> allUsersFromDB() {
       try(Session session=factory.openSession()) {
           List<AccountInfo> list = session.createQuery("SELECT E FROM model.AccountInfo E").list();
           return list;
       }
    }

    @Override
    public boolean find(String username, String password) {
        try(Session session=factory.openSession()){
            Query q=session.createQuery("FROM  model.AccountInfo E where E.username=:user AND E.password=:pass");
           q.setParameter("user",username);
           q.setParameter("pass",password);

                return !q.list().isEmpty();
        }

    }

    @Override
    public AccountInfo getAccount(String username) {
      try(Session session=factory.openSession()){
          Query q=session.createQuery("FROM  model.AccountInfo E where E.username=:user");
          q.setParameter("user",username);


      return (AccountInfo)q.list().get(0);}
    }

    public void Transactional(){
      // if(!factory.getCurrentSession().getTransaction().isActive())
       transaction= factory.getCurrentSession().beginTransaction();
}
    public void commit(){
      transaction.commit();
    }
    public void rollBack(){
        transaction.rollback();
    }

}
