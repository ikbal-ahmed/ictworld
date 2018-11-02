package department.mangement;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BookManagement extends javax.swing.JFrame {

    Toolkit screen = Toolkit.getDefaultToolkit();
    Dimension d;
    DerbyConnection connect = new DerbyConnection();
    int i = 0;
    String selected_id, column_name[] = {"Student ID", "Student Name", "College Name", "Mobile Number", "Total Payment",
        "Total Received", "Due"};
    String column_name2[] = {"Date", "Slip NO", "Amount"};
    String column_name3[] = {"Batch/Chapter Schedule"};
    String column_name4[] = {"Student ID", "Student Name", "Slip No", "Amount"};
    String column_name5[] = {"Student ID", "Student Name", "Slip No", "Amount", "Payment Date"};
    ResultSet books, batch1, batch2, rs;
    PreparedStatement ps, prstmnt;
    DefaultComboBoxModel<Object> batch = new DefaultComboBoxModel<>();

    DefaultTableModel tablemodel = new DefaultTableModel(column_name, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel1 = new DefaultTableModel(column_name, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel2 = new DefaultTableModel(column_name2, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel3 = new DefaultTableModel(column_name3, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel4 = new DefaultTableModel(column_name4, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel5 = new DefaultTableModel(column_name5, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public BookManagement() {

        initComponents();

        // ImageIcon icon = new ImageIcon(getClass().getResource("/coulibrary/project/images/main_icon.png"));
        // Image img = icon.getImage();
        // super.setIconImage(img);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setShowGrid(true);
        jTable1.setRowHeight(35);

        jMenu1.setBorderPainted(true);
        jMenu3.setBorderPainted(true);
        jMenu4.setBorderPainted(true);
        jMenu5.setBorderPainted(true);
        MessageMenu.setBorderPainted(true);
        jMenu7.setBorderPainted(true);
        aboutUsMenu.setBorderPainted(true);

        try {
            prstmnt = connect.connection.prepareStatement("SELECT day, time, chapter FROM routine ORDER BY day ASC");
            rs = prstmnt.executeQuery();
            batch.addElement("All Students");
            while (rs.next()) {
                batch.addElement(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
            }
            batchComboBox1.setModel(batch);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(BookManagement.this, "Communications link failure! Check your database connecttion.");
        }

        try {
            super.setTitle("ICT World Control Panel");
            d = screen.getScreenSize();

            super.setSize(d);
            bookList();

            jTable1.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent me) {
                    JTable table = (JTable) me.getSource();
                    if (me.getClickCount() == 1) {
                        Point p = me.getPoint();
                        int row = table.rowAtPoint(p);
                        selected_id = (String) jTable1.getModel().getValueAt(row, 0);
                    }

                    if (me.getClickCount() == 2) {
                        Point p = me.getPoint();
                        int row = table.rowAtPoint(p);
                        selected_id = (String) jTable1.getModel().getValueAt(row, 0);
                        add.setVisible(rootPaneCheckingEnabled);

                        try {
                            ps = connect.connection.prepareStatement("SELECT id, name, father, mobile, college, roll, groupp, address, payment, due, date, batch1, batch2 FROM student where id= '" + selected_id + "'");
                            rs = ps.executeQuery();

                            while (rs.next()) {
                                add.idLabel.setText(rs.getString(1));
                                add.nameLabel.setText(rs.getString(2));
                                add.fatherLabel.setText(rs.getString(3));
                                add.mobileLabel.setText(rs.getString(4));
                                add.collegeLabel.setText(rs.getString(5));
                                add.rollLabel.setText(rs.getString(6));
                                add.groupLabel.setText(rs.getString(7));
                                add.addressLabel.setText(rs.getString(8));
                                add.paymentLabel.setText(rs.getString(9));
                                add.dueLabel.setText(rs.getString(10));
                                add.dateLabel.setText(rs.getString(11));
                                add.batch1Label.setText(rs.getString(12));
                                add.batch2Label.setText(rs.getString(13));
                            }

                            ps = connect.connection.prepareStatement("SELECT date, slip, amount FROM payment where id= '" + selected_id + "'");
                            books = ps.executeQuery();

                            tablemodel2.setRowCount(0);
                            while (books.next()) {
                                tablemodel2.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3)});
                                i++;
                                add.jTable1.setModel(tablemodel2);
                            }

                            ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + selected_id + "'");
                            books = ps.executeQuery();

                            tablemodel3.setRowCount(0);
                            while (books.next()) {
                                tablemodel3.addRow(new Object[]{books.getString(1)});
                                i++;
                                add.batchTable.setModel(tablemodel3);
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(BookManagement.this, "Communications link failure! Check your database connecttion.");
                        }
                    }
                }
            });

        } catch (HeadlessException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(BookManagement.this, "Communications link failure! Check your database connecttion.");
        }

        batchComboBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();
                    tablemodel1.setRowCount(0);
                    try {
                        connect.statement = connect.connection.createStatement();

                        if (item.equals("All Students")) {
                            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student");

                            while (books.next()) {
                                tablemodel1.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3),
                                    books.getString(4), books.getString(5), books.getString(6), books.getInt(7)});
                                i++;
                                jTable1.setModel(tablemodel1);
                            }
                        } else {
                            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student WHERE batch1 = '" + item + "' OR batch2 = '" + item + "'");

                            while (books.next()) {
                                tablemodel1.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3),
                                    books.getString(4), books.getString(5), books.getString(6), books.getInt(7)});
                                i++;
                                jTable1.setModel(tablemodel1);
                            }
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex);

                    }
                }
            }
        });

    }

    public void bookList() {
        Statement stmt4;

        tablemodel.setRowCount(0);
        jTable1.setModel(tablemodel);
        try {
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student ORDER BY date DESC");
            while (books.next()) {
                id = books.getString(1);
                name = books.getString(2);
                college = books.getString(3);
                mobile = books.getString(4);
                payment = books.getString(5);
                received = books.getInt(6);
                due = books.getInt(7);
                tablemodel.addRow(new Object[]{id, name, college, mobile, payment, received, due});
                i++;
            }

            stmt4 = connect.connection.createStatement();
            rs2 = stmt4.executeQuery("SELECT  COUNT(id) FROM student");
            while (rs2.next()) {
                total_student = rs2.getString(1);
                total_level.setText("Total student = " + total_student);
            }
            TableResize();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
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

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        employeeButton = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jButton9 = new javax.swing.JButton();
        DateTo = new org.jdesktop.swingx.JXDatePicker();
        DateFrom = new org.jdesktop.swingx.JXDatePicker();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        batchComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        total_level = new javax.swing.JLabel();
        MessageButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        MessageMenu = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        aboutUsMenu = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(102, 102, 102));
        jInternalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "          Student Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jInternalFrame1.setForeground(new java.awt.Color(153, 153, 153));
        jInternalFrame1.setVisible(true);

        jButton3.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/Teacher-Icon.png"))); // NOI18N
        jButton3.setText("Teachers");
        jButton3.setAlignmentY(0.0F);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setIconTextGap(20);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        jButton4.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/student.png"))); // NOI18N
        jButton4.setText("Students");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        employeeButton.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        employeeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/exam_result-512.png"))); // NOI18N
        employeeButton.setText("Result");
        employeeButton.setAlignmentY(0.0F);
        employeeButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        employeeButton.setIconTextGap(15);
        employeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {employeeButton, jButton3, jButton4});

        jInternalFrame2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "         Admin Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jInternalFrame2.setVisible(true);

        jButton9.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/calendar.png"))); // NOI18N
        jButton9.setText("Routine");
        jButton9.setIconTextGap(15);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        DateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateToActionPerformed(evt);
            }
        });

        DateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateFromActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DateTo, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DateFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jInternalFrame2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DateFrom, DateTo});

        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jInternalFrame2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DateFrom, DateTo});

        addButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/plus.png"))); // NOI18N
        addButton.setText("Add Student");
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/pencil.png"))); // NOI18N
        editButton.setText("Edit");
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        viewButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/Sign-Info-icon.png"))); // NOI18N
        viewButton.setText("ALL Information");
        viewButton.setFocusable(false);
        viewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        paymentButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        paymentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/payment.png"))); // NOI18N
        paymentButton.setText("Add Payment");
        paymentButton.setFocusable(false);
        paymentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        paymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentButtonActionPerformed(evt);
            }
        });

        jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jXSearchField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXSearchField1ActionPerformed(evt);
            }
        });

        batchComboBox1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        batchComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Batch:");

        deleteButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coulibrary/project/images/Delete.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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
        jTable1.setGridColor(new java.awt.Color(0, 51, 250));
        jScrollPane1.setViewportView(jTable1);

        total_level.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        MessageButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        MessageButton.setText("Send Message");
        MessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageButtonActionPerformed(evt);
            }
        });

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setAlignmentX(1.5F);
        jMenuBar1.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(400, 40));

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setMnemonic('b');
        jMenu3.setText("          File          ");
        jMenu3.setAlignmentX(2.0F);
        jMenu3.setFocusPainted(true);
        jMenu3.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jMenu3.setIconTextGap(10);
        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setMnemonic('s');
        jMenu4.setText("          Students          ");
        jMenu4.setAlignmentX(2.0F);
        jMenu4.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jMenu4.setIconTextGap(15);
        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setMnemonic('w');
        jMenu5.setText("          Add Excel File           ");
        jMenu5.setAlignmentX(2.0F);
        jMenu5.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jMenu5.setIconTextGap(15);
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        MessageMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MessageMenu.setMnemonic('a');
        MessageMenu.setText("Send Message");
        MessageMenu.setToolTipText("");
        MessageMenu.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        MessageMenu.setIconTextGap(15);
        MessageMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessageMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(MessageMenu);

        jMenu7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu7.setMnemonic('h');
        jMenu7.setText("          Sign In         ");
        jMenu7.setToolTipText("");
        jMenu7.setAlignmentX(2.0F);
        jMenu7.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jMenu7.setIconTextGap(15);
        jMenuBar1.add(jMenu7);

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setMnemonic('a');
        jMenu1.setText("          Admin          ");
        jMenu1.setToolTipText("");
        jMenu1.setAlignmentX(2.0F);
        jMenu1.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jMenu1.setIconTextGap(15);
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.add(jSeparator2);
        jMenu1.add(jSeparator3);

        jMenuBar1.add(jMenu1);

        aboutUsMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aboutUsMenu.setText("          About Us          ");
        aboutUsMenu.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        aboutUsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUsMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(aboutUsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(batchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MessageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_level, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jXSearchField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, deleteButton, editButton, paymentButton, viewButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_level, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MessageButton)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(batchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, deleteButton, editButton, paymentButton, viewButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {MessageButton, batchComboBox1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeButtonActionPerformed

    }//GEN-LAST:event_employeeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        new AddStudent().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        try {
            int row = jTable1.getSelectedRow();
            id = (String) jTable1.getModel().getValueAt(row, 0);
            name = (String) jTable1.getModel().getValueAt(row, 1);
            college = (String) jTable1.getModel().getValueAt(row, 2);

            EditStudent edit = new EditStudent();
            edit.setVisible(true);
            edit.EditInformation(id, name);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(BookManagement.this, "You must select a row. The error code is: " + ex);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        try {

            if (selected_id != null) {

                add.setVisible(true);

                ps = connect.connection.prepareStatement("SELECT id, name, father, mobile, college, roll, groupp, address, payment, due, date, batch1, batch2 FROM student where id= '" + selected_id + "'");
                rs = ps.executeQuery();

                while (rs.next()) {
                    add.idLabel.setText(rs.getString(1));
                    add.nameLabel.setText(rs.getString(2));
                    add.fatherLabel.setText(rs.getString(3));
                    add.mobileLabel.setText(rs.getString(4));
                    add.collegeLabel.setText(rs.getString(5));
                    add.rollLabel.setText(rs.getString(6));
                    add.groupLabel.setText(rs.getString(7));
                    add.addressLabel.setText(rs.getString(8));
                    add.paymentLabel.setText(rs.getString(9));
                    add.dueLabel.setText(rs.getString(10));
                    add.dateLabel.setText(rs.getString(11));
                    add.batch1Label.setText(rs.getString(12));
                    add.batch2Label.setText(rs.getString(13));
                }

                ps = connect.connection.prepareStatement("SELECT date, slip, amount FROM payment where id= '" + selected_id + "'");
                books = ps.executeQuery();

                tablemodel2.setRowCount(0);
                while (books.next()) {
                    tablemodel2.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3)});
                    i++;
                    add.jTable1.setModel(tablemodel2);
                }

                ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + selected_id + "'");
                books = ps.executeQuery();

                tablemodel3.setRowCount(0);
                while (books.next()) {
                    tablemodel3.addRow(new Object[]{books.getString(1)});
                    i++;
                    add.batchTable.setModel(tablemodel3);
                }

            }

        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_viewButtonActionPerformed

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentButtonActionPerformed
        try {
            int row = jTable1.getSelectedRow();
            id = (String) jTable1.getModel().getValueAt(row, 0);
            name = (String) jTable1.getModel().getValueAt(row, 1);

            AddPaymentNew addPeyment = new AddPaymentNew();
            addPeyment.setVisible(true);
            addPeyment.AddPeyment(id, name);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(BookManagement.this, "You must select a row. The error code is: " + ex);
        }

    }//GEN-LAST:event_paymentButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // tablemodel.setRowCount(0);
        // bookList();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        Routine routine = new Routine();
        routine.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        batchComboBox1.removeAllItems();
        try {

            prstmnt = connect.connection.prepareStatement("SELECT day, time, chapter FROM routine ORDER BY day ASC");
            rs = prstmnt.executeQuery();
            batch.addElement("All Students");
            while (rs.next()) {
                batch.addElement(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
            }
            batchComboBox1.setModel(batch);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        bookList();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void aboutUsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMenuMouseClicked
        //new aboutUs().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_aboutUsMenuMouseClicked

    private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
        search = jXSearchField1.getText();
        try {

            tablemodel.setRowCount(0);
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("(SELECT id, name, college, mobile, payment, received, due FROM student WHERE name like "
                    + "'%" + search + "%' ORDER BY id ASC)" + "UNION" + "(SELECT id, name, college, mobile, payment, received, due FROM student WHERE id like " + "'%" + search
                    + "%' ORDER BY id ASC)" + "UNION" + "(SELECT id, name, college, mobile, payment, received, due FROM student WHERE mobile like " + "'%"
                    + search + "%' ORDER BY id ASC)");

            while (books.next()) {
                tablemodel.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3),
                    books.getString(4), books.getString(5), books.getString(6), books.getString(7)});
                jTable1.setModel(tablemodel);
                repaint();

            }
            TableResize();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jXSearchField1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        //new AdminFrame().setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jXSearchField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField2ActionPerformed

    }//GEN-LAST:event_jXSearchField2ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked

        JButton select = new JButton("SELECT EXCEL FILE");
        select.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fc.showOpenDialog(BookManagement.this);
                    File f = fc.getSelectedFile();
                    path = f.getAbsolutePath();
                    file2 = new File(path);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        Object[] button = {select};

        int n = JOptionPane.showConfirmDialog(this, button, "Title", JOptionPane.OK_OPTION);
        if (n == JOptionPane.OK_OPTION) {

            try {

                Iterator rows;

                if (FilenameUtils.getExtension(path).equalsIgnoreCase("xls")) {

                    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file2));
                    HSSFSheet sheet = workbook.getSheetAt(0);
                    rows = sheet.rowIterator();
                    while (rows.hasNext()) {
                        c = 0;

                        HSSFRow row = (HSSFRow) rows.next();
                        Cell lastCellInRow = row.getCell(row.getLastCellNum() - 1);
                        Cell firstCellInRow = row.getCell(0);
                        String sql = "INSERT INTO student(id, name, mobile, payment, received, due) VALUES(?,?,?,?,?) ";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);
                        prstmnt.setString(1, row.getCell(0).getStringCellValue());
                        prstmnt.setString(2, row.getCell(1).getStringCellValue());
                        prstmnt.setString(3, row.getCell(2).getStringCellValue());
                        prstmnt.setString(4, row.getCell(3).getStringCellValue());
                        prstmnt.setString(5, row.getCell(4).getStringCellValue());

                        prstmnt.executeUpdate();
                        prstmnt.close();
                        int input = JOptionPane.showOptionDialog(null, "Added Successfully!", "The title",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        if (input == JOptionPane.OK_OPTION) {
                            super.dispose();
                        }

                    }
                } else if (FilenameUtils.getExtension(path).equalsIgnoreCase("xlsx")) {

                    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file2));
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    rows = sheet.rowIterator();
                    while (rows.hasNext()) {
                        c = 0;

                        XSSFRow row = (XSSFRow) rows.next();
                        String sql = "INSERT INTO student(id, name, mobile, payment, received, due) VALUES(?,?,?,?,?,?) ";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);
                        prstmnt.setInt(1, (int) row.getCell(0).getNumericCellValue());
                        prstmnt.setString(2, row.getCell(1).getStringCellValue());
                        prstmnt.setString(3, row.getCell(2).getStringCellValue());
                        prstmnt.setInt(4, (int) row.getCell(3).getNumericCellValue());
                        prstmnt.setInt(5, (int) row.getCell(4).getNumericCellValue());
                        prstmnt.setInt(6, (int) row.getCell(5).getNumericCellValue());

                        prstmnt.executeUpdate();
                        prstmnt.close();
                    }
                }
            } catch (HeadlessException | IOException | SQLException ex) {
                System.out.println(ex);
            }
        }


    }//GEN-LAST:event_jMenu5MouseClicked

    private void batchComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchComboBox1ActionPerformed
        batch_time = (String) batchComboBox1.getItemAt(batchComboBox1.getSelectedIndex());
        if (batch_time == null) {
            header = new MessageFormat("All Students");
        } else {
            header = new MessageFormat(batch_time);
        }

        tablemodel.setRowCount(0);
        try {
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student "
                    + "WHERE batch1 = '" + batch_time + "' OR batch2 = '" + batch_time + "'");
            while (books.next()) {
                id = books.getString(1);
                name = books.getString(2);
                college = books.getString(3);
                mobile = books.getString(4);
                payment = books.getString(5);
                received = books.getInt(6);
                due = books.getInt(7);
                tablemodel.addRow(new Object[]{id, name, college, mobile, payment, received, due});
                i++;
                jTable1.setModel(tablemodel);
            }
            TableResize();

            stmt3 = connect.connection.createStatement();
            rs2 = stmt3.executeQuery("SELECT  COUNT(id) FROM student WHERE batch1 = '" + batch_time + "' OR batch2 = '" + batch_time + "'");
            while (rs2.next()) {
                total_student = rs2.getString(1);
                total_level.setText("Total Student = " + total_student);
            }

        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }//GEN-LAST:event_batchComboBox1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            int row = jTable1.getSelectedRow();

            if (row > -1) {
                id = (String) jTable1.getModel().getValueAt(row, 0);
                int input = JOptionPane.showOptionDialog(null, "Delete Information?", "The title",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if (input == JOptionPane.OK_OPTION) {

                    PreparedStatement ps = null;
                    ps = connect.connection.prepareStatement("DELETE FROM student WHERE id = '" + id + "'");
                    ps.executeUpdate();
                    ps = connect.connection.prepareStatement("DELETE FROM batch WHERE id = '" + id + "'");
                    ps.executeUpdate();
                    bookList();
                }
            } else {
                JOptionPane.showMessageDialog(BookManagement.this, "You must select a row");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(BookManagement.this, "You must select a row. The error code is: " + ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            MessageFormat footer = new MessageFormat("Page - {0}");

            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(BookManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateToActionPerformed
        tablemodel4.setRowCount(0);

        i = 0;
        //jXDatePicker2.setFormats("dd-MMM-yyyy");
        Date oDate = DateTo.getDate();
        DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        szDate2 = oDateFormat.format(oDate);
        String id2, slip, amount, total_amount, name2, date2;

        try {
            if (DateFrom == null) {
                connect.statement = connect.connection.createStatement();
                books = connect.statement.executeQuery("SELECT id, slip, amount FROM payment where date = '" + szDate2 + "'");

                stmt3 = connect.connection.createStatement();
                rs2 = stmt3.executeQuery("SELECT  SUM(amount) FROM payment where date = '" + szDate2 + "'");
                while (rs2.next()) {
                    total_amount = rs2.getString(1);
                    total_level.setText("Total Amount = " + total_amount);
                }

                statement2 = connect.connection.createStatement();
                while (books.next()) {
                    id2 = books.getString(1);
                    slip = books.getString(2);
                    amount = books.getString(3);

                    rs3 = statement2.executeQuery("SELECT name FROM student where id = '" + id2 + "'");
                    if (rs3.next()) {
                        name2 = rs3.getString(1);
                        tablemodel4.addRow(new Object[]{id2, name2, slip, amount});
                        jTable1.setModel(tablemodel4);
                    }
                    i++;
                }
            } else { //if find amount between two date 

                connect.statement = connect.connection.createStatement();
                books = connect.statement.executeQuery("SELECT id, slip, amount, date FROM payment where date BETWEEN '" + szDate1 + "' AND '" + szDate2 + "'");

                stmt3 = connect.connection.createStatement();
                rs2 = stmt3.executeQuery("SELECT  SUM(amount) FROM payment where date BETWEEN '" + szDate1 + "' AND '" + szDate2 + "'");
                while (rs2.next()) {
                    total_amount = rs2.getString(1);
                    total_level.setText("Total Amount = " + total_amount);
                }

                statement2 = connect.connection.createStatement();
                while (books.next()) {
                    id2 = books.getString(1);
                    slip = books.getString(2);
                    amount = books.getString(3);
                    date2 = books.getString(4);

                    rs3 = statement2.executeQuery("SELECT name FROM student where id = '" + id2 + "'");
                    if (rs3.next()) {
                        name2 = rs3.getString(1);
                        tablemodel5.addRow(new Object[]{id2, name2, slip, amount, date2});
                        jTable1.setModel(tablemodel5);
                    }
                    i++;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }//GEN-LAST:event_DateToActionPerformed

    private void MessageMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessageMenuMouseClicked
        MessageMenu.removeAll();
        try {
            prstmnt = connect.connection.prepareStatement("SELECT day, time, chapter FROM routine ORDER BY day ASC");
            rs = prstmnt.executeQuery();
            jMenuItem = new JMenuItem("All Students");
            MessageMenu.add(jMenuItem);
            while (rs.next()) {

                jMenuItem = new JMenuItem(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
                MessageMenu.add(jMenuItem);
            }
            System.out.println("ikbal ahmed");
            MessageMenu.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String) e.getSource();
                    System.out.println(item);
                    tablemodel1.setRowCount(0);
                    try {
                        connect.statement = connect.connection.createStatement();

                        if (item.equals("All Students")) {
                            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student");

                            while (books.next()) {
                                tablemodel1.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3),
                                    books.getString(4), books.getString(5), books.getString(6), books.getInt(7)});
                                i++;
                                jTable1.setModel(tablemodel1);
                            }
                        } else {
                            books = connect.statement.executeQuery("SELECT id, name, college, mobile, payment, received, due FROM student WHERE batch1 = '" + item + "' OR batch2 = '" + item + "'");

                            while (books.next()) {
                                tablemodel1.addRow(new Object[]{books.getString(1), books.getString(2), books.getString(3),
                                    books.getString(4), books.getString(5), books.getString(6), books.getInt(7)});
                                i++;
                                jTable1.setModel(tablemodel1);
                            }
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex);

                    }
                }

            });

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(BookManagement.this, "Communications link failure! Check your database connecttion.");
        }
    }//GEN-LAST:event_MessageMenuMouseClicked

    private void MessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MessageButtonActionPerformed
        SMSGateway sms = new SMSGateway();
        sms.Send_SMS(batch_time);
        System.out.println(batch_time);
    }//GEN-LAST:event_MessageButtonActionPerformed

    private void DateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateFromActionPerformed
        tablemodel4.setRowCount(0);

        i = 0;
        //jXDatePicker2.setFormats("dd-MMM-yyyy");
        Date oDate = DateFrom.getDate();
        DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        szDate1 = oDateFormat.format(oDate);
        System.out.println(szDate1);
        String id2, slip, amount, total_amount, name2;

        try {
            connect.statement = connect.connection.createStatement();
            books = connect.statement.executeQuery("SELECT id, slip, amount FROM payment where date = '" + szDate1 + "'");

            stmt3 = connect.connection.createStatement();
            rs2 = stmt3.executeQuery("SELECT  SUM(amount) FROM payment where date = '" + szDate1 + "'");
            while (rs2.next()) {
                total_amount = rs2.getString(1);
                total_level.setText("Total Amount = " + total_amount);
            }

            statement2 = connect.connection.createStatement();
            while (books.next()) {
                id2 = books.getString(1);
                slip = books.getString(2);
                amount = books.getString(3);

                rs3 = statement2.executeQuery("SELECT name FROM student where id = '" + id2 + "'");
                if (rs3.next()) {
                    name2 = rs3.getString(1);
                    tablemodel4.addRow(new Object[]{id2, name2, slip, amount});
                    jTable1.setModel(tablemodel4);
                }
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }//GEN-LAST:event_DateFromActionPerformed

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
            java.util.logging.Logger.getLogger(BookManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookManagement().setVisible(true);
            }
        });
    }

    StudentInformation add = new StudentInformation();
    AddStudent teacher;
    String id, search, address, name, father, mobile, phone, college, roll, payment, date, group, batch_time;
    String path, total_student;
    String szDate1 = null, szDate2 = null;
    int len, received, due, c = 0;
    int available;
    File file2;
    ImageIcon icon;
    static byte[] imagebyte;
    MessageFormat header;
    JFileChooser fc = new JFileChooser();
    Statement statement2, stmt3;
    ResultSet rs2, rs3;
    JMenuItem jMenuItem;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker DateFrom;
    private org.jdesktop.swingx.JXDatePicker DateTo;
    private javax.swing.JButton MessageButton;
    private javax.swing.JMenu MessageMenu;
    private javax.swing.JMenu aboutUsMenu;
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox batchComboBox1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton employeeButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JButton paymentButton;
    private javax.swing.JLabel total_level;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
