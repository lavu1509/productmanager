/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import productmanager.model.MenuModel;
import productmanager.view.CategoryJPanel;
import productmanager.view.DashboardJPanel;
import productmanager.view.MemberJPanel;
import productmanager.view.ProductJPanel;
import productmanager.view.StatisticJPanel;

/**
 *
 * @author Fox0fNight
 */
public class MenuController {
    private JPanel root;
    private String kindSelected = "";
    private List<MenuModel> listItem = null;
    
    public MenuController() {
    }

    public MenuController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Dashboard";
        jpnItem.setBackground(new Color(255, 153, 255));
        jlbItem.setBackground(new Color(255, 153, 255));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new DashboardJPanel());
        root.validate();
        root.repaint();
        
    }
    public void setEvent(List<MenuModel> listItem){
        this.listItem = listItem;
        listItem.forEach(item -> {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        });
    } 
    
    class LabelEvent implements MouseListener{
        private JPanel node;
        private final String kind;
        
        private final JPanel jpnItem;
        private final JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            node = switch (kind) {
                case "Dashboard" -> new DashboardJPanel();
                case "Category" -> new CategoryJPanel();
                case "Product" -> new ProductJPanel();
                case "Member" -> new MemberJPanel();
                case "Statistics" -> new StatisticJPanel();
                default -> new DashboardJPanel();
            };
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(255, 153, 255));
            jlbItem.setBackground(new Color(255, 153, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255, 153, 255));
            jlbItem.setBackground(new Color(255, 153, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(240, 240, 240));
                jlbItem.setBackground(new Color(240, 240, 240));
            }
        }
        
    }
    private void setChangeBackgroud(String kind){
        listItem.forEach(item -> {
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(255, 153, 255));
                item.getJlb().setBackground(new Color(255, 153, 255));
            }else{
                item.getJpn().setBackground(new Color(240, 240, 240));
                item.getJlb().setBackground(new Color(240, 240, 240));
            }
        });
    }
    
    
}
