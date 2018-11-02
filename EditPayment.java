package department.mangement;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class EditPayment extends javax.swing.JFrame {

    String previous_id, previous_amount, previous_slip, previous_id2, id5;

    public EditPayment() {
        initComponents();
        jXDatePicker1.setFormats("dd-MMM-yyyy");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void EditInformation(String previous_id, String previous_amount, String previous_slip) {
        this.previous_id = previous_id;
        this.previous_amount = previous_amount;
        this.previous_slip = previous_slip;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        slipField = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        amountField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Payment"));
        jInternalFrame1.setVisible(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Private ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Slip NO:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Payment Date:");

        jButton1.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        slipField.setText(" ");
        slipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slipFieldActionPerformed(evt);
            }
        });

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Payment Amount:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slipField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {amountField, idField, jXDatePicker1, slipField});

        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slipField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amountField, idField, jXDatePicker1, slipField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrame1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrame1)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Date oDate = jXDatePicker1.getDate();
        DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = oDateFormat.format(oDate);

        String amount = amountField.getText();
        String slip = slipField.getText();
        String id2 = idField.getText();

        try {

            PreparedStatement ps = null;
            ps = connect.connection.prepareStatement("DELETE FROM payment WHERE id = '"
                    + previous_id + "' AND amount = '" + previous_amount + "' AND slip = '" + previous_slip + "'");
            ps.executeUpdate();

            String sql3 = "UPDATE student SET due = due + " + Integer.parseInt(previous_amount) + ", received = received - "
                    + Integer.parseInt(previous_amount) + " WHERE id = '" + previous_id + "'";
            prstmnt = connect.connection.prepareStatement(sql3);
            prstmnt.executeUpdate();

            String sql = "INSERT INTO payment VALUES(?,?,?,?)";
            prstmnt = connect.connection.prepareStatement(sql);

            prstmnt.setString(1, slip);
            prstmnt.setString(2, id2);
            prstmnt.setString(3, date);
            prstmnt.setString(4, amount);
            prstmnt.executeUpdate();
            prstmnt.close();

            String sql2 = "UPDATE student SET due = due - " + Integer.parseInt(amount) + ", received = received + "
                    + Integer.parseInt(amount) + " WHERE id = '" + id2 + "'";
            prstmnt = connect.connection.prepareStatement(sql2);
            prstmnt.executeUpdate();
            prstmnt.close();

            int input = JOptionPane.showOptionDialog(null, "Added Successfully!", "The title",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                super.dispose();
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        amountField.requestFocus();
    }//GEN-LAST:event_idFieldActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        slipField.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void slipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slipFieldActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_slipFieldActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPayment().setVisible(true);
            }
        });
    }
    DerbyConnection connect = new DerbyConnection();
    PreparedStatement prstmnt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField amountField;
    public javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    public javax.swing.JTextField slipField;
    // End of variables declaration//GEN-END:variables
}
