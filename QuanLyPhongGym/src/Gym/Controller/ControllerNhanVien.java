/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Tao mot ham de do du lieu len bang --> roi sau do show ra giao dien
package Gym.Controller;

import Controller.connectDB;
import Gym.Model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import net.proteanit.sql.*; // Thu vien nay lay tu file moi add vao rs2xml

/**
 *
 * @author Admin
 */
public class ControllerNhanVien {

    public static PreparedStatement pst = null; // bien thuc thi sql
    public static ResultSet rs = null; // Ket qua tra ve 1 bang hay 1 dong du lieu
    public static Connection conn = null; // Lay tu lop co ban ket noi java
    public static Statement stt = null;

    // Lấy dữ liệu từ database
    public List<NhanVien> getNhanVienFromDB(){
        
//         String sql = "SELECT * FROM NHANVIEN";
//            String sql = "select nv.MaNV, nv.Hoten, nv.Ngaysinh, nv.Gioitinh, nv.Sodienthoai, nv.Diachi, nv.Email, nv.Ngayvaolam, nv.TenTK, nv.Matkhau, cv.ChucVu from NHANVIEN as nv, CHUCVU as cv where nv.ChucVu = cv.ChucVu";
            
            String sql = "SELECT * FROM NHANVIEN";
         List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
         try
         {
             conn = connectDB.connectSQLServer();
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                NhanVien nv = new NhanVien();
                 
                nv.setMaNV(rs.getString("maNV"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setSoDienThoai(rs.getInt("soDienThoai"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setEmail(rs.getString("email"));
                nv.setNgayVaolam(rs.getDate("Ngayvaolam"));
                nv.setTenTK(rs.getString("tenTK"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setChucVu(rs.getString("ChucVu"));
                
                listNhanVien.add(nv);
             }
             return listNhanVien;
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return null;
    }
        
    public ArrayList<String> loadCBNhanVien(){
        
        ArrayList<String> listCB = new ArrayList<String>();
        String sql = "SELECT * FROM CHUCVU";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCB.add(rs.getString("ChucVu"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCB;
    }
    
    // thêm mới nhân viên
    
    public boolean addNewNhanVien(NhanVien nv){
                
           String sqlquery = "SELECT * FROM NHANVIEN where MaNV = ? ";
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sqlquery);
               pst.setString(1, nv.getMaNV().trim());
               rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Đã có mã nhân viên này ! ","Thông báo",2);
                   return false;
               }else
               {
                   String sql = "INSERT INTO NHANVIEN(MaNV,Hoten,Ngaysinh,Gioitinh,Sodienthoai,Diachi,Email,Ngayvaolam,TenTK,Matkhau,ChucVu) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql
                   
                   conn = connectDB.connectSQLServer();//mở kết nối
                   pst = conn.prepareStatement(sql);//  chuẩn bị truy vấn
                   
                   
                   pst.setString(1, nv.getMaNV());
                   pst.setString(2, nv.getHoTen());
                   pst.setDate(3, new Date(nv.getNgaySinh().getTime()));
                   pst.setBoolean(4, nv.isGioiTinh());
                   pst.setInt(5, nv.getSoDienThoai());
                   pst.setString(6, nv.getDiaChi());
                   pst.setString(7, nv.getEmail());
                   pst.setDate(8, new Date(nv.getNgayVaolam().getTime()));
                   pst.setString(9, nv.getTenTK());
                   pst.setString(10, nv.getMatKhau());
                   pst.setString(11,nv.getChucVu()); 
                   
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
    
    //UPDATE nhan vien
    
    public boolean upDateNhanVien(NhanVien nv){

            String sql = "UPDATE NHANVIEN SET Hoten = ?, Ngaysinh= ?, Gioitinh = ?, Sodienthoai= ?, Diachi= ?, Email = ?,Ngayvaolam = ?, TenTK = ?, Matkhau= ?, ChucVu = ? WHERE MaNV = ?";
           try
           {
                   String maNV = nv.getMaNV();
                   
                   conn = connectDB.connectSQLServer();
                   pst = conn.prepareStatement(sql);
                   
                   pst.setString(1, nv.getHoTen());
                   pst.setDate(2, new Date(nv.getNgaySinh().getTime()));
                   pst.setBoolean(3, nv.isGioiTinh());
                   pst.setInt(4, nv.getSoDienThoai());
                   pst.setString(5, nv.getDiaChi());
                   pst.setString(6, nv.getEmail());
                   pst.setDate(7, new Date(nv.getNgayVaolam().getTime()));
                   pst.setString(8, nv.getTenTK());
                   pst.setString(9, nv.getMatKhau());
                   pst.setString(10,nv.getChucVu());;
                   pst.setString(11, nv.getMaNV());
                   
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
    
    // DELETE nhân viên
    
     public boolean deleteNhanVien(String MaNV){
        
               String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?";
            try
            {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);
                pst.setString(1, MaNV);
                
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

    //Viết hàm load data lên table
    
//    public void loadDaTaNhanVien(DefaultTableModel modelNhanVien ){
//            
//        String sql = "SELECT * FROM NHANVIEN";// chuỗi truy vấn csdl
//                
//        try
//        {
//            conn = connectDB.connectSQLServer(); // mở chuỗi kết nối
//            pst = conn.prepareStatement(sql);// chuẩn bị truy vấn
//            rs = pst.executeQuery();// thực thi truy vấn
//            while(rs.next())
//            // tại đây là đọc dữ liệu
//            {   
//                Vector vector = new Vector();// tạo mưới một vectorr
//                NhanVien nv = new NhanVien();
//                  
//                nv.setMaNV(rs.getString("maNV")); // dữ liệu đọc được đưa về trường mã nhân viên
//                nv.setHoTen(rs.getString("hoTen"));
//                nv.setNgaySinh(rs.getDate("ngaySinh"));
//                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
//                nv.setSoDienThoai(rs.getInt("soDienThoai"));
//                nv.setDiaChi(rs.getString("diaChi"));
//                nv.setEmail(rs.getString("email"));
//                nv.setTenTK(rs.getString("tenTK"));
//                nv.setMatKhau(rs.getString("matKhau"));
//                nv.setChucVu(rs.getString("chucVu"));
//                  
//                vector.add(nv.getMaNV()); // sao khi tạo phải đẩy dữ liệu nhân viên vào vector
//                vector.add(nv.getHoTen());
//                vector.add(nv.getNgaySinh());
//                vector.add(nv.isGioiTinh());
//                vector.add(nv.getSoDienThoai());
//                vector.add(nv.getDiaChi());
//                vector.add(nv.getEmail());
//                vector.add(nv.getTenTK());
//                vector.add(nv.getMatKhau());
//                vector.add(nv.getChucVu());
//                
//                modelNhanVien.addRow(vector);// đưa vector vào trong model
//            }
//            
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
