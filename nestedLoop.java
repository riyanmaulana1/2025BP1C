import java.util.Scanner;
public class nestedLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Main variables
        int menu;
        int banyak;
        int ulangi = 0;
        double harga1;
        int pilihanMenu;
        double harga= 0;
        double totalbelanjaItem;
        double Diskon;
        double grandDiskon=0;
        double grandTotalBelanja =0;
        int h1 = 1500; // Sate Ayam
        int h2 = 3000; // Sate Kambing
        int h3 = 13000; // Pecel Lauk Ayam
        int h4 = 15000; // Pecel Lauk Empal
        int h5 = 5000; // Penyetan Lauk Tahu/ Tempe
        int h6 = 7000; // Penyetan Lauk Telur
        int h7 = 10000; // Penyetan Lauk Ayam
        long totalPemasukanGlobal = 0L;
        // User log in variables
        String Nama = "riyan",sandi = "1234";
        System.out.println("=".repeat(15) + "SELAMAT DATANG DI WARUNG SEDERHANA" + "=".repeat(15));
        for (int i = 1;i<4;i ++){
            System.out.print("Username :");
            String username = input.next();
            System.out.print("Password :");
            String password = input.next();
            
        if (username.equals(Nama)&&password.equals(sandi)){
            System.out.println("Login Berhasil! selamat datang ");
            break;
        }else if (!username.equals(Nama)&&password.equals(sandi)){
            System.out.println("masukkan username dengan benar");
        }else if (username.equals(Nama)&&!password.equals(sandi)){
            System.out.println("masukkan password dengan benar");
        }else {
            System.out.println("Username dan password salah. Silakan coba lagi.");
        }
        if (i == 3) {
            System.out.println("AKUN anda di Blokir");
           return;
        }
    }while (true) {
        totalbelanjaItem = 0;
        System.out.println("\n========================================");
        System.out.println("     APLIKASI KASIR SEDERHANA");
        System.out.println("========================================");
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Pilih menu (1-4): ");
            
            pilihanMenu = input.nextInt();
            if (pilihanMenu >= 1 && pilihanMenu <= 4) {
                
                switch (pilihanMenu) {
                    case 1:
                    while(true){
                        do {
                            System.out.println("\n" + "-".repeat(15) + "MENU WARUNG SEDERHANA" + "-".repeat(15) +
                            "\n1. Sate" +
                            "\n2. Pecel" +
                            "\n3. Penyetan\n" +
                            "-".repeat(51));
                            System.out.print("Masukkan nomor menu:");
                            
                            if (input.hasNextInt()) {
                                menu = input.nextInt();
                            } else {
                                System.out.println("Input tidak valid. Silakan masukkan angka.");
                                input.next(); 
                                continue; 
                            }
                            
                            switch (menu) {
                                case 1:
                                    System.out.print(
                                        "=".repeat(20) + "ANEKA SATE" + "=".repeat(20) +
                                        "\n"+"-".repeat(50)+
                                        "\nKode"+"\tNama"+"\t\t   Harga"+
                                        "\n"+"-".repeat(50)+
                                        "\n1.  |\tAyam \t\t| Rp."+h1+" per tusuk" +
                                        "\n2.  |\tKambing \t| Rp."+h2+" per tusuk" +
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
                                        harga = h1;
                                        System.out.print("banyaknnya tusuk sate ayam :");
                                    } else if (sate == 2) {
                                        harga = h2;
                                        System.out.print("banyaknnya tusuk sate kambing :");
                                    } else {
                                        System.out.println("Pilihan sate tidak valid.");
                                        break;
                                    }
                                    break;
                                case 2:
                                    System.out.print("=".repeat(20) + "ANEKA PECEL" + "=".repeat(20) +
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t   Harga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1.  |\tLauk ayam\t| Rp."+h3+" per porsi" +
                                    "\n2.  |\tLauk empal\t| Rp."+h4+" per porsi" +
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
                                        harga = h3;
                                        System.out.print("banyaknnya pecel lauk ayam :");
                                    } else if (pecel == 2) {
                                        harga = h4;
                                        System.out.print("banyaknnya pecel lauk empal :");
                                    } else {
                                        System.out.println("Pilihan pecel tidak valid.");
                                        break;
                                    }
                                    break;
                                case 3:
                                    System.out.print("-".repeat(20) + "ANEKA PENYETAN" + "-".repeat(17) +
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t   Harga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1.  |\tLauk tahu/ tempe | Rp."+h5+" per porsi" +
                                    "\n2.  |\tLauk telur \t | Rp."+h6+" per porsi" +
                                    "\n3.  |\tLauk ayam \t | Rp."+h7+" per porsi" +
                                    "\nMasukkan angka pesaanan :");
                                    int penyetan;
                                    if (input.hasNextInt()) {
                                        penyetan = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        break;
                                    }
                                    
                                    switch (penyetan) {
                                        case 1:harga = h5;System.out.print("banyaknnya penyetan lauk tempe/tahu:");break;
                                        case 2:harga = h6;System.out.print("banyaknnya penyetan lauk telur:");break;
                                        case 3:harga = h7;System.out.print("banyaknnya penyetan lauk ayam:");break;
                                        default:System.out.println("Pilihan penyetan tidak valid.");break;
                                    }
                                    break;
                                default:
                                    System.out.println("Nomor menu tidak valid.");
                                    ulangi = 1;
                                    System.out.print("Apakah ingin memesan lagi? (0: Tidak, 1: Ya): ");
                                    if (input.hasNextInt()) {
                                        ulangi = input.nextInt();
                                    } else {
                                        input.next();
                                    }
                                    continue;
                            }
                            // hitung harga
                            if (harga > 0) { 
                                if (input.hasNextInt()) {
                                    banyak = input.nextInt();
                                } else {
                                    System.out.println("Input jumlah tidak valid. Pembelian dibatalkan.");
                                    input.next();
                                    continue; 
                                }
                                harga1 = harga * banyak;
                                System.out.println("Total harga: Rp." + harga1);
                                System.out.println("-".repeat(42));
                                totalbelanjaItem += harga1;
                            }
                            
                            System.out.print("Apakah ingin memesan lagi? (0: Tidak, 1: Ya): ");
                            if (input.hasNextInt()) {
                                ulangi = input.nextInt();
                            } else {
                                System.out.println("Input tidak valid. Asumsi Selesai Memesan (0).");
                                input.next(); 
                                ulangi = 0;
                            }
                            
                        } while (ulangi == 1);
                        grandTotalBelanja += totalbelanjaItem;
                        
                        while (true) {
                            System.out.print("apakah anda memiliki member (0: tidak, 1: iya)? :");
                            int member=input.nextInt();
                            if (member == 1) {
                                if(grandTotalBelanja > 170000){
                                    Diskon = grandTotalBelanja * 0.2;
                                    System.out.println("Anda mendapatkan diskon tambahan 20% sebesar Rp."+ Diskon + " karena total belanja lebih dari Rp.170.000");
                                    break;
                                }else if(grandTotalBelanja > 100000){
                                    Diskon = grandTotalBelanja * 0.1;
                                    System.out.println("Anda mendapatkan diskon tambahan 10% sebesar Rp."+ Diskon + " karena total belanja lebih dari Rp.50.000");
                                    break;
                                }else if(grandTotalBelanja <= 100000){
                                    Diskon = grandTotalBelanja * 0.02;
                                    System.out.println("Anda mendapatkan diskon tambahan 2% sebesar Rp."+ Diskon + " karena anda memiliki member");
                                    break;}
                            }else if (member == 0) {
                                System.out.println("Terima kasih telah berbelanja di warung kami.");
                                Diskon = 0;
                                break;
                            }else {
                                System.out.println("Input member tidak valid. Diskon member tidak diterapkan.");
                                continue;
                            }
                        }
                        System.out.println("\n" + "=".repeat(15) + "TOTAL PEMBAYARAN" + "=".repeat(15));
                        grandDiskon += Diskon;
                        double grandTotal = grandTotalBelanja - Diskon;
                        totalPemasukanGlobal += grandTotal;
                        
                        System.out.println("Total Biaya Item Awal : Rp."+ grandTotalBelanja);
                        System.out.println("Total Diskon: Rp."+ Diskon);
                        System.out.println("TOTAL YANG HARUS DIBAYAR: Rp."+ grandTotal);
                        System.out.println("=".repeat(46));
                        System.out.println("Terima kasih atas kunjungan Anda!");
                        grandTotalBelanja =0;
                        totalbelanjaItem =0;
                        System.out.print("Kembali ke menu utama? (1: Ya, 0: Tidak): ");
                        int kembali = input.nextInt();
                        if (kembali == 1) {
                            System.out.println("Terima kasih! Sampai jumpa lagi.");
                            break;
                        }
                    }
                    break;
                    
                    case 2:
                    System.out.println("\n========================================");
                    System.out.println("   SUB MENU ADMIN (UBAH HARGA)");
                    System.out.println("========================================");
                    while (true) {
                        System.out.println("\n----------------- MENU BARANG ------------------");
                        System.out.println("Kode | Nama Barang             | Harga");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1    | Sate Ayam               | Rp." + h1);
                        System.out.println("2    | Sate Kambing            | Rp." + h2);
                        System.out.println("3    | Pecel Lauk Ayam         | Rp." + h3);
                        System.out.println("4    | Pecel Lauk Empal        | Rp." + h4);
                        System.out.println("5    | Penyetan Lauk Tahu/tempe| Rp." + h5);
                        System.out.println("6    | Penyetan Lauk Telur     | Rp." + h6);
                        System.out.println("7    | Penyetan Lauk Ayam      | Rp." + h7);
                        System.out.println("--------------------------------------------------");
                        System.out.print("Masukkan Kode Barang yang ingin diubah (atau '0' untuk Selesai): ");
                        int kodeBarang = input.nextInt();
                        if (kodeBarang == 0) {
                            break;
                        }
                        int hargaBaru;
                        switch (kodeBarang) {
                        case 1:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h1 =hargaBaru;
                            System.out.println("Harga Sate Ayam berhasil diubah menjadi Rp." + h1);
                            break;
                        case 2:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h2 =hargaBaru;
                            System.out.println("Harga Sate Kambing berhasil diubah menjadi Rp." + h2);
                            break;
                        case 3:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h3 =hargaBaru;
                            System.out.println("Harga Pecel Lauk Ayam berhasil diubah menjadi Rp." + h3);
                            break;
                        case 4:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h4 =hargaBaru;
                            System.out.println("Harga Pecel Lauk Empal berhasil diubah menjadi Rp." + h4);
                            break;
                        case 5:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h5 =hargaBaru;
                            System.out.println("Harga Penyetan Lauk Tahu/tempe berhasil diubah menjadi Rp." + h5);
                            break;
                        case 6:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h6 =hargaBaru;
                            System.out.println("Harga Penyetan Lauk Telur berhasil diubah menjadi Rp." + h6);
                            break;
                        case 7:
                            System.out.print("Masukkan harga baru: Rp.");
                            hargaBaru = input.nextInt();
                            h7 =hargaBaru;
                            System.out.println("Harga Penyetan Lauk Ayam berhasil diubah menjadi Rp." + h7);
                            break;
                        default:
                            System.out.println("Kode Barang tidak valid.");
                            break;
                        }
                    }
                    break;
            case 3:
                    System.out.println("\n========================================");
                    System.out.println("         SUB MENU OWNER (LAPORAN)");
                    System.out.println("========================================");
                    System.out.println("Total Diskon yang diberikan: Rp." + grandDiskon);
                    System.out.println("Total Pemasukan Keseluruhan: Rp." + totalPemasukanGlobal);
                    System.out.println("enter untuk kembali ke menu utama");
                    input.nextLine();
                    input.nextLine(); //user enter
                    break;
            case 4:
                    System.out.println("\n========================================");
                    System.out.println("Terima kasih. Program selesai.");
                    System.out.println("========================================");
                    break;
                }
                if (pilihanMenu == 4) {
                    break;}
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine();
                continue;
            }
        }
        System.out.println("Program selesai. Terima kasih!");
    }
}
