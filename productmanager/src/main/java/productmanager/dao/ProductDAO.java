/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import productmanager.model.ProductModel;

/**
 *
 * @author Fox0fNight
 */
public class ProductDAO {

    public List<ProductModel> getList() {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM product";
        List<ProductModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel promodel = new ProductModel();
                promodel.setIdpro(rs.getInt("idpro"));
                promodel.setIdcat(rs.getInt("idcat"));
                promodel.setProname(rs.getString("proname"));
                promodel.setPrice(rs.getInt("price"));
                promodel.setSoluong(rs.getInt("soluong"));
                promodel.setInputdate(rs.getDate("inputdate"));
                promodel.setOutputdate(rs.getDate("outputdate"));
                promodel.setExpirydate(rs.getDate("expirydate"));
                promodel.setMota(rs.getString("mota"));

                list.add(promodel);
            }
            ps.close();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void GetCat(JComboBox cbLoai) {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "select * from category where status = 1";
        Statement st = null;
        try {
            st = cons.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MyCat = rs.getString("catname");
                cbLoai.addItem(MyCat);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (cons != null) {
                try {
                    cons.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void GetCatId(JComboBox cbLoai, int id) {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "select catname from category where idcat = " + id;
        Statement st = null;
        try {
            st = cons.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MyCat = rs.getString("catname");
                cbLoai.setSelectedItem(MyCat);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (cons != null) {
                try {
                    cons.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void GetCatName(JTextField txtcat, String txt) {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "select idcat from category where catname = '" + txt + "'";
        Statement st = null;
        try {
            st = cons.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("idcat");
                txtcat.setText(String.valueOf(id));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (cons != null) {
                try {
                    cons.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    public void addProduct(ProductModel promodel) {
        Connection conn = JDBCConnection.getJDBCConnection();
        //INSERT INTO `product_manager`.`product` (`idcat`, `proname`, `price`, `soluong`, `inputdate`, 
        //`outputdate`, `expirydate`, `mota`) VALUES ('');

        String sql = "INSERT INTO product (idcat,proname,price,soluong,inputdate,outputdate,expirydate,mota) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, promodel.getIdcat());
            pst.setString(2, promodel.getProname());
            pst.setInt(3, promodel.getPrice());
            pst.setInt(4, promodel.getSoluong());
            pst.setDate(5, promodel.getInputdate());
            pst.setDate(6, promodel.getOutputdate());
            pst.setDate(7, promodel.getExpirydate());
            pst.setString(8, promodel.getMota());

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(ProductModel promodel) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE product SET idcat=?,proname=?,price=?,soluong=?,inputdate=?,outputdate=?,expirydate=?,mota=? "
                + "WHERE idpro=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, promodel.getIdcat());
            pst.setString(2, promodel.getProname());
            pst.setInt(3, promodel.getPrice());
            pst.setInt(4, promodel.getSoluong());
            pst.setDate(5, promodel.getInputdate());
            pst.setDate(6, promodel.getOutputdate());
            pst.setDate(7, promodel.getExpirydate());
            pst.setString(8, promodel.getMota());
            pst.setInt(9, promodel.getIdpro());

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int idpro) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM product WHERE idpro = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idpro);

            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProductImage(ProductModel promodel, String path) throws FileNotFoundException {
        Connection conn = JDBCConnection.getJDBCConnection();
        //INSERT INTO `product_manager`.`product` (`idcat`, `proname`, `price`, `soluong`, `inputdate`, 
        //`outputdate`, `expirydate`, `mota`) VALUES ('');

        String sql = "INSERT INTO product (idcat,proname,price,soluong,inputdate,outputdate,expirydate,mota,image) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            InputStream is = new FileInputStream(new File(path));
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, promodel.getIdcat());
            pst.setString(2, promodel.getProname());
            pst.setInt(3, promodel.getPrice());
            pst.setInt(4, promodel.getSoluong());
            pst.setDate(5, promodel.getInputdate());
            pst.setDate(6, promodel.getOutputdate());
            pst.setDate(7, promodel.getExpirydate());
            pst.setString(8, promodel.getMota());
            pst.setBlob(9, is);
            pst.executeUpdate();

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GetImageById(JLabel label,int id) {
        Connection cons = JDBCConnection.getJDBCConnection();
        String sql = "select image from product where idpro = " + id;
        Statement st = null;
        try {
            st = cons.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                byte[] img = rs.getBytes("image");

                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                label.setIcon(newImage);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (cons != null) {
                try {
                    cons.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
