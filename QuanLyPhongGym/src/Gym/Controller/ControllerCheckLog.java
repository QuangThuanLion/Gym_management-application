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
import Controller.connectDB;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class ControllerCheckLog {
        
        public static ResultSet rs = null;
        public static PreparedStatement pst = null;
        public static Connection conn = null;
        
        
        public static String testConnect(){
        
            try
            {
                conn = connectDB.connectSQLServer();
                return "Kết nối CSDL thành công";
            }
            catch(ClassNotFoundException | SQLException e)
            {
                return "Kết nối CSDL thất bại";
            }
        }
        
        //check login
//        public static ResultSet cLog(String user, String pass)
//        {
//            String sql = "SELECT *from NHANVIEN where TenTK = ? and Matkhau =?";
//            try {        
//                pst = conn.prepareStatement(sql);
//                pst.setString(1, user);
//                pst.setString(2, pass);
//                return rs = pst.executeQuery();
//            } catch (Exception e) 
//            {
//                return rs = null;
//            }
//                
//        }
}
