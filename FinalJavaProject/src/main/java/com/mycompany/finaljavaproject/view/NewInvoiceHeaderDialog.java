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
public class NewInvoiceHeaderDialog extends JDialog {
    private final JTextField custoumerNameField;
    private final JTextField invoiceDateField;
    private final JLabel custumerNameLbl;
    private final JLabel invoiceDateLbl;
    private final JButton okBtn;
    private final JButton cancelBtn;

    public NewInvoiceHeaderDialog(AppView frame) {
        custumerNameLbl = new JLabel("Customer Name:");
        custoumerNameField = new JTextField(30);
        invoiceDateLbl = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(30);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("newInvOK");
        cancelBtn.setActionCommand("newInvCancel");
        
        okBtn.addActionListener(frame.getActionLestener());
        cancelBtn.addActionListener(frame.getActionLestener());
        setLayout(new GridLayout(3, 2));
        setLocation(500, 500);
        
        add(invoiceDateLbl);
        add(invoiceDateField);
        add(custumerNameLbl);
        add(custoumerNameField);
        add(okBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getCustomerName() {
        return custoumerNameField;
    }

    public JTextField getInvoiceDate() {
        return invoiceDateField;
    }
    
}
