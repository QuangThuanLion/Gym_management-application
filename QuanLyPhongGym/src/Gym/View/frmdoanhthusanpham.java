/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import Controller.connectDB;
import Gym.Controller.ControllerDoanhThuSanPham;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import Gym.Model.DoanhThuSanPham;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class frmdoanhthusanpham extends javax.swing.JFrame {

    /**
     * Creates new form frmdoanhthusanpham
     */
    
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Statement stt = null;
    ControllerDoanhThuSanPham controllerDoanhThuSanPham = null;
    DefaultTableModel model = null;
    DoanhThuSanPham doanhThuSanPham = null;
    public frmdoanhthusanpham() {
        initComponents();
        setLocationRelativeTo(null);
        loadDaTaDoanhThuSanPham();
        loadCBTENDMSP();
        loadCBTENSP();
        getSumTongSoLuong();
        getSumTongGia();
    }

    public void loadCBTENDMSP(){
        controllerDoanhThuSanPham = new ControllerDoanhThuSanPham();
        ArrayList<String> listCBTDMSP = controllerDoanhThuSanPham.loadCBTENDMSP();
        for(String item: listCBTDMSP){
            this.cbdanhmucSP.addItem(item.toString());
        }
    }
    public void loadCBTENSP(){
        controllerDoanhThuSanPham = new ControllerDoanhThuSanPham();       
        ArrayList<String> listCBTSP = controllerDoanhThuSanPham.loadCBTENSP();
        for(String item: listCBTSP){
            this.cbtenSP.addItem(item.toString());
        }
    }
    
    // Load DataDoanhThuSanPham
    
    public void loadDaTaDoanhThuSanPham(){
    
        model = new DefaultTableModel();
        
        Vector colum = new Vector();
        
        colum.add("Ma HD");
        colum.add("Ma SP");
        colum.add("Ma DM");
        colum.add("Ten DM");
        colum.add("Ten SP");
        colum.add("Gia Nhap");
        colum.add("SL đa ban");
        colum.add("Gia ban");
        colum.add("Tong gia");
        colum.add("Ngay ban");
        colum.add("Tình trang");
        colum.add("Ma NPPSP");
        colum.add("Ten NPPSP");
        
        model.setColumnIdentifiers(colum);
        
        controllerDoanhThuSanPham = new ControllerDoanhThuSanPham();
        List<DoanhThuSanPham> listDoanhThu = controllerDoanhThuSanPham.getDoanhThuSanPhamFromDB();
        for(int i =0; i<listDoanhThu.size();i++){
            
            DoanhThuSanPham doanhThuSanPham = (DoanhThuSanPham)listDoanhThu.get(i);
            
            //câu lệnh trên có thể thay thế bằng câu lệnh dưới đây
//            
//            doanhThuSanPham  = new DoanhThuSanPham();
//            doanhThuSanPham = listDoanhThu.get(i);
            
            Vector row = new Vector();
            
            row.add(doanhThuSanPham.getMaHD());
            row.add(doanhThuSanPham.getMaSP());
            row.add(doanhThuSanPham.getMaDM());
            row.add(doanhThuSanPham.getTenDM());
            row.add(doanhThuSanPham.getTenSP());
            row.add(doanhThuSanPham.getGiaNhap());
            row.add(doanhThuSanPham.getSoLuong());
            row.add(doanhThuSanPham.getGiaBan());
            row.add(doanhThuSanPham.getTongGia());
            row.add(doanhThuSanPham.getNgayBan());
            row.add(doanhThuSanPham.getTinhTrang());
            row.add(doanhThuSanPham.getMaNPPSP());
            row.add(doanhThuSanPham.getTenNPPSP());
            
            model.addRow(row);
            
        }
        this.tbdoanhthusanpham.setModel(model); 
        this.lbtongsanpham.setText("" + tbdoanhthusanpham.getRowCount() + " sản phẩm "); 
//        getSumTongGia();
    }
    
    public void getSumTongSoLuong(){
    
        int tongSL = 0;
        
        for(int i = 0; i<this.tbdoanhthusanpham.getRowCount();i++){
        
            tongSL = tongSL + Integer.parseInt(this.tbdoanhthusanpham.getValueAt(i, 6).toString());
        }
         this.lbtongsoluong.setText(Integer.toString(tongSL));
    }
    
    public void getSumTongGia(){
    
        float tongGia = 0;
        
        for(int i = 0; i<this.tbdoanhthusanpham.getRowCount();i++){
        
            tongGia = tongGia + Float.parseFloat(this.tbdoanhthusanpham.getValueAt(i, 8).toString());
        }
         this.lbtongdoanhthu.setText(Float.toString(tongGia));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btfresh = new javax.swing.JButton();
        btsearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbtenSP = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbdanhmucSP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdoanhthusanpham = new javax.swing.JTable();
        lbtongsoluong = new javax.swing.JLabel();
        lbtongdoanhthu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datengayban = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        lbtongsanpham = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doanh thu sản phẩm");
        setLocation(new java.awt.Point(210, 70));
        setMaximizedBounds(new java.awt.Rectangle(30, 50, 1500, 800));
        setResizable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/excel.png"))); // NOI18N
        jButton3.setText("Xuất excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THỐNG KÊ DOANH THU TỪ SẢN PHẨM");

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

        btfresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        btfresh.setText("Làm mới");
        btfresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfreshActionPerformed(evt);
            }
        });

        btsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkiem.png"))); // NOI18N
        btsearch.setText("Tìm kiếm");
        btsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/luachon.png"))); // NOI18N
        jLabel2.setText("Lựa chọn");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/danhsach.png"))); // NOI18N
        jLabel12.setText("Bảng thống kê từ sản phẩm");

        cbtenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "           ---TÊN SẢN PHẨM---" }));
        cbtenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtenSPActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên SP");

        jLabel3.setText("Tên DMSP");

        cbdanhmucSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ----DANH MỤC SẢN PHẨM---" }));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1300, 500));

        tbdoanhthusanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã SP", "Mã DM", "Tên DM", "Tên SP", "Giá Nhập", "Số lượng đã bán", "Giá bán", "Tổng giá", "Ngày bán", "Tình trạng", "Mã NPPSP", "Tên NPPSP"
            }
        ));
        tbdoanhthusanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdoanhthusanphamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbdoanhthusanpham);

        jScrollPane1.setViewportView(jScrollPane2);

        lbtongsoluong.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongsoluong.setForeground(new java.awt.Color(0, 51, 255));
        lbtongsoluong.setText("Tổng số lượng");

        lbtongdoanhthu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongdoanhthu.setForeground(new java.awt.Color(0, 0, 255));
        lbtongdoanhthu.setText("Tổng doanh thu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Tổng Doanh Thu");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Tổng số lượng");

        jLabel4.setText("Ngày bán");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Tổng sản phẩm");

        lbtongsanpham.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongsanpham.setForeground(new java.awt.Color(51, 51, 255));
        lbtongsanpham.setText("Tổng sản phẩm");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbtongsoluong)
                                            .addComponent(lbtongsanpham))
                                        .addGap(49, 49, 49))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel3))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btsearch)
                                            .addComponent(btfresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbtenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbdanhmucSP, 0, 185, Short.MAX_VALUE)
                                                .addComponent(datengayban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lbtongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbdanhmucSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbtenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(datengayban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(btsearch)
                        .addGap(18, 18, 18)
                        .addComponent(btfresh)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbtongsanpham))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbtongsoluong))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbtongdoanhthu))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addComponent(jLabel2)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbtenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtenSPActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // xuất excel
        exportExcel_TH(tbdoanhthusanpham);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    
    private void tbdoanhthusanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdoanhthusanphamMouseClicked
        // get dữ liệu từ table qua text field
        
        int row = this.tbdoanhthusanpham.getSelectedRow();
        try{
            if(row != -1 ){
           
                this.cbdanhmucSP.setSelectedItem(tbdoanhthusanpham.getValueAt(row,3).toString());
                this.cbtenSP.setSelectedItem(tbdoanhthusanpham.getValueAt(row,4).toString());

                try
                {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tbdoanhthusanpham.getValueAt(row,9).toString());
                    this.datengayban.setDate(date);
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
        
    }//GEN-LAST:event_tbdoanhthusanphamMouseClicked

    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        // tìm kiếm sản phẩm 
        
        if(this.cbdanhmucSP.getSelectedItem()==null && this.cbtenSP.getSelectedItem()==null)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giá trị để tìm kiếm !","Thông báo",2);
            this.cbtenSP.requestFocus();
            return;
        }
//        
//         if(this.cbtenSP.getSelectedObjects()!= null && this.cbtenSP.getSelectedObjects()!=null)
//        {
//            JOptionPane.showMessageDialog(null, "Không được nhập giá trị tìm kiếm vào 2 ô !","Thông báo",2);
//            this.cbtenSP.requestFocus();
//            return;
//        }      
        
        if(this.cbdanhmucSP.getSelectedItem()!=null)
        {
            findKhachHangTheoTDMSP((String) this.cbdanhmucSP.getSelectedItem());
            this.lbtongsanpham.setText(""+this.tbdoanhthusanpham.getRowCount()+" sản phẩm ");
            getSumTongSoLuong();
            getSumTongGia();

            if(this.cbtenSP.getSelectedItem()!=null)
                {
                    findKhachHangTheoTenSP((String) this.cbtenSP.getSelectedItem());
                    this.lbtongsanpham.setText(""+this.tbdoanhthusanpham.getRowCount()+"");
                    getSumTongSoLuong();
                    getSumTongGia();
//                    return;
                }
            return;
        }
//        
//        if(this.cbtenSP.getSelectedItem()!=null)
//        {
//            findKhachHangTheoTenSP((String) this.cbtenSP.getSelectedItem());
//            this.lbtongsanpham.setText(""+this.tbdoanhthusanpham.getRowCount()+"");
//            getSumTongSoLuong();
//            getSumTongGia();
//            return;
//        }
        
    }//GEN-LAST:event_btsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // load data doanh thu
        
        loadDaTaDoanhThuSanPham();
        getSumTongSoLuong();
        getSumTongGia();
    }//GEN-LAST:event_jButton1ActionPerformed
       
    public void refresh(){

        java.util.Date date = new java.util.Date();
        
        this.datengayban.setDate(date);    
        this.cbdanhmucSP.setSelectedItem(null);
        this.cbtenSP.setSelectedItem(null);

       }
    private void btfreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfreshActionPerformed
        
        refresh();       
        
    }//GEN-LAST:event_btfreshActionPerformed
    
    // tìm kiếm theo tên danh mục sản phẩm
    
     public void findKhachHangTheoTDMSP(String TenDM){
        
        String sql = "SELECT * FROM View_DoanhThuSanPham where TenDM like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +TenDM+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }

            while(rs.next()){
                
                doanhThuSanPham = new DoanhThuSanPham();
                    
                    doanhThuSanPham.setMaHD(rs.getString("MaHD"));
                    doanhThuSanPham.setMaSP(rs.getString("MaSP"));
                    doanhThuSanPham.setMaDM(rs.getString("MaDM"));
                    doanhThuSanPham.setTenDM(rs.getString("TenDM"));
                    doanhThuSanPham.setTenSP(rs.getString("TenSP"));
                    doanhThuSanPham.setGiaNhap(rs.getFloat("Dongia"));
                    doanhThuSanPham.setSoLuong(rs.getInt("Soluong"));
                    doanhThuSanPham.setGiaBan(rs.getFloat("Giaban"));
                    doanhThuSanPham.setTongGia(rs.getFloat("TongGia"));
                    doanhThuSanPham.setNgayBan(rs.getDate("Ngayban"));
                    doanhThuSanPham.setTinhTrang(rs.getString("TinhTrang"));
                    doanhThuSanPham.setMaNPPSP(rs.getString("MaNhaPPSS"));
                    doanhThuSanPham.setTenNPPSP(rs.getString("TenNhaPPSS"));

                    
                    Vector row = new Vector();
                    row.add(doanhThuSanPham.getMaHD());
                    row.add(doanhThuSanPham.getMaSP());
                    row.add(doanhThuSanPham.getMaDM());
                    row.add(doanhThuSanPham.getTenDM());
                    row.add(doanhThuSanPham.getTenSP());
                    row.add(doanhThuSanPham.getGiaNhap());
                    row.add(doanhThuSanPham.getSoLuong());
                    row.add(doanhThuSanPham.getGiaBan());
                    row.add(doanhThuSanPham.getTongGia());
                    row.add(doanhThuSanPham.getNgayBan());
                    row.add(doanhThuSanPham.getTinhTrang());
                    row.add(doanhThuSanPham.getMaNPPSP());
                    row.add(doanhThuSanPham.getTenNPPSP());
                    

                model.addRow(row);
                 
            }
            this.tbdoanhthusanpham.setModel(model);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
         
     // tìm kiếm theo tên sản phẩm
     
      public void findKhachHangTheoTenSP(String TenSP){
        
        String sql = "SELECT * FROM View_DoanhThuSanPham where TenSP like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +TenSP+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }

            while(rs.next()){
                
                doanhThuSanPham = new DoanhThuSanPham();
                    
                    doanhThuSanPham.setMaHD(rs.getString("MaHD"));
                    doanhThuSanPham.setMaSP(rs.getString("MaSP"));
                    doanhThuSanPham.setMaDM(rs.getString("MaDM"));
                    doanhThuSanPham.setTenDM(rs.getString("TenDM"));
                    doanhThuSanPham.setTenSP(rs.getString("TenSP"));
                    doanhThuSanPham.setGiaNhap(rs.getFloat("Dongia"));
                    doanhThuSanPham.setSoLuong(rs.getInt("Soluong"));
                    doanhThuSanPham.setGiaBan(rs.getFloat("Giaban"));
                    doanhThuSanPham.setTongGia(rs.getFloat("TongGia"));
                    doanhThuSanPham.setNgayBan(rs.getDate("Ngayban"));
                    doanhThuSanPham.setTinhTrang(rs.getString("TinhTrang"));
                    doanhThuSanPham.setMaNPPSP(rs.getString("MaNhaPPSS"));
                    doanhThuSanPham.setTenNPPSP(rs.getString("TenNhaPPSS"));

                    
                    Vector row = new Vector();
                    row.add(doanhThuSanPham.getMaHD());
                    row.add(doanhThuSanPham.getMaSP());
                    row.add(doanhThuSanPham.getMaDM());
                    row.add(doanhThuSanPham.getTenDM());
                    row.add(doanhThuSanPham.getTenSP());
                    row.add(doanhThuSanPham.getGiaNhap());
                    row.add(doanhThuSanPham.getSoLuong());
                    row.add(doanhThuSanPham.getGiaBan());
                    row.add(doanhThuSanPham.getTongGia());
                    row.add(doanhThuSanPham.getNgayBan());
                    row.add(doanhThuSanPham.getTinhTrang());
                    row.add(doanhThuSanPham.getMaNPPSP());
                    row.add(doanhThuSanPham.getTenNPPSP());
                    

                model.addRow(row);
                 
            }
            this.tbdoanhthusanpham.setModel(model);
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(frmdoanhthusanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthusanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthusanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdoanhthusanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmdoanhthusanpham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btfresh;
    private javax.swing.JButton btsearch;
    private javax.swing.JComboBox<String> cbdanhmucSP;
    private javax.swing.JComboBox<String> cbtenSP;
    private com.toedter.calendar.JDateChooser datengayban;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbtongdoanhthu;
    private javax.swing.JLabel lbtongsanpham;
    private javax.swing.JLabel lbtongsoluong;
    private javax.swing.JTable tbdoanhthusanpham;
    // End of variables declaration//GEN-END:variables
}
