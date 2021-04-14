/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.controller;

import productmanager.dao.UserDAO;
import productmanager.model.UserModel;

/**
 *
 * @author Fox0fNight
 */
public class LoginController {
    
    private UserDAO userdao ;

    public LoginController() {
        userdao = new UserDAO();
    }
    
    public UserModel login(String txtUsername, String txtPassword){
        
        return userdao.login(txtUsername, txtPassword);
        
    }
    
    
    
}
