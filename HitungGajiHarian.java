import java.util.Scanner;
public class HitungGajiHarian {
    public static void main(String[] args) {
        //deklarasi variable
          int jumlahmasuk, gajiharian, gajitotal,pajak, tunjangan,gajibersih;
        Scanner input = new Scanner(System.in);
        // input data dari user
        System.out.print("Jumlah masuk :");
        jumlahmasuk=input.nextInt();
        System.out.print("gaji harian :Rp.");
        gajiharian=input.nextInt();
        System.out.print("jumlah tunjangan (dalam persen):");
        tunjangan=input.nextInt();
        System.out.print("masukkan pajak (dalam persen):");
        // proses 
        gajitotal=jumlahmasuk*gajiharian;
        pajak=input.nextInt();
        pajak*=gajitotal/100;
        tunjangan*=gajitotal/100;
        gajibersih=gajitotal+tunjangan-pajak;
        //output
        System.out.println("Gaji total :Rp."+ gajitotal);
        System.out.println("tunjangan anda Rp."+tunjangan);
        System.out.println("pajak anda Rp."+pajak);
        System.out.println("Gaji bersih anda Rp."+gajibersih);    
    }
    
}
