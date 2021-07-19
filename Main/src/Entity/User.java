package Entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String nationalCode;
    private String birthday;
    private double creadit;

    public User() {
    }

    public User(int id, String firstName, String lastName,
                String username, String password, String nationalCode,
                String birthday, double creadit) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.creadit = creadit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getCreadit() {
        return creadit;
    }

    public void setCreadit(double creadit) {
        this.creadit = creadit;
    }
}
