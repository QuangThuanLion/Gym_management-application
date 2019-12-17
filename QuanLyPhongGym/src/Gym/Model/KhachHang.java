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
public class KhachHang {
    
    private String maKH;
    private String tenKH;
    private Date ngaySinh; //dd/MM/yyyy
    private boolean gioiTinh;
    private String diaChi;
    private int soDienThoai;
    private String email;
    private String maGoiDK;
    private Date ngayDK; //dd/MM/yyyy
    private Date ngayHetHanDK; //dd/MM/yyyy

    public KhachHang() {
        
    }
//String goiDK,
    public KhachHang(String maKH, String tenKH, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String email, String maGoiDK, Date ngayDK, Date ngayHetHanDK) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.maGoiDK = maGoiDK;
//        this.goiDK = goiDK;
        this.ngayDK = ngayDK;
        this.ngayHetHanDK = ngayHetHanDK;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaGoiDK() {
        return maGoiDK;
    }

    public void setMaGoiDK(String maGoiDK) {
        this.maGoiDK = maGoiDK;
    }

//    public String getGoiDK() {
//        return goiDK;
//    }
//
//    public void setGoiDK(String goiDK) {
//        this.goiDK = goiDK;
//    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Date getNgayHetHanDK() {
        return ngayHetHanDK;
    }

    public void setNgayHetHanDK(Date ngayHetHanDK) {
        this.ngayHetHanDK = ngayHetHanDK;
    }
           
    
}
