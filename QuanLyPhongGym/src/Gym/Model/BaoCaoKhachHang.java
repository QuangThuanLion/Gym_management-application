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
public class BaoCaoKhachHang {
    
    private String maKH;
    private String goiDK;
    private Date tuNgay;
    private Date denNgay;
    private float tongDoanhThu;

    public BaoCaoKhachHang(String maKH, String goiDK, Date tuNgay, Date denNgay, float tongDoanhThu) {
        this.maKH = maKH;
        this.goiDK = goiDK;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tongDoanhThu = tongDoanhThu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getGoiDK() {
        return goiDK;
    }

    public void setGoiDK(String goiDK) {
        this.goiDK = goiDK;
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

    public float getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(float tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
    
    
}
