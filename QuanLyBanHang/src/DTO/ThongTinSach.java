/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vukieuanh
 */
public class ThongTinSach {
    private String maSach;
    private String tenSach;
    private String maLoaiSach;
    private String maNXB;
    private int soLuong;
    private float giaTien;
    private String fileAnh;

    public ThongTinSach() {
    }

    public ThongTinSach(String maSach, String tenSach, String maLoaiSach, String maNXB, int soLuong, float giaTien, String fileAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maLoaiSach = maLoaiSach;
        this.maNXB = maNXB;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.fileAnh = fileAnh;
    }
    
    

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getMaLoaiSach() {
        return maLoaiSach;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public String getFileAnh() {
        return fileAnh;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setMaLoaiSach(String maLoaiSach) {
        this.maLoaiSach = maLoaiSach;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public void setFileAnh(String fileAnh) {
        this.fileAnh = fileAnh;
    }
    
    
}
