/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public abstract class Sach {

    /**
     * @param args the command line arguments
     */
    private int MaSach;
    private String TenSach;
    private Double TriGia;
    private int SoLuong;
    private String NXB;
    
    public void setMaSach(int MaSach){
        this.MaSach = MaSach;
    }
   
    public void setTenSach(String Ten){
        this.TenSach = Ten;
    }
    
    public void setTriGia(double TriGia){
        this.TriGia = TriGia;
    }
    
    public void setSoLuong(int SoLuong){
        this.SoLuong = SoLuong;
    }
    public void setNXB(String NXB){
        this.NXB = NXB;
    }
    public int getMaSach(){return MaSach;}
    public String getTenSach(){return TenSach;}
    public double getTriGia(){return this.TriGia;}
    public int getSoLuong(){return this.SoLuong;}
    public String getNXB(){return this.NXB;}
    public double ThanhTien(){return 0;}
    public void Nhap(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        this.TenSach = scan.next();
        System.out.println("Nhap tri gia");
        this.TriGia = scan.nextDouble();
        System.out.println("So Luong: ");
        this.SoLuong = scan.nextInt();
        System.out.println("Nha xuat ban: ");
        this.NXB = scan.next();
    }
    public void Xuat(){
        System.out.println("Ma sach: " + this.MaSach);
        System.out.println("\nTen sach: " + this.TenSach);
        System.out.println("\nTri gia: " + this.TriGia);
        System.out.println("\nSo luong: " + this.SoLuong);
        System.out.println("\nNha xuat ban: " + this.NXB);
    }
}
