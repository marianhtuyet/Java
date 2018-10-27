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
public class TieuThuyet extends Sach{
    private String TrangThai;
    @Override
    public double ThanhTien(){
        if(TrangThai.equals("Moi") || TrangThai.equals("moi"))
                return super.getSoLuong()*super.getTriGia();
        else
            return super.getSoLuong()*super.getTriGia()*0.2;
    }
    public void Nhap()
    {
        super.Nhap();
        System.out.println("\nNhap trang thai sach  ");
        Scanner scan = new Scanner(System.in);
        this.TrangThai = scan.next();
    }
    public void Xuat(){
        super.Xuat();
        System.out.print("\nTrang thai: " + this.TrangThai);
    }
}
