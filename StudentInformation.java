package department.mangement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentInformation extends javax.swing.JFrame implements Printable {

    int i = 0;
    String id, column_name[] = {"Date", "Slip NO", "Amount"}, batch_time, payment_slip, payment_amount, payment_date;
    ResultSet rs;
    PreparedStatement ps;
    String column_name3[] = {"Batch/Chapter Schedule"};
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

    DefaultTableModel tablemodel3 = new DefaultTableModel(column_name3, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tablemodel = new DefaultTableModel(column_name, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    EditPayment edit = new EditPayment();

    //PrinterJob printJob = PrinterJob.getPrinterJob();
    public StudentInformation() {
        initComponents();
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);

        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setShowGrid(true);
        jTable1.setModel(tablemodel);

        jTable1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    payment_date = (String) jTable1.getModel().getValueAt(row, 0);
                    payment_slip = (String) jTable1.getModel().getValueAt(row, 1);
                    payment_amount = (String) jTable1.getModel().getValueAt(row, 2);
                    edit.setVisible(rootPaneCheckingEnabled);
                    edit.idField.setText(idLabel.getText());
                    edit.slipField.setText(payment_slip);
                    edit.amountField.setText(payment_amount);
                    Date date2;
                    try {
                        date2 = formatter1.parse(payment_date);
                        edit.jXDatePicker1.setDate(date2);
                    } catch (ParseException ex) {
                        Logger.getLogger(StudentInformation.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    edit.EditInformation(idLabel.getText(), payment_amount, payment_slip);
                }
            }

        });

    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int page) throws PrinterException {

        Graphics2D g2d;

//pageFormat.setPaper(p);
        //--- Validate the page number, we only print the first page
        if (page == 0) {  //--- Create a graphic2D object a set the default parameters
            g2d = (Graphics2D) g;
            g2d.setColor(Color.black);

            //--- Translate the origin to be (0,0)
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            super.printAll(g);

            return (PAGE_EXISTS);
        } else {
            return (NO_SUCH_PAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        mobileLabel = new javax.swing.JLabel();
        fatherLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        dueLabel = new javax.swing.JLabel();
        collegeLabel = new javax.swing.JLabel();
        paymentLabel = new javax.swing.JLabel();
        rollLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        batchTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        changeBatchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        batch1Label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        batch2Label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Batch  History");

        jInternalFrame3.setVisible(true);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("College Name:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Father's Name:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Address:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Group::");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Total Due:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Total Payment::");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Admission Date::");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Mobile Number::");

        dateLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        dateLabel.setToolTipText("");
        dateLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mobileLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        mobileLabel.setToolTipText("");
        mobileLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fatherLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        fatherLabel.setToolTipText("");
        fatherLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        groupLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        groupLabel.setToolTipText("");
        groupLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addressLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        addressLabel.setToolTipText("");
        addressLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dueLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        dueLabel.setToolTipText("");
        dueLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        collegeLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        collegeLabel.setToolTipText("");
        collegeLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        paymentLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        paymentLabel.setToolTipText("");
        paymentLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rollLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        rollLabel.setToolTipText("");
        rollLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("College Roll:");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addGap(17, 17, 17)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(collegeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rollLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fatherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(collegeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rollLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(dueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24))
        );

        idLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        idLabel.setToolTipText("");
        idLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameLabel.setFont(new java.awt.Font("Andalus", 0, 16)); // NOI18N
        nameLabel.setToolTipText("");
        nameLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Student Name: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Student ID:");

        okButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        batchTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        batchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(batchTable);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Payment History");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Running Batches");

        changeBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        changeBatchButton.setText("Change");
        changeBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBatchButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Batch-1:");

        batch1Label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Batch-2:");

        batch2Label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Print Receipt");
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
                .addGap(18, 18, 18)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(batch1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(batch2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(changeBatchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(199, 199, 199)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(175, 175, 175)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)))
                        .addGap(2, 2, 2))
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(batch1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(batch2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeBatchButton))
                        .addGap(18, 18, 18)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBatchButtonActionPerformed
        String batch_time1 = batch2Label.getText();
        DefaultComboBoxModel<Object> batch = new DefaultComboBoxModel<>();

        try {
            ps = connect.connection.prepareStatement("SELECT day, time, chapter FROM routine");
            rs = ps.executeQuery();
            while (rs.next()) {
                batch.addElement(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
            }
            batchComboBox.setModel(batch);

            batchComboBox.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    batchComboBoxActionPerformed(evt);
                }
            });

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (batch_time1 == null) {  //if there is no batch exit previous

            Object[] checkbox = {batchComboBox};
            int n = JOptionPane.showConfirmDialog(this, checkbox, "Title", JOptionPane.OK_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                if (!batch1Label.getText().equals(batch_time)) {
                    batch2Label.setText(batch_time);
                    try {
                        String sql = "UPDATE student SET batch2 = ? WHERE id = ?";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, batch2Label.getText());
                        prstmnt.setString(2, idLabel.getText());
                        prstmnt.executeUpdate();
                        prstmnt.close();

                    } catch (SQLException | HeadlessException ex) {
                        System.out.println(ex);
                    }
                } else {
                    int input = JOptionPane.showOptionDialog(null, "Batch is already exist!!", "The title",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (input == JOptionPane.OK_OPTION) {

                    }
                }
            }
        } else {  //if there is a batch exist

            JCheckBox jCheckBox1 = new JCheckBox("Previous chapter is completed");
            JCheckBox jCheckBox2 = new JCheckBox("Previous chapter is not completed");
            JCheckBox jCheckBox3 = new JCheckBox("Clear Batch");

            Object[] checkbox = {batchComboBox, jCheckBox1, jCheckBox2, jCheckBox3};
            ButtonGroup btnGroup = new ButtonGroup();
            jCheckBox1.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "completed";
                }
            });
            jCheckBox2.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "not completed";
                }
            });
            jCheckBox3.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "clear";
                }
            });
            btnGroup.add(jCheckBox1);
            btnGroup.add(jCheckBox2);
            btnGroup.add(jCheckBox3);

            int n = JOptionPane.showConfirmDialog(this, checkbox, "Title", JOptionPane.OK_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                batch2Label.setText(batch_time);
                if (batch_completion.equals("completed")) {
                    try {
                        String sql = "INSERT INTO batch VALUES(?,?,?)";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, idLabel.getText());
                        prstmnt.setString(2, nameLabel.getText());
                        prstmnt.setString(3, batch_time1);

                        prstmnt.executeUpdate();
                        prstmnt.close();

                        //add completed batch to the batch history table
                        ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + idLabel.getText() + "'");
                        books = ps.executeQuery();
                        tablemodel3.setRowCount(0);
                        while (books.next()) {
                            tablemodel3.addRow(new Object[]{books.getString(1)});
                            i++;
                            batchTable.setModel(tablemodel3);
                        }
                        ps.close();

                    } catch (SQLException | HeadlessException ex) {
                        System.out.println(ex);
                    }
                } else if (batch_completion.equals("clear")) {
                    try {

                        String sql = "INSERT INTO batch VALUES(?,?,?)";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, idLabel.getText());
                        prstmnt.setString(2, nameLabel.getText());
                        prstmnt.setString(3, batch_time1);

                        prstmnt.executeUpdate();
                        prstmnt.close();

                        //add completed batch to the batch history table 
                        ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + idLabel.getText() + "'");
                        books = ps.executeQuery();
                        tablemodel3.setRowCount(0);
                        while (books.next()) {
                            tablemodel3.addRow(new Object[]{books.getString(1)});
                            i++;
                            batchTable.setModel(tablemodel3);
                        }
                        ps.close();

                        String sql1 = "UPDATE student SET batch2 = ? WHERE id = ?";
                        PreparedStatement prstmnt1 = connect.connection.prepareStatement(sql1);
                        prstmnt1.setString(1, null);
                        prstmnt1.setString(2, idLabel.getText());
                        prstmnt1.executeUpdate();
                        prstmnt1.close();

                        batch2Label.setText(null);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {
                    String sql1 = "UPDATE student SET batch2 = ? WHERE id = ?";
                    try {
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql1);
                        prstmnt.setString(1, batch2Label.getText());
                        prstmnt.setString(2, idLabel.getText());
                        prstmnt.executeUpdate();
                        prstmnt.close();
                        ps.executeUpdate();
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_changeBatchButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void batchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        batch_time = (String) batchComboBox.getItemAt(batchComboBox.getSelectedIndex());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String batch_time1 = batch1Label.getText();
        DefaultComboBoxModel<Object> batch = new DefaultComboBoxModel<>();

        try {
            ps = connect.connection.prepareStatement("SELECT day, time, chapter FROM routine");
            rs = ps.executeQuery();
            while (rs.next()) {
                batch.addElement(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
            }
            batchComboBox.setModel(batch);

            batchComboBox.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    batchComboBoxActionPerformed(evt);
                }
            });

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (batch_time1 == null) {  //if there is no batch exit previous

            Object[] checkbox = {batchComboBox};
            int n = JOptionPane.showConfirmDialog(this, checkbox, "Title", JOptionPane.OK_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                if (!batch2Label.equals(batch_time)) {
                    batch1Label.setText(batch_time);
                    try {
                        String sql = "UPDATE student SET batch1 = ? WHERE id = ?";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, batch1Label.getText());
                        prstmnt.setString(2, idLabel.getText());
                        prstmnt.executeUpdate();
                        prstmnt.close();

                    } catch (SQLException | HeadlessException ex) {
                        System.out.println(ex);
                    }
                } else {
                    int input = JOptionPane.showOptionDialog(null, "Batch is already exist", "The title",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (input == JOptionPane.OK_OPTION) {

                    }
                }
            }
        } else {  //if there is a batch exist

            JCheckBox jCheckBox1 = new JCheckBox("Previous chapter is completed");
            JCheckBox jCheckBox2 = new JCheckBox("Previous chapter is not completed");
            JCheckBox jCheckBox3 = new JCheckBox("Clear Batch");

            Object[] checkbox = {batchComboBox, jCheckBox1, jCheckBox2, jCheckBox3};
            ButtonGroup btnGroup = new ButtonGroup();
            jCheckBox1.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "completed";
                }
            });
            jCheckBox2.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "not completed";
                }
            });
            jCheckBox3.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    batch_completion = "clear";
                }
            });
            btnGroup.add(jCheckBox1);
            btnGroup.add(jCheckBox2);
            btnGroup.add(jCheckBox3);

            int n = JOptionPane.showConfirmDialog(this, checkbox, "Title", JOptionPane.OK_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                batch1Label.setText(batch_time);
                if (batch_completion.equals("completed")) {

                    try {
                        String sql = "INSERT INTO batch VALUES(?,?,?)";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, idLabel.getText());
                        prstmnt.setString(2, nameLabel.getText());
                        prstmnt.setString(3, batch_time1);

                        prstmnt.executeUpdate();
                        prstmnt.close();

                        //add completed batch to the batch history table 
                        ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + idLabel.getText() + "'");
                        books = ps.executeQuery();
                        tablemodel3.setRowCount(0);
                        while (books.next()) {
                            tablemodel3.addRow(new Object[]{books.getString(1)});
                            i++;
                            batchTable.setModel(tablemodel3);
                        }
                        ps.close();

                        String sql1 = "UPDATE student SET batch1 = ? WHERE id = ?";
                        PreparedStatement prstmnt1 = connect.connection.prepareStatement(sql1);

                        prstmnt1.setString(1, batch1Label.getText());
                        prstmnt1.setString(2, idLabel.getText());
                        prstmnt1.executeUpdate();
                        prstmnt1.close();

                    } catch (SQLException | HeadlessException ex) {
                        System.out.println(ex);
                    }
                } else if (batch_completion.equals("clear")) {
                    try {

                        String sql = "INSERT INTO batch VALUES(?,?,?)";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, idLabel.getText());
                        prstmnt.setString(2, nameLabel.getText());
                        prstmnt.setString(3, batch_time1);

                        prstmnt.executeUpdate();
                        prstmnt.close();

                        //add completed batch to the batch history table 
                        ps = connect.connection.prepareStatement("SELECT batch FROM batch where id= '" + idLabel.getText() + "'");
                        books = ps.executeQuery();
                        tablemodel3.setRowCount(0);
                        while (books.next()) {
                            tablemodel3.addRow(new Object[]{books.getString(1)});
                            i++;
                            batchTable.setModel(tablemodel3);
                        }
                        ps.close();

                        String sql1 = "UPDATE student SET batch1 = ? WHERE id = ?";
                        PreparedStatement prstmnt1 = connect.connection.prepareStatement(sql1);

                        prstmnt1.setString(1, null);
                        prstmnt1.setString(2, idLabel.getText());
                        prstmnt1.executeUpdate();
                        prstmnt1.close();

                        batch1Label.setText(null);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {

                    try {
                        String sql = "UPDATE student SET batch1 = ? WHERE id = ?";
                        PreparedStatement prstmnt = connect.connection.prepareStatement(sql);

                        prstmnt.setString(1, batch1Label.getText());
                        prstmnt.setString(2, idLabel.getText());
                        prstmnt.executeUpdate();
                        prstmnt.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PrintReceipt print = new PrintReceipt();
        String id2, amount2, date2;
        int row = jTable1.getSelectedRow();
        String slip =  (String) jTable1.getModel().getValueAt(row, 1);
        System.out.println(slip);
        try {

            ps = connect.connection.prepareStatement("SELECT id, amount, date FROM payment WHERE slip = '" + slip + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                id2 = rs.getString("id");
                amount2 = rs.getString("amount");
                date2 = rs.getString("date");
                 print.setVisible(true);
                print.RetreiveInfo(id2, amount2, date2);
            }

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentInformation().setVisible(true);
            }
        });
    }
    DerbyConnection connect = new DerbyConnection();
    ResultSet books;
    String day, time, chapter, batch_completion;
    JComboBox batchComboBox = new JComboBox();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel addressLabel;
    public javax.swing.JLabel batch1Label;
    public javax.swing.JLabel batch2Label;
    public javax.swing.JTable batchTable;
    private javax.swing.JButton changeBatchButton;
    public javax.swing.JLabel collegeLabel;
    public javax.swing.JLabel dateLabel;
    public javax.swing.JLabel dueLabel;
    public javax.swing.JLabel fatherLabel;
    public javax.swing.JLabel groupLabel;
    public javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JLabel mobileLabel;
    public javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    public javax.swing.JLabel paymentLabel;
    public javax.swing.JLabel rollLabel;
    // End of variables declaration//GEN-END:variables

}
