/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public class main {
    public static void main(String[] args) {
        ArrayList<Sach> lSach = new ArrayList<Sach>();
        System.out.print("Nhap So luong sach: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap loai sach \n1: Tieu thuyet\n2: TrinhTham");
            int LoaiSach = scan.nextInt();
            if(LoaiSach == 1)
            {
                TieuThuyet temp = new TieuThuyet();
                temp.setMaSach(LoaiSach);
                temp.Nhap();
                lSach.add(temp);
            }
            else
            {
                TrinhTham temp = new TrinhTham();
                temp.setMaSach(LoaiSach);
                temp.Nhap();
                lSach.add(temp);
            }
        }
        double sumTieuThuyet =0 , sumTrinhTham =0;
        for(Sach i : lSach)
        {
            if(i.getMaSach()==1)
            {
                sumTieuThuyet += i.ThanhTien();
            }
            else
                sumTrinhTham += i.ThanhTien();
        }
        System.out.println("Tong tien sach tieu thuyet: \n" + sumTieuThuyet);
        System.out.println("Tong tien sach trinh tham : \n" + sumTrinhTham);  
        System.out.println("Nhap ten nha xuat ban: ");
        String NXB = scan.next();
        for(Sach i : lSach)
        {
            if(i.getNXB().equals(NXB)){
               i.Xuat();
            }
        }
    }
    
}
