/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BaoCaoSanPham {
    
    private String maSP;
    private String maTenSP;
    private String maLoaiSP;
    private String tenSP;
    private Date tuNgay;
    private Date denNgay;
    private int tongSP;
    private float tongGia;

    public BaoCaoSanPham(String maSP, String maTenSP, String maLoaiSP, String tenSP, Date tuNgay, Date denNgay, int tongSP, float tongGia) {
        this.maSP = maSP;
        this.maTenSP = maTenSP;
        this.maLoaiSP = maLoaiSP;
        this.tenSP = tenSP;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tongSP = tongSP;
        this.tongGia = tongGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaTenSP() {
        return maTenSP;
    }

    public void setMaTenSP(String maTenSP) {
        this.maTenSP = maTenSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

    public int getTongSP() {
        return tongSP;
    }

    public void setTongSP(int tongSP) {
        this.tongSP = tongSP;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }
    
    
}
