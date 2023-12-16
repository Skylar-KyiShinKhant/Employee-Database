/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedb;

/**
 *
 * @author steve
 */
public class MainMenu extends javax.swing.JFrame {

    
    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuEntry = new javax.swing.JMenuItem();
        mnuUpdate = new javax.swing.JMenuItem();
        mnuSearching = new javax.swing.JMenuItem();
        numListing = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuFile.setMnemonic('F');
        mnuFile.setText("File");

        mnuEntry.setMnemonic('E');
        mnuEntry.setText("Employee Entry");
        mnuEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEntryActionPerformed(evt);
            }
        });
        mnuFile.add(mnuEntry);

        mnuUpdate.setMnemonic('U');
        mnuUpdate.setText("Employee Update");
        mnuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUpdateActionPerformed(evt);
            }
        });
        mnuFile.add(mnuUpdate);

        mnuSearching.setMnemonic('S');
        mnuSearching.setText("Employee Searching");
        mnuSearching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSearchingActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSearching);

        numListing.setMnemonic('L');
        numListing.setText("Employee Listing");
        numListing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numListingActionPerformed(evt);
            }
        });
        mnuFile.add(numListing);
        mnuFile.add(jSeparator1);

        mnuExit.setMnemonic('X');
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEntryActionPerformed
        EmployeeEntry e=new EmployeeEntry(this,true);
        e.show();
    }//GEN-LAST:event_mnuEntryActionPerformed

    private void mnuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUpdateActionPerformed
        EmployeeUpdate e=new EmployeeUpdate(this,true);
        e.show();
    }//GEN-LAST:event_mnuUpdateActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        if(javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?","Exit Program",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE)==javax.swing.JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void numListingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numListingActionPerformed
        EmployeeListing e=new EmployeeListing(this,true);
        e.show();
    }//GEN-LAST:event_numListingActionPerformed

    private void mnuSearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSearchingActionPerformed
        EmployeeSearching e=new EmployeeSearching(this,true);
        e.show();
    }//GEN-LAST:event_mnuSearchingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuEntry;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuSearching;
    private javax.swing.JMenuItem mnuUpdate;
    private javax.swing.JMenuItem numListing;
    // End of variables declaration//GEN-END:variables
}
