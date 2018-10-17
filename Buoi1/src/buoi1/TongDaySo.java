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
public class TongDaySo {
    public static void main(String[] args) {
        int n;
        System.out.println("Nhap so n");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double sum = (Math.pow(n, 2))/2 + (n/2);
        System.out.printf("Tong day so:  %.3f \n", sum);
    }
}

