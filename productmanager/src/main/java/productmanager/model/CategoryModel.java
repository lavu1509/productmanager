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
public class CategoryModel {
    private int idcat;
    private String catname;
    private boolean status;

    public CategoryModel() {
    }

    public CategoryModel(int idcat, String catname, boolean status) {
        this.idcat = idcat;
        this.catname = catname;
        this.status = status;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
          
}
