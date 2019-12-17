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
public class BanSanPham {
    
//    private String maDH;
    private String maSP;
    private String maDM;
    private String tenSP;
    private String NPPSP;
    private float donGia;
    private String maHD;
    private int soLuong;
    private float giaBan;
    private float tongGia;
    private Date ngayBan;
    private String tinhTrang;

    public BanSanPham() {
    }

    public BanSanPham(String maSP, String maDM, String tenSP, String NPPSP, float donGia, String maHD, int soLuong, float giaBan, float tongGia, Date ngayBan, String tinhTrang) {
        this.maSP = maSP;
        this.maDM = maDM;
        this.tenSP = tenSP;
        this.NPPSP = NPPSP;
        this.donGia = donGia;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongGia = tongGia;
        this.ngayBan = ngayBan;
        this.tinhTrang = tinhTrang;
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

    public String getNPPSP() {
        return NPPSP;
    }

    public void setNPPSP(String NPPSP) {
        this.NPPSP = NPPSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}
