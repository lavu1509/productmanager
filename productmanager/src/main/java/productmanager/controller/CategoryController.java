/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.controller;

import java.util.List;
import productmanager.dao.CategoryDAO;
import productmanager.model.CategoryModel;

/**
 *
 * @author Fox0fNight
 */
public class CategoryController {

    private CategoryDAO catdao;

    public CategoryController() {
        catdao = new CategoryDAO();
    }

    public List<CategoryModel> getList() {
        return catdao.getList();
    }
    public void addCategory(CategoryModel catmodel){
        catdao.addCategory(catmodel);
    }
    public void editCategory(CategoryModel catmodel){
        catdao.updateCategory(catmodel);
    }
     public void deleteCategory(int idcat){
         catdao.deleteCategory(idcat);
     }
}
