/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MyPC
 */
public class CongViec {
    String MaCV;
    String TenCongViec ;
    int DonGia ;

    public String getTenCongViec() {
        return TenCongViec;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setTenCongViec(String TenCongViec) {
        this.TenCongViec = TenCongViec;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    public String toString()
    {
        return  TenCongViec;
    }
    
}
