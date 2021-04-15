/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.model;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author Fox0fNight
 */
public class ProductModel extends CategoryModel{
    private int idpro;
    private String proname;
    private int price;
    private int soluong;
    private Date inputdate;
    private Date outputdate;
    private Date expirydate;
    private String mota;
    private FileInputStream imageIn;
    private String imagePath;
    
    public ProductModel() {
    }
    
    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public Date getOutputdate() {
        return outputdate;
    }

    public void setOutputdate(Date outputdate) {
        this.outputdate = outputdate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public FileInputStream getImageIn() {
        return imageIn;
    }

    public void setImageIn(FileInputStream imageIn) {
        this.imageIn = imageIn;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

   
    
    
    
    
}
