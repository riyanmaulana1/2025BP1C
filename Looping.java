package pkg2025bp1;
import java.util.Scanner;
public class Looping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean status=true;
        int menu, banyak;
        double harga = 0;
        double grandTotalBelanja = 0;
        double grandTotalDiskon = 0;
        int ulangi = 0;
        String Nama = "riyan",sandi = "1234";
        System.out.println("=".repeat(15) + "SELAMAT DATANG DI WARUNG SEDERHANA" + "=".repeat(15));
    while(status){
        System.out.print("Username :");
        String username = input.next();
        System.out.print("Password :");
        String password = input.next();
        if (username.equals(Nama)&&password.equals(sandi)){
            break;
        }
        else if (!username.equals(Nama)&&password.equals(password)){
            System.out.println("masukkan username dengan benar");
            continue;
        }
        else if (username.equals(Nama)&&!password.equals(password)){
            System.out.println("masukkan password dengan benar");
            continue;
        }
         else {
        System.out.println("Username dan password salah. Silakan coba lagi.");
        continue;
        }
    }
        do {
            double harga1 = 0;
            double diskon = 0;
            
            System.out.println("\n" + "=".repeat(15) + "MENU WARUNG SEDERHANA" + "=".repeat(15) +
                    "\n1. Sate" +
                    "\n2. Pecel" +
                    "\n3. Penyetan\n" +
                    "=".repeat(50));
            System.out.print("Masukkan nomor menu:");
            
            
            if (input.hasNextInt()) {
                menu = input.nextInt();
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                input.next(); // Membersihkan input yang salah
                continue; // Lanjut ke iterasi do-while berikutnya
            }

            
            switch (menu) {
                case 1:
                    System.out.print("-".repeat(15) + "ANEKA SATE" + "-".repeat(15) +
                            "\n\t1.Ayam : Rp.1.500 per tusuk" +
                            "\n\t2.Kambing : Rp.3.000 per tusuk" +
                            "\nMasukkan angka pesaanan :");
                    int sate;
                    if (input.hasNextInt()) {
                        sate = input.nextInt();
                    } else {
                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                        input.next();
                        break;
                    }
                    
                    if (sate == 1) {
                        harga = 1500;
                        System.out.print("banyaknnya tusuk sate ayam :");
                    } else if (sate == 2) {
                        harga = 3000;
                        System.out.print("banyaknnya tusuk sate kambing :");
                    } else {
                        System.out.println("Pilihan sate tidak valid.");
                        break;
                    }
                    break;
                case 2:
                    System.out.print("-".repeat(15) + "ANEKA PECEL" + "-".repeat(15) +
                            "\n\t1. Lauk ayam : Rp.13.000 per porsi" +
                            "\n\t2. Lauk empal : Rp.15.000 per porsi" +
                            "\nMasukkan angka pesaanan :");
                    int pecel;
                    if (input.hasNextInt()) {
                        pecel = input.nextInt();
                    } else {
                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                        input.next();
                        break;
                    }

                    if (pecel == 1) {
                        harga = 13000;
                        System.out.print("banyaknnya pecel lauk ayam :");
                    } else if (pecel == 2) {
                        harga = 15000;
                        System.out.print("banyaknnya pecel lauk empal :");
                    } else {
                        System.out.println("Pilihan pecel tidak valid.");
                        break;
                    }
                    break;
                case 3:
                    System.out.print("-".repeat(15) + "ANEKA PENYETAN" + "-".repeat(15) +
                            "\n\t1. Lauk tahu/ tempe : Rp.5.000 per porsi" +
                            "\n\t2. Lauk telur : Rp.7.000 per porsi" +
                            "\n\t3. Lauk ayam: Rp.10.000 per porsi" +
                            "\nMasukkan angka pesaanan :");
                    int penyetan;
                    if (input.hasNextInt()) {
                        penyetan = input.nextInt();
                    } else {
                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                        input.next();
                        break;
                    }
                    
                    switch (penyetan) {
                        case 1:
                            harga = 5000;
                            System.out.print("banyaknnya penyetan lauk tempe/tahu:");
                            break;
                        case 2:
                            harga = 7000;
                            System.out.print("banyaknnya penyetan lauk telur:");
                            break;
                        case 3:
                            harga = 10000;
                            System.out.print("banyaknnya penyetan lauk ayam:");
                            break;
                        default:
                            System.out.println("Pilihan penyetan tidak valid.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Nomor menu tidak valid.");
                    // Lanjut ke bagian pengulangan tanpa memproses jumlah
                    ulangi = 1; // Atur default untuk mengulang
                    System.out.print("Apakah ingin memesan lagi? (0: Tidak, 1: Ya): ");
                    if (input.hasNextInt()) {
                         ulangi = input.nextInt();
                    } else {
                        input.next(); // Membersihkan input
                    }
                    continue; // Lanjut ke iterasi do-while berikutnya
            }
            
            // Membaca jumlah pesanan
            if (harga > 0) { // Hanya proses jika harga sudah diatur (menu valid)
                 if (input.hasNextInt()) {
                    banyak = input.nextInt();
                 } else {
                    System.out.println("Input jumlah tidak valid. Pembelian dibatalkan.");
                    input.next();
                    continue; // Kembali ke menu utama
                 }
                
                harga1 = harga * banyak;

                // Cek diskon member
                System.out.println("-".repeat(42));
                System.out.print("apakah anda memiliki member (0: tidak, 1: iya)? :");
                int member;
                 if (input.hasNextInt()) {
                    member = input.nextInt();
                 } else {
                     System.out.println("Input member tidak valid. Diskon member tidak diterapkan.");
                     input.next();
                     member = 0;
                 }
                
                if (member == 1) {
                    diskon = harga1 * 0.05;
                } else {
                    diskon = 0;
                }
                
                double totalbelanjaItem = harga1 - diskon;
                grandTotalBelanja += totalbelanjaItem;
                grandTotalDiskon += diskon;

                System.out.println("\n--- Rincian Item Saat Ini ---");
                System.out.println("Sub-Total Item: Rp."+ harga1);
                System.out.println("Diskon Member : Rp."+ diskon);
                System.out.println("Total Item    : Rp."+ totalbelanjaItem);
                System.out.println("-----------------------------\n");
            }
            
            System.out.print("Apakah ingin memesan lagi? (0: Tidak, 1: Ya): ");
            if (input.hasNextInt()) {
                 ulangi = input.nextInt();
            } else {
                System.out.println("Input tidak valid. Asumsi Selesai Memesan (0).");
                input.next(); // Membersihkan input
                ulangi = 0;
            }

        } while (ulangi == 1);
        
        System.out.println("\n" + "=".repeat(15) + "TOTAL PEMBAYARAN" + "=".repeat(15));
        double grandTotalAwal = grandTotalBelanja + grandTotalDiskon;
        
        System.out.println("Total Biaya Item Awal : Rp."+ grandTotalAwal);
        System.out.println("Total Keseluruhan Diskon: Rp."+ grandTotalDiskon);
        System.out.println("TOTAL YANG HARUS DIBAYAR: Rp."+ grandTotalBelanja);
        System.out.println("=".repeat(46));
        System.out.println("Terima kasih atas kunjungan Anda!");
        
    }
}
