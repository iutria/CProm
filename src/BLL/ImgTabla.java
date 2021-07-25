/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author IVÁN UTRIA
 */
public class ImgTabla extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int column) {
        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            lbl.setOpaque(true);
            lbl.setBackground(new Color(128,140,141));
            lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            return lbl;
        }
        if(value instanceof TextField){
            TextField txt = (TextField)value;
            txt.setSize(20,100);
            return txt;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
