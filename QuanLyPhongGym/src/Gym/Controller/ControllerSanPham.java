/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Controller;

import Controller.connectDB;

import Gym.Model.ThongTinSanPham;
import Gym.Model.SanPham;
import Controller.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class ControllerSanPham {
    
    public static PreparedStatement pst = null; // bien thuc thi sql
    public static ResultSet rs = null; // Ket qua tra ve 1 bang hay 1 dong du lieu
    public static Connection conn = null; // Lay tu lop co ban ket noi java
    public static Statement stt = null;

    //Viet mot ham nap du lieu cho bang
    
    public List<ThongTinSanPham> getSanPhamFromDB(){
            
            String sql = "SELECT * FROM View_SanPham";
         List<ThongTinSanPham> listSanPham = new ArrayList<ThongTinSanPham>();
         try
         {
             conn = connectDB.connectSQLServer();
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                ThongTinSanPham sp = new ThongTinSanPham();
                 
                sp.setMaSP(rs.getString("MaSP"));
                sp.setMaDM(rs.getString("MaDM"));
                sp.setTenDM(rs.getString("TenDM"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMaNPPSP(rs.getString("MaNhaPPSS"));
                sp.setNhaPP(rs.getString("TenNhaPPSS"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getFloat("Dongia"));
                sp.setThoiGianNhan(rs.getDate("Thoigiannhan"));
                sp.setTongGia(rs.getFloat("Tonggia"));
                sp.setGhiChu(rs.getString("Ghichu"));
                
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
    
    //combobox mã danh mục
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
    
    //combobox mã tên sản phẩm
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
    
    //combobox mã nhà phân phối sản phẩm
    public ArrayList<String> LoadCBNPPSP(){
        
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
    
    // thêm mới sản phẩm
    
    public boolean addNewSanPham(SanPham sp){
                
           String sqlquery = "SELECT * FROM SANPHAM where MaSP = ? ";
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sqlquery);
               pst.setString(1, sp.getMaSP().trim());
               rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Đã có mã sản phẩm này ! ","Thông báo",2);
                   return false;
               }else
               {
                   String sql = "INSERT INTO SANPHAM(MaSP,MaDM,TenSP,SoLuong,Dongia,MaNhaPPSS,Thoigiannhan,Ghichu,Tonggia)VALUES (?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql
                   String sql2 = "INSERT INTO SANPHAMCONLAI(MaSP,MaDM,TenSP,SoLuong,Dongia,MaNhaPPSS,Thoigiannhan,Ghichu,Tonggia)VALUES (?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql 
                   
                   conn = connectDB.connectSQLServer();//mở kết nối
                   pst = conn.prepareStatement(sql);//  chuẩn bị truy vấn
                   
                   //truy vấn vào bảng chính
                   pst.setString(1, sp.getMaSP());
                   pst.setString(2, sp.getMaDM());
                   pst.setString(3, sp.getTenSP());
                   pst.setInt(4, sp.getSoLuong());
                   pst.setFloat(5, sp.getDonGia());
                   pst.setString(6, sp.getMaNPPSP());
                   pst.setDate(7, new Date(sp.getThoiGianNhan().getTime()));
                   pst.setString(8, sp.getGhiChu());
                   pst.setFloat(9, sp.getTongGia());
                                           
                   pst.executeUpdate();
                   
                   //truy vấn vào bảng phụ
                   
                   pst = conn.prepareStatement(sql2);//  chuẩn bị truy vấn
                                      
                   pst.setString(1, sp.getMaSP());
                   pst.setString(2, sp.getMaDM());
                   pst.setString(3, sp.getTenSP());
                   pst.setInt(4, sp.getSoLuong());
                   pst.setFloat(5, sp.getDonGia());
                   pst.setString(6, sp.getMaNPPSP());
                   pst.setDate(7, new Date(sp.getThoiGianNhan().getTime()));
                   pst.setString(8, sp.getGhiChu());
                   pst.setFloat(9, sp.getTongGia());
                   
                   
                   pst.executeUpdate();
                   conn.close();
                   pst.close();
                   
                   return true;
               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return false;
           }
        }
    
    //thêm vào bảng sản phẩm còn lại
    
     public boolean addNewSanPhamPhu(SanPham sp){
                
           String sqlquery = "SELECT * FROM SANPHAMCONLAI where MaSP = ? ";
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sqlquery);
               pst.setString(1, sp.getMaSP().trim());
               rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Đã có mã sản phẩm này ! ","Thông báo",2);
                   return false;
               }else
               {
                   String sql = "INSERT INTO SANPHAMCONLAI(MaSP,MaDM,TenSP,SoLuong,Dongia,MaNhaPPSS,Thoigiannhan,Ghichu,Tonggia)VALUES (?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql
                   
                   conn = connectDB.connectSQLServer();//mở kết nối
                   pst = conn.prepareStatement(sql);//  chuẩn bị truy vấn
                   
                   
                   pst.setString(1, sp.getMaSP());
                   pst.setString(2, sp.getMaDM());
                   pst.setString(3, sp.getTenSP());
                   pst.setInt(4, sp.getSoLuong());
                   pst.setFloat(5, sp.getDonGia());
                   pst.setString(6, sp.getMaNPPSP());
                   pst.setDate(7, new Date(sp.getThoiGianNhan().getTime()));
                   pst.setString(8, sp.getGhiChu());
                   pst.setFloat(9, sp.getTongGia());
                        
                   pst.executeUpdate();
                   conn.close();
                   pst.close();
                   
                   return true;
               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return false;
           }
        }
     
     
    // Update sản phẩm
    
    public boolean upDateSanPham(SanPham sp){

            String sql = "UPDATE SANPHAM SET MaDM = ?, TenSP= ?, SoLuong = ?, Dongia= ?, MaNhaPPSS = ?,Thoigiannhan = ?, Ghichu = ?, Tonggia=? WHERE MaSP = ?";
           try
           {
                   String maSP = sp.getMaSP();
                   
                   conn = connectDB.connectSQLServer();
                   pst = conn.prepareStatement(sql);
                   
                   pst.setString(1, sp.getMaDM());
                   pst.setString(2, sp.getTenSP());
                   pst.setInt(3, sp.getSoLuong());
                   pst.setFloat(4, sp.getDonGia());
                   pst.setString(5, sp.getMaNPPSP());
                   pst.setDate(6, new Date(sp.getThoiGianNhan().getTime()));
                   pst.setString(7, sp.getGhiChu());
                   pst.setFloat(8, sp.getTongGia());
                   pst.setString(9, sp.getMaSP());
                   
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
    
    //Delete sản phẩm
    
    public boolean deleteSanPham(String MaSP){
        
               String sql = "DELETE FROM SANPHAM WHERE MaSP = ?";
            try
            {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);
                pst.setString(1, MaSP);
                
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
