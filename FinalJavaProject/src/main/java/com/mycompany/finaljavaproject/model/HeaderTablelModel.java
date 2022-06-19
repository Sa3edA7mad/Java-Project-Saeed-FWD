package com.mycompany.finaljavaproject.model;

import com.mycompany.finaljavaproject.view.AppView;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saeed
 */
public class HeaderTablelModel extends AbstractTableModel{

    private final ArrayList<InvoiceHeaderHandeller> invoiceHeaderArray;

    public HeaderTablelModel(ArrayList<InvoiceHeaderHandeller> invoiceHeaderArray) {
        this.invoiceHeaderArray = invoiceHeaderArray;
    }
    
        
    @Override
    public int getRowCount() {
        return invoiceHeaderArray.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeaderHandeller invoice = invoiceHeaderArray.get(rowIndex);
        switch (columnIndex){
            case 0 -> { 
                return invoice.getInvoiceNum();
            } 
            case 1 -> {
                return AppView.simpleDateFormat.format(invoice.getInvoiceDate());
            } 
            case 2 -> {
                return invoice.getCountomerName();
            } 
            case 3 -> {
                return invoice.getIinvoicePriceTotal();
            }
        }
         return "";   
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "No.";
            case 1 -> "Date";
            case 2 -> "Coutomer";
            case 3 -> "Total";
            default -> "";
        };
        
    }
    
}
