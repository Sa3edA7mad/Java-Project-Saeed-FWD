package com.mycompany.finaljavaproject.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Saeed
 */
public class NewInvoiceLineDialog extends JDialog{
    private final JTextField nameField;
    private final JTextField countField;
    private final JTextField priceField;
    private final JLabel nameLbl;
    private final JLabel countLbl;
    private final JLabel priceLbl;
    private final JButton okBtn;
    private final JButton cancelBtn;
    
    public NewInvoiceLineDialog(AppView frame) {
               
               
        priceField = new JTextField(20);
        priceLbl = new JLabel("Item Price");        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");        
        okBtn.setActionCommand("newLineOK");
        cancelBtn.setActionCommand("newLineCancel");        
        countField = new JTextField(30);
        countLbl = new JLabel("Item Count");
        nameField = new JTextField(30);
        nameLbl = new JLabel("Item Name");
        
        okBtn.addActionListener(frame.getActionLestener());
        cancelBtn.addActionListener(frame.getActionLestener());
        
        setLayout(new GridLayout(4, 2));        
        setLocation(500, 500);
        
        add(nameLbl);
        add(nameField);
        add(countLbl);
        add(countField);
        add(priceLbl);
        add(priceField);
        add(okBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getCountField() {
        return countField;
    }

    public JTextField getPriceField() {
        return priceField;
    }
}
