
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cody
 */
public class Invoices extends javax.swing.JFrame {

    DBConnection dbc = null;
    boolean editMode = false;
    private MainWindow parentObject = null;
    public Invoices() {
        initComponents();
        dbc = new DBConnection();
        dbc.connect();
        updateFields();
        checkIfEditMode();
        if(editMode)
            updateFieldsEditMode();
        //this.getLocationCount();
    }
    
    public void updateFieldsEditMode()
    {
        String sql = "Select * FROM get_invoice_info_full(?)";
        double total = -1;
        int paymeth = -1;
        String desc = "";
        try (
            PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
            stmt.setString(1,Globals.invoiceid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
                paymeth = rs.getInt(2);
                desc = rs.getString(3);
            }
            jTextField3.setText(Globals.invoiceid);
            jTextField7.setText(""+total);
            jComboBox1.setSelectedIndex(paymeth-1);
            jTextArea1.setText(desc);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void checkIfEditMode()
    {
        if (!Globals.invoiceid.equals("-1"))
        {
            editMode = true;
            jTextField3.setEditable(false);
        }
    }
    
    boolean isDouble(String s)
    {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    public void setParentObject(MainWindow obj)
    {
        parentObject = obj;
    }
    
    public String getStatus(int id)
    {
        String sql = "select get_status(?)";
        String status = "";
        try (
        PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next())
            status = rs.getString(1);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public void changeStatus(int id, String newStatus)
    {
        String sql = "select set_status(?,?)";
        try (
        PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
        stmt.setInt(1, id);
        stmt.setString(2, newStatus);
        stmt.executeQuery();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateFields()
    {
        String sql = "Select * FROM get_invoice_info(?)";
        String customerName = "";
        String address = "";
        String city = "";
        String zipcode = "";
        String employeeName = "";
        String problem = "";
        String startTime = "";
        String endTime = "";
        try (
            PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
            stmt.setInt(1,Globals.ticketid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jTextField5.setText(rs.getString(1) + " " + rs.getString(2));
                jTextArea2.setText(rs.getString(3) + "\n" + rs.getString(4)
                        + "\n" + rs.getString(5));

                jTextField8.setText(rs.getString(6) + " " + rs.getString(7));
                jTextField12.setText(rs.getString(8));
                jTextField9.setText(rs.getString(9));
                jTextField10.setText(rs.getString(10));
            }
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Invoice Number: ");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Total: ");

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Payment Method:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Check", "Credit Card", "E-Check", "Charge" }));

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Customer Name:");

        jTextField5.setEditable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Job Location: ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Description: ");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Invoice");

        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Technician:");

        jTextField8.setEditable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Start Time:");

        jTextField9.setEditable(false);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("End Time:");

        jTextField10.setEditable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Problem:");

        jTextField12.setEditable(false);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(10);
        jTextArea2.setRows(4);
        jScrollPane1.setViewportView(jTextArea2);

        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(394, 394, 394)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, 137, Short.MAX_VALUE)
                                            .addComponent(jTextField8))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel20)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextField5.setText("" + Globals.ticketid);

        jMenu1.setText("File");

        jMenuItem2.setText("Generate PDF");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("About");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Invoices i = this;
        this.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //Globals.invoiceid = "-1";
        //validate
        if (jTextField3.getText().isEmpty() || jTextField7.getText().isEmpty()
                || !isDouble(jTextField7.getText()))
        {
            System.out.println("Invalid entry.");
            return;
        }
        //CREATE INVOICE
        String sql = "select * from addinvoice(?,?,?::numeric(10,2),?,?)";
        //System.out.println(jComboBox1.getSelectedIndex());
        try (
            PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
            stmt.setString(1, jTextField3.getText());
            stmt.setInt(2, Globals.ticketid);
            stmt.setDouble(3, Double.parseDouble(jTextField7.getText()));  
            stmt.setInt(4, jComboBox1.getSelectedIndex() + 1);
            stmt.setString(5, jTextArea1.getText());
            ResultSet rs = stmt.executeQuery();
            //if (rs.next())
                //System.out.println(rs.getInt(1));
        }
        catch (SQLException se){
            System.out.println(se.getMessage());
            return;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        changeStatus(Globals.ticketid, "Closed");
        parentObject.updateTickets();
        parentObject.updateInvoices();
        parentObject.updateRecentInvoices();

        this.setVisible(false);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //REPORT
        if (Globals.invoiceid.isEmpty())
            return;
        try {
            Document document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream("Report.pdf"));
            document.open();
            //Get invoice information
            String invoiceNumber = null;
            String date = null;
            String customerName = null;
            String address = null;
            String description = null;
            String jobAmount = null;
            String paymethod = null;
            String technicianName = null;
            String startTime = null;
            String endTime = null;
            double balance = 0;
            
            String sql = "select * from get_invoice_report(?)";
            try (
                PreparedStatement stmt = dbc.conn.prepareStatement(sql)){
                stmt.setString(1, Globals.invoiceid);
                ResultSet rs = stmt.executeQuery();
                if (rs.next())
                {
                    invoiceNumber = rs.getString(1);
                    customerName = rs.getString(2) + " " + rs.getString(3);
                    address = rs.getString(4) + "\n" + rs.getString(5) + ", " +
                            rs.getString(6) + " " + rs.getString(7);
                    description = rs.getString(8);
                    jobAmount = Double.toString(rs.getDouble(9));
                    paymethod = rs.getString(10);
                    technicianName = rs.getString(11) + " " + rs.getString(12);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy KK:mm a");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
                    startTime = sdf.format(rs.getTimestamp(13));
                    endTime = sdf.format(rs.getTimestamp(14));
                    date = sdf2.format(rs.getTimestamp(14));
                }
                
            
            }
            catch (SQLException se){
                System.out.println(se.getMessage());
                return;
            }
            
            //End
            Image robot = null;
            try {
                robot = Image.getInstance("robo.png");
                robot.scalePercent(50);
                
                
            } catch (BadElementException ex) {
                Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            Paragraph title = new Paragraph("Invoice", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, new BaseColor(69,130,168)));
            title.setAlignment(Element.ALIGN_RIGHT);
            Paragraph companyInfo = new Paragraph("Robo Plumbing\n" + "3535 Bowman Ct.\n" + "Bakersfield, CA 93308");

            
            PdfPTable  headerTable = new PdfPTable(3);
            PdfPCell image = new PdfPCell(robot);
            PdfPCell company = new PdfPCell(companyInfo);
            PdfPCell invoiceTitle = new PdfPCell(title);
            image.setBorder(Rectangle.NO_BORDER);
            company.setBorder(Rectangle.NO_BORDER);
            invoiceTitle.setBorder(Rectangle.NO_BORDER);
            image.setVerticalAlignment(Element.ALIGN_LEFT);
            company.setVerticalAlignment(Element.ALIGN_LEFT);
            invoiceTitle.setHorizontalAlignment(Element.ALIGN_RIGHT);
            headerTable.addCell(image);
            headerTable.addCell(company);
            headerTable.addCell(invoiceTitle);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[] {1,2,6});
            

            Paragraph paraBreak = new Paragraph("______________________________________________________________________________");
            paraBreak.setAlignment(Element.ALIGN_CENTER);
            
            PdfPTable invoiceDateTable = new PdfPTable(3);
            PdfPCell cName = new PdfPCell(new Paragraph(customerName));
            PdfPCell cAddr = new PdfPCell(new Paragraph(address));
            PdfPCell blank = new PdfPCell(new Paragraph(""));
            //cName.setBorder(Rectangle.NO_BORDER);
            //cAddr.setBorder(Rectangle.NO_BORDER);
            blank.setBorder(Rectangle.NO_BORDER);
            
            invoiceDateTable.addCell(cName);
            invoiceDateTable.addCell(blank);
            invoiceDateTable.addCell("Invoice#: " + invoiceNumber);
            invoiceDateTable.addCell(cAddr);
            invoiceDateTable.addCell(blank);
            invoiceDateTable.addCell("      Date: " + date);
            invoiceDateTable.setWidthPercentage(100);
            invoiceDateTable.setWidths(new float[] {1,2,1});

            
            
            PdfPTable descAmountTable = new PdfPTable(2);
            PdfPCell desc = new PdfPCell(new Paragraph("Description"));
            PdfPCell amount = new PdfPCell(new Paragraph("Amount"));
            PdfPCell descContent = new PdfPCell(new Paragraph(description));
            PdfPCell amountContent = new PdfPCell(new Paragraph(jobAmount));
            PdfPCell tech = new PdfPCell (new Paragraph("Technician: " + technicianName));
            PdfPCell start = new PdfPCell (new Paragraph("Start Time: " + startTime));
            PdfPCell end = new PdfPCell (new Paragraph("End Time: " + endTime));
            PdfPCell total;
            PdfPCell balanceCell;
            if (!paymethod.equals("Charge"))
            {
                total = new PdfPCell(new Paragraph("Paid with " + paymethod + ". Amount Owed "));
                balance = 0.00;
            }
            else
            {
                total = new PdfPCell(new Paragraph("Amount Owed "));
                balance = Double.parseDouble(jobAmount);
            }
            balanceCell = new PdfPCell(new Paragraph(Double.toString(balance)));
            
            
            amount.setHorizontalAlignment(Element.ALIGN_RIGHT);
            amountContent.setHorizontalAlignment(Element.ALIGN_RIGHT);
            total.setHorizontalAlignment(Element.ALIGN_RIGHT);
            balanceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            descContent.setMinimumHeight(300);
            amountContent.setMinimumHeight(300);
            
            descAmountTable.addCell(desc);
            descAmountTable.addCell(amount);
            descAmountTable.addCell(descContent);
            descAmountTable.addCell(amountContent);
            descAmountTable.addCell(total);
            
            descAmountTable.addCell(balanceCell);
            descAmountTable.setWidthPercentage(100);
            descAmountTable.setWidths(new float[] {3,1});

            
            

            document.add(headerTable);
            document.add(new Paragraph("\nCustomer"));
            document.add(invoiceDateTable);
            //document.add(paraBreak);
            document.add(new Paragraph("\n"));
            document.add(descAmountTable);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Technician: " + technicianName));
            document.add(new Paragraph("Start Time: " + startTime));
            document.add(new Paragraph("End Time: " + endTime));

            
            
            
            JOptionPane.showMessageDialog(null,"Report.pdf Created");
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
