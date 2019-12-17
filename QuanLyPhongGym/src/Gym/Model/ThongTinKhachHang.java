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
public class ThongTinKhachHang {
    
    private String maKH;
    private String hoTenKH;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String maGoi;
    private String tenGoi;
    private Date ngayDK;
    private Date ngayHHDK;
    private int soDienThoai;
    private String diaChi;
    private String email;

    public ThongTinKhachHang() {
    }

    public ThongTinKhachHang(String maKH, String hoTenKH, Date ngaySinh, boolean gioiTinh,String maGoi,String tenGoi, Date ngayDK, Date ngayHHDK, int soDienThoai, String diaChi, String email) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maGoi = maGoi;
        this.tenGoi = tenGoi;
        this.ngayDK = ngayDK;
        this.ngayHHDK = ngayHHDK;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public String getMaGoi(){
        return maGoi;
    }
    
    public void setMaGoi(String maGoi){
        this.maGoi = maGoi;
    }
    
    public String getTenGoi() {
        return tenGoi;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Date getNgayHHDK() {
        return ngayHHDK;
    }

    public void setNgayHHDK(Date ngayHHDK) {
        this.ngayHHDK = ngayHHDK;
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

    
    
    
    
}
