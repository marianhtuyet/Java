/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountbank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public class AccountBank {

        private long ID;
        private String Name;
        private double Money;
        
        public void setID(int ID)
        {
            this.ID = ID;
        }
        public void setName(String Name)
        {
            this.Name = Name;
        }
        public void setMoney(double Money)
        {
            this.Money = Money;
        }
        public long getID(){return this.ID;}
        public String getName(){return this.Name;}
        public double getMoney(){return this.Money;}
        public void Print(){
            System.out.println("So Tai khoan:  "+ this.ID);
            System.out.println("So Tai khoan:  "+ this.Name);
            System.out.println("So Tai khoan:  %2f"+ this.Money);
        }
        public void EnterAccount()
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap So Tai Khoan, ten Tai khoan va So tien : ");
            this.ID = scan.nextInt();
            this.Name = scan.nextLine();
            this.Money = scan.nextDouble();
        }
        public void DaoHan()
        {
            if(this.Money < 100 )
                this.Money += this.Money*0.02;
            if(this.Money > 500)
                this.Money += this.Money*0.06;
            else
                this.Money += this.Money*0.04;
        }
        public void NapTien(double Money)
        {
            this.Money += Money;
        }
        public void ChuyenTien(AccountBank B, double Money)
        {
            if(Money > this.Money)
                System.out.print("Khong du tien trong tai khoan!");
            else
            {
                this.Money -= Money;
                B.NapTien(Money);
            }
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<AccountBank> lAccount = new ArrayList<>();
        do{
            AccountBank temp = new AccountBank();
            temp.EnterAccount();
            if(!String.valueOf(temp.getID()).equals("")) 
                lAccount.add(temp);
            
            }while(!String.valueOf(lAccount.get(lAccount.size()-1).getID()).equals("") );
              
        
        for(AccountBank temp : lAccount)
        {
            temp.DaoHan();
            temp.Print();
        }
        //Chuyen tien
        AccountBank A = new AccountBank();
        AccountBank B = new AccountBank();
        A.EnterAccount();
        B.EnterAccount();
        System.out.println("Nhap so tien:  ");
        Scanner scan = new Scanner(System.in);
        double Money = scan.nextDouble();
        A.ChuyenTien(B, Money);
        
        
                    
// TODO code application logic here
    }
    
}
