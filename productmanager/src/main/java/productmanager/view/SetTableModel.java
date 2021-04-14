/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import productmanager.model.CategoryModel;

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
}
