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
public class chiTietKhuyenMai {
    private String maGiamGia;
    private String maSach;
    private Float tienKhuyenMai;

    public chiTietKhuyenMai(String maGiamGia, String maSach, Float tienKhuyenMai) {
        this.maGiamGia = maGiamGia;
        this.maSach = maSach;
        this.tienKhuyenMai = tienKhuyenMai;
    }

    public chiTietKhuyenMai() {
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Float getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public void setTienKhuyenMai(Float tienKhuyenMai) {
        this.tienKhuyenMai = tienKhuyenMai;
    }
    
    
}
