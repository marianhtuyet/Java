/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lenvo
 */
public class main {
    public static void main(String[] args) {
        int n;
        float max =0;
        System.out.println("Nhap so sinh vien: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ArrayList<Student> lStudent = new ArrayList<>();
        System.out.println("Nhap danh sach sinh vien trong lop: \n");
        for (int i=0;i<n;i++)
        {
            Student temp = new Student();
            temp.Input();
            lStudent.add(temp);
        }
        for (int i=0;i<n;i++)
        {
            if(lStudent.get(i).getAvgScore() > max)
                max = lStudent.get(i).getAvgScore();
            lStudent.get(i).Output();
        }
        System.out.println("Hoc sinh co DTB cao nhat: ");
        for(int i=0; i<n;i++)
        {
            if(lStudent.get(i).getAvgScore() == max)
                lStudent.get(i).Output();
        }
        //dem so sv DTB >5
        System.out.println("Hoc sinh co DTB > 5 : ");
        for(int i=0; i<n;i++)
        {
            if(lStudent.get(i).getAvgScore() >5)
                lStudent.get(i).Output();
        }
        System.out.println("Nhap ten sinh vien can tim kiem: ");
        Scanner scan = new Scanner(System.in);
        String temp = scan.next();
        for(int i=0;i<n;i++)
        {
            if(lStudent.get(i).getName().equals(temp))
            {
                System.out.println("Sinh vien can tim kiem: ");
                lStudent.get(i).Output();
            }
        }
        System.out.println("Sap xep: ");
        lStudent.sort(Comparator.comparing(Student:: getAvgScore));
        //Collections.sort(lStudent, new compare() );
        for(int i=0;i<n;i++)
        {
            lStudent.get(i).Output();
        }
    }
}
