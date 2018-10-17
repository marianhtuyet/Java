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
public class Buoi1 {

    /**
     * @param args the command line arguments
     */
    //bai 1
    public static void Bai1()
    {
        System.out.println("Hello World!");
    }
    // bai 5
    public static void Bai5(){
        System.out.println("Nhap vao 2 so a va b:  ");
        Scanner in  = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        double kq = a/b;
        System.out.printf("Ket qua = %.3f\n", kq);
    }
    public static void Bai6(){
        int n;
        System.out.println("Nhap so n: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double sum =0;
        for(int i=1;i<=n;i++)
        {
            sum += Math.pow(i, i);
        }
        System.out.printf("Tong = %.3f", sum);
    }
    //bai 7
    public static void Bai7() {
        int n;
        System.out.println("Nhap so n: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int count = 1;
        while (n/10 !=0) {            
            count++;
            n = n/10;
        }
        System.out.printf("So luong cu so trong n: %d\n", count);
    }
    //bai 8
    public static void Bai8() {
        int n;
        String n1, reverse;
        System.out.println("Nhap vao so n:  \n");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        n1 = Integer.toString(n);
        reverse = new StringBuffer(n1).reverse().toString();
        if(n1.equals(reverse))
            System.out.println(" n La so doi xung");
        else 
            System.out.println("n Khong phai la so doi xung");
        if(n < 2)
            System.out.println("n la so nguyen to!");
        int check=-1;
        for(int i=2; i<n;i++)
        {
            if(n%i == 0)
                 check = 0;
        }
        if(check == 0)
            System.out.println(" va khong phai so nguyen to");
        else
            System.out.println(" va la so nguyen to");
    }
    
    //bai 9
    public static void Bai9(){
        String a, b;
        System.out.println("nhap vao 2 chuoi 1 chuoi 1 dong: ");
        Scanner in = new Scanner(System.in);
        a = in.nextLine();
        b = in.nextLine();
        //a. tong chieu dai
        int sum = a.length() + b.length();
        System.out.println("Tong hai chuoi = %" +sum);
        String a1 = a.substring(0,3);//3 ki tu cua x
        System.out.printf("\nBa ki tu cua x: %s" , a1);
        String c = b.substring((b.length()-3));
        System.out.printf("\\nBa ki tu  cuoi cua y: %s" , c);
        char d = a.charAt(6);
        System.out.printf("\nKi tu thu 6 cua x: %s", d);
        String e = a1 + c;
        if(a.equals(b)== true)
            System.out.println("\nhai chuoi bang nhau");
        else
            System.out.println("\nhai chuoi khong bang nhau");
        
        if(a.equalsIgnoreCase(b)== true)
            System.out.println("\nhai chuoi bang nhau (khong phan biet kieu chu)");
        else
            System.out.println("\nhai chuoi khong bang nhau (khong phan biet kieu chu)");
        int index = a.indexOf(b);
        
        if(index == -1)
            System.out.print("\ny khong nam trong x\n");
        else
        {
            System.out.println("\ny nam trong x\n");
            
        }
                    
        
        
        
        
    }
    //bai 1
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bai9();
    }
    
}
