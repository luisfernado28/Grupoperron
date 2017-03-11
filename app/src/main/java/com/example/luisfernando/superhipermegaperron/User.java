package com.example.luisfernando.superhipermegaperron;

/**
 * Created by andres on 10/3/2017.
 */

public class User extends Object {

    private String USER_NAME;
    private String NAME;
    private String E_MAIL;
    private String PASSWORD;



    public User(String []user){
        this.USER_NAME = user[0];
        this.NAME = user[1];
        this.E_MAIL = user[2];
        this.PASSWORD = user[3];
    }
    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

}
