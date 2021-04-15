/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.controller;

import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import productmanager.dao.ProductDAO;
import productmanager.model.ProductModel;

/**
 *
 * @author Fox0fNight
 */
public class ProductController {

    private ProductDAO prodao;

    public ProductController() {
        prodao = new ProductDAO();
    }

    public List<ProductModel> getList() {
        return prodao.getList();
    }

    public void addProduct(ProductModel catmodel) {
        prodao.addProduct(catmodel);
    }

    public void editProduct(ProductModel catmodel) {
        prodao.updateProduct(catmodel);
    }

    public void deleteProduct(int idcat) {
        prodao.deleteProduct(idcat);
    }
    public void getCat(JComboBox cbLoai){
        prodao.GetCat(cbLoai);
    }
    public void GetCatId(JComboBox cbLoai, int id){
        prodao.GetCatId(cbLoai, id);
    }
     public void GetCatName(JTextField txtcat,String txt){
          prodao.GetCatName(txtcat,txt);
     }
     
     public void addProductImage(ProductModel promodel,String path) throws FileNotFoundException{
         prodao.addProductImage(promodel, path);
     }
     public void GetImageById(JLabel label,int id){
         prodao.GetImageById(label, id);
     }
}
