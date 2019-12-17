/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Controller;

import Controller.connectDB;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import Gym.Model.ThietBi;
import Gym.Model.ThongTinThietBi;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Controllerthietbi {
    
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Statement stt = null;
    
    //viết hàm lấy dữ liệu từ database
    
    public List<ThongTinThietBi> getDataThietBi(){
        
        List<ThongTinThietBi> listThietBi = new ArrayList<ThongTinThietBi>();
        
        String sql = "SELECT * FROM View_ThietBi";
        
        try
        {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery();
               
               while(rs.next())
               {
               
                   ThongTinThietBi thietBi = new ThongTinThietBi();
                   
                   thietBi.setMaThietBi(rs.getString("Mathietbi"));
                   thietBi.setMaDMTB(rs.getString("MaDMTB"));
                   thietBi.setTenDMTB(rs.getString("TenDMTH"));
                   thietBi.setTenThietBi(rs.getString("Tenthietbi"));
                   thietBi.setSoLuong(rs.getInt("Soluong"));
                   thietBi.setDonGia(rs.getInt("Dongia"));
                   thietBi.setTongGia(rs.getInt("Tonggia"));
                   thietBi.setTinhTrang(rs.getString("Tinhtrang"));
                   thietBi.setMaNhaPP(rs.getString("MaNhaPPTB"));
                   thietBi.setTenNPPTB(rs.getString("TenNhaPPTB"));
                   thietBi.setMoTa(rs.getString("Mota"));
                   
                   listThietBi.add(thietBi);
               }
               return listThietBi;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
                
    }
    
    //load CB tên danh mục thiết bị
    
    public ArrayList<String> loadCBDMTB(){
        
        ArrayList<String> listCBDMTB = new ArrayList<String>();
        String sql = "SELECT * FROM DANHMUCTHIETBI";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBDMTB.add(rs.getString("MaDMTB"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBDMTB;
    }
    
    //combobox mã nhà phân phối thiết bị
    public ArrayList<String> LoadCBNPPTB(){
        
        ArrayList<String> listCBNPPTB = new ArrayList<String>();
        String sql = "SELECT * FROM NHAPHANPHOITHIETBI";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBNPPTB.add(rs.getString("MaNhaPPTB"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBNPPTB;
    }
    
    //thêm mới thiết bị
    
    public boolean addNewThietBi(ThietBi tb){
                
           String sqlquery = "SELECT * FROM THIETBITAP where Mathietbi = ? ";
           try
           {
               conn = connectDB.connectSQLServer();
               pst = conn.prepareStatement(sqlquery);
               pst.setString(1, tb.getMaThietBi().trim());
               rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Đã có mã thiết bị này ! ","Thông báo",2);
                   return false;
               }else
               {
                   String sql = "INSERT INTO THIETBITAP(Mathietbi,MaDMTB,Tenthietbi,Soluong,Dongia,Tonggia,Tinhtrang,MaNhaPPTB,Mota)VALUES (?,?,?,?,?,?,?,?,?)"; //chuỗi truy vấn sql
                   
                   conn = connectDB.connectSQLServer();//mở kết nối
                   pst = conn.prepareStatement(sql);//  chuẩn bị truy vấn
                   
                   
                   pst.setString(1, tb.getMaThietBi());
                   pst.setString(2, tb.getMaDMTB());
                   pst.setString(3, tb.getTenThietBi());
                   pst.setInt(4, tb.getSoLuong());
                   pst.setInt(5, tb.getDonGia());
                   pst.setInt(6, tb.getTongGia());
                   pst.setString(7, tb.getTinhTrang());
                   pst.setString(8, tb.getMaNhaPP());
                   pst.setString(9, tb.getMoTa());
                   
                        
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
    
    //update thiết bị
    
    public boolean upDateThietBi(ThietBi tb){

            String sql = "UPDATE THIETBITAP SET MaDMTB = ?, Tenthietbi= ?, Soluong = ?, Dongia= ?, Tonggia = ?,Tinhtrang = ?, MaNhaPPTB = ?, Mota=? WHERE Mathietbi = ?";
           try
           {
                   String maTB = tb.getMaThietBi();
                   
                   conn = connectDB.connectSQLServer();
                   pst = conn.prepareStatement(sql);
                   
                   pst.setString(1, tb.getMaDMTB());
                   pst.setString(2, tb.getTenThietBi());
                   pst.setInt(3, tb.getSoLuong());
                   pst.setInt(4, tb.getDonGia());
                   pst.setInt(5, tb.getTongGia());
                   pst.setString(6, tb.getTinhTrang());
                   pst.setString(7, tb.getMaNhaPP());
                   pst.setString(8, tb.getMoTa());
                   pst.setString(9, tb.getMaThietBi());
                   
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
    
    //delete thiết bị
    
    public boolean deleteThietBi(String tb){
        
               String sql = "DELETE FROM THIETBITAP WHERE Mathietbi = ?";
            try
            {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);
                pst.setString(1, tb);
                
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
