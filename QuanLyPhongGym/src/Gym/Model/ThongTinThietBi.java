/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym.Model;

/**
 *
 * @author Admin
 */
public class ThongTinThietBi {
  
    private String maThietBi;
    private String maDMTB;
    private String tenDMTB;
    private String tenThietBi;
    private int soLuong;
    private int donGia;
    private int tongGia;
    private String tinhTrang;
    private String maNhaPP;
    private String tenNPPTB;
    private String moTa;

    public ThongTinThietBi() {
    }

    public ThongTinThietBi(String maThietBi, String maDMTB, String tenDMTB, String tenThietBi, int soLuong, int donGia, int tongGia, String tinhTrang, String maNhaPP, String tenNPPTB, String moTa) {
        this.maThietBi = maThietBi;
        this.maDMTB = maDMTB;
        this.tenDMTB = tenDMTB;
        this.tenThietBi = tenThietBi;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongGia = tongGia;
        this.tinhTrang = tinhTrang;
        this.maNhaPP = maNhaPP;
        this.tenNPPTB = tenNPPTB;
        this.moTa = moTa;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getMaDMTB() {
        return maDMTB;
    }

    public void setMaDMTB(String maDMTB) {
        this.maDMTB = maDMTB;
    }

    public String getTenDMTB() {
        return tenDMTB;
    }

    public void setTenDMTB(String tenDMTB) {
        this.tenDMTB = tenDMTB;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaNhaPP() {
        return maNhaPP;
    }

    public void setMaNhaPP(String maNhaPP) {
        this.maNhaPP = maNhaPP;
    }

    public String getTenNPPTB() {
        return tenNPPTB;
    }

    public void setTenNPPTB(String tenNPPTB) {
        this.tenNPPTB = tenNPPTB;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
}
