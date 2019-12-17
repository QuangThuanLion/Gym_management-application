/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Controller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Gym.Model.KhachHang;
import Controller.connectDB;
import Gym.Model.ThongTinKhachHang;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class ControllerKhachHang {

    public static PreparedStatement pst = null;// đây là biến thực thi sql
    public static Connection conn = null; //lấy từ lớp cơ bản đến kết nối java
    public static ResultSet rs = null; // câu lệnh trả về một giá trị hay một dòng hay một bảng dữ liệu
    public static Statement stt = null; // biến thực thi trong sql, là biến lớn hơn PreparedStatement

   
    public List<ThongTinKhachHang> LoadKhachHang(){
            
        List<ThongTinKhachHang> listKhachHang = new ArrayList<ThongTinKhachHang>();

            String sql = "SELECT * FROM View_DangKiKhachHang";// tạo câu lệnh truy vấn
        try{
                conn = connectDB.connectSQLServer();// mở phương thức kết nối
                pst = conn.prepareStatement(sql);// chuẩn bị truy vấn
                rs = pst.executeQuery();// thực hiện truy vấn
                
                ThongTinKhachHang kh; 
                while(rs.next()){
                    //trả về dữ liệu, show ra dữ liệu
                   kh = new ThongTinKhachHang();
                   kh.setMaKH(rs.getString("MaKH"));
                   kh.setHoTenKH(rs.getString("Hoten"));
                   kh.setNgaySinh(rs.getDate("Ngaysinh"));
                   kh.setGioiTinh(rs.getBoolean("Gioitinh"));
                   kh.setMaGoi(rs.getString("MaGoiDk"));
                   kh.setTenGoi(rs.getString("Tengoi"));
                   kh.setNgayDK(rs.getDate("NgayDK"));
                   kh.setNgayHHDK(rs.getDate("NgayHetHanDk"));
                   kh.setSoDienThoai(rs.getInt("Sodienthoai"));
                   kh.setDiaChi(rs.getString("Diachi"));
                   kh.setEmail(rs.getString("Email"));
        
                   listKhachHang.add(kh);
                }
                return listKhachHang;
        }
            
        catch(Exception e){
        
               e.printStackTrace();
        }
        return null;
    }
    
    //add combobox vao
    
       public ArrayList<String> loadCBGDK(){
        
        ArrayList<String> listCBGDK = new ArrayList<String>();
        String sql = "SELECT * FROM GOIDANGKY";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBGDK.add(rs.getString("MaGoiDk"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBGDK;
    }
    
    // Thêm mới khách hàng
    
        public boolean addNewKhachHang(KhachHang kh){
                
           String sqlquery = "SELECT * FROM KHACHHANG where MaKH = ? ";
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sqlquery);
               pst.setString(1, kh.getMaKH().trim());
               rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Đã có mã khách hàng này ! ","Thông báo",2);
                   return false;
               }else
               {
                   String sql = "INSERT INTO KHACHHANG(MaKH,Hoten,Ngaysinh,Gioitinh,Diachi,Sodienthoai,Email,MaGoiDk,NgayDK,NgayHetHanDk) VALUES (?,?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql
                   
                   conn = connectDB.connectSQLServer();//mở kết nối
                   pst = conn.prepareStatement(sql);//  chuẩn bị truy vấn
                   
                   pst.setString(1, kh.getMaKH());
                   pst.setString(2, kh.getTenKH());
                   pst.setDate(3, new Date(kh.getNgaySinh().getTime()));
                   pst.setBoolean(4, kh.getGioiTinh());
                   pst.setString(5, kh.getDiaChi());
                   pst.setInt(6, kh.getSoDienThoai());
                   pst.setString(7, kh.getEmail());
                   pst.setString(8, kh.getMaGoiDK());
                   pst.setDate(9, new Date(kh.getNgayDK().getTime()));
                   pst.setDate(10,new Date(kh.getNgayHetHanDK().getTime()));
                   
                   pst.executeUpdate();
                   conn.close();
                   pst.close();
                   
                   return true;
               }
//               return true;
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return false;
           }
        }
        
        // Hàm edit khách hàng
        public boolean upDateKhachHang(KhachHang kh){
        
//           String sqlquery =  "SELECT *FROM KHACHHANG WHERE MaKH = ?"

            String sql = "UPDATE KHACHHANG SET Hoten = ?, Ngaysinh= ?, Gioitinh = ?, Diachi= ?, Sodienthoai= ?, Email = ?, MaGoiDk = ?, NgayDK= ?, NgayHetHanDk = ? WHERE MaKH = ?";
           try
           {
                   String maKh = kh.getMaKH();
                   
                   conn = connectDB.connectSQLServer();
                   pst = conn.prepareStatement(sql);
                   
                   pst.setString(1, kh.getTenKH());
                   pst.setDate(2, new Date(kh.getNgaySinh().getTime()));
                   pst.setBoolean(3, kh.getGioiTinh());
                   pst.setString(4, kh.getDiaChi());
                   pst.setInt(5, kh.getSoDienThoai());
                   pst.setString(6, kh.getEmail());
                   pst.setString(7, kh.getMaGoiDK());
                   pst.setDate(8, new Date(kh.getNgayDK().getTime()));
                   pst.setDate(9,new Date(kh.getNgayHetHanDK().getTime()));
                   pst.setString(10, kh.getMaKH());
                   
                   pst.executeUpdate();
                   conn.close();
                   pst.close();
                   
                   return true;
//               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return false;
           }
           
        }
        
        // Delete khách hàng
        
        public boolean deleteKhachHang(String MaKH){
        
               String sql = "DELETE FROM KHACHHANG WHERE MaKH = ?";
            try
            {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);
                pst.setString(1, MaKH);
                
                pst.executeUpdate();
                pst.close();
                conn.close();
                
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }

//        public boolean findKhachHang(String tenKH){
//            
//                String sqlquery = "SELECT * FROM View_DangKiKhachHang where Hoten like ?";
//            try
//            {   
//                   
//                   conn = connectDB.connectSQLServer();
//                   pst = conn.prepareStatement(sqlquery);
//                   pst.setString(1, "%" + tenKH + "%");
//                   
//                   rs = pst.executeQuery();
//                   
//                   ThongTinKhachHang kh = new ThongTinKhachHang();
//                   while(rs.next()){
//                       
//                       kh.setMaKH(rs.getString("maKH"));
//                       kh.setHoTenKH(rs.getString("hoTenKH"));
//                       kh.setNgaySinh(rs.getDate("ngaySinh"));
//                       kh.setGioiTinh(rs.getBoolean("gioiTinh"));
//                       kh.setTenGoi(rs.getString("tenGoi"));
//                       kh.setNgayDK(rs.getDate("ngayDK"));
//                       kh.setNgayHHDK(rs.getDate("ngayHHDK"));
//                       kh.setSoDienThoai(rs.getInt("soDienThoai"));
//                       kh.setDiaChi(rs.getString("diaChi"));
//                       kh.setEmail(rs.getString("email"));
//                       
//                       Vector row = new Vector();
//                       
//                       row.add(kh.getMaKH());
//                       row.add(kh.getHoTenKH());
//                       row.add(kh.getNgaySinh());
//                       row.add(kh.getGioiTinh());
//                       row.add(kh.getMaGoi());
//                       row.add(kh.getTenGoi());
//                       row.add(kh.getNgayDK());
//                       row.add(kh.getNgayHHDK());
//                       row.add(kh.getDiaChi());
//                       row.add(kh.getEmail());
//
//                     
//              }
//                   return true;
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//                return false;
//            }
//        }

 }
