package com.mycompany.finaljavaproject.model;

import com.mycompany.finaljavaproject.view.AppView;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Saeed
 */


public class InvoiceHeaderHandeller {
    private int invoiceNum;
    private String countomerName;
    private Date invoiceDate;
    private ArrayList<InvoiceLinesHandler> lines;
    public InvoiceHeaderHandeller() {
    }

    public InvoiceHeaderHandeller(int invoiceNum, String countomerName, Date invoiceDate) {
        this.invoiceNum = invoiceNum;
        this.countomerName = countomerName;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getCountomerName() {
        return countomerName;
    }

    public void setCountomerName(String countomerName) {
        this.countomerName = countomerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceLinesHandler> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLinesHandler> lines) {
        this.lines = lines;
    }
    
    public double getIinvoicePriceTotal(){
        double total = 0.0;
        
        for (int i =0; i<getLines().size(); i++){
            total = total + getLines().get(i).getLineTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return (invoiceNum + "," + AppView.simpleDateFormat.format(invoiceDate) + "," + countomerName);
    }
    
}
