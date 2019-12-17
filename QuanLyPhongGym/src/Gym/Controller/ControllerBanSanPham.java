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

import Gym.Model.SanPham;
import Gym.Model.BanSanPham;
import Controller.connectDB;
import Gym.Model.ThongTinSanPham;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ControllerBanSanPham {
    
    public static PreparedStatement pst = null; // bien thuc thi sql
    public static ResultSet rs = null; // Ket qua tra ve 1 bang hay 1 dong du lieu
    public static Connection conn = null; // Lay tu lop co ban ket noi java
    public static Statement stt = null;
    
    
    public List<SanPham> getSanPhamFromDB(){
            
            String sql = "SELECT * FROM SANPHAMCONLAI";
         List<SanPham> listSanPham = new ArrayList<SanPham>();
         try
         {
             conn = connectDB.connectSQLServer();
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                SanPham sp = new SanPham();
                 
                sp.setMaSP(rs.getString("MaSP"));
                sp.setMaDM(rs.getString("MaDM"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getFloat("Dongia"));
                sp.setMaNPPSP(rs.getString("MaNhaPPSS"));
                sp.setThoiGianNhan(rs.getDate("Thoigiannhan"));
                sp.setGhiChu(rs.getString("Ghichu"));
                sp.setTongGia(rs.getFloat("Tonggia"));
                
                listSanPham.add(sp);
             }
             return listSanPham;
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return null;
    }
    
    //load combobox Ma danh muc san pham
    
    public ArrayList<String> loadCBDMSP(){
        
        ArrayList<String> listCBDMSP = new ArrayList<String>();
        String sql = "SELECT * FROM DANHMUCSANPHAM";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBDMSP.add(rs.getString("MaDM"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBDMSP;
    }
    
    //load combobox ten san pham
    
    public ArrayList<String> loadCBTENSP(){
        
        ArrayList<String> listCBTENSP = new ArrayList<String>();
        String sql = "SELECT * FROM TENSANPHAM";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBTENSP.add(rs.getString("TenSP"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBTENSP;
    }
    
    //load combobox NPPSP
    
    public ArrayList<String> loadCBNPSP(){
        
        ArrayList<String> listCBNPPSP = new ArrayList<String>();
        String sql = "SELECT * FROM NHAPHANPHOISANPHAM";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBNPPSP.add(rs.getString("MaNhaPPSS"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBNPPSP;
    }
    
    
    
    public boolean addDoanhThu(BanSanPham sp,String maSP){
        
        String sqlInsert = "INSERT INTO BANSANPHAM (MaSP,MaDM,TenSP,MaNhaPPSS,Dongia,MaHD,Soluong,Giaban,TongGia,Ngayban,TinhTrang) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        String sqlDelete = "DELETE FROM SANPHAMCONLAI Where MaSP = ?"; // chuỗi truy vấn
        
                try
                {
                        conn = connectDB.connectSQLServer(); // câu lệnh kết nối
                        pst = conn.prepareStatement(sqlInsert); // chuẩn bị truy vấn

                        // thực hiện truy vấn
                        pst.setString(1, sp.getMaSP());
                        pst.setString(2, sp.getMaDM());
                        pst.setString(3, sp.getTenSP());
                        pst.setString(4, sp.getNPPSP());
                        pst.setFloat(5, sp.getDonGia());
                        pst.setString(6, sp.getMaHD());
                        pst.setInt(7, sp.getSoLuong());
                        pst.setFloat(8, sp.getGiaBan());
                        pst.setFloat(9, sp.getTongGia());
                        pst.setDate(10, new Date(sp.getNgayBan().getTime()));
                        pst.setString(11, sp.getTinhTrang());
                        
                        pst.executeUpdate();
                        
                        pst = conn.prepareStatement(sqlDelete);
                        pst.setString(1, maSP);

                 

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
    }
    
//          public boolean deleteSanPhamBanDuoc(String maSP){
//        
//            String sqlDelete = "DELETE FROM SANPHAMCONLAI Where MaSP = ?";  // chuỗi truy vấn
//            
//            try
//            {
//                conn = connectDB.connectSQLServer();
//                pst = conn.prepareStatement(sqlDelete);
//                pst.setString(1, maSP);
//                
//                pst.executeUpdate();
//                pst.close();
//                conn.close();
//                
//                return true;
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//                return false;
//            }
    
    
//    tìm kiếm thông tin theo mảng
    
//    public List<ThongTinSanPham> findTenSanPham(String tenSP ){
//    
//        List<ThongTinSanPham> listSanPham = new ArrayList<ThongTinSanPham>();
//        
//        String sql = "SELECT * FROM View_SanPham where TenSP = '" + tenSP + "' ";
//        
//        try
//        {
//                conn = connectDB.connectSQLServer();
//                stt = conn.createStatement();
//                rs = stt.executeQuery(sql);
//                
//                ThongTinSanPham thongTinSanPham;
//                while(rs.next()){
//                   
//                    thongTinSanPham = new ThongTinSanPham();
//                    
//                    thongTinSanPham.setMaSP(rs.getString("MaSP"));
//                    thongTinSanPham.setMaDM(rs.getString("MaDM"));
//                    thongTinSanPham.setTenDM(rs.getString("TenDM"));
//                    thongTinSanPham.setTenSP(rs.getString("TenSP"));
//                    thongTinSanPham.setMaNPPSP(rs.getString("MaNhaPPSS"));
//                    thongTinSanPham.setNhaPP(rs.getString("TenNhaPPSS"));
//                    thongTinSanPham.setSoLuong(rs.getInt("SoLuong"));
//                    thongTinSanPham.setDonGia(rs.getFloat("Dongia"));
//                    thongTinSanPham.setThoiGianNhan(rs.getDate("Thoigiannhan"));
//                    thongTinSanPham.setTongGia(rs.getFloat("Tonggia"));
//                    thongTinSanPham.setGhiChu(rs.getString("Ghichu"));
//                    
//                    listSanPham.add(thongTinSanPham);
//                
//                }
//                return listSanPham;
//            
//        }
//        catch(Exception e)
//        {
////            JOptionPane.showMessageDialog(null, "Không tìm thấy !","Thông báo",1);
//            e.printStackTrace();
//        }
//        return listSanPham;
//    }
