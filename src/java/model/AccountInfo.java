package model;




import javax.persistence.*;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@CheckEquality(field ="password",fieldMatch = "ensurepass",message = "Passwords are not equal")
public class AccountInfo {

@Id
@Pattern(regexp = "[A-Za-z0-9//-//.//#]{5,13}",message = "username must be at least 5 characters and donot use symbols except - .")
@OccupiedInDB(property = "username",entity = AccountInfo.class)
private String username;
@Pattern(regexp ="[A-Za-z0-9//-]{6,15}",message = "password must be at least 6 characters")
    private String password;



    @Transient
private String ensurepass;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate date) {
        this.birthday =date;

    }

    @Basic
    private LocalDate birthday;

//
//@Pattern(regexp = "[0-9]{4}",message = "please select year")
//    private String year;
//@Pattern(regexp = "^(?!.*NONE).*$",message = "please select month")
//    private String month;
//@Pattern(regexp = "[0-9]{2}",message = "please select day")
//    private String day;


//    public void setYear(String year) {
//        this.year = year;
//    }
//    public String getYear(){
//        return year;
//    }
//
//    public String getMonth() {
//        return month;
//    }
//
//    public void setMonth(String month) {
//        this.month = month;
//    }
//
//    public String getDay() {
//        return day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnsurepass() {
        return ensurepass;
    }

    public void setEnsurepass(String ensurepass) {
        this.ensurepass = ensurepass;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s",username,password,birthday);
    }
}
