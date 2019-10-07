/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author RODRIGUEZ
 */
public class User {
    
    private String user_name;
    private String pass;
    private int type;
    private boolean state;

    public User(String user_name, String pass, int type, boolean state) {
        this.user_name = user_name;
        this.pass = pass;
        this.type = type;
        this.state = state;
    }
    
    
    public User(HttpServletRequest request){
        
       user_name = request.getParameter("name");
       pass = request.getParameter("pass");
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
}
