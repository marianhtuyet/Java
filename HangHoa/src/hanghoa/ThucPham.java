/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanghoa;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public class ThucPham  extends HangHoa{
    private Calendar NgaySX;
    private Calendar HSD;
    private  String NhaCungCap;

    public ThucPham(Calendar NgaySX, Calendar HSD, String NhaCungCap) {
        this.NgaySX = NgaySX;
        this.HSD = HSD;
        this.NhaCungCap = NhaCungCap;
    }

    

    public ThucPham() {
    }
     @Override
   public  String MucDoBanBuon(){
       //if(HSD < get)
Calendar now = java.util.Calendar.getInstance();
       if(HSD.compareTo(now) == 1   && SLTon > 2)
           return  "Kho Ban!";
       return null;
   }
    @Override
   public  double ThanhTien(){
       return SLTon * DonGia * 1.05;
   }
   public void Nhap(){
       this.NgaySX = Calendar.getInstance();
       Scanner scan = new Scanner(System.in);
       System.out.println("Nhap ngay sx:  ngay - thang - nam ");
       int Day =  scan.nextInt();
       int Month = scan.nextInt();
       int Year = scan.nextInt();
       NgaySX.set(Year, Month - 1, Day);
       
       
       System.out.println("HSD: ");
       Day = scan.nextInt();
       Month = scan.nextInt();
       Year = scan.nextInt();
       HSD.set(Year, Month - 1, Day);
       System.out.println("Nha cung cap: ");
       this.NhaCungCap = scan.next();
       
   }

    
    
    
}
