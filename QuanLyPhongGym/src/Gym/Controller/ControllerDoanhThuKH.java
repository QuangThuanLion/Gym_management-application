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
import Gym.Model.DoanhThuKhachHang;

import Controller.connectDB;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class ControllerDoanhThuKH {
    
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static Statement stt = null;
    public static ResultSet rs = null;
    
    public List<DoanhThuKhachHang> getDoanhThuFromDB(){
    
        List<DoanhThuKhachHang> listDoanhThu = new ArrayList<DoanhThuKhachHang>();
        String sql = "SELECT * FROM View_DoanhThuKhachHang";
        
        try
        {
                conn = connectDB.connectSQLServer();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                
                DoanhThuKhachHang doanhThuKhachHang;
                while(rs.next()){
                
                    doanhThuKhachHang = new DoanhThuKhachHang();
                    
                    doanhThuKhachHang.setHoTen(rs.getString("Hoten"));
                    doanhThuKhachHang.setMaGDK(rs.getString("MaGoiDk"));
                    doanhThuKhachHang.setTenGDK(rs.getString("Tengoi"));
                    doanhThuKhachHang.setDonGia(rs.getInt("Dongia"));
                    doanhThuKhachHang.setNgayDK(rs.getDate("NgayDK"));
                    doanhThuKhachHang.setNgayHHDK(rs.getDate("NgayHetHanDk"));
                    
                    listDoanhThu.add(doanhThuKhachHang);
                    
                }
                return listDoanhThu;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    //load combobox goi dang ky
    
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
                
                listCBGDK.add(rs.getString("Tengoi"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBGDK;
    }
    
}
