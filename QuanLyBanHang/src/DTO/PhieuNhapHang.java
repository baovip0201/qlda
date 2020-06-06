/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author MSI
 */
public class PhieuNhapHang {
    private String maNH;
    private String maNV;
    private String maNXB;
    private String tinhTrang;
    private Float tongTien;
    private Date ngayNhap;
    public PhieuNhapHang(){
        
    }
    public PhieuNhapHang(String maNH, String maNV, String maNXB, String tinhTrang, Float tongTien, Date ngayNhap){
        this.maNH=maNH;
        this.maNV=maNV;
        this.maNXB=maNXB;
        this.tinhTrang=tinhTrang;
        this.tongTien=tongTien;
        this.ngayNhap=ngayNhap;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
}
