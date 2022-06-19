package com.mycompany.finaljavaproject.controller;

import com.mycompany.finaljavaproject.model.InvoiceHeaderHandeller;
import com.mycompany.finaljavaproject.model.InvoiceLinesHandler;
import com.mycompany.finaljavaproject.model.LinesTabelModel;
import com.mycompany.finaljavaproject.view.AppView;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Saeed
 */
public class InvoiceTabelListener implements ListSelectionListener{
    
    private AppView frame;

    public InvoiceTabelListener(AppView frame) {
        this.frame = frame;
    }   
    

    @Override
    public void valueChanged(ListSelectionEvent e) {
        var selectedInvIndex = frame.getInvoiceHeaderTbl().getSelectedRow();
        if(selectedInvIndex != -1){
        InvoiceHeaderHandeller invoiceHeaderHandeller = frame.getInvoiceHeaderArray().get(selectedInvIndex);
        ArrayList<InvoiceLinesHandler> lines = invoiceHeaderHandeller.getLines();
        LinesTabelModel lineTabelModel = new LinesTabelModel(lines);
        frame.setInvoiceLinesArray(lines);
        frame.getInvoiceLineTbl().setModel(lineTabelModel);
        frame.getInvoiceNumberValueLabel().setText(""+invoiceHeaderHandeller.getInvoiceNum());
        frame.getIncoiveDatevluelable().setText(AppView.simpleDateFormat.format(invoiceHeaderHandeller.getInvoiceDate()));
        frame.getCustomerNameVlueLabel().setText(invoiceHeaderHandeller.getCountomerName());
        frame.getInvoiveTotalValuelabel().setText(""+invoiceHeaderHandeller.getIinvoicePriceTotal());
    }
    }
    
    
}
