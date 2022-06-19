package com.mycompany.finaljavaproject.model;

/**
 *
 * @author Saeed
 */

public class InvoiceLinesHandler {
    private int itemCount;
    private double itemPrice;
    private String itemName;
    private InvoiceHeaderHandeller invoiceNum;

    public InvoiceLinesHandler() {
    }

    public InvoiceLinesHandler(int itemCount, double price, String itemName, InvoiceHeaderHandeller invoiceNum) {
        this.itemCount = itemCount;
        this.itemPrice = price;
        this.itemName = itemName;
        this.invoiceNum = invoiceNum;
    }

    public InvoiceHeaderHandeller getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(InvoiceHeaderHandeller invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getLineTotal(){
        return itemCount * itemPrice;
    } 

    @Override
    public String toString() {
        return (invoiceNum.getInvoiceNum() + "," + itemName + "," + itemPrice + "," + itemCount) ;
    }
    
}
