package department.mangement;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EditStudent extends javax.swing.JFrame {

    ImageIcon imageIcon;
    String id;
    ResultSet rs;
    Object college_list[] = {"NULL", "Comilla Victoria College", "Comilla Government College", "Comilla Womens College",
        "Ibn Taimiya College", "Comilla Govt. City College", "Shikkha Board Model COllege", "Comilla Model College",
        "Ispahani Public College", "SonarBangla College", "Comilla Residential College", "Ajit Guha Degree College", "Comilla Commerce College",
        "Lalmai Degree COllege"};

    public EditStudent() {
        initComponents();
        super.setTitle("Student");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jComboBox1.setModel(new DefaultComboBoxModel(department));
        collegeBox.setModel(new DefaultComboBoxModel(college_list));
 
    }

    public void EditInformation(String id, String name) {
        id2 = id;
        idLabel.setText(id);
        nameField.setText(name);
        try {
            ps = connect.connection.prepareStatement("SELECT * FROM student WHERE id = '" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                father = rs.getString("father");
                mobile = rs.getString("mobile");
                college = rs.getString("college");
                roll = rs.getString("roll");
                group = rs.getString("groupp");
                admission_date = rs.getDate("date");
                
                address = rs.getString("address");
                payment = Integer.parseInt(rs.getString("payment"));
                received = Integer.parseInt(rs.getString("received"));

                fatherField.setText(father);
                mobileFIeld.setText(mobile);
                collegeBox.setSelectedItem(college);
                rollField.setText(roll);
                jComboBox1.setSelectedItem(group);
                jXDatePicker1.setDate(admission_date);
                addressField.setText(address);
                paymentFIeld.setText(String.valueOf(payment));
                receivedField.setText(String.valueOf(received));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog2 = new javax.swing.JDialog();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fatherField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mobileFIeld = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rollField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        paymentFIeld = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        receivedField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        idLabel = new javax.swing.JTextField();
        collegeBox = new javax.swing.JComboBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Teacher"));
        jPanel1.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel2.setText("Name:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel4.setText("Group:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        fatherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel5.setText("College Name:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        mobileFIeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileFIeldActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel6.setText("Father's Name:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        jComboBox1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel7.setText("Total Payment:");

        jLabel9.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel9.setText("ID:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        rollField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel10.setText("Mobile Number:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel11.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel11.setText("College Roll::");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        paymentFIeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFIeldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel12.setText("BDT");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel13.setText("Admission Date: ");

        jLabel14.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel14.setText("Total Received:");

        receivedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel15.setText("BDT");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        idLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLabelActionPerformed(evt);
            }
        });

        collegeBox.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        collegeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(fatherField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(mobileFIeld, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(rollField, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 247, Short.MAX_VALUE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressField)
                    .addComponent(paymentFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receivedField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(collegeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(171, 171, 171))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addressField, collegeBox, fatherField, idLabel, jComboBox1, jXDatePicker1, mobileFIeld, nameField, paymentFIeld, rollField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fatherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(collegeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rollField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(paymentFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(receivedField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addressField, collegeBox, fatherField, idLabel, jComboBox1, jXDatePicker1, mobileFIeld, nameField, paymentFIeld, rollField});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        id = idLabel.getText();
        name = nameField.getText();
        father = fatherField.getText();
        mobile = mobileFIeld.getText();
        address = addressField.getText();
        roll = rollField.getText();
        address = addressField.getText();
        payment = Integer.parseInt(paymentFIeld.getText());
        received = Integer.parseInt(receivedField.getText());
        due = payment - received;

        try {
            String sql = "UPDATE student SET id = ?, name = ?, father = ?, mobile = ?, "
                    + "college = ?, roll = ?, groupp = ?, address = ?, payment = ?, received = ?, due = ?, date = ? WHERE id = ?";
            PreparedStatement prstmnt = connect.connection.prepareStatement(sql);
            prstmnt.setString(1, id);
            prstmnt.setString(2, name);
            prstmnt.setString(3, father);
            prstmnt.setString(4, mobile);
            prstmnt.setString(5, college);
            prstmnt.setString(6, roll);
            prstmnt.setString(7, group);
            prstmnt.setString(8, address);
            prstmnt.setInt(9, payment);
            prstmnt.setInt(10, received);
            prstmnt.setInt(11, due);
           // System.out.println(new java.sql.Date(admission_date.getTime()));

            if(admission_date == null){
                prstmnt.setDate(12, null);
            }
            else{
             prstmnt.setDate(12, new java.sql.Date(admission_date.getTime()));
            }
           
            prstmnt.setString(13, id2);

            prstmnt.executeUpdate();
            prstmnt.close();
            int input = JOptionPane.showOptionDialog(null, "Updated Successfully!", "The title",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                super.dispose();
            }

        } catch (SQLException | NumberFormatException | HeadlessException ex) {
            JOptionPane.showOptionDialog(null, "Fill the all information!", "The title",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        group = (String) jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        fatherField.requestFocusInWindow();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void fatherFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherFieldActionPerformed
        mobileFIeld.requestFocusInWindow();
    }//GEN-LAST:event_fatherFieldActionPerformed

    private void mobileFIeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileFIeldActionPerformed
        collegeBox.requestFocusInWindow();
    }//GEN-LAST:event_mobileFIeldActionPerformed

    private void idLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLabelActionPerformed
        nameField.requestFocusInWindow();
    }//GEN-LAST:event_idLabelActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        admission_date = jXDatePicker1.getDate();
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void rollFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollFieldActionPerformed
        jComboBox1.requestFocus();
    }//GEN-LAST:event_rollFieldActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        paymentFIeld.requestFocus();
    }//GEN-LAST:event_addressFieldActionPerformed

    private void receivedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receivedFieldActionPerformed

    private void paymentFIeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFIeldActionPerformed
        receivedField.requestFocus();
    }//GEN-LAST:event_paymentFIeldActionPerformed

    private void collegeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeBoxActionPerformed
        college = (String) collegeBox.getItemAt(collegeBox.getSelectedIndex());
    }//GEN-LAST:event_collegeBoxActionPerformed

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
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditStudent().setVisible(true);
            }
        });
    }

    DerbyConnection connect = new DerbyConnection();
    String name, mobile, father, address, college, roll, group, admission, id2;
    Object department[] = {"NULL", "Science", "Commerce/Business Studies", "Arts/Humanities"};
    DefaultComboBoxModel deptName;
    PreparedStatement ps;
    int available, len, copies, payment, received, due, save = 0;
    Date admission_date = new Date();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JComboBox collegeBox;
    private javax.swing.JTextField fatherField;
    private javax.swing.JTextField idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField mobileFIeld;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField paymentFIeld;
    private javax.swing.JTextField receivedField;
    private javax.swing.JTextField rollField;
    // End of variables declaration//GEN-END:variables
}
