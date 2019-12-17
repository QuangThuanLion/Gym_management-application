/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.View;


import java.util.List;
import Gym.Controller.ControllerDoanhThuKH;
import Gym.Model.DoanhThuKhachHang;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.connectDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class frmdoanhthukhachhang extends javax.swing.JFrame {

    /**
     * Creates new form frmdoanhthukhachhang
     */
    DoanhThuKhachHang doanhThuKhachHang = null;
    DefaultTableModel model = null;
    ControllerDoanhThuKH controllerDoanhThuKH = new ControllerDoanhThuKH();
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Statement stt = null;
    
    public frmdoanhthukhachhang() {
        initComponents();
        setLocationRelativeTo(null);
        loadDaTaDoanhThuKH();
        loadCBGDK();
        
    }
    
    //load data len giao dien
    
    public void loadDaTaDoanhThuKH(){
      
        model = new DefaultTableModel();
        // tao vector day vao cot header
        
        Vector colum = new Vector();
        
        colum.add("Ho Ten");
        colum.add("Ma Goi DK");
        colum.add("Ten Goi DK");
        colum.add("Don Gia");
        colum.add("Ngay DK");
        colum.add("Ngay HHDK");
        
        //add colum vao model
        model.setColumnIdentifiers(colum);
        
        List<DoanhThuKhachHang> listDoanhThu = controllerDoanhThuKH.getDoanhThuFromDB();
        for(int i = 0; i< listDoanhThu.size(); i++){
                
            DoanhThuKhachHang doanhThuKhachHang = (DoanhThuKhachHang)listDoanhThu.get(i);
            //add row vao vector
             
            Vector row = new Vector();
            row.add(doanhThuKhachHang.getHoTen());
            row.add(doanhThuKhachHang.getMaGDK());
            row.add(doanhThuKhachHang.getTenGDK());
            row.add(doanhThuKhachHang.getDonGia());
            row.add(doanhThuKhachHang.getNgayDK());
            row.add(doanhThuKhachHang.getNgayHHDK());
           
            model.addRow(row);
        }
        this.tbdoanhthukhachhang.setModel(model);
        this.lbtongso.setText("" + tbdoanhthukhachhang.getRowCount() + " khách hàng ");
        getSumTongGia();
    }
    
    
    public void getSumTongGia(){
    
        int tongGia = 0;
        
        for(int i = 0; i< this.tbdoanhthukhachhang.getRowCount(); i++){
        
            tongGia = tongGia + Integer.parseInt(this.tbdoanhthukhachhang.getValueAt(i, 3).toString());
        }
        this.lbdongia.setText(Integer.toString(tongGia));
    }
    
    
    public void loadCBGDK(){
               
        ArrayList<String> listCBGDK = controllerDoanhThuKH.loadCBGDK();
        for(String item: listCBGDK){
            this.cbgdk.addItem(item.toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbgdk = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btsearch = new javax.swing.JButton();
        btfresh = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        datedenngay = new com.toedter.calendar.JDateChooser();
        datetungay = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdoanhthukhachhang = new javax.swing.JTable();
        txt12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbdongia = new javax.swing.JLabel();
        lbtongso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doanh thu từ khách hàng");
        setLocation(new java.awt.Point(250, 50));
        setMaximizedBounds(new java.awt.Rectangle(30, 50, 1300, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THỐNG KÊ DOANH THU TỪ KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/luachon.png"))); // NOI18N
        jLabel2.setText("Lựa chọn");

        jLabel3.setText("Chọn gói");

        jLabel10.setText("Đến ngày");

        jLabel11.setText("Từ ngày");

        btsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkiem.png"))); // NOI18N
        btsearch.setText("Tìm kiếm");
        btsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchActionPerformed(evt);
            }
        });

        btfresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        btfresh.setText("Làm mới");
        btfresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfreshActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/danhsach.png"))); // NOI18N
        jLabel12.setText("Bảng thống kê từ khách hàng");

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/excel.png"))); // NOI18N
        jButton3.setText("Xuất excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 500));

        tbdoanhthukhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Tên", "Mã GĐK", "Gói ĐK", "Đơn giá", "Từ ngày", "Đến ngày"
            }
        ));
        tbdoanhthukhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdoanhthukhachhangMouseClicked(evt);
            }
        });
        tbdoanhthukhachhang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbdoanhthukhachhangKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbdoanhthukhachhang);

        jScrollPane1.setViewportView(jScrollPane2);

        txt12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt12.setForeground(new java.awt.Color(255, 51, 0));
        txt12.setText("Tổng số :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tổng doanh thu :");

        lbdongia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbdongia.setForeground(new java.awt.Color(51, 51, 255));
        lbdongia.setText("Giá trị đơn giá");

        lbtongso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongso.setForeground(new java.awt.Color(0, 0, 255));
        lbtongso.setText("Tổng số KH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datedenngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datetungay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(cbgdk, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btsearch)
                                    .addComponent(btfresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txt12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbdongia, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(lbtongso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 155, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(datetungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(datedenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbgdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btsearch)
                        .addGap(18, 18, 18)
                        .addComponent(btfresh)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt12)
                            .addComponent(lbtongso))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbdongia)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbdoanhthukhachhangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbdoanhthukhachhangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbdoanhthukhachhangKeyPressed

    private void tbdoanhthukhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdoanhthukhachhangMouseClicked
        // hiển thị lên trên text field

        int row = this.tbdoanhthukhachhang.getSelectedRow();
        try{
            if(row != -1 ){
           
                this.cbgdk.setSelectedItem(tbdoanhthukhachhang.getValueAt(row,2).toString());

                try
                {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tbdoanhthukhachhang.getValueAt(row,4).toString());
                    this.datetungay.setDate(date);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                try
                {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tbdoanhthukhachhang.getValueAt(row,5).toString());
                    this.datedenngay.setDate(date);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

        }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbdoanhthukhachhangMouseClicked

        public void findKhachHangTheoCB(String Tengoi){
        
        String sql = "SELECT * FROM View_DoanhThuKhachHang where Tengoi like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +Tengoi+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }

            while(rs.next()){
                
                doanhThuKhachHang = new DoanhThuKhachHang();

                    doanhThuKhachHang.setHoTen(rs.getString("Hoten"));
                    doanhThuKhachHang.setMaGDK(rs.getString("MaGoiDk"));
                    doanhThuKhachHang.setTenGDK(rs.getString("Tengoi"));
                    doanhThuKhachHang.setDonGia(rs.getInt("Dongia"));
                    doanhThuKhachHang.setNgayDK(rs.getDate("NgayDK"));
                    doanhThuKhachHang.setNgayHHDK(rs.getDate("NgayHetHanDk"));
                    
                    Vector row = new Vector();
                    row.add(doanhThuKhachHang.getHoTen());
                    row.add(doanhThuKhachHang.getMaGDK());
                    row.add(doanhThuKhachHang.getTenGDK());
                    row.add(doanhThuKhachHang.getDonGia());
                    row.add(doanhThuKhachHang.getNgayDK());
                    row.add(doanhThuKhachHang.getNgayHHDK());

                model.addRow(row);
                 
            }
            this.tbdoanhthukhachhang.setModel(model);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
//         public void findKhachHangTheoNgay(Date date, Date date1){
//        
//        String sql = "SELECT * FROM View_DoanhThuKhachHang WHERE NgayDK BETWEEN CAST('date' AS DATE) AND CAST('date1' AS DATE)";
//            doanhThuKhachHang = new DoanhThuKhachHang();
//        try
//        {   
//           Date tuNgay= doanhThuKhachHang.getNgayDK();
//           Date denNgay = doanhThuKhachHang.getNgayHHDK();
//            conn = connectDB.connectSQLServer();
//            pst = conn.prepareStatement(sql);
//            pst.setDate(1, (java.sql.Date) tuNgay);
//            pst.setDate(2, (java.sql.Date) denNgay);
//            rs = pst.executeQuery();
//            
//            while(model.getRowCount()>0){
//                model.removeRow(0);
//            }
//
//            while(rs.next()){
//                
//                doanhThuKhachHang = new DoanhThuKhachHang();
//                
//                    doanhThuKhachHang.setMaGDK(rs.getString("MaGoiDk"));
//                    doanhThuKhachHang.setTenGDK(rs.getString("Tengoi"));
//                    doanhThuKhachHang.setDonGia(rs.getInt("Dongia"));
//                    doanhThuKhachHang.setNgayDK(rs.getDate("NgayDK"));
//                    doanhThuKhachHang.setNgayHHDK(rs.getDate("NgayHetHanDk"));
//                    
//                    Vector row = new Vector();
//                    row.add(doanhThuKhachHang.getMaGDK());
//                    row.add(doanhThuKhachHang.getTenGDK());
//                    row.add(doanhThuKhachHang.getDonGia());
//                    row.add(doanhThuKhachHang.getNgayDK());
//                    row.add(doanhThuKhachHang.getNgayHHDK());
//
//                model.addRow(row);
//                 
//            }
//            this.tbdoanhthukhachhang.setModel(model);
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(this, "Error: " +e.getMessage());
//        }
//    }
         
         
    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        // tìm kiếm thông tin khách hàng
        
        if(this.cbgdk.getSelectedItem()==null)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giá trị cần tìm kiếm !","Thông báo",2);
            this.cbgdk.requestFocus();
            return;
        }

        if(this.cbgdk.getSelectedItem()!=null)
        {
            findKhachHangTheoCB((String) this.cbgdk.getSelectedItem());
            this.lbtongso.setText(""+this.tbdoanhthukhachhang.getRowCount()+" khách hàng ");
            getSumTongGia();
            return;
        }
        
//        findKhachHangTheoNgay(this.datetungay, this.datedenngay);
    }//GEN-LAST:event_btsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // load lai data
        loadDaTaDoanhThuKH();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void refresh(){

        java.util.Date date = new java.util.Date();
        
        this.datetungay.setDate(date);
        this.datedenngay.setDate(date);
        
        this.cbgdk.setSelectedItem(null);

       }

    private void btfreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfreshActionPerformed

        refresh();
    }//GEN-LAST:event_btfreshActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // export excel
        
        exportExcel_TH(tbdoanhthukhachhang);
    }//GEN-LAST:event_jButton3ActionPerformed
    
        // Xuất file excel
    public void exportExcel_TH(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }
    
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthukhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthukhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthukhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthukhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmdoanhthukhachhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btfresh;
    private javax.swing.JButton btsearch;
    private javax.swing.JComboBox<String> cbgdk;
    private com.toedter.calendar.JDateChooser datedenngay;
    private com.toedter.calendar.JDateChooser datetungay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbdongia;
    private javax.swing.JLabel lbtongso;
    private javax.swing.JTable tbdoanhthukhachhang;
    private javax.swing.JLabel txt12;
    // End of variables declaration//GEN-END:variables
}
