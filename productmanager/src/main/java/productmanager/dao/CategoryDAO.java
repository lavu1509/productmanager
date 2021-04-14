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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import productmanager.model.CategoryModel;

/**
 *
 * @author Fox0fNight
 */
public class CategoryDAO {

    public List<CategoryModel> getList() {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM category";
        List<CategoryModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel catmodel = new CategoryModel();
                catmodel.setIdcat(rs.getInt("idcat"));
                catmodel.setCatname(rs.getString("catname"));
                catmodel.setStatus(rs.getBoolean("status"));
                list.add(catmodel);
            }
            ps.close();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addCategory(CategoryModel catmodel) {
        Connection conn = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO category (catname,status) VALUES (?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, catmodel.getCatname());
            pst.setBoolean(2, catmodel.isStatus());

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCategory(CategoryModel catmodel) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE category SET catname=?,status=? WHERE idcat=?";
        //"UPDATE category SET catname = "+ "'?'" + ", status = " +"?"+ WHERE (idcat = +"'?'"+")";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, catmodel.getCatname());
            pst.setBoolean(2, catmodel.isStatus());
            pst.setInt(3, catmodel.getIdcat());

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(int idcat) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM category WHERE idcat = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idcat);

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
