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
public class LuongNhanVien {
    
    private String maNV;
    private String tenNV;
    private String chucVu;
    private Date tuNgay;
    private Date denNgay;
    private int ngayCongChuan;
    private int tongNgayCong;
    private float luongCoBan;
    private float luongChinh;
    private float luongPhuCap;
    private float tongGioTangCa;
    private float luongTangCa;
    private double tongLuong;
    private String ghiChu;

    public LuongNhanVien() {
    }

    public LuongNhanVien(String maNV, String tenNV, String chucVu, Date tuNgay, Date denNgay, int ngayCongChuan, int tongNgayCong, float luongCoBan, float luongChinh, float luongPhuCap, float tongGioTangCa, float luongTangCa, double tongLuong, String ghiChu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.chucVu = chucVu;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.ngayCongChuan = ngayCongChuan;
        this.tongNgayCong = tongNgayCong;
        this.luongCoBan = luongCoBan;
        this.luongChinh = luongChinh;
        this.luongPhuCap = luongPhuCap;
        this.tongGioTangCa = tongGioTangCa;
        this.luongTangCa = luongTangCa;
        this.tongLuong = tongLuong;
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public int getNgayCongChuan() {
        return ngayCongChuan;
    }

    public void setNgayCongChuan(int ngayCongChuan) {
        this.ngayCongChuan = ngayCongChuan;
    }

    public int getTongNgayCong() {
        return tongNgayCong;
    }

    public void setTongNgayCong(int tongNgayCong) {
        this.tongNgayCong = tongNgayCong;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getLuongChinh() {
        return luongChinh;
    }

    public void setLuongChinh(float luongChinh) {
        this.luongChinh = luongChinh;
    }

    public float getLuongPhuCap() {
        return luongPhuCap;
    }

    public void setLuongPhuCap(float luongPhuCap) {
        this.luongPhuCap = luongPhuCap;
    }

    public float getTongGioTangCa() {
        return tongGioTangCa;
    }

    public void setTongGioTangCa(float tongGioTangCa) {
        this.tongGioTangCa = tongGioTangCa;
    }

    public float getLuongTangCa() {
        return luongTangCa;
    }

    public void setLuongTangCa(float luongTangCa) {
        this.luongTangCa = luongTangCa;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
