/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsystem;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JaiShriRam
 */
public class FrmViewSixMonth extends javax.swing.JInternalFrame {

    String startMonth, endMonth, nameYear;
    int startMonthNo, endMonthNo;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form FrmViewSixMonth
     */
    public FrmViewSixMonth() {
        initComponents();
    }

    public FrmViewSixMonth(String month, String year) {
        initComponents();
//        String da = year + "-" + month + "-01";
//        switch (month) {
//            case "January":
//                startMonth = month;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                startMonthNo = Calendar.MONTH+1;
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                endMonth = da;
//                endMonthNo = Calendar.MONTH+1;
//                break;
//            case "February":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "March":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "April":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "May":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "June":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "July":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "August":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "September":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "October":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "Novemeber":
//                startMonth = da;
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//            case "December":
//                try {
//                    cal.setTime(sdf.parse(da));
//                } catch (ParseException ex) {
//                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
////                startMonth = new DateFormatSymbols().getMonths()[];
//                cal.add(Calendar.MONTH, 6);
//                da = sdf.format(cal.getTime());
//                endMonth = da;
//                break;
//        }
//        startDate.setText(startMonth);
//        endDate.setText(endMonth);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        startDate = new javax.swing.JLabel();
        sheet_name = new javax.swing.JLabel();
        lblTotalMatch = new javax.swing.JLabel();
        lblTotalUnmatch = new javax.swing.JLabel();
        lblMatch = new javax.swing.JLabel();
        lblUnmatch = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblMatchedList = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblUnmatchedList = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        endDate = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        startDate.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        startDate.setForeground(new java.awt.Color(15, 41, 161));
        startDate.setText("Month");

        sheet_name.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        sheet_name.setForeground(new java.awt.Color(15, 48, 161));
        sheet_name.setText("Internal/External Sheet");

        lblTotalMatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblTotalMatch.setForeground(new java.awt.Color(15, 41, 161));
        lblTotalMatch.setText("TOTAL MATCHED: ");

        lblTotalUnmatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblTotalUnmatch.setForeground(new java.awt.Color(15, 41, 161));
        lblTotalUnmatch.setText("TOTAL UNMATCHED: ");

        lblMatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblMatch.setForeground(new java.awt.Color(0, 153, 0));
        lblMatch.setText("NOs");

        lblUnmatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblUnmatch.setForeground(new java.awt.Color(255, 51, 0));
        lblUnmatch.setText("NOs");

        jTable1.setFont(new java.awt.Font("Bodoni MT", 1, 10)); // NOI18N
        jTable1.setForeground(new java.awt.Color(15, 48, 161));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Serial No.", "Generated No.", "0i", "0e", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAlignmentX(5.5F);
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable1.setRowHeight(23);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Matched Column Names"));

        lblMatchedList.setBackground(new java.awt.Color(255, 255, 255));
        lblMatchedList.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblMatchedList.setForeground(new java.awt.Color(51, 204, 0));
        lblMatchedList.setText("Matched Columns");
        jScrollPane1.setViewportView(lblMatchedList);

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Unmatched Column Names"));

        lblUnmatchedList.setBackground(new java.awt.Color(255, 255, 255));
        lblUnmatchedList.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblUnmatchedList.setForeground(new java.awt.Color(255, 0, 0));
        lblUnmatchedList.setText("Unmatched Columns");
        jScrollPane3.setViewportView(lblUnmatchedList);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 3, 16)); // NOI18N
        jLabel1.setText("to");

        endDate.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        endDate.setForeground(new java.awt.Color(15, 41, 161));
        endDate.setText("Month");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(lblTotalMatch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatch)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sheet_name)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(lblTotalUnmatch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnmatch)))))
                .addGap(35, 35, 35))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sheet_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalUnmatch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatch)
                    .addComponent(lblUnmatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Panel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMatch;
    private javax.swing.JLabel lblMatchedList;
    private javax.swing.JLabel lblTotalMatch;
    private javax.swing.JLabel lblTotalUnmatch;
    private javax.swing.JLabel lblUnmatch;
    private javax.swing.JLabel lblUnmatchedList;
    private javax.swing.JLabel sheet_name;
    private javax.swing.JLabel startDate;
    // End of variables declaration//GEN-END:variables
}
