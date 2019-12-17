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
public class SanPham {
    
    private String maSP;
    private String maDM;
    private String tenSP;
    private int soLuong;
    private float donGia;
    private String maNPPSP;
    private Date thoiGianNhan;
    private String ghiChu;
    private float tongGia;

    public SanPham() {
    }

    public SanPham(String maSP, String maDM, String tenSP, int soLuong, float donGia, String maNPPSP, Date thoiGianNhan, String ghiChu, float tongGia) {
        this.maSP = maSP;
        this.maDM = maDM;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maNPPSP = maNPPSP;
        this.thoiGianNhan = thoiGianNhan;
        this.ghiChu = ghiChu;
        this.tongGia = tongGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getMaNPPSP() {
        return maNPPSP;
    }

    public void setMaNPPSP(String maNPPSP) {
        this.maNPPSP = maNPPSP;
    }

    public Date getThoiGianNhan() {
        return thoiGianNhan;
    }

    public void setThoiGianNhan(Date thoiGianNhan) {
        this.thoiGianNhan = thoiGianNhan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }
    

   
}
