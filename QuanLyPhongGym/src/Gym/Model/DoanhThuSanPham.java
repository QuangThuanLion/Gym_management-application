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
public class DoanhThuSanPham {
    
    private String maHD;
    private String maSP;
    private String maDM;
    private String tenDM;
    private String tenSP;
    private float giaNhap;
    private int soLuong;
    private float giaBan;
    private float tongGia;
    private Date ngayBan;
    private String tinhTrang;
    private String MaNPPSP;
    private String tenNPPSP;

    public DoanhThuSanPham() {
    }

    public DoanhThuSanPham(String maHD, String maSP, String maDM, String tenDM, String tenSP, float giaNhap,int soLuong, float giaBan, float tongGia, Date ngayBan, String tinhTrang, String MaNPPSP, String tenNPPSP) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongGia = tongGia;
        this.ngayBan = ngayBan;
        this.tinhTrang = tinhTrang;
        this.MaNPPSP = MaNPPSP;
        this.tenNPPSP = tenNPPSP;
    }
    
    public String getMaHD(){
        return maHD;
    }
    
    public void setMaHD(String maHD){
        this.maHD = maHD;
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
    
    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
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

    public String getMaNPPSP() {
        return MaNPPSP;
    }

    public void setMaNPPSP(String MaNPPSP) {
        this.MaNPPSP = MaNPPSP;
    }

    public String getTenNPPSP() {
        return tenNPPSP;
    }

    public void setTenNPPSP(String tenNPPSP) {
        this.tenNPPSP = tenNPPSP;
    }
    
    
}
