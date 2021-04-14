/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.model;

/**
 *
 * @author Fox0fNight
 */
public class UserModel {

    private int iduser;
    private String username;
    private String password;
    private boolean status;

    public UserModel() {
    }

    public UserModel(int iduser, String username, String password, boolean status) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public UserModel(int iduser, String username, String password) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
