/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanghoa;

import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public class HangHoa {

    /**
     * @param args the command line arguments
     */
    protected int MaHang;
    protected  String TenHang;
   protected  int SLTon;
    protected double DonGia;

    

    public HangHoa(int MaHang, String TenHang, int SLTon, double DonGia) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.SLTon = SLTon;
        this.DonGia = DonGia;
    }

    public HangHoa() {
    }
    public int getMaHang() {
        return MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public int getSLTon() {
        return SLTon;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public void setSLTon(int SLTon) {
        this.SLTon = SLTon;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    public  String MucDoBanBuon() {
        return null;
    }
    public  double ThanhTien(){
        return SLTon * DonGia;
    }
    public  void Nhap(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ma hang hoa: ");
        this.MaHang = scan.nextInt();
        System.out.println("\nNhap ten hang hoa");
        this.TenHang = scan.next();
        System.out.println("\nSo luong ton : ");
        this.SLTon = scan.nextInt();
        System.out.println("\nDon gia: ");
        this.DonGia = scan.nextDouble();
    }
    public  void Xuat(){
        
        System.out.println("\nNhap ma hang hoa: " + this.MaHang);
        System.out.println("\nNhap ten hang hoa" + this.TenHang);
        System.out.println("\nSo luong ton : " + this.SLTon);
        System.out.println("\nDon gia: %2f" + this.DonGia);
    }
    
        
}
