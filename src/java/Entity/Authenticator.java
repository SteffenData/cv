/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author juhlm
 */
public class Authenticator {
    private String userNaeme;
    private String passWord;

    public Authenticator() {
    }

    public String getUserNaeme() {
        return userNaeme;
    }

    public void setUserNaeme(String userNaeme) {
        this.userNaeme = userNaeme;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
