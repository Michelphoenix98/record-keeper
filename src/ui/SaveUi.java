/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Services.Data.IO.Text.Saver;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Michel Thomas
 */
public class SaveUi extends javax.swing.JFrame {

    /**
     * Creates new form SaveUi
     */
    int x,y;
    
    public SaveUi() {
        initComponents();
         Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
       int w=this.getSize().width;
       int h=this.getSize().height;
       
        x=(dim.width-w)/2;
        y=(dim.height-h)/2;
       
       this.setLocation(x,y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save Record");
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/save.png"))); // NOI18N
        jLabel1.setText("Do you want to save this record before closing it?");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton1.setText("Yes ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      ui.RecordPanel rec=(ui.RecordPanel) (obj1.jTabbedPane1.getComponentAt(obj1.jTabbedPane1.getSelectedIndex()));
    if(rec.Edit==true){
        try {
            obj1.DBManager.setSerialNumber(rec.tabNo, rec.tabNo);
            obj1.DBManager.setName(rec.nameVar.getText(), rec.tabNo);
            obj1.DBManager.setDOB(rec.dob.getText(), rec.tabNo);
            obj1.DBManager.setGender(rec.getGender(), rec.tabNo);
            obj1.DBManager.setMarital_Status(rec.getMarStat(), rec.tabNo);
            obj1.DBManager.setAadhar_ID(rec.aID.getText(), rec.tabNo);
            obj1.DBManager.setEmail_ID(rec.eID.getText(), rec.tabNo);
            obj1.DBManager.setNationality(rec.nationality.getText(), rec.tabNo);
            obj1.DBManager.setAddress(rec.address.getText(), rec.tabNo);
           obj1. DBManager.setPhNo(rec.phNo.getText(), rec.tabNo);
            obj1.DBManager.setMbno(rec.MbNo.getText(), rec.tabNo);
            obj1.DBManager.setSBJ(rec.subject.getText(), rec.tabNo);
            obj1.DBManager.setPID(rec.PID.getText(), rec.tabNo);
            obj1.DBManager.setCG(rec.CG.getText(), rec.tabNo);
           obj1. DBManager.update();
            javax.swing.JOptionPane.showMessageDialog(this,"Save operation successful","Save data",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
             javax.swing.JOptionPane.showMessageDialog(this,"Save operation failed","Save data",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    //code to be completed
    
    }
    else{
        try {
            System.out.println(rec.tabNo);
            
            //obj1.DBManager.createNewRow();
             rec.Edit=true;
            obj1.DBManager.createNewRow();
            rec.tabNo=(int) obj1.DBManager.getCurrentRow();
             obj1.DBManager.setSerialNumber(rec.tabNo, rec.tabNo);
            obj1.DBManager.setName(rec.nameVar.getText(), rec.tabNo);
            obj1.DBManager.setDOB(rec.dob.getText(), rec.tabNo);
           obj1. DBManager.setGender(rec.getGender(), rec.tabNo);
            obj1.DBManager.setMarital_Status(rec.getMarStat(), rec.tabNo);
            obj1.DBManager.setAadhar_ID(rec.aID.getText(), rec.tabNo);
            obj1.DBManager.setEmail_ID(rec.eID.getText(), rec.tabNo);
            obj1.DBManager.setNationality(rec.nationality.getText(), rec.tabNo);
            obj1.DBManager.setAddress(rec.address.getText(), rec.tabNo);
            obj1.DBManager.setPhNo(rec.phNo.getText(), rec.tabNo);
            obj1.DBManager.setMbno(rec.MbNo.getText(), rec.tabNo);
            obj1.DBManager.setSBJ(rec.subject.getText(), rec.tabNo);
            obj1.DBManager.setPID(rec.PID.getText(), rec.tabNo);
            obj1.DBManager.setCG(rec.CG.getText(), rec.tabNo);
            obj1.DBManager.save();
             javax.swing.JOptionPane.showMessageDialog(this,"Save operation successful","Save data",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(obj1, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    obj1.recnum=(int )obj1.DBManager.getNumberOfRecords();
        try {
            obj1.arrangeList();
        } catch (SQLException ex) {
            Logger.getLogger(SaveUi.class.getName()).log(Level.SEVERE, null, ex);
        }
    this.dispose();
    obj1.removeTab1(Selected);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
      obj1.removeTab1(Selected);
    }//GEN-LAST:event_jButton2ActionPerformed
 static int Selected;
 static Main obj1;
    /**
     * @param args the command line arguments
     */
    public static void main(int selected,Main obj) {
        
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
            java.util.logging.Logger.getLogger(SaveUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaveUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaveUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaveUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaveUi().setVisible(true);
            }
        });
        Selected=selected;
    obj1=obj;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
