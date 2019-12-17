/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.View;

import Controller.connectDB;
import Gym.Controller.ControllerCongNoKH;
import Gym.Model.ThongTinKhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Gym.Model.CongNoKhachHang;
import Gym.Model.QuanlyCongNoKH;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class frmBangcongnoKH extends javax.swing.JFrame {

    /**
     * Creates new form frmtimkiemthongtinsanpham
     */
    DefaultTableModel model;
    ControllerCongNoKH controllercongNoKH = null;
    public static PreparedStatement pst = null;
    public static Connection conn = null;
    public static ResultSet rs = null;
    CongNoKhachHang congNoKhachHang = null;
    QuanlyCongNoKH quanlyCongNoKH = null;
    
    public frmBangcongnoKH() {
        initComponents();
        setLocationRelativeTo(null);
        loadDaTaKhachHang();
        loadDaTaCongNoKH();
    }

    public void loadDaTaKhachHang(){
        model = new DefaultTableModel();
        //set colum cho title - headers
        Vector colum = new Vector();
        colum.add("Ma KH");
        colum.add("Ho Ten");
        colum.add("Ngay Sinh");
        colum.add("Gioi Tinh");
        colum.add("Ma GDK");
        colum.add("Goi Dang Ki");
        colum.add("Ngay DK");
        colum.add("Ngay HHDK");
        colum.add("SDT");
        colum.add("Dia Chỉ");
        colum.add("Email");
        //add colum headers vao model
        model.setColumnIdentifiers(colum);
        
        // set coumn cho data hien thi tren table
        controllercongNoKH = new ControllerCongNoKH();
        List<ThongTinKhachHang> listKhachHang = controllercongNoKH.LoadKhachHang();
        for(int i=0;i<listKhachHang.size(); i++){
            
            ThongTinKhachHang kh = (ThongTinKhachHang)listKhachHang.get(i);
            Vector row = new Vector();
            row.add(kh.getMaKH());
            row.add(kh.getHoTenKH());
            row.add(kh.getNgaySinh());
            row.add(CheckGioiTinh(kh.getGioiTinh()));
            row.add(kh.getMaGoi());
            row.add(kh.getTenGoi());
            row.add(kh.getNgayDK());
            row.add(kh.getNgayHHDK());
            row.add(kh.getSoDienThoai());
            row.add(kh.getDiaChi());
            row.add(kh.getEmail());
            
            //add row data vao model
            model.addRow(row);        
        }
        //set model cho table
        this.tbkhachhang.setModel(model);
    }
    
    public String CheckGioiTinh(boolean gioitinh){
        if(gioitinh==true){
            return "Nam";
        }else{
            return "Nu";
        }
    }
    
     //load data cong no cua khach hang
     
     public void loadDaTaCongNoKH(){
        model = new DefaultTableModel();
        //set colum cho title - headers
        Vector colum = new Vector();
        colum.add("Ma KH");
        colum.add("Ho Ten");
        colum.add("Ma SP");
        colum.add("Ten SP");
        colum.add("So Tien No");
        colum.add("Ghi Chu");

        //add colum headers vao model
        model.setColumnIdentifiers(colum);
        
        // set coumn cho data hien thi tren table
        controllercongNoKH = new ControllerCongNoKH();
        List<QuanlyCongNoKH> listCongNoKhachHang = controllercongNoKH.LoadBangCongNoKH();
        for(int i=0;i<listCongNoKhachHang.size(); i++){
            
            QuanlyCongNoKH quanlyCongNoKH = (QuanlyCongNoKH)listCongNoKhachHang.get(i);
            Vector row = new Vector();
            
            row.add(quanlyCongNoKH.getMaKH());
            row.add(quanlyCongNoKH.getTenKH());
            row.add(quanlyCongNoKH.getMaSP());
            row.add(quanlyCongNoKH.getTenSP());
            row.add(quanlyCongNoKH.getSoTienNo());
            row.add(quanlyCongNoKH.getGhiChu());

            //add row data vao model
            model.addRow(row);        
        }
        //set model cho table
        this.tbcongnokhachhang.setModel(model);
        this.lbtongkhno.setText("" +this.tbcongnokhachhang.getRowCount()+ " Khách hàng ");
        getSumTongCongNo();
    }
     
     public void getSumTongCongNo(){
     
         int tongCongNo = 0;
         
         for(int i = 0; i < this.tbcongnokhachhang.getRowCount(); i++){
         
             tongCongNo = tongCongNo + Integer.parseInt(this.tbcongnokhachhang.getValueAt(i, 4).toString());
         }
         this.lbtongsotienno.setText(Integer.toString(tongCongNo));
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkhachhang = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txtsearchtenkh = new javax.swing.JTextField();
        txtsearchsdt = new javax.swing.JTextField();
        txtmakh = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtsotienno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        btadd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtmasanpham = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbcongnokhachhang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtsearchnoTKH = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbtongkhno = new javax.swing.JLabel();
        lbtongsotienno = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(50, 50));
        setResizable(false);

        jTabbedPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("CÔNG NỢ KHÁCH HÀNG");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        jLabel5.setText("Tìm kiếm");

        jLabel2.setText("Mã KH");

        jLabel4.setText("Tên KH");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/luachon.png"))); // NOI18N
        jLabel7.setText("Lựa chọn");

        jLabel11.setText("Tên KH");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Picture.png"))); // NOI18N
        jLabel13.setText("Bảng khách hàng");

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jLabel3.setText("SĐT");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 500));

        tbkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ tên", "Ngày sinh", "Giới tính", "Mã GĐK", "Gói ĐK", "Ngày ĐK", "Ngày HHĐK", "SĐT", "Địa chỉ", "Email"
            }
        ));
        tbkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkhachhang);

        jScrollPane4.setViewportView(jScrollPane1);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/excel.png"))); // NOI18N
        jButton10.setText("Xuất exel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkiem.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel36.setText("Số tiền nợ");

        jLabel10.setText("Ghi chú");

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane3.setViewportView(txtghichu);

        btadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        btadd.setText("Thêm vào công nợ");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Mã SP");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(427, 427, 427))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel3)))
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGap(0, 2, Short.MAX_VALUE)
                                                        .addComponent(jLabel2)
                                                        .addGap(60, 60, 60))
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel36)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel8))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtsotienno)
                                                    .addComponent(jScrollPane3)
                                                    .addComponent(txtmasanpham))))))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtsearchtenkh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsearchsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btadd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btadd)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtsearchtenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtsearchsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmakh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(txtsotienno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jTabbedPane5.addTab("Bảng công nợ ", jPanel6);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("CHI TIẾT CÔNG NỢ KHÁCH HÀNG");

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/luachon.png"))); // NOI18N
        jLabel14.setText("Tổng hợp");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        jLabel17.setText("Tìm kiếm");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/process.png"))); // NOI18N
        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkiem.png"))); // NOI18N
        jButton4.setText("Tìm kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Picture.png"))); // NOI18N
        jLabel24.setText("Bảng chi tiết công nợ khách hàng");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/excel.png"))); // NOI18N
        jButton9.setText("Xuất exel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        tbcongnokhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ Tên", "Mã SP", "Tên SP", "Ngày bán", "Giá bán", "Số tiền nợ", "Ghi chú"
            }
        ));
        jScrollPane5.setViewportView(tbcongnokhachhang);

        jScrollPane6.setViewportView(jScrollPane5);

        jLabel16.setText("Tên KH");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("Tổng số KH");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Tổng công nợ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton2.setText("Xóa");

        lbtongkhno.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongkhno.setForeground(new java.awt.Color(51, 0, 255));
        lbtongkhno.setText("Khách hàng");

        lbtongsotienno.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbtongsotienno.setForeground(new java.awt.Color(51, 0, 255));
        lbtongsotienno.setText("Công nợ");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        jButton5.setText("Home");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(182, 182, 182)
                .addComponent(jButton9)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtsearchnoTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel18))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbtongkhno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbtongsotienno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)
                        .addGap(353, 353, 353)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtsearchnoTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel14)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbtongkhno))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lbtongsotienno))
                        .addGap(190, 190, 190))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane5.addTab("Bảng quản lý công nợ", jPanel1);

        jScrollPane2.setViewportView(jTabbedPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // tra ve data

        loadDaTaKhachHang();
        this.txtsearchsdt.setText(null);
        this.txtsearchtenkh.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        // thêm mới công nợ

        if (this.txtmasanpham.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm ","Thông báo",2);
            this.txtmasanpham.requestFocus();
            return;
        }
        
        if (this.txtsotienno.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền nợ ","Thông báo",2);
            this.txtsotienno.requestFocus();
            return;
        }

        congNoKhachHang = new CongNoKhachHang();

        congNoKhachHang.setMaKH(this.txtmakh.getText());
        congNoKhachHang.setHoTen(this.txttenkh.getText());
        congNoKhachHang.setMaSP(this.txtmasanpham.getText());
        congNoKhachHang.setSoTienNo(Integer.parseInt(this.txtsotienno.getText()));
        congNoKhachHang.setGhiChu(this.txtghichu.getText());

        controllercongNoKH = new ControllerCongNoKH();
        boolean kq = controllercongNoKH.addNewCongNoKH(congNoKhachHang);
        if(kq){
            JOptionPane.showMessageDialog(null, "Đã thêm vào công nợ !","Thông báo",1);
            dispose();

        }else
        {
            JOptionPane.showMessageDialog(null, "Thất bại","Thông báo",2);
        }
    }//GEN-LAST:event_btaddActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // tìm kiếm khách hàng

        if(this.txtsearchtenkh.getText().isEmpty() && this.txtsearchsdt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị cần tìm kiếm !","Thông báo",2);
            this.txtsearchtenkh.requestFocus();
            return;
        }
        if(this.txtsearchtenkh.getText().length()!=0 && this.txtsearchsdt.getText().length() !=0)
        {
            JOptionPane.showMessageDialog(null, "Không được nhập giá trị tìm kiếm vào 2 ô !","Thông báo",2);
            this.txtsearchtenkh.requestFocus();
            this.txtsearchtenkh.setText(null);
            this.txtsearchsdt.setText(null);
            return;
        }
        if(this.txtsearchtenkh.getText().length()!=0)
        {
            findKhachHangTheoTen(this.txtsearchtenkh.getText());
            return;
        }
        
        Pattern patter = Pattern.compile("^[0-9]*$");
        Matcher matcher = patter.matcher(this.txtsearchsdt.getText());
        if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "kí tự tại mục ngày công chuẩn không phải là số!");
                    this.txtsearchsdt.requestFocus();
                    return;
        }
        if(this.txtsearchsdt.getText().length() != 0){
            findKhachHangTheoSDT(Integer.parseInt(this.txtsearchsdt.getText()));
            return;
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tbkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkhachhangMouseClicked
        // Load data từ bảng qua textfield

        this.txtmakh.setEnabled(false);
        this.txttenkh.setEnabled(false);
        int row = this.tbkhachhang.getSelectedRow();

        try{
            if(row != -1 ){
                this.txtmakh.setText(tbkhachhang.getValueAt(row,0).toString());
                this.txttenkh.setText(tbkhachhang.getValueAt(row,1).toString());

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbkhachhangMouseClicked

    private void jTabbedPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane5MouseClicked
        // trang quản lý chi tiết công nợ
        
        
    }//GEN-LAST:event_jTabbedPane5MouseClicked

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane5MouseClicked
    
    //tim kiem theo bang cong no khach hang
    
    public void findCongNoKHTheoTen(String tenKH){
        
        String sql = "SELECT * FROM View_CongNoKhachHang where Hoten like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +tenKH+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
                QuanlyCongNoKH quanlyCongNoKH = null;
            while(rs.next()){
                
                quanlyCongNoKH = new QuanlyCongNoKH();
                
                    quanlyCongNoKH.setMaKH(rs.getString("MaKH"));
                    quanlyCongNoKH.setTenKH(rs.getString("Hoten"));
                    quanlyCongNoKH.setMaSP(rs.getString("MaSP"));
                    quanlyCongNoKH.setTenSP(rs.getString("TenSP"));
                    quanlyCongNoKH.setSoTienNo(rs.getInt("Sotienno"));
                    quanlyCongNoKH.setGhiChu(rs.getString("Ghichu"));

                    
                    Vector row = new Vector();
                    
                    row.add(quanlyCongNoKH.getMaKH());
                    row.add(quanlyCongNoKH.getTenKH());
                    row.add(quanlyCongNoKH.getMaSP());
                    row.add(quanlyCongNoKH.getTenSP());
                    row.add(quanlyCongNoKH.getSoTienNo());
                    row.add(quanlyCongNoKH.getGhiChu());

                model.addRow(row);
                 
            }
            this.tbcongnokhachhang.setModel(model);
        }
        catch(Exception e)
        {
              e.printStackTrace();
        }
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Tìm kiếm theo bảng công nợ khách hàng
        
        if(this.txtsearchnoTKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị cần tìm kiếm !","Thông báo",2);
            this.txtsearchnoTKH.requestFocus();
            return;
        }

        if(this.txtsearchnoTKH.getText().length()!=0)
        {
            findCongNoKHTheoTen(this.txtsearchnoTKH.getText());
            this.lbtongkhno.setText("" +this.tbcongnokhachhang.getRowCount()+ " Khách hàng ");
            getSumTongCongNo();
            return;
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //  làm mới bảng công nợ khách hàng
        this.txtsearchnoTKH.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // load về home
        
        loadDaTaCongNoKH();
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Xuất excel
        
        exportExcel_TH(tbkhachhang);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // excel quan ly cong no
        exportExcel_TH(tbcongnokhachhang);
    }//GEN-LAST:event_jButton9ActionPerformed
    
    
    
    //tìm kiếm theo tên khach hang
    
      public void findKhachHangTheoTen(String tenKH){
        
        String sql = "SELECT * FROM View_DangKiKhachHang where Hoten like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +tenKH+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
                ThongTinKhachHang thongTinKhachHang = null;
            while(rs.next()){
                
                thongTinKhachHang = new ThongTinKhachHang();
                
                    thongTinKhachHang.setMaKH(rs.getString("MaKH"));
                    thongTinKhachHang.setHoTenKH(rs.getString("Hoten"));
                    thongTinKhachHang.setNgaySinh(rs.getDate("Ngaysinh"));
                    thongTinKhachHang.setGioiTinh(rs.getBoolean("Gioitinh"));
                    thongTinKhachHang.setMaGoi(rs.getString("MaGoiDk"));
                    thongTinKhachHang.setTenGoi(rs.getString("Tengoi"));
                    thongTinKhachHang.setNgayDK(rs.getDate("NgayDK"));
                    thongTinKhachHang.setNgayHHDK(rs.getDate("NgayHetHanDk"));
                    thongTinKhachHang.setSoDienThoai(rs.getInt("Sodienthoai"));
                    thongTinKhachHang.setDiaChi(rs.getString("Diachi"));
                    thongTinKhachHang.setEmail(rs.getString("Email"));
                    
                    Vector row = new Vector();
                    row.add(thongTinKhachHang.getMaKH());
                    row.add(thongTinKhachHang.getHoTenKH());
                    row.add(thongTinKhachHang.getNgaySinh());
                    row.add(CheckGioiTinh(thongTinKhachHang.getGioiTinh()));
                    row.add(thongTinKhachHang.getMaGoi());
                    row.add(thongTinKhachHang.getTenGoi());
                    row.add(thongTinKhachHang.getNgayDK());
                    row.add(thongTinKhachHang.getNgayHHDK());
                    row.add(thongTinKhachHang.getSoDienThoai());
                    row.add(thongTinKhachHang.getDiaChi());
                    row.add(thongTinKhachHang.getEmail());

                model.addRow(row);
                 
            }
            this.tbkhachhang.setModel(model);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error: " +e.getMessage());
        }
    }
      
      // Tìm kiếm theo số điện thoại khách hàng
      public void findKhachHangTheoSDT(int sdtKH){
          
        
        String sql = "SELECT * FROM View_DangKiKhachHang WHERE Sodienthoai like ?";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" +sdtKH+ "%");
            rs = pst.executeQuery();
            
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
                ThongTinKhachHang thongTinKhachHang = null;
            while(rs.next()){
                
                thongTinKhachHang = new ThongTinKhachHang();
                
                    thongTinKhachHang.setMaKH(rs.getString("MaKH"));
                    thongTinKhachHang.setHoTenKH(rs.getString("Hoten"));
                    thongTinKhachHang.setNgaySinh(rs.getDate("Ngaysinh"));
                    thongTinKhachHang.setGioiTinh(rs.getBoolean("Gioitinh"));
                    thongTinKhachHang.setMaGoi(rs.getString("MaGoiDk"));
                    thongTinKhachHang.setTenGoi(rs.getString("Tengoi"));
                    thongTinKhachHang.setNgayDK(rs.getDate("NgayDK"));
                    thongTinKhachHang.setNgayHHDK(rs.getDate("NgayHetHanDk"));
                    thongTinKhachHang.setSoDienThoai(rs.getInt("Sodienthoai"));
                    thongTinKhachHang.setDiaChi(rs.getString("Diachi"));
                    thongTinKhachHang.setEmail(rs.getString("Email"));
                    
                    Vector row = new Vector();
                    row.add(thongTinKhachHang.getMaKH());
                    row.add(thongTinKhachHang.getHoTenKH());
                    row.add(thongTinKhachHang.getNgaySinh());
                    row.add(CheckGioiTinh(thongTinKhachHang.getGioiTinh()));
                    row.add(thongTinKhachHang.getMaGoi());
                    row.add(thongTinKhachHang.getTenGoi());
                    row.add(thongTinKhachHang.getNgayDK());
                    row.add(thongTinKhachHang.getNgayHHDK());
                    row.add(thongTinKhachHang.getSoDienThoai());
                    row.add(thongTinKhachHang.getDiaChi());
                    row.add(thongTinKhachHang.getEmail());

                model.addRow(row);
                 
            }
            this.tbkhachhang.setModel(model);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error: " +e.getMessage());
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
            java.util.logging.Logger.getLogger(frmBangcongnoKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBangcongnoKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBangcongnoKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBangcongnoKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBangcongnoKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lbtongkhno;
    private javax.swing.JLabel lbtongsotienno;
    private javax.swing.JTable tbcongnokhachhang;
    private javax.swing.JTable tbkhachhang;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmasanpham;
    private javax.swing.JTextField txtsearchnoTKH;
    private javax.swing.JTextField txtsearchsdt;
    private javax.swing.JTextField txtsearchtenkh;
    private javax.swing.JTextField txtsotienno;
    private javax.swing.JTextField txttenkh;
    // End of variables declaration//GEN-END:variables
}
