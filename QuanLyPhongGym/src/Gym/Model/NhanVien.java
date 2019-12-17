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
public class NhanVien {
    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private int soDienThoai;
    private String diaChi;
    private String email;
    private Date ngayVaolam;
    private String tenTK;
    private String matKhau;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Date ngaySinh, boolean gioiTinh, int soDienThoai, String diaChi, String email, Date ngayVaolam, String tenTK, String matKhau, String chucVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.ngayVaolam = ngayVaolam;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayVaolam() {
        return ngayVaolam;
    }

    public void setNgayVaolam(Date ngayVaolam) {
        this.ngayVaolam = ngayVaolam;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }


    
}
