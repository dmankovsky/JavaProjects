package model;

public class User {
    private String auto_increment;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastname;

    public User(Integer auto_increment, String username, String salt, String password, String firstName, String lastname) {
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

//    CREATE TABLE IF NOT EXISTS USERS (
//        userid INT PRIMARY KEY auto_increment,
//        username VARCHAR(20),
//    salt VARCHAR,
//    password VARCHAR,
//    firstname VARCHAR(20),
//    lastname VARCHAR(20)
//);