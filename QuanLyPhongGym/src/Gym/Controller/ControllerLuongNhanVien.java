/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import Controller.connectDB;
import Gym.Model.LuongNhanVien;
import java.util.List;
import java.util.ArrayList;
import Gym.Model.NhanVien;
import java.sql.Date;
/**
 *
 * @author Admin
 */

public class ControllerLuongNhanVien {
    
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
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
    
    public List<LuongNhanVien> getLuongNhanVienFromDB(){
   
       List<LuongNhanVien> listLuongNhanVien = new ArrayList<LuongNhanVien>();
        String sql = "SELECT * FROM LUONGNHANVIEN ORDER BY MaNV asc";
        
        try
        {
           conn = connectDB.connectSQLServer();
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            
            LuongNhanVien luongNhanVien;
            while(rs.next()){
                
                luongNhanVien = new LuongNhanVien();
                
                luongNhanVien.setMaNV(rs.getString("MaNV"));
                luongNhanVien.setTenNV(rs.getString("Hoten"));
                luongNhanVien.setChucVu(rs.getString("ChucVu"));
                luongNhanVien.setTuNgay(rs.getDate("Tungay"));
                luongNhanVien.setDenNgay(rs.getDate("Denngay"));
                luongNhanVien.setNgayCongChuan(rs.getInt("Ngaycongchuan"));
                luongNhanVien.setTongNgayCong(rs.getInt("Tongngaycong"));
                luongNhanVien.setLuongCoBan(rs.getFloat("Luongcoban"));
                luongNhanVien.setLuongChinh(rs.getFloat("LuongChinh"));
                luongNhanVien.setLuongPhuCap(rs.getFloat("Luongphucap"));
                luongNhanVien.setTongGioTangCa(rs.getFloat("Tonggiotangca"));
                luongNhanVien.setLuongTangCa(rs.getFloat("Luongtangca"));
                luongNhanVien.setTongLuong(rs.getFloat("Tongluong"));
                luongNhanVien.setGhiChu(rs.getString("Ghichu"));
                
                listLuongNhanVien.add(luongNhanVien);
                
            }
            return listLuongNhanVien;
           
       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<String> loadCBCVNhanVien(){
        
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
    
    public boolean addNewKhachHang(LuongNhanVien nv){
                
          String sql = "INSERT INTO LUONGNHANVIEN(MaNV,Hoten,ChucVu,Tungay,Denngay,Ngaycongchuan,Tongngaycong,Luongcoban,LuongChinh,Luongphucap,Tonggiotangca,Luongtangca,Tongluong,Ghichu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
           try
           {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);;
  
                    pst.setString(1, nv.getMaNV());
                    pst.setString(2, nv.getTenNV());
                    pst.setString(3, nv.getChucVu());
                    pst.setDate(4, new Date(nv.getTuNgay().getTime()));
                    pst.setDate(5, new Date(nv.getDenNgay().getTime()));
                    pst.setInt(6, nv.getNgayCongChuan());
                    pst.setInt(7, nv.getTongNgayCong());
                    pst.setFloat(8, nv.getLuongCoBan());                   
                    pst.setFloat(9, nv.getLuongChinh());                   
                    pst.setFloat(10, nv.getLuongPhuCap());                   
                    pst.setFloat(11, nv.getTongGioTangCa());                   
                    pst.setFloat(12, nv.getLuongTangCa());                   
                    pst.setDouble(13, nv.getTongLuong());                   
                    pst.setString(14, nv.getGhiChu());                   

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
    
    //edit lương nhân viên
    
    public boolean upDateLuongNhanVien(LuongNhanVien nv){

            String sql = "UPDATE LUONGNHANVIEN SET Hoten= ?, ChucVu = ?, Tungay= ?, Denngay= ?, Ngaycongchuan = ?,Tongngaycong = ?, Luongcoban = ?, LuongChinh= ?, Luongphucap = ?, Tonggiotangca = ?, Luongtangca = ?,Tongluong = ?,Ghichu = ? WHERE MaNV = ?";
           try
           {
                   String maNV = nv.getMaNV();
                   
                   conn = connectDB.connectSQLServer();
                   pst = conn.prepareStatement(sql);
                   
                    pst.setString(1, nv.getTenNV());
                    pst.setString(2, nv.getChucVu());
                    pst.setDate(3, new Date(nv.getTuNgay().getTime()));
                    pst.setDate(4, new Date(nv.getDenNgay().getTime()));
                    pst.setInt(5, nv.getNgayCongChuan());
                    pst.setInt(6, nv.getTongNgayCong());
                    pst.setFloat(7, nv.getLuongCoBan());                   
                    pst.setFloat(8, nv.getLuongChinh());                   
                    pst.setFloat(9, nv.getLuongPhuCap());                   
                    pst.setFloat(10, nv.getTongGioTangCa());                   
                    pst.setFloat(11, nv.getLuongTangCa());                   
                    pst.setDouble(12, nv.getTongLuong());                   
                    pst.setString(13, nv.getGhiChu()); 
                    pst.setString(14, nv.getMaNV());
                   
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
    
    //delete luong nhan vien
    
    public boolean deleteLuongNhanVien(String MaNV){
        
               String sql = "DELETE FROM LUONGNHANVIEN WHERE MaNV = ?";
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
