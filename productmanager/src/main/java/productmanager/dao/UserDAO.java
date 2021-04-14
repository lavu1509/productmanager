/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import productmanager.model.UserModel;

/**
 *
 * @author Fox0fNight
 */
public class UserDAO {

    public UserModel login(String txtUsername, String txtPassword) {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM user WHERE username LIKE ?  AND password LIKE ?";
        UserModel usermodel = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, txtUsername);
            ps.setString(2, txtPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usermodel = new UserModel();
                usermodel.setIduser(rs.getInt("iduser"));
                usermodel.setUsername(rs.getString("username"));
                usermodel.setPassword(rs.getString("password"));
                usermodel.setStatus(rs.getBoolean("status"));
            }
            ps.close();
            cons.close();
            return usermodel;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
