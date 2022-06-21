package com.mycompany.finaljavaproject.controller;

import com.mycompany.finaljavaproject.model.HeaderTablelModel;
import com.mycompany.finaljavaproject.model.InvoiceHeaderHandeller;
import com.mycompany.finaljavaproject.model.InvoiceLinesHandler;
import com.mycompany.finaljavaproject.model.LinesTabelModel;
import com.mycompany.finaljavaproject.view.AppView;
import com.mycompany.finaljavaproject.view.NewInvoiceHeaderDialog;
import com.mycompany.finaljavaproject.view.NewInvoiceLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Saeed
 */
public class InvoiceAppActionListener implements ActionListener{

    private final AppView frame;
    private NewInvoiceHeaderDialog headerDialog;
    private NewInvoiceLineDialog lineDialog;
      
    public InvoiceAppActionListener (AppView frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File" -> loadFile();       
            case "Save File" -> saveFile();
            case "Create New Invoice" -> createNewInvoice();
            case "Delete Invoice" -> deleteInvoice();
            case "Save" -> save();
            case "Cancel" -> cancel();
            case "newInvCancel" -> newInvCancel();
            case "newInvOK" -> newInvOkay();
            case "newLineOK" -> newLineOkay();
            case "newLineCancel" -> newLineCancel();
            default -> throw new AssertionError();
        }        
    }


    private void cancel() {
        var selectedLineIndex = frame.getInvoiceLineTbl().getSelectedRow();
        var selectedInvoiceIndex = frame.getInvoiceLineTbl().getSelectedRow();
        if (selectedLineIndex != -1) {
            frame.getInvoiceLinesArray().remove(selectedLineIndex);
             LinesTabelModel lineTableModel = (LinesTabelModel) frame.getInvoiceLineTbl().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getHeaderTablelModel().fireTableDataChanged();
            frame.getInvoiveTotalValuelabel().setText("" + frame.getInvoiceLinesArray().get(selectedInvoiceIndex).getLineTotal());
            frame.getHeaderTablelModel().fireTableDataChanged();
        }
        
    }

    private void save() {
        lineDialog = new NewInvoiceLineDialog(frame);
        lineDialog.setVisible(true);
    }

    private void deleteInvoice() {
        var selectedInvToDelete = frame.getInvoiceHeaderTbl().getSelectedRow();
        if(selectedInvToDelete != -1){
            frame.getInvoiceHeaderArray().remove(selectedInvToDelete);
            frame.getHeaderTablelModel().fireTableDataChanged();
            frame.getInvoiceLineTbl().setModel(new LinesTabelModel(new ArrayList<>()));
            frame.setInvoiceLinesArray(null);
            frame.getInvoiceNumberValueLabel().setText("");
            frame.getIncoiveDatevluelable().setText("");
            frame.getCustomerNameVlueLabel().setText("");
            frame.getInvoiveTotalValuelabel().setText("");
        }
        else{
            JOptionPane.showMessageDialog(frame, "No Invoice Selected \n Please Select one.",
                    "Warrnig", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void createNewInvoice() {
        headerDialog = new NewInvoiceHeaderDialog(frame);
        headerDialog.setVisible(true);
    }
    private void newInvCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
    }

    private void newInvOkay() {
        headerDialog.setVisible(false);
        var custName = headerDialog.getCustomerName().getText();
        var invDate = headerDialog.getInvoiceDate().getText();
        Date date = new Date();
        try {
            date = AppView.simpleDateFormat.parse(invDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, 
                    "The date is in wrong format, will use today's date instade.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        InvoiceHeaderHandeller newInv = new InvoiceHeaderHandeller(newInvoiceNumber(), custName, date);
        frame.getInvoiceHeaderArray().add(newInv);
        frame.getHeaderTablelModel().fireTableDataChanged();
        headerDialog.dispose();
        headerDialog = null;
    }

    private void saveFile() {
        ArrayList<InvoiceHeaderHandeller> invArray = frame.getInvoiceHeaderArray();
        JFileChooser fileChooser = new JFileChooser();
        var result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION){
            File headFile = fileChooser.getSelectedFile();
            try {
                FileWriter headerFileWriter = new FileWriter(headFile);
                String headers = "";
                String lines = "";
                for(InvoiceHeaderHandeller invoice : invArray){
                    headers += invoice.toString();
                    headers += "\n";
                    for(InvoiceLinesHandler line : invoice.getLines()){
                        lines += line.toString();
                        lines += "\n";
                        }
                }
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fileChooser.showSaveDialog(frame);
                File lineFile = fileChooser.getSelectedFile();
                FileWriter linesFileWriter = new FileWriter(lineFile);
                headerFileWriter.write(headers);
                linesFileWriter.write(lines);
                headerFileWriter.close();
                linesFileWriter.close();
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }               
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        
        //Opening the header file.
        JOptionPane.showMessageDialog(frame,"Please open the invoice header file. ","Information",JOptionPane.INFORMATION_MESSAGE);
        var result = fileChooser.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
           File headerFile = fileChooser.getSelectedFile();
            try {
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<InvoiceHeaderHandeller> invoiceHeaderHandellers = new ArrayList<>();
                
                for(String headerLine : headerLines){
                    String[] tempArr = headerLine.split(",");
                    String tempInvoiceId = tempArr[0];
                    String tampDate = tempArr[1];
                    String tampName = tempArr[2];
                    
                    int invoiceId = Integer.parseInt(tempInvoiceId);
                    Date invoiceDate =AppView.simpleDateFormat.parse(tampDate);
                    
                    InvoiceHeaderHandeller hader = new InvoiceHeaderHandeller(invoiceId, tampName, invoiceDate);
                    
                    invoiceHeaderHandellers.add(hader);
                    System.out.println(hader.toString());
                }
                
                frame.setInvoiceHeaderArray(invoiceHeaderHandellers);
                JOptionPane.showMessageDialog(frame,"Please open the invoice lines file. ","Information",JOptionPane.INFORMATION_MESSAGE);
                 result = fileChooser.showOpenDialog(frame);
                 if(result == JFileChooser.APPROVE_OPTION){
                     File linesFile = fileChooser.getSelectedFile();                 
                    Path linesPath = Paths.get(linesFile.getAbsolutePath());
                    List<String> linesLines = Files.readAllLines(linesPath);
                 for(String linesLine : linesLines){
                     String[] tempArr = linesLine.split(",");
                     String tempInvoiceId = tempArr[0];
                     String itemName = tempArr[1];
                     String tempItemPrice = tempArr[2];
                     String tempItemCount = tempArr[3];
                     
                     var invoiceId = Integer.parseInt(tempInvoiceId);
                     var itemPrice = Double.parseDouble(tempItemPrice);
                     var itemCount = Integer.parseInt(tempItemCount);
                     
                     InvoiceHeaderHandeller invoice = frame.getInvoinceObj(invoiceId);
                     InvoiceLinesHandler line = new InvoiceLinesHandler(itemCount, itemPrice, itemName, invoice);
                     invoice.getLines().add(line);
                     System.out.println(line.toString());
                     
                 } 
                 
                     HeaderTablelModel headerTablelModel = new HeaderTablelModel(invoiceHeaderHandellers);
                     frame.setHeaderTablelModel(headerTablelModel);
                     frame.getInvoiceHeaderTbl().setModel(headerTablelModel);
                    
                 }
            } catch (IOException ex) {
                Logger.getLogger(InvoiceAppActionListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(frame,"The file: "+ ex.getMessage() + " is not found","Error",JOptionPane.ERROR_MESSAGE);                
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceAppActionListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(frame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);                
            }
        }
        else{
            JOptionPane.showMessageDialog(frame,"No file was choosen","Warning",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int newInvoiceNumber(){
        var tempInvNum = 0;
        
        for(InvoiceHeaderHandeller inv : frame.getInvoiceHeaderArray()){
            if(inv.getInvoiceNum() >= tempInvNum)
                tempInvNum = inv.getInvoiceNum();
        }
        return tempInvNum+1;
    }

    private void newLineOkay() {
        lineDialog.setVisible(false);
        
        var selectedInvHeader = frame.getInvoiceHeaderTbl().getSelectedRow();
        var itemName = lineDialog.getNameField().getText();
        var tempCount = lineDialog.getCountField().getText();
        var temprice = lineDialog.getPriceField().getText();
        var count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(tempCount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(temprice);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
                if (selectedInvHeader != -1) {
            InvoiceHeaderHandeller invHeader = frame.getInvoiceHeaderArray().get(selectedInvHeader);
            InvoiceLinesHandler line = new InvoiceLinesHandler(count, price, itemName, invHeader);
            frame.getInvoiceLinesArray().add(line);
            LinesTabelModel lineTableModel = (LinesTabelModel) frame.getInvoiceLineTbl().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getHeaderTablelModel().fireTableDataChanged();
        }
        frame.getInvoiceLineTbl().setRowSelectionInterval(selectedInvHeader, selectedInvHeader); 
       
        lineDialog.dispose();
        lineDialog = null; 
    }

    private void newLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;    
    }

    
    
}
