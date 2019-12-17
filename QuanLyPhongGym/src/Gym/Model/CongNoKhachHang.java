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
public class CongNoKhachHang {
    
    private String maKH;
    private String hoTen;
    private String maSP;
    private int soTienNo;
    private String ghiChu;

    public CongNoKhachHang() {
    }

    public CongNoKhachHang(String maKH, String hoTen, String maSP, int soTienNo, String ghiChu) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.maSP = maSP;
        this.soTienNo = soTienNo;
        this.ghiChu = ghiChu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoTienNo() {
        return soTienNo;
    }

    public void setSoTienNo(int soTienNo) {
        this.soTienNo = soTienNo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
}
