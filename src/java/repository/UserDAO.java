package repository;

import model.AccountInfo;

import java.util.List;

public interface UserDAO {
    void saveDB(AccountInfo user);
    List<AccountInfo> allUsersFromDB();
    boolean find(String username,String password);
    AccountInfo getAccount(String username);
}
