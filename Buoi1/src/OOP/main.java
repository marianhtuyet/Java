/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP;

/**
 *
 * @author lenvo
 */
public class main  {
    public static void main(String[] args) {
        Point a = new Point();
        Point b = new Point();
        a.Nhap();
        b.Nhap();
        System.out.println("Toa do 2 diem a va b: ");
        a.Xuat();
        b.Xuat();
        System.out.printf("Khoang cach = %.3f\n", a.TinhKhoangcach(b));
    }
}
