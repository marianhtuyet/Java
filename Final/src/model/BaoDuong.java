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
public class BaoDuong {
    String MaBD ;
    String NgayGioNhan ;
    String NGayGioTra ;
    int SoKM;
    String SoXe;
    String NoiDung ;

    public void setMaBD(String MaBD) {
        this.MaBD = MaBD;
    }

    public void setNgayGioNhan(String NgayGioNhan) {
        this.NgayGioNhan = NgayGioNhan;
    }

    public void setNGayGioTra(String NGayGioTra) {
        this.NGayGioTra = NGayGioTra;
    }

    public void setSoKM(int SoKM) {
        this.SoKM = SoKM;
    }

    public void setSoXe(String SoXe) {
        this.SoXe = SoXe;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getMaBD() {
        return MaBD;
    }

    public String getNgayGioNhan() {
        return NgayGioNhan;
    }

    public String getNGayGioTra() {
        return NGayGioTra;
    }

    public int getSoKM() {
        return SoKM;
    }

    public String getSoXe() {
        return SoXe;
    }

    public String getNoiDung() {
        return NoiDung;
    }
    
    @Override
    public String toString()
    {
        return SoXe;
    }
}
