/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MSI
 */
public class ChiTietPhieuNhapHang {
    private String maNH;
    private String maSach;
    private int soLuong;
    private Float giaNhap;
    public ChiTietPhieuNhapHang(){
        
    }
    public ChiTietPhieuNhapHang(String maNH,String maSach, int soLuong, Float giaNhap){
        this.maNH=maNH;
        this.maSach=maSach;
        this.soLuong=soLuong;
        this.giaNhap=giaNhap;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Float giaNhap) {
        this.giaNhap = giaNhap;
    }
    
}
