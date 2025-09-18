import java.util.Scanner;
public class memberToko {
    public static void main(String[] args) {
        int harga, jumlah,member;
        double total1,diskon,total2,diskon2,total3;
         Scanner input = new Scanner(System.in);
        System.out.println("masukkan harga barang:");
        harga=input.nextInt();
        System.out.println("masukkan jumlah barang:");
        jumlah=input.nextInt();
        total1=harga*jumlah;
        System.out.println("total1");
        if(total1>100000&&total1<=200000){
            diskon= 0.1*total1;
            System.out.println("diskon 10% :"+ diskon);
            total2 = total1- diskon;
            System.out.println("total baru :"+total2);
        }
        else if(total1>20000&&total1<=300000){
            diskon= 0.2*total1;
            System.out.println("diskon 20% :"+ diskon);
            total2 = total1- diskon;
            System.out.println("total baru :"+total2);
         }
        else  if(total1>20000&&total1<=300000){
            diskon= 0.2*total1;
            System.out.println("diskon 20% :"+ diskon);
            total2 = total1- diskon;
            System.out.println("total baru :"+total2);
         }
        else {
            System.out.println("no Diskon");
            total2=total1;
            System.out.println("total baru :"+total1);
        }
        System.out.println("apakah anda member?(ketik 1 jika iya dan 0 jika tidak)");
        member=input.nextInt();
        if (member == 1){
        diskon = 0.05*total2;
            System.out.println("diskon 5% :"+ diskon);
            total3 = total2-diskon;
             System.out.println("total yang anda bayar :"+total3);
        }
        else{
            System.out.println("anda bukan member");
            System.out.println("total yang anda bayar :"+total2);
        }
        
    }
}
