/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedb;

/**
 *
 * @author skylar
 */
import java.sql.*;
import javax.swing.*;
public class EmployeeUpdate extends javax.swing.JDialog {
    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    /**
     * Creates new form EmployeeUpdate
     */
    public EmployeeUpdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try
        {
            con=clsDBConnection.getConnection();
            getEmployeeID();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void getEmployeeID()
    {
        try
        {
            ste=con.createStatement();
            cboEmployeeID.removeAllItems();
            cboEmployeeID.addItem("-----------Select-----------");
            rs=ste.executeQuery("Select EmployeeID From Employee Order By EmployeeID");
            while(rs.next())
            {
                cboEmployeeID.addItem(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    public void fillRecord()
    { 
        try
        { 
            ste=con.createStatement();
            rs=ste.executeQuery("SELECT * FROM Employee WHERE EmployeeID="+cboEmployeeID.getSelectedItem().toString().trim());
            if(rs.next())
            { 
                lblName.setText(rs.getString(2));
                lblNRC.setText(rs.getString(3));
                lblGender.setText(rs.getString(4));
                txtAddress.setText(rs.getString(5));
                cboDepartment.setSelectedItem(rs.getObject(6));
                cboPost.setSelectedItem(rs.getObject(7));
                txtQualification.setText(rs.getString(8));
                txtAddress.requestFocus(); 
            }
        }
        catch(SQLException e)
        { 
            System.out.println(e); 
        }
    }
    
    public void checkData()
    {
        if(cboEmployeeID.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(this,"You must choose Employee ID!");
            cboEmployeeID.requestFocus();
        }
        else if(txtAddress.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"You must enter Address!");
            txtAddress.requestFocus();
        }
        if(cboDepartment.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this,"You must choose Department!");
            cboDepartment.requestFocus();
        }
        if(cboPost.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this,"You must choose Post!");
            cboPost.requestFocus();
        }
        else if(txtQualification.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"You must enter Qualification!");
            txtQualification.requestFocus();
        }
        else
        {
            updateRecord();
        }
    }
    
    public void updateRecord()
    {
        try
        {
            if(cboEmployeeID.getSelectedIndex()>0)
            {
                ste=con.createStatement();
                String sql="Update Employee Set Address='"+txtAddress.getText().trim()+"',Department='"+cboDepartment.getSelectedItem().toString().trim()+"',Post='"+cboPost.getSelectedItem().toString().trim()+"',Qualification='"+txtAddress.getText().trim()+"' Where EmployeeID="+cboEmployeeID.getSelectedItem().toString().trim()+"";
                int result=ste.executeUpdate(sql);
                if(result==1)
                {
                    JOptionPane.showMessageDialog(this,"This record is successfully updated!");
                    clearData();
                }
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
            JOptionPane.showMessageDialog(this,"This record can't update.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void deleteRecord()
    { 
        try
        { 
            if(cboEmployeeID.getSelectedIndex()>0)
            { 
                ste=con.createStatement();            
                String sql="DELETE * FROM Employee WHERE EmployeeID="+cboEmployeeID.getSelectedItem().toString().trim();
                int result=ste.executeUpdate(sql);
                if(result==1)
                { 
                    JOptionPane.showMessageDialog(this,"This record is successfully deleted!");
                    clearData();
                    getEmployeeID(); 
                }
            } 
        }
        catch(SQLException sqle)
        { 
            System.out.println (sqle);        
            JOptionPane.showMessageDialog(this,"This record is can't delete.");
        }
        catch(Exception exp)
        { System.out.println (exp); 
        }
    }
    public void clearData()
    { 
        cboEmployeeID.setSelectedIndex(0);
        lblName.setText("");
        lblNRC.setText("");
        lblGender.setText("");
        txtAddress.setText("");
        txtQualification.setText("");
        cboDepartment.setSelectedIndex(0);
        cboPost.setSelectedIndex(0);
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
        jPanel2 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblNRC = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtQualification = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        cboDepartment = new javax.swing.JComboBox();
        cboPost = new javax.swing.JComboBox();
        cboEmployeeID = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:Employee Update:.");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Employee Information"));

        jPanel2.setBackground(java.awt.Color.black);

        btnDelete.setMnemonic('D');
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdate.setMnemonic('U');
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setMnemonic('L');
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel)
                    .addComponent(btnClose))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        lblNRC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("NRC No:");

        jLabel5.setText("Employee Name:");

        jLabel6.setText("Employee ID:");

        jLabel7.setText("Address:");

        jLabel8.setText("Gender:");

        jLabel9.setText("Qualification:");

        jLabel10.setText("Post:");

        jLabel11.setText("Department:");

        cboDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------Select-------------", "NCC", "SE", "NE", "Training" }));
        cboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDepartmentActionPerformed(evt);
            }
        });

        cboPost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------Select-------------" }));

        cboEmployeeID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------Select-------------" }));
        cboEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmployeeIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEmployeeID, 0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(cboEmployeeID.getSelectedIndex()>0)
            checkData();
        else
            JOptionPane.showMessageDialog(this,"Please choose EmployeeID for update!");    // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmployeeIDActionPerformed
        if(cboEmployeeID.getSelectedIndex()>0)
        {
            fillRecord();
        }// TODO add your handling code here:
    }//GEN-LAST:event_cboEmployeeIDActionPerformed

    private void cboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDepartmentActionPerformed
        if(cboDepartment.getSelectedIndex()==1||cboDepartment.getSelectedIndex()==2||cboDepartment.getSelectedIndex()==3) 
        { 
            cboPost.removeAllItems();        
            cboPost.addItem("-------Select-------");
            cboPost.addItem("Instructor");
            cboPost.addItem("Demonstrator");
            cboPost.addItem("Senior Instructor");
            cboPost.addItem("Incharge");
            cboPost.addItem("Lecturer");
            cboPost.addItem("Senior Lecturer");
            cboPost.addItem("Asst: Training Manager");
            cboPost.addItem("Training Manager");
            return;
        }
        if(cboDepartment.getSelectedIndex()==4) 
        { 
            cboPost.removeAllItems();
            cboPost.addItem("-------Select-------");
            cboPost.addItem("Instructor");
            cboPost.addItem("Senior Instructor");
            cboPost.addItem("Incharge");
            cboPost.addItem("Lecturer");
            cboPost.addItem("Senior Lecturer");
            cboPost.addItem("Asst: Training Manager");
            cboPost.addItem("Training Manager");
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDepartmentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(cboEmployeeID.getSelectedIndex()>0)
        { 
            if(JOptionPane.showConfirmDialog(this,"Do you really want to delete selected record.","Delete Confirm", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
            deleteRecord();
        }
        else
        { 
            JOptionPane.showMessageDialog(this,"Please choose EmployeeID for delete!");       
            cboEmployeeID.requestFocus();// TODO add your handling code here:
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearData();// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeUpdate dialog = new EmployeeUpdate(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboDepartment;
    private javax.swing.JComboBox cboEmployeeID;
    private javax.swing.JComboBox cboPost;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblNRC;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtQualification;
    // End of variables declaration//GEN-END:variables
}
