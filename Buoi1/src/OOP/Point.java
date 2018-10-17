/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP;

import java.util.Scanner;

/**
 *
 * @author lenvo
 */
public class Point
{
    public int iHoanh ;
    public int iTung ;
    
    public void Nhap()
    {
        System.out.println("Nhap toa do (x, y): ");
        Scanner in = new Scanner(System.in);
        iHoanh = in.nextInt();
        iTung = in.nextInt();
                
    }
    
    public void Xuat()
    {
        System.out.println(iHoanh +","+ iTung + "\n");
    }
    public double TinhKhoangcach(Point b)
    {
        return Math.sqrt(Math.pow((this.iHoanh- b.iHoanh), 2) + Math.pow((this.iTung- b.iTung), 2)); 
    }
}


