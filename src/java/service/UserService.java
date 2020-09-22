package service;

import model.AccountInfo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDAOImpl;

import java.util.List;

@Service
public class UserService {
    @Autowired
     @Qualifier(value = "userDAOImpl")
    UserDAOImpl userDAO;

    /**
     *
     * @param user
     *
     * A single Hibernate Session might have the same scope as a single database transaction.
     */
    public void saveDB(AccountInfo user){

    userDAO.Transactional();
      userDAO.saveDB(user);
     userDAO.commit();
    }

    public List<AccountInfo> getList(){
   // userDAO.Transactional();
    //List<AccountInfo> list=userDAO.allUsersFromDB();
   // userDAO.rollBack();
        return userDAO.allUsersFromDB() ;
    }
    public boolean find(String username,String password){
        return userDAO.find(username,password);

    }
    public AccountInfo getAccount(String username){

        return userDAO.getAccount(username);

    }
}
