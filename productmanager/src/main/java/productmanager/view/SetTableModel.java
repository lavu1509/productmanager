/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import productmanager.model.CategoryModel;
import productmanager.model.ProductModel;

/**
 *
 * @author Fox0fNight
 */
public class SetTableModel {
    
     public DefaultTableModel setTableCategory(List<CategoryModel> listcat, String[] listcolumn) {
        int columns = listcolumn.length;
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        model.setColumnIdentifiers(listcolumn);
        Object[] obj;
        int num = listcat.size();
        for (int i = 0; i < num; i++) {
            CategoryModel catmodel = listcat.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = catmodel.getIdcat();
            obj[2] = catmodel.getCatname();
            obj[3] = catmodel.isStatus();
            model.addRow(obj);
        }
        return model;

    }
     
     public DefaultTableModel setTableProduct(List<ProductModel> listpro, String[] listcolumn) {
        int columns = listcolumn.length;
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(listcolumn);
        Object[] obj;
        int num = listpro.size();
        for (int i = 0; i < num; i++) {
            ProductModel promodel = listpro.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = promodel.getIdpro();
            obj[2] = promodel.getIdcat();
            obj[3] = promodel.getProname();
            obj[4] = promodel.getPrice();
            obj[5] = promodel.getSoluong();
            obj[6] = promodel.getInputdate();
            obj[7] = promodel.getOutputdate();
            obj[8] = promodel.getExpirydate();
            obj[9] = promodel.getMota();
            model.addRow(obj);
        }
        return model;

    }
}
