/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1;

import java.util.Scanner;

/**
 *
 * @author lenvo
 */
public class ChuViDuongTron {
    public static void main(String[] args)
    {
        System.out.println("Nhap ban kinh : ");
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        double CV = 2 *r * Math.PI;
        System.out.printf("Chu vi:  %.3f\n", CV);
        
    }
}
