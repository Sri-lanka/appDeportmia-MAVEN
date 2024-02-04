package com.mycompany.appdeporttests;


import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author SENA
 */
public class Sportsman extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    String[] dataSportsMen = new String[4];
    Conection conect = new Conection();
    Date today = new Date();
    ArrayList<Object> listObjDep = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    public int indexSportComboBox;
    public int gender;
    public Date date;
    public String formattedDate;
    public int row;

    /**
     * Creates new form Interfaz
     */
    public Sportsman() {
        initComponents();
        this.conect.connect();
        this.jDbirth.setDate(today);

        this.model.addColumn("CODE");
        this.model.addColumn("IDENTIFICATION");
        this.model.addColumn("NAMES");
        this.model.addColumn("SPORT");
        this.jtableHistory.setModel(model);

        this.loadTable();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.listObjDep = this.listSportObjects();

        Iterator iterator = this.listObjDep.iterator();

        while (iterator.hasNext()) {

            Sport objSportComboBox = (Sport) iterator.next();
            this.jComboSports.addItem("" + objSportComboBox.getName());
        }
    }

    public void loadTable() {

        for (int i = 0; i < this.jtableHistory.getRowCount(); i++) {
            this.model.removeRow(i);
            i--;
        }

        try {
            PreparedStatement query = this.conect.con.prepareStatement("SELECT sportman_code, identification, full_names, sport_code FROM sportsman");
            ResultSet result = query.executeQuery();

            while (result.next()) {
                this.dataSportsMen[0] = result.getString(1);
                this.dataSportsMen[1] = result.getString(2);
                this.dataSportsMen[2] = result.getString(3);
                this.dataSportsMen[3] = result.getString(4);

                this.model.addRow(this.dataSportsMen);
                this.jtableHistory.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sportsman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Object> listSportObjects() {
        ArrayList<Object> sportsList = new ArrayList<>();

        Sport objSport = null;

        try {
            PreparedStatement query = this.conect.con.prepareStatement("SELECT * FROM sport;");
            ResultSet result = query.executeQuery();

            // Extract sports
            while (result.next()) {
                objSport = new Sport();
                objSport.setSportCode(result.getInt("sport_code"));
                objSport.setName(result.getString("name_sport"));
                sportsList.add(objSport);
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            Logger.getLogger(Sportsman.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sportsList;
    }

    public void captureData() {
        this.indexSportComboBox = this.jComboSports.getSelectedIndex() + 1;

        gender = 3;

        if (this.jRadioFemale.isSelected()) {
            gender = 1;
        } else if (this.jRadioMale.isSelected()) {
            gender = 2;
        }

        this.date = this.jDbirth.getDate();
        this.formattedDate = this.dateFormat.format(date);
    }

    public boolean validateData() {

        if (this.txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter the Sportman's Code");
            this.txtCode.requestFocus();
            return false;
        } else if (this.txtIdentification.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter the Athlete's Identification");
            this.txtIdentification.requestFocus();
            return false;
        } else if (this.txtNames.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter the Athlete's Full Name");
            this.txtNames.requestFocus();
            return false;
        } else if (this.txtPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter the Athlete's Phone Number");
            this.txtPhone.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void clearFields() {

        this.txtCode.setText("");
        this.txtIdentification.setText("");
        this.txtNames.setText("");
        this.txtAddress.setText("");
        this.txtPhone.setText("");
        this.jComboSports.setSelectedIndex(0);
        this.jRadioFemale.isSelected();
        this.jDbirth.setDate(today);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btModify = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        txtIdentification = new javax.swing.JTextField();
        txtNames = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jRadioFemale = new javax.swing.JRadioButton();
        jRadioMale = new javax.swing.JRadioButton();
        jRadioOther = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableHistory = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboSports = new javax.swing.JComboBox<>();
        jDbirth = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Sports management");

        btAdd.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btModify.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btModify.setText("modify");
        btModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifyActionPerformed(evt);
            }
        });

        btDelete.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btDelete.setText("delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioFemale);
        jRadioFemale.setText("F");
        jRadioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFemaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioMale);
        jRadioMale.setText("M");

        buttonGroup1.add(jRadioOther);
        jRadioOther.setText("O");

        jLabel8.setText("Gender");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jtableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableHistory);

        jLabel9.setText("Date of birth :");

        jLabel10.setText("Code");

        jLabel11.setText("Identification");

        jLabel12.setText("Name");

        jLabel13.setText("Address");

        jLabel14.setText("Phone");

        jLabel15.setText("Sports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jDbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(42, 42, 42)
                                .addComponent(jRadioFemale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioOther))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNames)
                                    .addComponent(txtIdentification)
                                    .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jComboSports, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioFemale)
                            .addComponent(jRadioMale)
                            .addComponent(jRadioOther)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDbirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioFemaleActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        this.captureData();

        if (this.validateData()) {
            try {
                PreparedStatement query = this.conect.con.prepareStatement("INSERT INTO sportsman VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                query.setString(1, this.txtCode.getText());
                query.setString(2, this.txtIdentification.getText());
                query.setString(3, this.txtNames.getText());
                query.setString(4, this.txtAddress.getText());
                query.setString(5, this.txtPhone.getText());
                query.setString(6, "" + this.indexSportComboBox);
                query.setString(7, "" + this.gender);
                query.setString(8, this.formattedDate);
                query.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data stored successfully!");
                this.loadTable();
                this.clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(Sportsman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.clearFields();
        this.loadTable();
    }//GEN-LAST:event_btAddActionPerformed

    private void btModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifyActionPerformed

        this.row = this.jtableHistory.getSelectedRow();

        this.captureData();

        if (row >= 0) {
            if (this.validateData()) {
                try {
                    PreparedStatement query = this.conect.con.prepareStatement("UPDATE sportsman SET identification = ?, full_names = ?, address = ?, phone_number = ?, sport_code = ?, gender = ?, birth_date = ? WHERE sportman_code = ?");
                    query.setString(1, this.txtIdentification.getText());
                    query.setString(2, this.txtNames.getText());
                    query.setString(3, this.txtAddress.getText());
                    query.setString(4, this.txtPhone.getText());
                    query.setString(5, "" + this.indexSportComboBox);
                    query.setString(6, "" + this.gender);
                    query.setString(7, this.formattedDate);
                    query.setString(8, this.txtCode.getText());
                    query.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data modified successfully!");

                    this.loadTable();
                    this.clearFields();
                } catch (SQLException ex) {
                    Logger.getLogger(Sportsman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must select a record from the table");
        }

    }//GEN-LAST:event_btModifyActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        this.row = this.jtableHistory.getSelectedRow();

        if (row >= 0) {
            try {
                String code = "" + this.jtableHistory.getValueAt(row, 0);
                this.txtCode.setText(code);
                PreparedStatement query = this.conect.con.prepareStatement("DELETE FROM sportsman WHERE sportman_code = ?");
                query.setString(1, this.txtCode.getText());
                query.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data deleted successfully!");

                this.loadTable();
                this.clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(Sportsman.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You must select a record from the table");
        }
    }//GEN-LAST:event_btDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Sportsman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sportsman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sportsman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sportsman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sportsman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btModify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> jComboSports;
    private com.toedter.calendar.JDateChooser jDbirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioFemale;
    private javax.swing.JRadioButton jRadioMale;
    private javax.swing.JRadioButton jRadioOther;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableHistory;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtIdentification;
    private javax.swing.JTextField txtNames;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
