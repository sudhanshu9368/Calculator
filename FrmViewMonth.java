/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsystem;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author JaiShriRam
 */
public class FrmViewMonth extends javax.swing.JInternalFrame {

    int monthNo;
    String tableName, tableName1, tableName2;
    String monthLcl, yearLcl, sheet_nameLcl;
    Connection co;
    Statement getData_st, showData_st, getUnmatchedInt_st, getUnmatchedExt_st, getLastMonthUnmatchInt_st, getLastMonthUnmatchExt_st, getData2_st, showData2_st, getData1_st, showData3_st;
    ResultSet getData_rs, showData_rs, getLastMonthUnmatchInt_rs, getLastMonthUnmatchExt_rs, showData2_rs, getData1_rs, getData2_rs, showData3_rs;
    PreparedStatement insertUnmatchedInt_st, insertUnmatchedExt_st;

    /**
     * Creates new form FrmViewMonth
     *
     * @param month1
     * @param sheet_name1
     * @param year1
     * @param farmName
     */
    public FrmViewMonth(String month1, String year1, String sheet_name1, String farmName) {
        initComponents();
        jPanel3.setVisible(false);
        jPanel5.setVisible(false);
        co = DataBaseConnection.ConnectDB();
        month.setText(month1);
        year.setText(year1);
        sheet_name.setText(sheet_name1);
        this.farmName.setText(farmName);
        monthLcl = month1;
        yearLcl = year1;
        sheet_nameLcl = sheet_name1;
        switch (sheet_name1) {
            case "Fixed Sheet":
                btnMatch1.setText("Movable Internal");
                btnMatch2.setText("Movable External");
                tableName = "FixedInternal";
                tableName1 = "MovableInternal";
                tableName2 = "MovableExternal";
                break;
            case "Movable Internal Sheet":
                btnMatch1.setText("Fixed Strip");
                btnMatch2.setText("Movable External");
                tableName = "MovableInternal";
                tableName1 = "FixedInternal";
                tableName2 = "MovableExternal";
                break;
            default:
                btnMatch1.setText("Movable Internal");
                btnMatch2.setText("Fixed Strip");
                tableName = "MovableExternal";
                tableName1 = "MovableInternal";
                tableName2 = "FixedInternal";
                break;
        }
        switch (month1) {
            case "January":
                monthNo = 1;
                break;
            case "February":
                monthNo = 2;
                break;
            case "March":
                monthNo = 3;
                break;
            case "April":
                monthNo = 4;
                break;
            case "May":
                monthNo = 5;
                break;
            case "June":
                monthNo = 6;
                break;
            case "July":
                monthNo = 7;
                break;
            case "August":
                monthNo = 8;
                break;
            case "September":
                monthNo = 9;
                break;
            case "October":
                monthNo = 10;
                break;
            case "November":
                monthNo = 11;
                break;
            case "December":
                monthNo = 12;
                break;
        }
        String Cmonth = month1;
        String Cyear = year1;
        System.out.println(Cmonth);
        ArrayList<String> Slist = new ArrayList();
        ArrayList<String> Slist1 = new ArrayList();
        ArrayList<String> Slist2 = new ArrayList();
        @SuppressWarnings("UseOfObsoleteCollectionType")
        DefaultTableModel dm = new DefaultTableModel();
        DefaultTableModel dm1 = new DefaultTableModel();
        DefaultTableModel dm2 = new DefaultTableModel();
        String header[] = new String[]{"S.No", "Genereated No", "0i", "0e", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e"
            + "", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"};
        dm.setColumnIdentifiers(header);
        String header1[] = new String[]{"S.No", "Genereated No", "0i", "0e", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e"
            + "", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"};
        dm1.setColumnIdentifiers(header1);
        String header2[] = new String[]{"S.No", "Genereated No", "0i", "0e", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e"
            + "", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"};
        dm2.setColumnIdentifiers(header2);
//        dm.set
        jTable1.setModel(dm);
        jTable2.setModel(dm1);
        jTable3.setModel(dm2);
        co = DataBaseConnection.ConnectDB();
        try {
            String showData1 = "select * from '" + tableName + "' where year='" + Cyear + "' and month='" + Cmonth + "'"
                    + " and farm_name = '" + farmName + "'";
            String showData2 = "select * from '" + tableName1 + "' where year='" + Cyear + "' and month='" + Cmonth + "'"
                    + " and farm_name = '" + farmName + "'";
            String showData3 = "select * from '" + tableName2 + "' where year='" + Cyear + "' and month='" + Cmonth + "'"
                    + " and farm_name = '" + farmName + "'";
            showData_st = co.createStatement();
            showData_rs = showData_st.executeQuery(showData1);

            showData2_st = co.createStatement();
            showData2_rs = showData2_st.executeQuery(showData2);

            showData3_st = co.createStatement();
            showData3_rs = showData3_st.executeQuery(showData3);
            while (showData_rs.next()) {
                Slist.add(showData_rs.getString("date"));
            }
            while (showData2_rs.next())//show data of second table
            {
                Slist1.add(showData2_rs.getString("date"));
            }
            while (showData3_rs.next()) {
                Slist2.add(showData3_rs.getString("date"));
            }
            System.out.println(Slist);
            System.out.println("Print hui h list" + Slist1);

            int SlistLength = Slist.size();
            int SlistLength1 = Slist1.size();
            int SlistLength2 = Slist2.size();
            System.out.println("Print huaaa h length" + SlistLength1);
            int noDataLength = 31 - SlistLength;

            for (int add2 = 0; add2 < SlistLength2; add2++)//get the data from jtable3
            {
                Vector<Object> data2 = new Vector<>();
                String getData2 = "select * from '" + tableName2 + "' where year='" + Cyear + "' and month='" + Cmonth + "' "
                        + "and date='" + Slist2.get(add2) + "'";
                getData2_st = co.createStatement();
                getData2_rs = getData2_st.executeQuery(getData2);
                if (getData2_rs.next()) {
                    data2.add((Object) getData2_rs.getString("date"));
                    data2.add((Object) getData2_rs.getString("g_no"));
                    data2.add((Object) getData2_rs.getString("0L"));
                    data2.add((Object) getData2_rs.getString("0R"));
                    data2.add((Object) getData2_rs.getString("1L"));
                    data2.add((Object) getData2_rs.getString("1R"));
                    data2.add((Object) getData2_rs.getString("2L"));
                    data2.add((Object) getData2_rs.getString("2R"));
                    data2.add((Object) getData2_rs.getString("3L"));
                    data2.add((Object) getData2_rs.getString("3R"));
                    data2.add((Object) getData2_rs.getString("4L"));
                    data2.add((Object) getData2_rs.getString("4R"));
                    data2.add((Object) getData2_rs.getString("5L"));
                    data2.add((Object) getData2_rs.getString("5R"));
                    data2.add((Object) getData2_rs.getString("6L"));
                    data2.add((Object) getData2_rs.getString("6R"));
                    data2.add((Object) getData2_rs.getString("7L"));
                    data2.add((Object) getData2_rs.getString("7R"));
                    data2.add((Object) getData2_rs.getString("8L"));
                    data2.add((Object) getData2_rs.getString("8R"));
                    data2.add((Object) getData2_rs.getString("9L"));
                    data2.add((Object) getData2_rs.getString("9R"));
                    dm2.addRow(data2);
                    System.out.println(data2);
                }
            }

            for (int add1 = 0; add1 < SlistLength1; add1++)//get the data from jtable2
            {
                Vector<Object> data1 = new Vector<>();
                String getData1 = "select * from '" + tableName1 + "' where year='" + Cyear + "' and month='" + Cmonth + "' "
                        + "and date='" + Slist1.get(add1) + "'";
                getData1_st = co.createStatement();
                getData1_rs = getData1_st.executeQuery(getData1);
                if (getData1_rs.next()) {
                    data1.add((Object) getData1_rs.getString("date"));
                    data1.add((Object) getData1_rs.getString("g_no"));
                    data1.add((Object) getData1_rs.getString("0L"));
                    data1.add((Object) getData1_rs.getString("0R"));
                    data1.add((Object) getData1_rs.getString("1L"));
                    data1.add((Object) getData1_rs.getString("1R"));
                    data1.add((Object) getData1_rs.getString("2L"));
                    data1.add((Object) getData1_rs.getString("2R"));
                    data1.add((Object) getData1_rs.getString("3L"));
                    data1.add((Object) getData1_rs.getString("3R"));
                    data1.add((Object) getData1_rs.getString("4L"));
                    data1.add((Object) getData1_rs.getString("4R"));
                    data1.add((Object) getData1_rs.getString("5L"));
                    data1.add((Object) getData1_rs.getString("5R"));
                    data1.add((Object) getData1_rs.getString("6L"));
                    data1.add((Object) getData1_rs.getString("6R"));
                    data1.add((Object) getData1_rs.getString("7L"));
                    data1.add((Object) getData1_rs.getString("7R"));
                    data1.add((Object) getData1_rs.getString("8L"));
                    data1.add((Object) getData1_rs.getString("8R"));
                    data1.add((Object) getData1_rs.getString("9L"));
                    System.out.println("datatatattattta======" + data1.add((Object) getData1_rs.getString("9R")));
                    dm1.addRow(data1);
                    System.out.println(data1);
                }
            }
            for (int add = 0; add < SlistLength; add++) {
                Vector<Object> data = new Vector<>();

                String getData = "select * from '" + tableName + "' where year='" + Cyear + "' and month='" + Cmonth + "' "
                        + "and date='" + Slist.get(add) + "'";

                getData_st = co.createStatement();
                getData_rs = getData_st.executeQuery(getData);
                if (getData_rs.next()) {
//                    for(int count = 1; count <SlistLength; count++){
                    data.add((Object) getData_rs.getString("date"));
                    data.add((Object) getData_rs.getString("g_no"));
                    data.add((Object) getData_rs.getString("0L"));
                    data.add((Object) getData_rs.getString("0R"));
                    data.add((Object) getData_rs.getString("1L"));
                    data.add((Object) getData_rs.getString("1R"));
                    data.add((Object) getData_rs.getString("2L"));
                    data.add((Object) getData_rs.getString("2R"));
                    data.add((Object) getData_rs.getString("3L"));
                    data.add((Object) getData_rs.getString("3R"));
                    data.add((Object) getData_rs.getString("4L"));
                    data.add((Object) getData_rs.getString("4R"));
                    data.add((Object) getData_rs.getString("5L"));
                    data.add((Object) getData_rs.getString("5R"));
                    data.add((Object) getData_rs.getString("6L"));
                    data.add((Object) getData_rs.getString("6R"));
                    data.add((Object) getData_rs.getString("7L"));
                    data.add((Object) getData_rs.getString("7R"));
                    data.add((Object) getData_rs.getString("8L"));
                    data.add((Object) getData_rs.getString("8R"));
                    data.add((Object) getData_rs.getString("9L"));
                    data.add((Object) getData_rs.getString("9R"));
                    dm.addRow(data);
//                    jTable1.setValueAt(getData_rs.getString("date"), add, 0);
//                    jTable1.setValueAt(getData_rs.getString("g_no"), add, 1);
//                    jTable1.setValueAt(getData_rs.getString("0L"), add, 2);
//                    jTable1.setValueAt(getData_rs.getString("0R"), add, 3);
//                    jTable1.setValueAt(getData_rs.getString("1L"), add, 4);
//                    jTable1.setValueAt(getData_rs.getString("1R"), add, 5);
//                    jTable1.setValueAt(getData_rs.getString("2L"), add, 6);
//                    jTable1.setValueAt(getData_rs.getString("2R"), add, 7);
//                    jTable1.setValueAt(getData_rs.getString("3L"), add, 8);
//                    jTable1.setValueAt(getData_rs.getString("3R"), add, 9);
//                    jTable1.setValueAt(getData_rs.getString("4L"), add, 10);
//                    jTable1.setValueAt(getData_rs.getString("4R"), add, 11);
//                    jTable1.setValueAt(getData_rs.getString("5L"), add, 12);
//                    jTable1.setValueAt(getData_rs.getString("5R"), add, 13);
//                    jTable1.setValueAt(getData_rs.getString("6L"), add, 14);
//                    jTable1.setValueAt(getData_rs.getString("6R"), add, 15);
//                    jTable1.setValueAt(getData_rs.getString("7L"), add, 16);
//                    jTable1.setValueAt(getData_rs.getString("7R"), add, 17);
//                    jTable1.setValueAt(getData_rs.getString("8L"), add, 18);
//                    jTable1.setValueAt(getData_rs.getString("8R"), add, 19);
//                    jTable1.setValueAt(getData_rs.getString("9L"), add, 20);
//                    jTable1.setValueAt(getData_rs.getString("9R"), add, 21);
                }
            }
//            for(int ndL = SlistLength; ndL<noDataLength; ndL++){
//                jTable1.setValueAt(null, ndL, 0);
//                jTable1.setValueAt(null, ndL, 1);
//                jTable1.setValueAt(null, ndL, 2);
//                jTable1.setValueAt(null, ndL, 3);
//                jTable1.setValueAt(null, ndL, 4);
//                jTable1.setValueAt(null, ndL, 5);
//                jTable1.setValueAt(null, ndL, 6);
//                jTable1.setValueAt(null, ndL, 7);
//                jTable1.setValueAt(null, ndL, 8);
//                jTable1.setValueAt(null, ndL, 9);
//                jTable1.setValueAt(null, ndL, 10);
//                jTable1.setValueAt(null, ndL, 11);
//                jTable1.setValueAt(null, ndL, 12);
//                jTable1.setValueAt(null, ndL, 13);
//                jTable1.setValueAt(null, ndL, 14);
//                jTable1.setValueAt(null, ndL, 15);
//                jTable1.setValueAt(null, ndL, 16);
//                jTable1.setValueAt(null, ndL, 17);
//                jTable1.setValueAt(null, ndL, 18);
//                jTable1.setValueAt(null, ndL, 19);
//                jTable1.setValueAt(null, ndL, 20);
//                jTable1.setValueAt(null, ndL, 21);
//            }
            System.out.println("End");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrmFillMovInt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        unmatchedInt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        matchedIntlist = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        matchedExList = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        unmatchedListEx = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        pureUnmatchList = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        pureUnmatchListEx = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        unmatchedLastMonthEx = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        unMatchedLastMonthInt = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTotalUnmatch = new javax.swing.JLabel();
        lblPureUnmatch = new javax.swing.JLabel();
        lblTotalUnmatch1 = new javax.swing.JLabel();
        lblUnmatch = new javax.swing.JLabel();
        lblMatch = new javax.swing.JLabel();
        lblTotalMatch = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnMatch1 = new javax.swing.JButton();
        btnMatch2 = new javax.swing.JButton();
        btnMatch3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        farmName = new javax.swing.JLabel();
        month = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        sheet_name = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1216, 655));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setEnabled(false);
        jScrollPane2.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(15, 48, 161));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
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
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(23);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("0");

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1");

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3");

        jLabel4.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2");

        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("7");

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("6");

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("5");

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("4");

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("9");

        jLabel10.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unmatched ( Internal to External ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane3.setMinimumSize(new java.awt.Dimension(35, 45));
        jScrollPane3.setName(""); // NOI18N
        jScrollPane3.setPreferredSize(new java.awt.Dimension(108, 45));

        unmatchedInt.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        unmatchedInt.setForeground(new java.awt.Color(255, 102, 0));
        unmatchedInt.setText("jLabel12");
        jScrollPane3.setViewportView(unmatchedInt);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matched ( Internal to External ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(108, 45));

        matchedIntlist.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        matchedIntlist.setForeground(new java.awt.Color(0, 153, 0));
        matchedIntlist.setText("jLabel12");
        jScrollPane1.setViewportView(matchedIntlist);

        jScrollPane5.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matched ( External to Internal ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane5.setPreferredSize(new java.awt.Dimension(108, 45));

        matchedExList.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        matchedExList.setForeground(new java.awt.Color(0, 153, 0));
        matchedExList.setText("jLabel12");
        jScrollPane5.setViewportView(matchedExList);

        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unmatched ( External to Internal ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane6.setPreferredSize(new java.awt.Dimension(108, 45));

        unmatchedListEx.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        unmatchedListEx.setForeground(new java.awt.Color(255, 102, 0));
        unmatchedListEx.setText("jLabel12");
        jScrollPane6.setViewportView(unmatchedListEx);

        jScrollPane7.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pure ( Unmatched Internal to External ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane7.setPreferredSize(new java.awt.Dimension(108, 45));

        pureUnmatchList.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        pureUnmatchList.setForeground(new java.awt.Color(255, 0, 0));
        pureUnmatchList.setText("jLabel12");
        jScrollPane7.setViewportView(pureUnmatchList);

        jScrollPane8.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pure ( Unmatched External to Internal ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane8.setPreferredSize(new java.awt.Dimension(108, 45));

        pureUnmatchListEx.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        pureUnmatchListEx.setForeground(new java.awt.Color(255, 0, 0));
        pureUnmatchListEx.setText("jLabel12");
        jScrollPane8.setViewportView(pureUnmatchListEx);

        jScrollPane9.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unmatched from Last Month ( External to Internal ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane9.setPreferredSize(new java.awt.Dimension(108, 45));

        unmatchedLastMonthEx.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        unmatchedLastMonthEx.setForeground(new java.awt.Color(255, 102, 0));
        unmatchedLastMonthEx.setText("jLabel12");
        jScrollPane9.setViewportView(unmatchedLastMonthEx);

        jScrollPane10.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unmatched From Last Month ( Internal to External ) Column Names", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 12))); // NOI18N
        jScrollPane10.setPreferredSize(new java.awt.Dimension(108, 45));

        unMatchedLastMonthInt.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        unMatchedLastMonthInt.setForeground(new java.awt.Color(255, 102, 0));
        unMatchedLastMonthInt.setText("unmatched last month");
        jScrollPane10.setViewportView(unMatchedLastMonthInt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel2);

        lblTotalUnmatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblTotalUnmatch.setForeground(new java.awt.Color(15, 41, 161));
        lblTotalUnmatch.setText("TOTAL UNMATCHED: ");

        lblPureUnmatch.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        lblPureUnmatch.setForeground(new java.awt.Color(255, 51, 0));
        lblPureUnmatch.setText("NOs");

        lblTotalUnmatch1.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblTotalUnmatch1.setForeground(new java.awt.Color(15, 41, 161));
        lblTotalUnmatch1.setText("PURE UNMATCHED: ");

        lblUnmatch.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        lblUnmatch.setForeground(new java.awt.Color(255, 153, 0));
        lblUnmatch.setText("NOs");

        lblMatch.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        lblMatch.setForeground(new java.awt.Color(0, 153, 0));
        lblMatch.setText("NOs");

        lblTotalMatch.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        lblTotalMatch.setForeground(new java.awt.Color(15, 41, 161));
        lblTotalMatch.setText("TOTAL MATCHED: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblTotalMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalUnmatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnmatch)
                .addGap(248, 248, 248)
                .addComponent(lblTotalUnmatch1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPureUnmatch)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTotalUnmatch1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPureUnmatch)
                    .addComponent(lblUnmatch)
                    .addComponent(lblTotalUnmatch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatch)
                    .addComponent(lblTotalMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 41, 161));
        jLabel11.setText("Match With: ");

        btnMatch1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnMatch1.setText("External Sheet");
        btnMatch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch1ActionPerformed(evt);
            }
        });

        btnMatch2.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnMatch2.setText("External Sheet");
        btnMatch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch2ActionPerformed(evt);
            }
        });

        btnMatch3.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnMatch3.setText("View Original Sheet");
        btnMatch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch3ActionPerformed(evt);
            }
        });

        farmName.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        farmName.setForeground(new java.awt.Color(15, 48, 161));
        farmName.setText("FarmName");

        month.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        month.setForeground(new java.awt.Color(15, 41, 161));
        month.setText("Month");

        year.setFont(new java.awt.Font("Bodoni MT", 1, 16)); // NOI18N
        year.setForeground(new java.awt.Color(15, 48, 161));
        year.setText("Year");

        sheet_name.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        sheet_name.setForeground(new java.awt.Color(15, 48, 161));
        sheet_name.setText("Internal/External Sheet");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282)
                .addComponent(farmName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sheet_name)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year)
                    .addComponent(sheet_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(farmName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)
                                .addComponent(btnMatch1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMatch2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMatch3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(0, 0, 0))
        );

        PanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMatch1, btnMatch2, btnMatch3});

        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMatch1)
                    .addComponent(jLabel11)
                    .addComponent(btnMatch2)
                    .addComponent(btnMatch3))
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMatch1, btnMatch2, btnMatch3});

        getContentPane().add(Panel);

        jPanel3.setEnabled(false);
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel3.setLayout(new java.awt.CardLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Serial_no", "Generated_No", "0i", "oe", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"
            }
        ));
        jScrollPane12.setViewportView(jTable2);

        jPanel3.add(jScrollPane12, "card2");

        getContentPane().add(jPanel3);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jPanel5.setEnabled(false);
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel5.setLayout(new java.awt.CardLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Serial_no", "Generated_No", "0i", "oe", "1i", "1e", "2i", "2e", "3i", "3e", "4i", "4e", "5i", "5e", "6i", "6e", "7i", "7e", "8i", "8e", "9i", "9e"
            }
        ));
        jScrollPane13.setViewportView(jTable3);

        jPanel5.add(jScrollPane13, "card2");

        getContentPane().add(jPanel5);
        jPanel5.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        TableModel model = jTable1.getModel();
        int rowcount = model.getRowCount();
        int columns = model.getColumnCount();
        System.out.println(rowcount + "  " + columns);
        String[][] outputin = new String[rowcount][columns];
        String[][] outputex = new String[rowcount][columns];
        String[] outputintemp = new String[rowcount];
        String[] outputextemp = new String[rowcount];
        ArrayList<String> columnsmatched = new ArrayList<>();
        ArrayList<String> columnsunmatched = new ArrayList<>();
        ArrayList<String> columnsmatchedex = new ArrayList<>();
        ArrayList<String> columnsunmatchedex = new ArrayList<>();
        ArrayList<String> pureUnmatched = new ArrayList<>();
        ArrayList<String> pureUnmatchedex = new ArrayList<>();
        ArrayList<String> columnsUnmatchedIntLastMonth = new ArrayList<>();
        ArrayList<String> columnsUnmatchedExtLastMonth = new ArrayList<>();
        int count = 0, unmatched = 0, pureUnmatchCount = 0;
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputin[row][col] = null;
//                        jTable2.setValueAt(null, row, col);
//                    }
                outputin[row][col] = (String) model.getValueAt(row, col);
//                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputex[row][col] = null;
//                        jTable1.setValueAt(null, row, col);
//                    }
                outputex[row][col] = (String) model.getValueAt(row, col);
            }
        }
        /**
         * *********************************=Matching
         * Logic=****************************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int col1 = 3; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputintemp[row] = outputin[row][col];
                    outputextemp[row] = outputex[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputintemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputintemp[rowtemp].equals(outputextemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {

                    if (match == elements) {
                        count++;
                        columnsmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputextemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }

                    }
                }
            }
        }
        /**
         * ****************************External to internal
         * match**********************************
         */
        for (int col = 3; col < columns; col = col + 2) {
            for (int col1 = 2; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputextemp[row] = outputex[row][col];
                    outputintemp[row] = outputin[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputextemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputextemp[rowtemp].equals(outputintemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {
                    if (match == elements) {
                        count++;
                        columnsmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputintemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }
                    }
                }
            }
        }
        /**
         * ************************************=Matching Logic
         * Ends=********************************************
         */
        lblMatch.setText(String.valueOf(count));
        lblUnmatch.setText(String.valueOf(unmatched));
        lblPureUnmatch.setText(String.valueOf(pureUnmatchCount));
        matchedIntlist.setText(columnsmatched.toString());
        unmatchedInt.setText(columnsunmatched.toString());
        matchedExList.setText(columnsmatchedex.toString());
        unmatchedListEx.setText(columnsunmatchedex.toString());
        pureUnmatchList.setText(pureUnmatched.toString());
        pureUnmatchListEx.setText(pureUnmatchedex.toString());
        System.out.println("columns matched = " + count);
        System.out.println("===========================");
        System.out.println(columnsmatched);
        System.out.println("===========================");
        System.out.println(columnsunmatched);
        /**
         * ***************************Formatting the jTable
         * Sizing*********************************
         */
        /*Resizing the Columns Dynamically*/
        TableColumnModel tcm = jTable1.getColumnModel();
        for (int i = 2; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tcm.getColumn(i);
            column.setPreferredWidth(44);
        }
        TableColumn column = tcm.getColumn(1);
        column.setPreferredWidth(160);
        //Centering jtable data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        /**
         * *************************************Formatting table data
         * Completed*******************************************
         */

        /**
         * *****************************************Saving data into
         * database************************************************
         */
        /*ArrayLists to be stored into the Database
        columnsunmatched to the column name unmatchInt to the table ResultUnmatchInt
        columnsunmatchedex to the column name unmatchExt to the table ResultUnmatchExt
        where farm_name = farmName and month = monthName and year = yearName
         */
        co = DataBaseConnection.ConnectDB();
        String getResultInt = "delete from ResultUnmatchInt where month='" + monthLcl + "' and year = '" + yearLcl + "'"
                + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
        String getResultExt = "delete from ResultUnmatchExt where month='" + monthLcl + "' and year = '" + yearLcl + "'"
                + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
        String insertunmatchInt = "insert into ResultUnmatchInt(month, year, farm_name, unmatchInt, month_no, "
                + "sheet_name) values(?,?,?,?,?,?)";
        String insertunmatchExt = "insert into ResultUnmatchExt(month, year, farm_name, unmatchExt, month_no, "
                + "sheet_name) values(?,?,?,?,?,?)";
//        String updateUnmatchInt = "update ResultUnmatchInt set month";
        try {
            getUnmatchedInt_st = co.createStatement();
            getUnmatchedInt_st.execute(getResultInt);

            getUnmatchedExt_st = co.createStatement();
            getUnmatchedExt_st.execute(getResultExt);
            
            insertUnmatchedInt_st = co.prepareStatement(insertunmatchInt);
            for (String unmatchInt : columnsunmatched) {
                insertUnmatchedInt_st.setString(1, monthLcl);
                insertUnmatchedInt_st.setString(2, yearLcl);
                insertUnmatchedInt_st.setString(3, farmName.getText().trim());
                insertUnmatchedInt_st.setString(4, unmatchInt);
                insertUnmatchedInt_st.setInt(5, monthNo);
                insertUnmatchedInt_st.setString(6, sheet_nameLcl);
                insertUnmatchedInt_st.execute();
            }
            insertUnmatchedExt_st = co.prepareStatement(insertunmatchExt);
            for (String unmatchExt : columnsunmatchedex) {
                insertUnmatchedExt_st.setString(1, monthLcl);
                insertUnmatchedExt_st.setString(2, yearLcl);
                insertUnmatchedExt_st.setString(3, farmName.getText().trim());
                insertUnmatchedExt_st.setString(4, unmatchExt);
                insertUnmatchedExt_st.setInt(5, monthNo);
                insertUnmatchedExt_st.setString(6, sheet_nameLcl);
                insertUnmatchedExt_st.execute();
            }
            /**
             * *******************************Match Column Name With last Month
             * data*********************************
             */
            if (monthNo == 1) {
                if (yearLcl.equals("1990")) {
                    unMatchedLastMonthInt.setText("No Past Year Record is present");
                    unmatchedLastMonthEx.setText("No Past Year Record is present");
                } else {
                    int yearInteger = Integer.parseInt(yearLcl) - 1;
                    yearLcl = String.valueOf(yearInteger);
                    monthNo = 12;
                    String getLastMonthUnmatchInt = "select * from ResultUnmatchInt where month_no='" + monthNo + "' and year = '" + yearLcl + "'"
                    + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
            String getLastMonthUnmatchExt = "select * from ResultUnmatchExt where month_no='" + monthNo + "' and year = '" + yearLcl + "'"
                    + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
            //Internal Unmatch List
            ArrayList<String> unmatchIntList = new ArrayList<>();
            ArrayList<String> unmatchIntListEx = new ArrayList<>();
            getLastMonthUnmatchInt_st = co.createStatement();
            getLastMonthUnmatchInt_rs = getLastMonthUnmatchInt_st.executeQuery(getLastMonthUnmatchInt);
            if (getLastMonthUnmatchInt_rs.getString("month") != null) {
                while (getLastMonthUnmatchInt_rs.next()) {
                    unmatchIntList.add(getLastMonthUnmatchInt_rs.getString("unMatchInt"));
                }
            } else {
                System.out.println("No Data in the Result");
            }
            for (String item : columnsunmatched) {
                for (String itemInt : unmatchIntList) {
                    if (item.equals(itemInt)) {
//                        String something = getLastMonthUnmatchInt_rs.getString("unmatchInt");
                        columnsUnmatchedIntLastMonth.add(itemInt);
                    }
                }
            }
            //External unmatch List
            getLastMonthUnmatchExt_st = co.createStatement();
            getLastMonthUnmatchExt_rs = getLastMonthUnmatchExt_st.executeQuery(getLastMonthUnmatchExt);
            if (getLastMonthUnmatchExt_rs.getString("month") != null) {
                while (getLastMonthUnmatchExt_rs.next()) {
                    String something = getLastMonthUnmatchExt_rs.getString("unmatchExt");
                    unmatchIntListEx.add(something);
                }
            } else {
                System.out.println("No Data in the Result");
            }
            for (String item : columnsunmatchedex) {
                for (String itemInt : unmatchIntListEx) {
                    if (item.equals(itemInt)) {
                        columnsUnmatchedExtLastMonth.add(itemInt);
                    }
                }
            }
            /**
             * **********************************Matching with last month
             * done************************************
             */
            unMatchedLastMonthInt.setText(columnsUnmatchedIntLastMonth.toString());
            unmatchedLastMonthEx.setText(columnsUnmatchedExtLastMonth.toString());
            
                }
            }
            else{
            String getLastMonthUnmatchInt = "select * from ResultUnmatchInt where month_no='" + (monthNo - 1) + "' and year = '" + yearLcl + "'"
                    + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
            String getLastMonthUnmatchExt = "select * from ResultUnmatchExt where month_no='" + (monthNo - 1) + "' and year = '" + yearLcl + "'"
                    + " and farm_name='" + farmName.getText().trim() + "' and sheet_name = '" + sheet_nameLcl + "'";
            //Internal Unmatch List
            ArrayList<String> unmatchIntList = new ArrayList<>();
            ArrayList<String> unmatchIntListEx = new ArrayList<>();
            getLastMonthUnmatchInt_st = co.createStatement();
            getLastMonthUnmatchInt_rs = getLastMonthUnmatchInt_st.executeQuery(getLastMonthUnmatchInt);
            if (getLastMonthUnmatchInt_rs.getString("month") != null) {
                while (getLastMonthUnmatchInt_rs.next()) {
                    unmatchIntList.add(getLastMonthUnmatchInt_rs.getString("unMatchInt"));
                }
            } else {
                System.out.println("No Data in the Result");
            }
            for (String item : columnsunmatched) {
                for (String itemInt : unmatchIntList) {
                    if (item.equals(itemInt)) {
//                        String something = getLastMonthUnmatchInt_rs.getString("unmatchInt");
                        columnsUnmatchedIntLastMonth.add(itemInt);
                    }
                }
            }
            //External unmatch List
            getLastMonthUnmatchExt_st = co.createStatement();
            getLastMonthUnmatchExt_rs = getLastMonthUnmatchExt_st.executeQuery(getLastMonthUnmatchExt);
            if (getLastMonthUnmatchExt_rs.getString("month") != null) {
                while (getLastMonthUnmatchExt_rs.next()) {
                    String something = getLastMonthUnmatchExt_rs.getString("unmatchExt");
                    unmatchIntListEx.add(something);
                }
            } else {
                System.out.println("No Data in the Result");
            }
            for (String item : columnsunmatchedex) {
                for (String itemInt : unmatchIntListEx) {
                    if (item.equals(itemInt)) {
                        columnsUnmatchedExtLastMonth.add(itemInt);
                    }
                }
            }
            /**
             * **********************************Matching with last month
             * done************************************
             */
            unMatchedLastMonthInt.setText(columnsUnmatchedIntLastMonth.toString());
            unmatchedLastMonthEx.setText(columnsUnmatchedExtLastMonth.toString());
            
            /**
             * *****************************************Saving data into
             * database ==End==***************************************
             */}
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrmViewMonth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnMatch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch1ActionPerformed
        sheet_name.setText(btnMatch1.getText());
        //=====================================================================
        TableModel model = jTable1.getModel();
        int rowcount = model.getRowCount();
        int columns = model.getColumnCount();
        /**
         * ******************************************
         */
        TableModel model1 = jTable2.getModel(); //get the value from the jtable2..
        int rowcount1 = model1.getRowCount();
        int columns1 = model1.getColumnCount();

        /**
         * ***********************************************
         */
        System.out.println(rowcount + "  " + columns);
        String[][] outputin = new String[rowcount][columns];
        String[][] outputex = new String[rowcount][columns];
        String[] outputintemp = new String[rowcount];
        String[] outputextemp = new String[rowcount];
        ArrayList<String> columnsmatched = new ArrayList<>();
        ArrayList<String> columnsunmatched = new ArrayList<>();
        ArrayList<String> columnsmatchedex = new ArrayList<>();
        ArrayList<String> columnsunmatchedex = new ArrayList<>();
        ArrayList<String> pureUnmatched = new ArrayList<>();
        ArrayList<String> pureUnmatchedex = new ArrayList<>();
        ArrayList<String> columnsUnmatchedIntLastMonth = new ArrayList<>();
        ArrayList<String> columnsUnmatchedExtLastMonth = new ArrayList<>();
        int count = 0, unmatched = 0, pureUnmatchCount = 0;
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputin[row][col] = null;
//                        jTable2.setValueAt(null, row, col);
//                    }
                outputin[row][col] = (String) model.getValueAt(row, col);
//                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputex[row][col] = null;
//                        jTable1.setValueAt(null, row, col);
//                    }
                outputex[row][col] = (String) model1.getValueAt(row, col);
            }
        }
        /**
         * *********************************=Matching
         * Logic=****************************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int col1 = 3; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputintemp[row] = outputin[row][col];
                    outputextemp[row] = outputex[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputintemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputintemp[rowtemp].equals(outputextemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {

                    if (match == elements) {
                        count++;
                        columnsmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputextemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }

                    }
                }
            }
        }
        /**
         * ****************************External to internal
         * match**********************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputin[row][col] = null;
//                        jTable2.setValueAt(null, row, col);
//                    }
                outputin[row][col] = (String) model1.getValueAt(row, col);
//                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputex[row][col] = null;
//                        jTable1.setValueAt(null, row, col);
//                    }
                outputex[row][col] = (String) model.getValueAt(row, col);
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int col1 = 2; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputextemp[row] = outputex[row][col];
                    outputintemp[row] = outputin[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputextemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputextemp[rowtemp].equals(outputintemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {
                    if (match == elements) {
                        count++;
                        columnsmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputintemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }
                    }
                }
            }
        }
        /**
         * ************************************=Matching Logic
         * Ends=********************************************
         */
        lblMatch.setText(String.valueOf(count));
        lblUnmatch.setText(String.valueOf(unmatched));
        lblPureUnmatch.setText(String.valueOf(pureUnmatchCount));

        matchedIntlist.setText(columnsmatched.toString());
        unmatchedInt.setText(columnsunmatched.toString());
        matchedExList.setText(columnsmatchedex.toString());
        unmatchedListEx.setText(columnsunmatchedex.toString());
        pureUnmatchList.setText(pureUnmatched.toString());
        pureUnmatchListEx.setText(pureUnmatchedex.toString());
        System.out.println("columns matched = " + count);
        System.out.println("===========================");
        System.out.println(columnsmatched);
        System.out.println("===========================");
        System.out.println(columnsunmatched);
        /**
         * ***************************Formatting the jTable
         * Sizing*********************************
         */
        /*Resizing the Columns Dynamically*/
        TableColumnModel tcm = jTable1.getColumnModel();
        for (int i = 2; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tcm.getColumn(i);
            column.setPreferredWidth(44);
        }
        TableColumn column = tcm.getColumn(1);
        column.setPreferredWidth(160);
        //Centering jtable data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
    }//GEN-LAST:event_btnMatch1ActionPerformed

    private void btnMatch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch2ActionPerformed
        sheet_name.setText(btnMatch2.getText());
        //==========================================================
        TableModel model = jTable1.getModel();
        int rowcount = model.getRowCount();
        int columns = model.getColumnCount();

        /**
         * ************************************************
         */
        TableModel model3 = jTable3.getModel(); //get the value from the jtable2..
        /**
         * ***********************************************
         */

        System.out.println(rowcount + "  " + columns);
        String[][] outputin = new String[rowcount][columns];
        String[][] outputex = new String[rowcount][columns];
        String[] outputintemp = new String[rowcount];
        String[] outputextemp = new String[rowcount];
        ArrayList<String> columnsmatched = new ArrayList<>();
        ArrayList<String> columnsunmatched = new ArrayList<>();
        ArrayList<String> columnsmatchedex = new ArrayList<>();
        ArrayList<String> columnsunmatchedex = new ArrayList<>();
        ArrayList<String> pureUnmatched = new ArrayList<>();
        ArrayList<String> pureUnmatchedex = new ArrayList<>();
        ArrayList<String> columnsUnmatchedIntLastMonth = new ArrayList<>();
        ArrayList<String> columnsUnmatchedExtLastMonth = new ArrayList<>();
        int count = 0, unmatched = 0, pureUnmatchCount = 0;
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputin[row][col] = null;
//                        jTable2.setValueAt(null, row, col);
//                    }
                outputin[row][col] = (String) model.getValueAt(row, col);
//                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputex[row][col] = null;
//                        jTable1.setValueAt(null, row, col);
//                    }
                outputex[row][col] = (String) model3.getValueAt(row, col);
            }
        }
        /**
         * *********************************=Matching
         * Logic=****************************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int col1 = 3; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputintemp[row] = outputin[row][col];
                    outputextemp[row] = outputex[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputintemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputintemp[rowtemp].equals(outputextemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {

                    if (match == elements) {
                        count++;
                        columnsmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputextemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }

                    }
                }
            }
        }
        /**
         * ****************************External to internal
         * match**********************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputin[row][col] = null;
//                        jTable2.setValueAt(null, row, col);
//                    }
                outputin[row][col] = (String) model3.getValueAt(row, col);
//                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
//                    if (model.getValueAt(row, col) == "") {
////                    outputex[row][col] = null;
//                        jTable1.setValueAt(null, row, col);
//                    }
                outputex[row][col] = (String) model.getValueAt(row, col);
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int col1 = 2; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputextemp[row] = outputex[row][col];
                    outputintemp[row] = outputin[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
//
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
//                    
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputextemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputextemp[rowtemp].equals(outputintemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {
                    if (match == elements) {
                        count++;
                        columnsmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputintemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }
                    }
                }
            }
        }
        /**
         * ************************************=Matching Logic
         * Ends=********************************************
         */
        lblMatch.setText(String.valueOf(count));
        lblUnmatch.setText(String.valueOf(unmatched));
        lblPureUnmatch.setText(String.valueOf(pureUnmatchCount));

        matchedIntlist.setText(columnsmatched.toString());
        unmatchedInt.setText(columnsunmatched.toString());
        matchedExList.setText(columnsmatchedex.toString());
        unmatchedListEx.setText(columnsunmatchedex.toString());
        pureUnmatchList.setText(pureUnmatched.toString());
        pureUnmatchListEx.setText(pureUnmatchedex.toString());
        System.out.println("columns matched = " + count);
        System.out.println("===========================");
        System.out.println(columnsmatched);
        System.out.println("===========================");
        System.out.println(columnsunmatched);
        /**
         * ***************************Formatting the jTable
         * Sizing*********************************
         */
        /*Resizing the Columns Dynamically*/
        TableColumnModel tcm = jTable1.getColumnModel();
        for (int i = 2; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tcm.getColumn(i);
            column.setPreferredWidth(44);
        }
        TableColumn column = tcm.getColumn(1);
        column.setPreferredWidth(160);
        //Centering jtable data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
    }//GEN-LAST:event_btnMatch2ActionPerformed

    private void btnMatch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch3ActionPerformed
        sheet_name.setText(sheet_nameLcl);
        //=======================================================
        TableModel model = jTable1.getModel();
        int rowcount = model.getRowCount();
        int columns = model.getColumnCount();

        System.out.println(rowcount + "  " + columns);
        String[][] outputin = new String[rowcount][columns];
        String[][] outputex = new String[rowcount][columns];
        String[] outputintemp = new String[rowcount];
        String[] outputextemp = new String[rowcount];
        ArrayList<String> columnsmatched = new ArrayList<>();
        ArrayList<String> columnsunmatched = new ArrayList<>();
        ArrayList<String> columnsmatchedex = new ArrayList<>();
        ArrayList<String> columnsunmatchedex = new ArrayList<>();
        ArrayList<String> pureUnmatched = new ArrayList<>();
        ArrayList<String> pureUnmatchedex = new ArrayList<>();
        ArrayList<String> columnsUnmatchedIntLastMonth = new ArrayList<>();
        ArrayList<String> columnsUnmatchedExtLastMonth = new ArrayList<>();
        int count = 0, unmatched = 0, pureUnmatchCount = 0;
        for (int col = 2; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
                //                    if (model.getValueAt(row, col) == "") {
                ////                    outputin[row][col] = null;
                //                        jTable2.setValueAt(null, row, col);
                //                    }
                outputin[row][col] = (String) model.getValueAt(row, col);
                //                    outputintemp[row] = outputin[row][col];
            }
        }
        for (int col = 3; col < columns; col = col + 2) {
            for (int row = 0; row < rowcount; row++) {
                //                    if (model.getValueAt(row, col) == "") {
                ////                    outputex[row][col] = null;
                //                        jTable1.setValueAt(null, row, col);
                //                    }
                outputex[row][col] = (String) model.getValueAt(row, col);
            }
        }
        /**
         * *********************************=Matching
         * Logic=****************************************
         */
        for (int col = 2; col < columns; col = col + 2) {
            for (int col1 = 3; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputintemp[row] = outputin[row][col];
                    outputextemp[row] = outputex[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
                //
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
                //
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputintemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputintemp[rowtemp].equals(outputextemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {

                    if (match == elements) {
                        count++;
                        columnsmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputextemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatched.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }

                    }
                }
            }
        }
        /**
         * ****************************External to internal
         * match**********************************
         */
        for (int col = 3; col < columns; col = col + 2) {
            for (int col1 = 2; col1 < columns; col1 = col1 + 2) {
                for (int row = 0; row < rowcount; row++) {
                    outputextemp[row] = outputex[row][col];
                    outputintemp[row] = outputin[row][col1];
                }
                System.out.println(col + ": output in temp : " + Arrays.toString(outputintemp));
                //
                System.out.println(col1 + ": output ex temp: " + Arrays.toString(outputextemp));
                System.out.println("=================================================");
                int match = 0, elements = 0, nullRow = 0;
                //
                for (int rowtemp = 0; rowtemp < rowcount; rowtemp++) {
                    if (outputextemp[rowtemp] == null) {
                        nullRow++;
                        continue;
                    } else {
                        elements++;
                        if (outputextemp[rowtemp].equals(outputintemp[rowtemp])) {
                            match++;
                            System.out.println("match: " + match + " found");
                        }
                    }
                }
                if (nullRow == rowcount) {
                    unmatched++;
                } else {
                    if (match == elements) {
                        count++;
                        columnsmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                    } else {
                        if (match == 0) {
                            int rowNo = 0;
                            for (int i = 0; i < rowcount; i++) {
                                if (outputintemp[i] == null) {
                                    rowNo++;
                                }
                            }
                            if (rowNo != rowcount) {
                                pureUnmatchCount++;
                                pureUnmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            } else {
                                unmatched++;
                                columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                            }
                        } else {
                            unmatched++;
                            columnsunmatchedex.add(model.getColumnName(col) + "/" + model.getColumnName(col1));
                        }
                    }
                }
            }
        }
        /**
         * ************************************=Matching Logic
         * Ends=********************************************
         */
        lblMatch.setText(String.valueOf(count));
        lblUnmatch.setText(String.valueOf(unmatched));
        lblPureUnmatch.setText(String.valueOf(pureUnmatchCount));

        matchedIntlist.setText(columnsmatched.toString());
        unmatchedInt.setText(columnsunmatched.toString());
        matchedExList.setText(columnsmatchedex.toString());
        unmatchedListEx.setText(columnsunmatchedex.toString());
        pureUnmatchList.setText(pureUnmatched.toString());
        pureUnmatchListEx.setText(pureUnmatchedex.toString());
        System.out.println("columns matched = " + count);
        System.out.println("===========================");
        System.out.println(columnsmatched);
        System.out.println("===========================");
        System.out.println(columnsunmatched);
        /**
         * ***************************Formatting the jTable
         * Sizing*********************************
         */
        /*Resizing the Columns Dynamically*/
        TableColumnModel tcm = jTable1.getColumnModel();
        for (int i = 2; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tcm.getColumn(i);
            column.setPreferredWidth(44);
        }
        TableColumn column = tcm.getColumn(1);
        column.setPreferredWidth(160);
        //Centering jtable data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        /**
         * *************************************Formatting table data
         * Completed*******************************************
         */

    }//GEN-LAST:event_btnMatch3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnMatch1;
    private javax.swing.JButton btnMatch2;
    private javax.swing.JButton btnMatch3;
    public javax.swing.JLabel farmName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblMatch;
    private javax.swing.JLabel lblPureUnmatch;
    private javax.swing.JLabel lblTotalMatch;
    private javax.swing.JLabel lblTotalUnmatch;
    private javax.swing.JLabel lblTotalUnmatch1;
    private javax.swing.JLabel lblUnmatch;
    private javax.swing.JLabel matchedExList;
    private javax.swing.JLabel matchedIntlist;
    private javax.swing.JLabel month;
    private javax.swing.JLabel pureUnmatchList;
    private javax.swing.JLabel pureUnmatchListEx;
    public javax.swing.JLabel sheet_name;
    private javax.swing.JLabel unMatchedLastMonthInt;
    private javax.swing.JLabel unmatchedInt;
    private javax.swing.JLabel unmatchedLastMonthEx;
    private javax.swing.JLabel unmatchedListEx;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
