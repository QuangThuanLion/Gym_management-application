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
public class ThongTinSanPham {
    
    private String maSP;
    private String maDM;
    private String tenDM;
    private String tenSP;
    private String maNPPSP;
    private String nhaPP;
    private int soLuong;
    private float donGia;
    private Date thoiGianNhan;
    private float tongGia;
    private String ghiChu;

    public ThongTinSanPham() {
    }

    public ThongTinSanPham(String maSP, String maDM, String tenDM, String tenSP, String maNPPSP, String nhaPP, int soLuong, float donGia, Date thoiGianNhan, float tongGia, String ghiChu) {
        this.maSP = maSP;
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.tenSP = tenSP;
        this.maNPPSP = maNPPSP;
        this.nhaPP = nhaPP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thoiGianNhan = thoiGianNhan;
        this.tongGia = tongGia;
        this.ghiChu = ghiChu;
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

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaNPPSP() {
        return maNPPSP;
    }

    public void setMaNPPSP(String maNPPSP) {
        this.maNPPSP = maNPPSP;
    }

    public String getNhaPP() {
        return nhaPP;
    }

    public void setNhaPP(String nhaPP) {
        this.nhaPP = nhaPP;
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

    public Date getThoiGianNhan() {
        return thoiGianNhan;
    }

    public void setThoiGianNhan(Date thoiGianNhan) {
        this.thoiGianNhan = thoiGianNhan;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
