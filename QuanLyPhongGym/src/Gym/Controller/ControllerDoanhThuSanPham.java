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
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import Gym.Model.DoanhThuSanPham;


/**
 *
 * @author Admin
 */
public class ControllerDoanhThuSanPham {
    
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static Statement stt = null;
    public static ResultSet rs = null;
    
    public List<DoanhThuSanPham> getDoanhThuSanPhamFromDB(){
    
        List<DoanhThuSanPham> listDoanhThu = new ArrayList<DoanhThuSanPham>();
        
        String sql = "SELECT * FROM View_DoanhThuSanPham";
        
        try
        {
            conn = connectDB.connectSQLServer();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            DoanhThuSanPham doanhThuSanPham = null;
            while(rs.next()){
             
                doanhThuSanPham = new DoanhThuSanPham();
                
                doanhThuSanPham.setMaHD(rs.getString("MaHD"));
                doanhThuSanPham.setMaSP(rs.getString("MaSP"));
                doanhThuSanPham.setMaDM(rs.getString("MaDM"));
                doanhThuSanPham.setTenDM(rs.getString("TenDM"));
                doanhThuSanPham.setTenSP(rs.getString("TenSP"));
                doanhThuSanPham.setGiaNhap(rs.getFloat("Dongia"));
                doanhThuSanPham.setSoLuong(rs.getInt("Soluong"));
                doanhThuSanPham.setGiaBan(rs.getFloat("Giaban"));
                doanhThuSanPham.setTongGia(rs.getFloat("TongGia"));
                doanhThuSanPham.setNgayBan(rs.getDate("Ngayban"));
                doanhThuSanPham.setTinhTrang(rs.getString("TinhTrang"));
                doanhThuSanPham.setMaNPPSP(rs.getString("MaNhaPPSS"));
                doanhThuSanPham.setTenNPPSP(rs.getString("TenNhaPPSS"));
                
                listDoanhThu.add(doanhThuSanPham);
                
            }
            return listDoanhThu;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<String> loadCBTENDMSP(){
        
        ArrayList<String> listCBTENSP = new ArrayList<String>();
        String sql = "SELECT * FROM DANHMUCSANPHAM";// chuoi truy van
        try
        {
            conn = connectDB.connectSQLServer();// ket noi csdl
            pst = conn.prepareStatement(sql);//chua bi truy van
            rs = pst.executeQuery();//truy van
            //doc ket qua
            while(rs.next()){
                
                listCBTENSP.add(rs.getString("TenDM"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listCBTENSP;
    }
    
    
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
}
