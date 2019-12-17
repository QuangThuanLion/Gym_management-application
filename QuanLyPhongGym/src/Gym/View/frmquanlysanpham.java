/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.View;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import Controller.connectDB;
import Gym.Controller.ControllerNhanVien;
import Gym.Controller.ControllerSanPham;
import java.text.SimpleDateFormat;
import Gym.Model.SanPham;
import Gym.Model.ThongTinSanPham;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class frmquanlysanpham extends javax.swing.JFrame {
    /**
     * Creates new form frmquanlysanpham
     */
    DefaultTableModel model;
    ControllerSanPham controllerSanPham = new ControllerSanPham();
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
//    String filename = null;
//    byte[] image_product = null;
    
    public frmquanlysanpham() {
        initComponents();
        setLocationRelativeTo(null);
        loadDaTaSanPham();
        loadCBDMSP();
        loadCBTENSP();
        LoadCBNPPSP();
        ProcessAction(false);
        //gọi hàm khi load Jcombobox
        //Tiếp theo là xử lý khi chọn dòng dữ liệu trong CBbox
//        String sqlcbNPP = "SELECT *FROM NHAPHANPHOISANPHAM";
//        LoadDataCB(sqlcbNPP,this.cbNPP, "TenNhaPPSS");
//        String sqlcbTSP = "SELECT *FROM TENSANPHAM";
//        LoadDataCB(sqlcbTSP, cbTSP, "TenSP");
    }
    
    public void loadDaTaSanPham(){
        model = new DefaultTableModel();
        //set colum cho title - headers
        Vector colum = new Vector();
        colum.add("Mã SP");
        colum.add("Mã DM");
        colum.add("Tên DM");
        colum.add("Tên SP");
        colum.add("Mã NPPSP");
        colum.add("NPP");
        colum.add("Số Lượng");
        colum.add("Giá Cả");
        colum.add("T.Gian Nhận");
        colum.add("Tổng Giá (VNĐ)");
        colum.add("Chi Chú");
        //add colum headers vao model
        model.setColumnIdentifiers(colum);
        
        // set coumn cho data hien thi tren table
        List<ThongTinSanPham> listSanPham = controllerSanPham.getSanPhamFromDB();
        for(int i=0;i<listSanPham.size(); i++){
            
            ThongTinSanPham sanPham = (ThongTinSanPham)listSanPham.get(i);
            Vector row = new Vector();
            row.add(sanPham.getMaSP());
            row.add(sanPham.getMaDM());
            row.add(sanPham.getTenDM());
            row.add(sanPham.getTenSP());
            row.add(sanPham.getMaNPPSP());
            row.add(sanPham.getNhaPP());
            row.add(sanPham.getSoLuong());
            row.add(sanPham.getDonGia());
            row.add(sanPham.getThoiGianNhan());
            row.add(sanPham.getTongGia());
            row.add(sanPham.getGhiChu());
            
            //add row data vao model
            model.addRow(row);        
        }
        //set model cho table
        this.tbSanpham.setModel(model);
    }
    
    public void loadCBDMSP(){
               
        ArrayList<String> listCBDMSP = controllerSanPham.loadCBDMSP();
        for(String item: listCBDMSP){
            this.cbDMSP.addItem(item.toString());
        }
    }
    public void loadCBTENSP(){
               
        ArrayList<String> listCBTSP = controllerSanPham.loadCBTENSP();
        for(String item: listCBTSP){
            this.cbTenSP.addItem(item.toString());
        }
    }
    public void LoadCBNPPSP(){
               
        ArrayList<String> listCBNPPSP = controllerSanPham.LoadCBNPPSP();
        for(String item: listCBNPPSP){
            this.cbNPPSP.addItem(item.toString());
        }
    }
    
    public void ProcessAction(boolean a){
         this.btAdd.setEnabled(a);
         this.btDelete.setEnabled(a);
         this.btEdit.setEnabled(a);
           
    }
//    public void LoadDataCB(String sql,JComboBox cb ,String bien){
//    
//        
//        try
//          {
//              conn = connectDB.connectSQLServer();
//              pst = conn.prepareStatement(sql);
//              rs = pst.executeQuery();
//              while(rs.next()){
//                  cb.addItem(rs.getString(bien));
//              }
//          }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,e,"Thông báo lỗi",1);
//        }
//    }
//    public void LoadCBLoaiSP(){
//        
//        String sql = "SELECT * FROM DANHMUCSANPHAM";
//        LoadDataCB(sql, this.cbLoaiSP, "TenSP");
//    }
//    public void LoadCBTenSP(){
//        String sql = "SELECT *FROM TENSANPHAM";
//        LoadDataCB(sql, this.cbtenSP, "TenSP");
//    }
//    public void LoadCPNPP(){
//        String sql = "SELECT * FROM NHAPHANPHOISANPHAM";
//        LoadDataCB(sql, this.cbNPPSS, "TenNhaPPSS");
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbNPPSP = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        cbTenSP = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbDMSP = new javax.swing.JComboBox<>();
        lbhinhanh = new javax.swing.JLabel();
        butimage = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtMSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttonggia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSanpham = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        txtgiaca = new javax.swing.JTextField();
        datethoigiannhan = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm mới sản phẩm");
        setLocation(new java.awt.Point(250, 10));
        setMaximizedBounds(new java.awt.Rectangle(30, 10, 1300, 670));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        btAdd.setText("Thêm");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        btEdit.setText("Sửa");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        btDelete.setText("Xóa");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        btRefresh.setText("Làm mới");
        btRefresh.setOpaque(false);
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/info.png"))); // NOI18N
        jLabel2.setText("Thông tin chi tiết");

        jLabel4.setText("Mã DMSP");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Giá cả");

        jLabel7.setText("Nhà phân phối");

        jLabel8.setText("Ghi chú");

        cbNPPSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ----MÃ NHÀ PHÂN PHỐI----" }));
        cbNPPSP.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbNPPSPPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbNPPSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNPPSPActionPerformed(evt);
            }
        });

        jScrollPane5.setPreferredSize(new java.awt.Dimension(250, 200));

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane5.setViewportView(txtghichu);

        jLabel11.setText("Mã SP");

        cbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "        --TÊN SẢN PHẨM--" }));
        cbTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenSPActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        cbDMSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       ---CHỌN MÃ DANH MỤC---" }));
        cbDMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDMSPActionPerformed(evt);
            }
        });

        lbhinhanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        butimage.setText("Hình ảnh");
        butimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butimageActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên SP");

        jLabel9.setText("Thời gian nhận");

        txttonggia.setText("00");

        jScrollPane6.setPreferredSize(new java.awt.Dimension(1000, 800));

        tbSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Ma DM", "Tên DM", "Tên SP", "Ma NPPSP", "NPP", "Số lượng", "Giá cả", "Thời gian nhận", "Tổng giá", "Ghi chú"
            }
        ));
        tbSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanphamMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbSanpham);

        jScrollPane1.setViewportView(jScrollPane6);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"DM01", "SẢN PHẨM CHỨC NĂNG - BỔ SUNG"},
                {"DM02", "SẢN PHẨM NƯỚC UỐNG - GIẢI KHÁT"},
                {"DM03", "SẢN PHẨM BẢO VỆ CÁ NHÂN"}
            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(300, 100));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(600, 50));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NPPSS01", "DM01", "Cửa hàng vật tư thể hình Đông Giang", "35 Trường Chinh - Đà Nẵng"},
                {"NPPSP02", "DM01", "Nhà PP BBT WHEY SHOP", "120 Cộng Hòa - TP. Hồ Chí Minh"},
                {"NPPSP03", "DM02", "Công ty TNHH Lavie", "40 Từ Liên - Hà Nội"},
                {"NPPSP04", "DM02", "Công ty TNHH SUNTORY PEPSICO Việt Nam", "10 Hai Bà Trưng - Hà Nội"},
                {"NPPSP05", "DM03", "Cửa hàng sỉ lẻ - bảo hộ FNI", "60 Nguyễn Văn Linh - Đà Nẵng"},
                {"NPPSP06", "DM03", "Nhà PP SPORT FOOD", "450 Lê Duẩn - Hà Nội"}
            },
            new String [] {
                "Mã Nhà PPSP", "Mã Danh Mục", "Tên Nhà PPSP", "Địa Chỉ"
            }
        ));
        jTable2.setRowHeight(25);
        jScrollPane3.setViewportView(jTable2);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel10.setText("DANH SÁCH DANH MỤC SẢN PHẨM");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel14.setText("DANH SÁCH NHÀ PHÂN PHỐI SẢN PHẨM");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Picture.png"))); // NOI18N
        jLabel15.setText("BẢNG CHI TIẾT SẢN PHẨM");

        jLabel3.setText("Tổng giá");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(butimage)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttonggia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(datethoigiannhan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(cbNPPSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtSoluong)
                                                .addComponent(txtgiaca)
                                                .addComponent(cbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbDMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap()))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btRefresh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd)
                            .addComponent(btEdit)
                            .addComponent(btDelete)
                            .addComponent(btRefresh))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(cbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbNPPSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(txtgiaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(datethoigiannhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttonggia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butimage)
                            .addComponent(lbhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDMSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDMSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDMSPActionPerformed

    private void cbNPPSPPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbNPPSPPopupMenuWillBecomeInvisible
        // xử lý combobox để cho dữ liệu hiện lên trên 1 textflied bất kỳ mình chọn
        //hàm nhỏ trong combobox
        //          String sql = "select *from NHAPHANPHOISANPHAM where TenNhaPPSS = ? ";
        //           try
        //           {
            //            pst = conn.prepareStatement(sql);
            //            pst.setString(1, (String)this.cbNPP.getSelectedItem());
            //            rs = pst.executeQuery();
            //            while(rs.next()){
                //                    this.load.setText(rs.getString("TenNhaPPSS"));
                //            }
            //           }
        //           catch(Exception e)
        //           {
            //           JOptionPane.showMessageDialog(null, e,"Thông báo lỗi",1);
            //           }
        //        String sql = "SELECT *FROM NHAPHANPHOISANPHAM where TenNhaPPSS =?";
        //        UpLoadCB(sql, this.cbNPP, this.load, "TenNhaPPSS");
    }//GEN-LAST:event_cbNPPSPPopupMenuWillBecomeInvisible

    private void cbNPPSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNPPSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNPPSPActionPerformed

    private void tbSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanphamMouseClicked
        // hien thi danh sach tu bang len các textflied
        
        ProcessAction(true);
        this.btAdd.setEnabled(false);
        this.txtMSP.setEnabled(false);
           int row = this.tbSanpham.getSelectedRow();
              
            try{
                if(row != -1 ){
                this.txtMSP.setText(tbSanpham.getValueAt(row,0).toString());
                
                this.cbDMSP.setSelectedItem(tbSanpham.getValueAt(row,1).toString());
                this.cbTenSP.setSelectedItem(tbSanpham.getValueAt(row,3).toString());
                this.cbNPPSP.setSelectedItem(tbSanpham.getValueAt(row,4).toString());
                
                this.txtSoluong.setText(tbSanpham.getValueAt(row,6).toString());
                this.txtgiaca.setText(tbSanpham.getValueAt(row,7).toString());
//                this.txtgiaca.setText(String.valueOf(tbSanpham.getValueAt(row,7)));
                
                try
                {       
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tbSanpham.getValueAt(row,8).toString());
                        this.datethoigiannhan.setDate(date);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }                
                
                this.txttonggia.setText(tbSanpham.getValueAt(row, 9).toString());
                this.txtghichu.setText(tbSanpham.getValueAt(row,10).toString());
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_tbSanphamMouseClicked
    
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // thêm mới sản phẩm
       if(this.txtMSP.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Mã sản phẩm  không thể bỏ trống","Thông báo",2);
                    this.txtMSP.requestFocus();
                    return;
        }
        if(this.cbDMSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn danh mục sản phẩm","Thông báo",2);
                this.cbDMSP.requestFocus();
                return;
        }
        if(this.cbTenSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn tên sản phẩm","Thông báo",2);
                this.cbTenSP.requestFocus();
                return;
        }
        if(this.cbNPPSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn nhà phân phối","Thông báo",2);
                this.cbNPPSP.requestFocus();
                return;
        }
        if (this.txtSoluong.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sản phẩm","Thông báo",2);
                    this.txtSoluong.requestFocus();
                    return;
        }
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(this.txtSoluong.getText());
        if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục số lượng không phải là số!");
                    this.txtSoluong.requestFocus();
                    return;
        }
        if (this.txtgiaca.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá cả sản phẩm!","Thông báo",2);
                    this.txtgiaca.requestFocus();
                    return;
        }
        Pattern pattern1 = Pattern.compile("^[0-9]*$");
        Matcher matcher1 = pattern1.matcher(this.txtgiaca.getText());
        if (!matcher1.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục giá cả không phải là số!");
                    this.txtgiaca.requestFocus();
                    return;
        }
        if (this.txttonggia.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tổng giá sản phẩm","Thông báo",2);
                    this.txttonggia.requestFocus();
                    return;
        }
        Pattern pattern2 = Pattern.compile("^[0-9]*$");
        Matcher matcher2 = pattern2.matcher(this.txttonggia.getText());
        if (!matcher2.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục tổng giá không phải là số!");
                    this.txttonggia.requestFocus();
                    return;
        }         
        
        SanPham sp = new SanPham();
        
        sp.setMaSP(this.txtMSP.getText());
        
        sp.setMaDM((String) this.cbDMSP.getSelectedItem());
        sp.setTenSP((String) this.cbTenSP.getSelectedItem());
        sp.setMaNPPSP((String) this.cbNPPSP.getSelectedItem());
        
        sp.setSoLuong(Integer.parseInt(this.txtSoluong.getText()));
        sp.setDonGia(Float.parseFloat(this.txtgiaca.getText()));
        sp.setThoiGianNhan(this.datethoigiannhan.getDate());       
           
        String a = this.txtSoluong.getText();
        String b = this.txtgiaca.getText();
        String c = this.txttonggia.getText();
        
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);
        
        c1 = a1 * b1;
        
        String c2 = Integer.toString(c1);
        
        sp.setTongGia(Float.parseFloat(c2));
        
        
//        sp.setTongGia(Float.parseFloat(this.txttonggia.getText()));
        
        sp.setGhiChu((String) this.txtghichu.getText());
        
        boolean kq =  controllerSanPham.addNewSanPham(sp);
        
        if(kq){
            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công","Thông báo",1);
            DefaultTableModel model = (DefaultTableModel)tbSanpham.getModel();
            model.setRowCount(0);
            loadDaTaSanPham();
            ProcessAction(false);
            refresh();
            
        }else
        {
            JOptionPane.showMessageDialog(null, "Thêm thất bại","Thông báo",2);
        }
    }//GEN-LAST:event_btAddActionPerformed
        public void refresh(){
           
        this.txtMSP.setText(null);
        
        this.cbDMSP.setSelectedItem(null);
        this.cbTenSP.setSelectedItem(null);
        this.cbNPPSP.setSelectedItem(null);
        
        this.txtSoluong.setText(null);
        this.txtgiaca.setText(null);
          
        java.util.Date date = new java.util.Date();
        this.datethoigiannhan.setDate(date);
        
        this.txttonggia.setText("00");
        this.txtghichu.setText(null);

       }
    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        // làm mới sản phẩm      
        
            refresh();
            ProcessAction(false);
            this.btAdd.setEnabled(true); 
            this.txtMSP.setEnabled(true);
    }//GEN-LAST:event_btRefreshActionPerformed
    
    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // Sửa thông tin sản phẩm

        if(this.txtMSP.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Mã sản phẩm  không thể bỏ trống","Thông báo",2);
                    this.txtMSP.requestFocus();
                    return;
        }
        if(this.cbDMSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn danh mục sản phẩm","Thông báo",2);
                this.cbDMSP.requestFocus();
                return;
        }
        if(this.cbTenSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn tên sản phẩm","Thông báo",2);
                this.cbTenSP.requestFocus();
                return;
        }
        if(this.cbNPPSP.getSelectedItem()==null)
        {
                JOptionPane.showMessageDialog(null,"Vui lòng chọn nhà phân phối","Thông báo",2);
                this.cbNPPSP.requestFocus();
                return;
        }
        if (this.txtSoluong.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sản phẩm","Thông báo",2);
                    this.txtSoluong.requestFocus();
                    return;
        }
        if (this.txtSoluong.getText().length()<0) {
                    JOptionPane.showMessageDialog(null, "Số lượng không thể là số âm !","Thông báo",2);
                    this.txtSoluong.requestFocus();
                    return;
        }
        
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(this.txtSoluong.getText());
        if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục số lượng không phải là số!");
                    this.txtSoluong.requestFocus();
                    return;
        }
        if (this.txtgiaca.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá cả sản phẩm!","Thông báo",2);
                    this.txtgiaca.requestFocus();
                    return;
        }
        if (this.txtgiaca.getText().length()<0) {
                    JOptionPane.showMessageDialog(null, "Đơn giá không thể là số âm !","Thông báo",2);
                    this.txtgiaca.requestFocus();
                    return;
        }
        
        Pattern pattern1 = Pattern.compile("^[0-9]*$");
        Matcher matcher1 = pattern1.matcher(this.txtgiaca.getText());
        if (!matcher1.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục giá cả không phải là số!");
                    this.txtgiaca.requestFocus();
                    return;
        }
        if (this.txttonggia.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tổng giá sản phẩm","Thông báo",2);
                    this.txttonggia.requestFocus();
                    return;
        }
        Pattern pattern2 = Pattern.compile("^[0-9]*$");
        Matcher matcher2 = pattern2.matcher(this.txttonggia.getText());
        if (!matcher2.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục tổng giá không phải là số!");
                    this.txttonggia.requestFocus();
                    return;
        }         
        
        SanPham sp = new SanPham();
        
        sp.setMaSP(this.txtMSP.getText());
        
        sp.setMaDM((String) this.cbDMSP.getSelectedItem());
        sp.setTenSP((String) this.cbTenSP.getSelectedItem());
        sp.setMaNPPSP((String) this.cbNPPSP.getSelectedItem());
        
        sp.setSoLuong(Integer.parseInt(this.txtSoluong.getText()));
        sp.setDonGia(Float.parseFloat(this.txtgiaca.getText()));
        sp.setThoiGianNhan(this.datethoigiannhan.getDate());       
        
        String a = this.txtSoluong.getText();
        String b = this.txtgiaca.getText();
        String c = this.txttonggia.getText();
        
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);
        
        c1 = a1 * b1;
        
        String c2 = Integer.toString(c1);
        
        sp.setTongGia(Float.parseFloat(c2));
  
        sp.setGhiChu((String) this.txtghichu.getText());
        
        boolean kq =  controllerSanPham.upDateSanPham(sp);
        if(kq){
            JOptionPane.showMessageDialog(null, " Sửa thành công !","Thông báo",1);
            DefaultTableModel model = (DefaultTableModel)tbSanpham.getModel();
            model.setRowCount(0);
            loadDaTaSanPham();
            ProcessAction(false);
            refresh();
            
        }else
        {
            JOptionPane.showMessageDialog(null, "Sửa thất bại","Thông báo",2);
        }
    }//GEN-LAST:event_btEditActionPerformed
    
    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // Xóa sản phẩm
        
        if(this.txtMSP.getText().length()==0)
            JOptionPane.showMessageDialog(null,"Bạn cần chọn mã sản phẩm để xóa","Thông báo",2);
        else
        {   
            int confirmdelete = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa mã sản phẩm này không ?"," Thông báo ",JOptionPane.YES_NO_OPTION);
            if (confirmdelete == JOptionPane.YES_NO_OPTION){
                boolean kq = controllerSanPham.deleteSanPham(this.txtMSP.getText());
                if(kq){
                    JOptionPane.showMessageDialog(null,"Bạn đã xóa sản phẩm thành công","Thông báo",1);
                    DefaultTableModel model = (DefaultTableModel)tbSanpham.getModel();
                    model.setRowCount(0);
                    loadDaTaSanPham();
                    ProcessAction(false);
                    refresh();
                }else{
                    JOptionPane.showMessageDialog(null,"Xóa thất bại !","Thông báo",2);
                }
            }        
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void cbTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTenSPActionPerformed

    private void butimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butimageActionPerformed
        // Them hình ảnh
    }//GEN-LAST:event_butimageActionPerformed
//    public void tongGia(){
//        
//        String a = this.txtSoluong.getText();
//        String b = this.txtgiaca.getText();
//        String c = this.txttonggia.getText();
//        
//        int a1 = Integer.parseInt(a);
//        int b1 = Integer.parseInt(b);
//        int c1 = Integer.parseInt(c);
//        
//        c1 = a1 * b1;
//        
//        String c2 = Integer.toString(c1);
//        
//    }
    
//    public void UpLoadCB( String sql,JComboBox cb, JTextField tf, String bien){
//    mở rộng hàm cho combobox
//    
//           try
//           {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, (String)cb.getSelectedItem());
//            rs = pst.executeQuery();
//            while(rs.next()){
//                    tf.setText(rs.getString(bien));
//            }
//           }
//           catch(Exception e)
//           {
//           JOptionPane.showMessageDialog(null, e,"Thông báo lỗi",1);
//           }
//    
//    }
    
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
            java.util.logging.Logger.getLogger(frmquanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmquanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmquanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmquanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmquanlysanpham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton butimage;
    private javax.swing.JComboBox<String> cbDMSP;
    private javax.swing.JComboBox<String> cbNPPSP;
    private javax.swing.JComboBox<String> cbTenSP;
    private com.toedter.calendar.JDateChooser datethoigiannhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbhinhanh;
    private javax.swing.JTable tbSanpham;
    private javax.swing.JTextField txtMSP;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txtgiaca;
    private javax.swing.JTextField txttonggia;
    // End of variables declaration//GEN-END:variables
}
