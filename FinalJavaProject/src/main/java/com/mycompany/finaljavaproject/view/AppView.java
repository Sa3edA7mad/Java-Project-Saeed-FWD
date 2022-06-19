package com.mycompany.finaljavaproject.view;

import com.mycompany.finaljavaproject.controller.InvoiceAppActionListener;
import com.mycompany.finaljavaproject.controller.InvoiceTabelListener;
import com.mycompany.finaljavaproject.model.HeaderTablelModel;
import com.mycompany.finaljavaproject.model.InvoiceHeaderHandeller;
import com.mycompany.finaljavaproject.model.InvoiceLinesHandler;
import com.mycompany.finaljavaproject.model.LinesTabelModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;



public class AppView extends javax.swing.JFrame {


    public AppView() {
        this.actionLestener = new InvoiceAppActionListener(this);
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceHeaderTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceLineTbl = new javax.swing.JTable();
        createNewInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        save = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        invoiceNumberLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        coustomerNameLabel = new javax.swing.JLabel();
        invoiceNumberValueLabel = new javax.swing.JLabel();
        incoiveDatevluelable = new javax.swing.JLabel();
        customerNameVlueLabel = new javax.swing.JLabel();
        invoiveTotalValuelabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        InvoiceHeaderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Coustomer", "Total"
            }
        ));
        InvoiceHeaderTbl.getSelectionModel().addListSelectionListener(invoiceTabelListener);

        jScrollPane1.setViewportView(InvoiceHeaderTbl);

        InvoiceLineTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Total"
            }
        ));
        jScrollPane2.setViewportView(InvoiceLineTbl);

        createNewInvoiceButton.setText("Create New Invoice");
        createNewInvoiceButton.addActionListener(actionLestener);

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(actionLestener);

        save.setText("Save");
        save.addActionListener(actionLestener);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(actionLestener);

        invoiceNumberLabel.setText("Invoice Number");

        invoiceDateLabel.setText("Invoice Date");

        coustomerNameLabel.setText("Coustomer Name");

        invoiceTotalLabel.setText("Invoice Total");
        invoiceTotalLabel.setToolTipText("");

        jMenu1.setText("File");

        loadFileMenuItem.setText("Load File");
        loadFileMenuItem.addActionListener(actionLestener);
        jMenu1.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        saveFileMenuItem.addActionListener(actionLestener);
        jMenu1.add(saveFileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(createNewInvoiceButton)
                .addGap(18, 18, 18)
                .addComponent(deleteInvoiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceDateLabel)
                            .addComponent(invoiceNumberLabel)
                            .addComponent(coustomerNameLabel)
                            .addComponent(invoiceTotalLabel))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incoiveDatevluelable)
                            .addComponent(invoiceNumberValueLabel)
                            .addComponent(invoiveTotalValuelabel)
                            .addComponent(customerNameVlueLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoiceNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coustomerNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceTotalLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoiceNumberValueLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(incoiveDatevluelable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerNameVlueLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiveTotalValuelabel)))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(save)
                    .addComponent(cancelButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceHeaderTbl;
    private javax.swing.JTable InvoiceLineTbl;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel coustomerNameLabel;
    private javax.swing.JButton createNewInvoiceButton;
    private javax.swing.JLabel customerNameVlueLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JLabel incoiveDatevluelable;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel invoiceNumberValueLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JLabel invoiveTotalValuelabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JButton save;
    private javax.swing.JMenuItem saveFileMenuItem;
    // End of variables declaration//GEN-END:variables
    private InvoiceAppActionListener actionLestener = new InvoiceAppActionListener(this);
    private ArrayList<InvoiceHeaderHandeller> invoiceHeaderArray ;
    private ArrayList<InvoiceLinesHandler> invoiceLinesArray;

    public ArrayList<InvoiceHeaderHandeller> getInvoiceHeaderArray() {
        return invoiceHeaderArray;
    }
    private HeaderTablelModel headerTablelModel;
    private LinesTabelModel linesTabelModel;

    public LinesTabelModel getLinesTabelModel() {
        return linesTabelModel;
    }
    private InvoiceTabelListener invoiceTabelListener = new InvoiceTabelListener(this);
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    
    
    public void setInvoiceHeaderArray(ArrayList<InvoiceHeaderHandeller> invoiceHeaderArray) {
        this.invoiceHeaderArray = invoiceHeaderArray;
    }
    
    public InvoiceHeaderHandeller getInvoinceObj(int invoiceId){
        for (InvoiceHeaderHandeller invoice : invoiceHeaderArray){
            if(invoice.getInvoiceNum() == invoiceId){
                return invoice;
            }
        }
        return null;
    } 

    public HeaderTablelModel getHeaderTablelModel() {
        return headerTablelModel;
    }

    public void setHeaderTablelModel(HeaderTablelModel headerTablelModel) {
        this.headerTablelModel = headerTablelModel;
    }

    public JTable getInvoiceHeaderTbl() {
        return InvoiceHeaderTbl;
    }

    public JTable getInvoiceLineTbl() {
        return InvoiceLineTbl;
    }

    public JLabel getCustomerNameVlueLabel() {
        return customerNameVlueLabel;
    }

    public JLabel getIncoiveDatevluelable() {
        return incoiveDatevluelable;
    }

    public JLabel getInvoiceNumberValueLabel() {
        return invoiceNumberValueLabel;
    }

    public JLabel getInvoiveTotalValuelabel() {
        return invoiveTotalValuelabel;
    }

    public InvoiceAppActionListener getActionLestener() {
        return actionLestener;
    }

    public ArrayList<InvoiceLinesHandler> getInvoiceLinesArray() {
        return invoiceLinesArray;
    }

    public void setInvoiceLinesArray(ArrayList<InvoiceLinesHandler> invoiceLinesArray) {
        this.invoiceLinesArray = invoiceLinesArray;
    }
    
    
}


