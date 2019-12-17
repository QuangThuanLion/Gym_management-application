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
public class QuanlyCongNoKH {
    
    private String maKH;
    private String tenKH;
    private String maSP;
    private String tenSP;
    private int soTienNo;
    private String ghiChu;

    public QuanlyCongNoKH() {
    }

    public QuanlyCongNoKH(String maKH, String tenKH, String maSP, String tenSP, int soTienNo, String ghiChu) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soTienNo = soTienNo;
        this.ghiChu = ghiChu;
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

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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
