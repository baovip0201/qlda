/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Thanh Phuc
 */
public class NhanVien {
    private String maNv;
    private String maCv;
    private String hoTen;
    private String gioiTinh; 
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private Float luong;
    public NhanVien(){
        
    }

    public NhanVien(String maNv) {
        this.maNv = maNv;
    }

    public NhanVien(String maNv, String maCv, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String email, Float luong) {
        this.maNv = maNv;
        this.maCv = maCv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.luong = luong;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaCv() {
        return maCv;
    }

    public void setMaCv(String maCv) {
        this.maCv = maCv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGender() {
        return gioiTinh;
    }

    public void setGender(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getDob() {
        return ngaySinh;
    }

    public void setDob(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getLuong() {
        return luong;
    }

    public void setLuong(Float luong) {
        this.luong = luong;
    }
}
