package department.mangement;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Routine extends javax.swing.JFrame {

    Toolkit screen = Toolkit.getDefaultToolkit();
    Dimension d;
    int i = 0;
    ResultSet books;
    String column_name[] = {"Day", "Time", "Chapter"};
    public DefaultTableModel tablemodel = new DefaultTableModel(column_name, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public Routine() {
        initComponents();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setShowGrid(true);

        try {
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("SELECT day, time, chapter FROM routine");
            while (books.next()) {
                day = books.getString(1);
                time = books.getString(2);
                chapter = books.getString(3);
                tablemodel.addRow(new Object[]{day, time, chapter});
                i++;
                jTable1.setModel(tablemodel);
            }
            TableResize();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        jTable1.setRowHeight(50);
    }

    public void TableResize() {
        final TableColumnModel columnModel = jTable1.getColumnModel();
        for (int column = 0; column < jTable1.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                TableCellRenderer renderer = jTable1.getCellRenderer(row, column);
                Component comp = jTable1.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        deleteMenu = new javax.swing.JMenu();
        refreshMenu = new javax.swing.JMenu();

        jLabel9.setText("jLabel9");

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setGridColor(new java.awt.Color(0, 51, 255));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("           File ");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("           Edit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setText("          Add New Batch");
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
        });
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        deleteMenu.setText("          Delete");
        deleteMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(deleteMenu);

        refreshMenu.setText("      Refresh");
        refreshMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(refreshMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MenuSelected

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new RoutineAdd().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void deleteMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMenuMouseClicked
        String id4, name4, batch4;
        try {

            int row = jTable1.getSelectedRow();
            day = (String) jTable1.getModel().getValueAt(row, 0);
            time = (String) jTable1.getModel().getValueAt(row, 1);
            chapter = (String) jTable1.getModel().getValueAt(row, 2);
            String batch = day + "   " + time + "   " + chapter + "   ";

            books = connect.statement.executeQuery("SELECT id, name FROM student "
                    + "WHERE batch1 = '" + batch + "'" + "OR batch2 = '" + batch + "'");
                    //3 ta space dite hbe day time chapter er majhe

            while (books.next()) {
                id4 = books.getString(1);
                name4 = books.getString(2);


                String sql = "INSERT INTO batch VALUES(?,?,?)";
                PreparedStatement prstmnt = connect.connection.prepareStatement(sql); //add information to batch history
                prstmnt.setString(1, id4);
                prstmnt.setString(2, name4);
                prstmnt.setString(3, batch);
                prstmnt.executeUpdate();

                String sql2 = "UPDATE student SET batch1 = " + null + " WHERE batch1 = '" + batch + "'"; //clear batch1 from student
                PreparedStatement prstmnt1 = connect.connection.prepareStatement(sql2);
                prstmnt1.executeUpdate();

                String sql3 = "UPDATE student SET batch2 = " + null + " WHERE batch2 = '" + batch + "'"; //clear batch2 from student
                PreparedStatement prstmnt2 = connect.connection.prepareStatement(sql3);
                prstmnt2.executeUpdate();
            }

            PreparedStatement ps = connect.connection.prepareStatement("DELETE FROM routine WHERE day = '" + day + "' AND time = '" + time + "'");
            ps.executeUpdate();

            int input = JOptionPane.showOptionDialog(null, "Deleted Successfully!", "The title",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                tablemodel.setRowCount(0);
                connect.statement = connect.connection.createStatement();
                books = connect.statement.executeQuery("SELECT day, time, chapter FROM routine");
                while (books.next()) {
                    day = books.getString(1);
                    time = books.getString(2);
                    chapter = books.getString(3);
                    tablemodel.addRow(new Object[]{day, time, chapter});
                    i++;
                    jTable1.setModel(tablemodel);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Routine.this, "You must select a row. The error code is: " + ex);
        }

    }//GEN-LAST:event_deleteMenuMouseClicked

    private void refreshMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMenuMouseClicked
        try {
            tablemodel.setRowCount(0);
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("SELECT day, time, chapter FROM routine");
            while (books.next()) {
                day = books.getString(1);
                time = books.getString(2);
                chapter = books.getString(3);
                tablemodel.addRow(new Object[]{day, time, chapter});
                i++;
                jTable1.setModel(tablemodel);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Routine.this, "You must select a row. The error code is: " + ex);
        }
    }//GEN-LAST:event_refreshMenuMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        try {
            int row = jTable1.getSelectedRow();
            day = (String) jTable1.getModel().getValueAt(row, 0);
            time = (String) jTable1.getModel().getValueAt(row, 1);
            chapter = (String) jTable1.getModel().getValueAt(row, 2);

            RoutineEdit edit = new RoutineEdit();
            edit.setVisible(true);
            edit.EditInformation(day, time, chapter);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Routine.this, "You must select a row. The error code is: " + ex);
        }
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Routine().setVisible(true);
            }
        });
    }
    DerbyConnection connect = new DerbyConnection();
    String day, time, chapter;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu deleteMenu;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JMenu refreshMenu;
    // End of variables declaration//GEN-END:variables
}
