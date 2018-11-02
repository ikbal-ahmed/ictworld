package department.mangement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.text.Document;

public class PrintReceipt extends javax.swing.JFrame implements Printable {

    PreparedStatement ps;
    DerbyConnection connect = new DerbyConnection();
    ResultSet rs;
    String name, father, mobile, college, payment, received, due;
    int slip;

    public PrintReceipt() {
        initComponents();
        super.setSize(new Dimension(400, 300));
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTextPane1.setEditable(false);
        jTextPane1.setBackground(Color.lightGray);
        Insets inset = new Insets(10, 10, 10, 5);
        jTextPane1.setMargin(inset);
    }

    public void RetreiveInfo(String id, String amount, String d) {
        try {
            ps = connect.connection.prepareStatement("SELECT name, father, mobile, college, payment, received, due FROM student WHERE id = '" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                father = rs.getString("father");
                mobile = rs.getString("mobile");
                college = rs.getString("college");
                payment = rs.getString("payment");
                received = rs.getString("received");
                due = rs.getString("due");
            }

            String date2 = d;
            if (d == null) { // to reprint the receipt
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now2 = LocalDateTime.now();
                date2 = dtf2.format(now2);
            }
            ps = connect.connection.prepareStatement("SELECT slip FROM payment WHERE id = '" + id + "' AND date = '" + date2 + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                slip = rs.getInt("slip");
            }
            
            //to convert string to date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate date1 = LocalDate.parse(date2, formatter);

            //change date format to print
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            date2 = dtf3.format(date1);
            String query = "\n\nDate:   " + date2 + "\t   Slip No:     " + slip + " \n\nPrivate id:                  " + id + "\nName:                       " + name + "\nFather's Name:       " + father + "\nCollege Name:       " + college
                    + "\nMobile Number:      " + mobile + "\nCash Received:      " + amount + "\nTotal Course Fee:   " + payment + "\nTotal Received:       " + received + "\nDue:                          " + due + "\n\nFacebook Group- \n                 facebook.com/groups/ictworldikbalsir\nTo find tutors visit- www.tutorsbangladesh.com";

            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/2.jpg"));
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(280, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);
            jTextPane1.insertIcon(imageIcon);

            Document doc = jTextPane1.getDocument();
            doc.insertString(doc.getLength(), query, null);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void RetreiveInfo(String id, String d) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
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
                .addGap(119, 119, 119)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            PrinterJob pj = PrinterJob.getPrinterJob();
           
            PageFormat pf = pj.defaultPage();
            pf.setOrientation(PageFormat.PORTRAIT);
            Paper paper = new Paper();
            double margin = 2; // half inch
            paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
            pf.setPaper(paper);
            pj.setPrintable(this, pf);
            //  if (pj.printDialog()) {
            pj.print();
            //}  
            super.dispose();
        } catch (Exception ex) {
            Logger.getLogger(PrintReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        double width = 312;
        double height = 254;
        Paper custom = new Paper();
        custom.setSize(width, height);
        custom.setImageableArea(160, 0, width, height);
        pf.setPaper(custom);

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        jTextPane1.print(g);

        return PAGE_EXISTS;
    }

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
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrintReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
