package com.mycompany.finaljavaproject.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saeed
 */
public class LinesTabelModel extends AbstractTableModel {
    private final ArrayList<InvoiceLinesHandler> invoiceLinesArray;
    private final String[] coulums = {"No.","Item Name","Item Price","Count","Item Total"};

    public LinesTabelModel(ArrayList<InvoiceLinesHandler> invoiceLinesArray) {
        this.invoiceLinesArray = invoiceLinesArray;
    }
    
     
    @Override
    public int getRowCount() {
        return invoiceLinesArray == null ? 0 : invoiceLinesArray.size();
    }

    @Override
    public int getColumnCount() {
        return coulums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLinesHandler lines = invoiceLinesArray.get(rowIndex);
        switch (columnIndex){
            case 0 -> { 
                return rowIndex+1;
            } 
            case 1 -> {
                return lines.getItemName();
            } 
            case 2 -> {
                return lines.getItemPrice();
            } 
            case 3 -> {
                return lines.getItemCount();
            } 
            case 4 -> {
                return lines.getLineTotal();
            }
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        return coulums[column];
    }
    
            
}
