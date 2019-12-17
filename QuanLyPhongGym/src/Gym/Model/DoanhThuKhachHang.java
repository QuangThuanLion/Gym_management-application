/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class DoanhThuKhachHang {
    
    private String hoTen;
    private String maGDK;
    private String tenGDK;
    private int donGia;
    private Date ngayDK;
    private Date ngayHHDK;

    public DoanhThuKhachHang() {
    }

    public DoanhThuKhachHang(String hoTen,String maGDK, String tenGDK, int donGia, Date ngayDK, Date ngayHHDK) {
        this.hoTen = hoTen;
        this.maGDK = maGDK;
        this.tenGDK = tenGDK;
        this.donGia = donGia;
        this.ngayDK = ngayDK;
        this.ngayHHDK = ngayHHDK;
    }
    public String getHoTen(){
        return hoTen;
    }
    
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    
    public String getMaGDK() {
        return maGDK;
    }

    public void setMaGDK(String maGDK) {
        this.maGDK = maGDK;
    }

    public String getTenGDK() {
        return tenGDK;
    }

    public void setTenGDK(String tenGDK) {
        this.tenGDK = tenGDK;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Date getNgayHHDK() {
        return ngayHHDK;
    }

    public void setNgayHHDK(Date ngayHHDK) {
        this.ngayHHDK = ngayHHDK;
    }
    
    
}
