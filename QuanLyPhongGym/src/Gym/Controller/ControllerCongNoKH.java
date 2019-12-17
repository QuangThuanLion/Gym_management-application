/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Controller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Gym.Model.KhachHang;
import Controller.connectDB;
import Gym.Model.ThongTinKhachHang;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import Gym.Model.QuanlyCongNoKH;

import Gym.Model.CongNoKhachHang;
/**
 *
 * @author Admin
 */
public class ControllerCongNoKH {
    
    public static PreparedStatement pst = null;// đây là biến thực thi sql
    public static Connection conn = null; //lấy từ lớp cơ bản đến kết nối java
    public static ResultSet rs = null; // câu lệnh trả về một giá trị hay một dòng hay một bảng dữ liệu
    CongNoKhachHang congNoKhachHang = null;
    QuanlyCongNoKH quanlyCongNoKH = null;

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
       
      public boolean addNewCongNoKH(CongNoKhachHang cnkh){
                
           String sql = "INSERT INTO CONGNOKHACHHANG(MaKH,Hoten,MaSP,Sotienno,Ghichu) VALUES (?,?,?,?,?)"; //chuỗi truy vấn sql
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sql);  
                   
                   pst.setString(1, cnkh.getMaKH());
                   pst.setString(2, cnkh.getHoTen());
                   pst.setString(3, cnkh.getMaSP());
                   pst.setInt(4, cnkh.getSoTienNo());
                   pst.setString(5, cnkh.getGhiChu());
                   
                   pst.executeUpdate();
                   conn.close();
                   pst.close();
                   
                   return true;
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return false;
           }
        } 
      
      //load data lên bảng chi tiết công nợ
      
      public List<QuanlyCongNoKH> LoadBangCongNoKH(){
            
        List<QuanlyCongNoKH> listCongNoKH = new ArrayList<QuanlyCongNoKH>();

            String sql = "SELECT * FROM View_CongNoKhachHang";// tạo câu lệnh truy vấn
        try{
                conn = connectDB.connectSQLServer();// mở phương thức kết nối
                pst = conn.prepareStatement(sql);// chuẩn bị truy vấn
                rs = pst.executeQuery();// thực hiện truy vấn
                
                ThongTinKhachHang kh; 
                while(rs.next()){
                    //trả về dữ liệu, show ra dữ liệu
                   quanlyCongNoKH = new QuanlyCongNoKH();
                   
                   quanlyCongNoKH.setMaKH(rs.getString("MaKH"));
                   quanlyCongNoKH.setTenKH(rs.getString("Hoten"));
                   quanlyCongNoKH.setMaSP(rs.getString("MaSP"));
                   quanlyCongNoKH.setTenSP(rs.getString("TenSP"));
                   quanlyCongNoKH.setSoTienNo(rs.getInt("Sotienno"));
                   quanlyCongNoKH.setGhiChu(rs.getString("Ghichu"));
        
                   listCongNoKH.add(quanlyCongNoKH);
                }
                return listCongNoKH;
        }
            
        catch(Exception e){
        
               e.printStackTrace();
        }
        return null;
    }
      
      //delete from bang cong no khach hang
      
      public boolean deleteCongNoKhachHang(String MaKH){
        
               String sql = "DELETE FROM CONGNOKHACHHANG WHERE MaKH = ?";
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
    
}
