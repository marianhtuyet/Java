/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lenvo
 */
public class Student {
    private int ID;
    private String Name;
    private float avgScore;
    int getID(){return ID; }
    String getName(){ return Name;}
    float getAvgScore(){return avgScore;}
    void set(int ID){ this.ID = ID;}
    void set(String Name){ this.Name = Name;}
    void set(float avgScore){this.avgScore = avgScore;}
    
    void Input()
    {
        System.out.println("Nhap MSSV:  ");
        Scanner in = new Scanner(System.in);
        ID = in.nextInt();
        System.out.print("Nhap ten Sv: ");
        Name = in.next();
        System.out.print("Nhap DTB cua sinh vien: ");
        avgScore = in.nextFloat();   
    }
    void Output()
    {
        System.out.println("MSSV: " + ID );
        System.out.println("Ho Ten: " + Name );
        System.out.println("DTB: " + avgScore);
    }
    
  
    
    
}
