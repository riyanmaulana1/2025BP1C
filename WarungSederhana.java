  package pkg2025bp1;
import java.util.Scanner;
public class WarungSederhana {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int menu,banyak;
        double harga=0,diskon=0;
        System.out.println("=".repeat(15)+"MENU WARUNG SEDERHANA"+"=".repeat(15)+
                "\n1. Sate"+
                "\n2. Pecel"+
                "\n3. Penyetan\n"+
                "=".repeat(50));
        System.out.print("Masukkan nomor menu:");
        menu=input.nextInt();
        switch (menu){
            case 1 :
                System.out.print("-".repeat(15)+"ANEKA SATE"+"-".repeat(15)+
                        "\n\t1.Ayam : Rp.1.500 per tusuk"+
                        "\n\t2.Kambing : Rp.3.000 per tusuk"+
                        "\nMasukkan angka pesaanan :");
                int sate = input.nextInt();
                if (sate==1){
                  harga=1500;
                    System.out.print("banyaknnya tusuk sate ayam :");
                   
                }
                else if (sate==2){
                    harga=3000;
                     System.out.print("banyaknnya tusuk sate kambing :");
                    
                }
                break;
            case 2 :
             System.out.print("-".repeat(15)+"ANEKA PECEL"+"-".repeat(15)+
                     "\n\t1. Lauk ayam : Rp.13.000 per porsi"+
                     "\n\t2. Lauk empal : Rp.15.000 per porsi"+
                     "\nMasukkan angka pesaanan  :");
             int pecel = input.nextInt();
             if (pecel==1){
                  harga=13000;
                    System.out.print("banyaknnya pecel lauk ayam :");
                    }
                else if (pecel==2){
                    harga=15000; 
                    System.out.print("banyaknnya pecel lauk empal :");
                    }
                break;
            case 3 :
             System.out.print("-".repeat(15)+"ANEKA PENYETAN"+"-".repeat(15)+
                     "\n\t1. Lauk tahu/ tempe : Rp.5.000 per porsi"+
                     "\n\t2. Lauk telur : Rp.7.000 per porsi"+
                     "\n\t3. Lauk ayam: Rp.10.000 per porsi"+
                     "\nMasukkan angka pesaanan :");
             int penyetan = input.nextInt();
                  switch (penyetan){
                      case 1:
                          harga=5000;
                           System.out.print("banyaknnya pecel lauk tempe/tahu:");
                           break;
                      case 2:
                          harga=7000;
                           System.out.print("banyaknnya pecel lauk telur:");
                           break;
                      case 3:
                          harga=10000;
                           System.out.print("banyaknnya pecel lauk telur:");
                           break;
                  }
                break;
            }
        banyak=input.nextInt();
        double harga1 =harga*banyak;
        System.out.println("-".repeat(42));
        System.out.print("apakah anda memiliki member(0. tidak, 1. iya)? :");
        int member = input.nextInt();
        if (member==1){
             diskon = harga1*0.05;
        }
        else if (member==0){
            diskon=0;
        }
        double totalbelanja = harga1-diskon;
        System.out.println("Total Item :Rp."+harga1);
        System.out.println("Total Diskon :Rp."+ diskon);
        System.out.println("Total belanja :Rp."+totalbelanja);
        
    }
    
}

