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
public class TrinhTham extends Sach{
    private float Thue;
    @Override
    public double ThanhTien(){
        return super.getSoLuong()*super.getTriGia() + this.Thue;
    }
    @Override
    public void Nhap()
    {
        super.Nhap();
        System.out.println("\nNhap thue sach ");
        Scanner scan = new Scanner(System.in);
        this.Thue = scan.nextFloat();
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.print("\nThue: " + this.Thue);
    }
}
