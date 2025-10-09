import java.util.Scanner;
public class kopivan {
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
        int h11=12000; //nasi goreng kopivan
        int h12=12000; //nasi goreng merah
        int h13=14000; //nasi goreng sosis
        int h14=15000; //nasi goreng gila
        int h15=15000; //nasi goreng jawa
        int h16=10000; //nasi pecel biasa
        int h17=15000; //nasi pecel ayam
        int h18=13000; //nasi pecel telur
        int h21=12000; //mie goreng kopivan
        int h22=15000; //mie kluntung
        int h23=15000; //mie goreng jawa
        int h24=9000; //indomie telur ceplok
        int h25=7000; //indomie biasa
        int h26=15000; //indomie ayam geprek
        int h31=13000; //PAKET HEMAT
        int h41=8000; //kentang goreng
        int h42=10000; //pok pok my chrispy
        int h43=7000; //nugget goreng
        int h44=7000; //sosis goreng
        int h45=9000; //sosis kentang goreng
        int h51=4000; //kopi hitam
        int h52=5000; //kopi susu
        int h53=5000; //cappucino
        int h54=6000; //milo
        int h55=5000; //gooday freeze
        int h56=6000; //greentea
        int h57=3000; //es teh manis
        int h58=3000; //teh panas
        int h59=5000; //es cao
        int h510=10000; //es cao jumbo
        int h511=5000; //aqua
        int h512=3000; //nutrisari
        int h513=5000; //es jeruk peras
        int h514=5000; //teh tarik
        int h515=5000; //pop ice coklat
        int h516=5000; //beng-beng
        int h517=5000; //tai tea
        int h518=4000; //kopi kapal api
        int h519=9000; //aqua 1,5L
        int h520=2500; //marimas
        int h521=5000; //teh pucuk
        long totalPemasukanGlobal = 0L;
        // User log in variablesn       
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
                            System.out.println("\n" + "-".repeat(16) + "MENU DEPOT KOPIVAN" + "-".repeat(16) +
                            "\n1. Nasi" +
                            "\n2. Mie" +
                            "\n3. Paket Hemat, Rp.13000/Free Es Teh Atau Nutrisari " +
                            "\n4. Snack"+
                            "\n5. Minuman\n"+
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
                                        "=".repeat(20) + "ANEKA NASI" + "=".repeat(20) +
                                        "\n"+"-".repeat(50)+
                                        "\nKode"+"\tNama"+"\t\t   Harga"+
                                        "\n"+"-".repeat(50)+
                                        "\n1  |\tNasi Goreng Kopivan  \t| Rp."+h11 +
                                        "\n3  |\tNasi Goreng Merah \t| Rp."+h12 +
                                        "\n3  |\tNasi Goreng Sosis \t| Rp."+h13+
                                        "\n4  |\tNasi Goreng Gila \t| Rp."+h14+
                                        "\n5  |\tNasi Goreng Jawa \t| Rp."+h15+
                                        "\n6  |\tNasi Pecel Biasa \t| Rp."+h16+
                                        "\n7  |\tNasi Pecel Ayam \t| Rp."+h17+
                                        "\n8  |\tNasi Pecel Telur \t| Rp."+h18+
                                        "\nMasukkan angka pesaanan :");
                                    int nasi;
                                    if (input.hasNextInt()) {
                                        nasi = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        input.next();
                                        break;
                                    }
                                    
                                    switch (nasi) {
                                        case 1:
                                            harga = h11;
                                            System.out.print("banyaknnya nasi goreng kopivan :");
                                            break;
                                        case 2:
                                            harga = h12;
                                            System.out.print("banyaknnya nasi goreng merah :");
                                            break;
                                        case 3:
                                            harga = h13;
                                            System.out.print("banyaknnya nasi goreng sosis :");
                                            break;
                                        case 4:
                                            harga = h14;
                                            System.out.print("banyaknnya nasi goreng gila :");
                                            break;
                                        case 5:
                                            harga = h15;
                                            System.out.print("banyaknnya nasi goreng jawa :");
                                            break;
                                        case 6:
                                            harga = h16;
                                            System.out.print("banyaknnya nasi pecel biasa :");
                                            break;
                                        case 7:
                                            harga = h17;
                                            System.out.print("banyaknnya nasi pecel ayam :");
                                            break;
                                        case 8:
                                            harga = h18;
                                            System.out.print("banyaknnya nasi pecel telur :");
                                            break;
                                        default:
                                            System.out.println("Pilihan nasi tidak valid.");
                                            break;
                                    }if (nasi < 1 || nasi > 8){
                                        break;
                                    }
                                    break;
                                case 2:
                                    System.out.print("=".repeat(20) + "ANEKA MIE" + "=".repeat(20) +
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t\t  Harga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1  |\tMie Goreng Kopivan\t| Rp."+h21+
                                    "\n2  |\tMie Kluntung\t\t| Rp."+h22+
                                    "\n3  |\tMie Goreng Jawa\t\t| Rp."+h23+
                                    "\n4  |\tIndomie Telur Ceplok\t| Rp."+h24+
                                    "\n5  |\tIndomie Biasa\t\t| Rp."+h25+
                                    "\n6  |\tIndomie Ayam Geprek\t| Rp."+h26+
                                    "\nMasukkan angka pesaanan :");
                                    int mie;
                                    if (input.hasNextInt()) {
                                        mie = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        input.next();
                                        break;
                                    }
                                    
                                    switch (mie) {
                                        case 1:harga = h21;System.out.print("banyaknnya mie goreng kopivan:");break;
                                        case 2:harga = h22;System.out.print("banyaknnya mie kluntung:");break;
                                        case 3:harga = h23;System.out.print("banyaknnya mie goreng jawa:");break;
                                        case 4:harga = h24;System.out.print("banyaknnya indomie telur ceplok:");break;
                                        case 5:harga = h25;System.out.print("banyaknnya indomie biasa:");break;
                                        case 6:harga = h26;System.out.print("banyaknnya indomie ayam geprek:");break;
                                        default:System.out.println("Pilihan mie tidak valid.");break;}
                                    if (mie < 1 || mie > 6){
                                        break;
                                    }
                                    break;
                                case 3:
                                    System.out.print("-".repeat(10) + "PAKET HEMAT(Rp.13.000)" + "-".repeat(10) +
                                    "\n\tFREE ES TEH ATAU NUTRISARI"+
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t   Harga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1  |\tGeprek \t\t| Rp."+h31 +
                                    "\n2  |\tPenyet \t\t| Rp."+h31+
                                    "\n3  |\tNasi Campur \t| Rp."+h31+
                                    "\n4  |\t4T\t\t| Rp."+h31+
                                    "\nMasukkan angka pesaanan :");
                                    int PaketHemat;
                                    if (input.hasNextInt()) {
                                        PaketHemat = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        break;
                                    }
                                    
                                    switch (PaketHemat) {
                                        case 1: harga = h31; System.out.print("banyaknya paket geprek: "); break;
                                        case 2: harga = h31; System.out.print("banyaknya paket penyet: "); break;
                                        case 3: harga = h31; System.out.print("banyaknya paket nasi campur: "); break;
                                        case 4: harga = h31; System.out.print("banyaknya paket 4T: "); break;
                                        default: System.out.println("Pilihan Paket Hemat tidak valid."); break;
                                    } if (PaketHemat < 1 || PaketHemat > 4){
                                        break;
                                    }
                                    break;
                                case 4:
                                    System.out.print("=".repeat(20) + "ANEKA SNACK" + "=".repeat(20) +
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t   Harga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1  |\tKentang Goreng\t\t| Rp."+h41 +
                                    "\n2  |\tPok Pok My Chrispy\t| Rp."+h42 +
                                    "\n3  |\tNugget Goreng\t\t| Rp."+h43+
                                    "\n4  |\tSosis Goreng\t\t| Rp."+h44+
                                    "\n5  |\tSosis Kentang Goreng\t| Rp."+h45+
                                    "\nMasukkan angka pesaanan :");
                                    int snack;
                                    if (input.hasNextInt()) {
                                        snack = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        input.next();
                                        break;
                                    }
                                    switch (snack) {
                                        case 1:
                                            harga = h41;
                                            System.out.print("banyaknnya kentang goreng :");
                                            break;
                                        case 2:
                                            harga = h42;
                                            System.out.print("banyaknnya pok pok my chrispy :");
                                            break;
                                        case 3:
                                            harga = h43;
                                            System.out.print("banyaknnya nugget goreng :");
                                            break;
                                        case 4:
                                            harga = h44;
                                            System.out.print("banyaknnya sosis goreng :");
                                            break;
                                        case 5:
                                            harga = h45;
                                            System.out.print("banyaknnya sosis kentang goreng :");
                                            break;
                                        default:
                                            System.out.println("Pilihan snack tidak valid.");
                                            break;}
                                    if (snack < 1 || snack > 5){
                                        break;
                                    }
                                    break;
                                case 5:
                                    System.out.print("=".repeat(20) + "ANEKA MINUMAN" + "=".repeat(20) +
                                    "\n"+"-".repeat(50)+
                                    "\nKode"+"\tNama"+"\t\t\tHarga"+
                                    "\n"+"-".repeat(50)+
                                    "\n1  |\tKopi Hitam\t\t| Rp."+h51+
                                    "\n2  |\tKopi Susu\t\t| Rp."+h52+
                                    "\n3  |\tCappucino\t\t| Rp."+h53+
                                    "\n4  |\tMilo\t\t\t| Rp."+h54+
                                    "\n5  |\tGooday Freeze\t\t| Rp."+h55+
                                    "\n6  |\tGreentea\t\t| Rp."+h56+
                                    "\n7  |\tEs Teh Manis\t\t| Rp."+h57+
                                    "\n8  |\tTeh Panas\t\t| Rp."+h58+
                                    "\n9  |\tEs Cao\t\t\t| Rp."+h59+
                                    "\n10 |\tEs Cao Jumbo\t\t| Rp."+h510+
                                    "\n11 |\tAqua\t\t\t| Rp."+h511+
                                    "\n12 |\tNutrisari\t\t| Rp."+h512+
                                    "\n13 |\tEs Jeruk Peras\t\t| Rp."+h513+
                                    "\n14 |\tTeh Tarik\t\t| Rp."+h514+
                                    "\n15 |\tPop Ice Coklat\t\t| Rp."+h515+
                                    "\n16 |\tBeng-Beng\t\t| Rp."+h516+
                                    "\n17 |\tTai Tea\t\t\t| Rp."+h517+
                                    "\n18 |\tKopi Kapal Api\t\t| Rp."+h518+
                                    "\n19 |\tAqua 1,5L\t\t| Rp."+h519+
                                    "\n20 |\tMarimas\t\t\t| Rp."+h520+
                                    "\n21 |\tTeh Pucuk\t\t| Rp."+h521+
                                    "\nMasukkan angka pesaanan :");
                                    int minuman;
                                    if (input.hasNextInt()) {
                                        minuman = input.nextInt();
                                    } else {
                                        System.out.println("Input tidak valid. Kembali ke menu utama.");
                                        input.next();
                                        break;
                                    }
                                    switch (minuman) {
                                        case 1:harga = h51;System.out.print("banyaknnya kopi hitam:");break;
                                        case 2:harga = h52;System.out.print("banyaknnya kopi susu:");break;
                                        case 3:harga = h53;System.out.print("banyaknnya cappucino:");break;
                                        case 4:harga = h54;System.out.print("banyaknnya milo:");break;
                                        case 5:harga = h55;System.out.print("banyaknnya gooday freeze:");break;
                                        case 6:harga = h56;System.out.print("banyaknnya greentea:");break;
                                        case 7:harga = h57;System.out.print("banyaknnya es teh manis:");break;
                                        case 8:harga = h58;System.out.print("banyaknnya teh panas:");break;
                                        case 9:harga = h59;System.out.print("banyaknnya es cao:");break;
                                        case 10:harga = h510;System.out.print("banyaknnya es cao jumbo:");break;
                                        case 11:harga = h511;System.out.print("banyaknnya aqua:");break;
                                        case 12:harga = h512;System.out.print("banyaknnya nutrisari:");break;
                                        case 13:harga = h513;System.out.print("banyaknnya es jeruk peras:");break;
                                        case 14:harga = h514;System.out.print("banyaknnya teh tarik:");break;
                                        case 15:harga = h515;System.out.print("banyaknnya pop ice coklat:");break;
                                        case 16:harga = h516;System.out.print("banyaknnya beng-beng:");break;
                                        case 17:harga = h517;System.out.print("banyaknnya tai tea:");break;
                                        case 18:harga = h518;System.out.print("banyaknnya kopi kapal api:");break;
                                        case 19:harga = h519;System.out.print("banyaknnya aqua 1,5L:");break;
                                        case 20:harga = h520;System.out.print("banyaknnya marimas:");break;
                                        case 21:harga = h521;System.out.print("banyaknnya teh pucuk:");break;
                                        default:System.out.println("Pilihan minuman tidak valid.");break;
                                    }if (minuman < 1 || minuman > 21){
                                        break;
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

                        // Perbaikan: grandTotalBelanja hanya ditambah totalbelanjaItem satu kali per transaksi
                        grandTotalBelanja += totalbelanjaItem;
                        
                        while (true) {
                            System.out.print("apakah anda memiliki member (0: tidak, 1: iya)? :");
                            int member=input.nextInt();
                            if (member == 1) {
                                if(grandTotalBelanja > 150000){
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
                        double grandTotal = grandTotalBelanja - Diskon;
                        
                        System.out.println("Total Biaya Item Awal : Rp."+ grandTotalBelanja);
                        grandTotalBelanja =0;
                        totalbelanjaItem =0;
                        System.out.println("Total Diskon: Rp."+ Diskon);
                        System.out.println("TOTAL YANG HARUS DIBAYAR: Rp."+ grandTotal);
                        System.out.println("=".repeat(46));
                        System.out.print("Masukkan jumlah uang pembayaran: Rp.");
                        double pembayaran = input.nextDouble();
                        if (pembayaran >= grandTotal) {
                            double kembalian = pembayaran - grandTotal;
                            System.out.println("Kembalian: Rp." + kembalian);
                        } else {
                            System.out.println("Uang pembayaran kurang Rp." + (grandTotal - pembayaran));
                            System.out.println("Transaksi dibatalkan.");
                            grandTotalBelanja =0;
                            Diskon =0;
                        }
                        System.out.println("Terima kasih atas kunjungan Anda!");
                        totalPemasukanGlobal += grandTotal;
                        grandDiskon += Diskon;
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
                        System.out.println("1    | Nasi Goreng Kopivan     | Rp." + h11);
                        System.out.println("2    | Nasi Goreng Merah       | Rp." + h12);
                        System.out.println("3    | Nasi Goreng Sosis       | Rp." + h13);
                        System.out.println("4    | Nasi Goreng Gila        | Rp." + h14);
                        System.out.println("5    | Nasi Goreng Jawa        | Rp." + h15);
                        System.out.println("6    | Nasi Pecel Biasa        | Rp." + h16);
                        System.out.println("7    | Nasi Pecel Ayam         | Rp." + h17);
                        System.out.println("8    | Nasi Pecel Telur        | Rp." + h18);
                        System.out.println("9    | Mie Goreng Kopivan      | Rp." + h21);
                        System.out.println("10   | Mie Kluntung            | Rp." + h22);
                        System.out.println("11   | Mie Goreng Jawa         | Rp." + h23);
                        System.out.println("12   | Indomie Telur Ceplok    | Rp." + h24);
                        System.out.println("13   | Indomie Biasa           | Rp." + h25);
                        System.out.println("14   | Indomie Ayam Geprek     | Rp." + h26);
                        System.out.println("15   | Paket Hemat             | Rp." + h31);
                        System.out.println("16   | Kentang Goreng          | Rp." + h41);
                        System.out.println("17   | Pok Pok My Chrispy      | Rp." + h42);
                        System.out.println("18   | Nugget Goreng           | Rp." + h43);
                        System.out.println("19   | Sosis Goreng            | Rp." + h44);
                        System.out.println("20   | Sosis Kentang Goreng    | Rp." + h45);
                        System.out.println("21   | Kopi Hitam              | Rp." + h51);
                        System.out.println("22   | Kopi Susu               | Rp." + h52);
                        System.out.println("23   | Cappucino               | Rp." + h53);
                        System.out.println("24   | Milo                    | Rp." + h54);
                        System.out.println("25   | Gooday Freeze           | Rp." + h55);
                        System.out.println("26   | Greentea                | Rp." + h56);
                        System.out.println("27   | Es Teh Manis            | Rp." + h57);
                        System.out.println("28   | Teh Panas               | Rp." + h58);
                        System.out.println("29   | Es Cao                  | Rp." + h59);
                        System.out.println("30   | Es Cao Jumbo            | Rp." + h510);
                        System.out.println("31   | Aqua                    | Rp." + h511);
                        System.out.println("32   | Nutrisari               | Rp." + h512);
                        System.out.println("33   | Es Jeruk Peras          | Rp." + h513);
                        System.out.println("34   | Teh Tarik               | Rp." + h514);
                        System.out.println("35   | Pop Ice Coklat          | Rp." + h515);
                        System.out.println("36   | Beng-Beng               | Rp." + h516);
                        System.out.println("37   | Tai Tea                 | Rp." + h517);
                        System.out.println("38   | Kopi Kapal Api          | Rp." + h518);
                        System.out.println("39   | Aqua 1,5L               | Rp." + h519);
                        System.out.println("40   | Marimas                 | Rp." + h520);
                        System.out.println("41   | Teh Pucuk               | Rp." + h521);
                        System.out.println("--------------------------------------------------");
                        System.out.print("Masukkan Kode Barang yang ingin diubah (atau '0' untuk Selesai): ");
                        int kodeBarang = input.nextInt();
                        if (kodeBarang == 0) {
                            break;
                        }
                        int hargaBaru;
                        switch(kodeBarang) {
                            case 1:
                                System.out.print("Masukkan harga baru untuk Nasi Goreng Kopivan: Rp.");
                                hargaBaru = input.nextInt();
                                h11 = hargaBaru;
                                System.out.println("Harga Nasi Goreng Kopivan berhasil diubah menjadi Rp." + h11);
                                break;
                            case 2:
                                System.out.print("Masukkan harga baru untuk Nasi Goreng Merah: Rp.");
                                hargaBaru = input.nextInt();
                                h12 = hargaBaru;
                                System.out.println("Harga Nasi Goreng Merah berhasil diubah menjadi Rp." + h12);
                                break;
                            case 3:
                                System.out.print("Masukkan harga baru untuk Nasi Goreng Sosis: Rp.");
                                hargaBaru = input.nextInt();
                                h13 = hargaBaru;
                                System.out.println("Harga Nasi Goreng Sosis berhasil diubah menjadi Rp." + h13);
                                break;
                            case 4:
                                System.out.print("Masukkan harga baru untuk Nasi Goreng Gila: Rp.");
                                hargaBaru = input.nextInt();
                                h14 = hargaBaru;
                                System.out.println("Harga Nasi Goreng Gila berhasil diubah menjadi Rp." + h14);
                                break;
                            case 5:
                                System.out.print("Masukkan harga baru untuk Nasi Goreng Jawa: Rp.");
                                hargaBaru = input.nextInt();
                                h15 = hargaBaru;
                                System.out.println("Harga Nasi Goreng Jawa berhasil diubah menjadi Rp." + h15);
                                break;
                            case 6:
                                System.out.print("Masukkan harga baru untuk Nasi Pecel Biasa: Rp.");
                                hargaBaru = input.nextInt();
                                h16 = hargaBaru;
                                System.out.println("Harga Nasi Pecel Biasa berhasil diubah menjadi Rp." + h16);
                                break;
                            case 7:
                                System.out.print("Masukkan harga baru untuk Nasi Pecel Ayam: Rp.");
                                hargaBaru = input.nextInt();
                                h17 = hargaBaru;
                                System.out.println("Harga Nasi Pecel Ayam berhasil diubah menjadi Rp." + h17);
                                break;
                            case 8:
                                System.out.print("Masukkan harga baru untuk Nasi Pecel Telur: Rp.");
                                hargaBaru = input.nextInt();
                                h18 = hargaBaru;
                                System.out.println("Harga Nasi Pecel Telur berhasil diubah menjadi Rp." + h18);
                                break;
                            case 9:
                                System.out.print("Masukkan harga baru untuk Mie Goreng Kopivan: Rp.");
                                hargaBaru = input.nextInt();
                                h21 = hargaBaru;
                                System.out.println("Harga Mie Goreng Kopivan berhasil diubah menjadi Rp." + h21);
                                break;
                            case 10:
                                System.out.print("Masukkan harga baru untuk Mie Kluntung: Rp.");
                                hargaBaru = input.nextInt();
                                h22 = hargaBaru;
                                System.out.println("Harga Mie Kluntung berhasil diubah menjadi Rp." + h22);
                                break;
                            case 11:
                                System.out.print("Masukkan harga baru untuk Mie Goreng Jawa: Rp.");
                                hargaBaru = input.nextInt();
                                h23 = hargaBaru;
                                System.out.println("Harga Mie Goreng Jawa berhasil diubah menjadi Rp." + h23);
                                break;
                            case 12:
                                System.out.print("Masukkan harga baru untuk Indomie Telur Ceplok: Rp.");
                                hargaBaru = input.nextInt();
                                h24 = hargaBaru;
                                System.out.println("Harga Indomie Telur Ceplok berhasil diubah menjadi Rp." + h24);
                                break;
                            case 13:
                                System.out.print("Masukkan harga baru untuk Indomie Biasa: Rp.");
                                hargaBaru = input.nextInt();
                                h25 = hargaBaru;
                                System.out.println("Harga Indomie Biasa berhasil diubah menjadi Rp." + h25);
                                break;
                            case 14:
                                System.out.print("Masukkan harga baru untuk Indomie Ayam Geprek: Rp.");
                                hargaBaru = input.nextInt();
                                h26 = hargaBaru;
                                System.out.println("Harga Indomie Ayam Geprek berhasil diubah menjadi Rp." + h26);
                                break;
                            case 15:
                                System.out.print("Masukkan harga baru untuk Paket Hemat: Rp.");
                                hargaBaru = input.nextInt();
                                h31 = hargaBaru;
                                System.out.println("Harga Paket Hemat berhasil diubah menjadi Rp." + h31);
                                break;
                            case 16:
                                System.out.print("Masukkan harga baru untuk Kentang Goreng: Rp.");
                                hargaBaru = input.nextInt();
                                h41 = hargaBaru;
                                System.out.println("Harga Kentang Goreng berhasil diubah menjadi Rp." + h41);
                                break;
                            case 17:
                                System.out.print("Masukkan harga baru untuk Pok Pok My Chrispy: Rp.");
                                hargaBaru = input.nextInt();
                                h42 = hargaBaru;
                                System.out.println("Harga Pok Pok My Chrispy berhasil diubah menjadi Rp." + h42);
                                break;
                            case 18:
                                System.out.print("Masukkan harga baru untuk Nugget Goreng: Rp.");
                                hargaBaru = input.nextInt();
                                h43 = hargaBaru;
                                System.out.println("Harga Nugget Goreng berhasil diubah menjadi Rp." + h43);
                                break;
                            case 19:
                                System.out.print("Masukkan harga baru untuk Sosis Goreng: Rp.");
                                hargaBaru = input.nextInt();
                                h44 = hargaBaru;
                                System.out.println("Harga Sosis Goreng berhasil diubah menjadi Rp." + h44);
                                break;
                            case 20:
                                System.out.print("Masukkan harga baru untuk Sosis Kentang Goreng: Rp.");
                                hargaBaru = input.nextInt();
                                h45 = hargaBaru;
                                System.out.println("Harga Sosis Kentang Goreng berhasil diubah menjadi Rp." + h45);
                                break;
                            case 21:
                                System.out.print("Masukkan harga baru untuk Kopi Hitam: Rp.");
                                hargaBaru = input.nextInt();
                                h51 = hargaBaru;
                                System.out.println("Harga Kopi Hitam berhasil diubah menjadi Rp." + h51);
                                break;
                            case 22:
                                System.out.print("Masukkan harga baru untuk Kopi Susu: Rp.");
                                hargaBaru = input.nextInt();
                                h52 = hargaBaru;
                                System.out.println("Harga Kopi Susu berhasil diubah menjadi Rp." + h52);
                                break;
                            case 23:
                                System.out.print("Masukkan harga baru untuk Cappucino: Rp.");
                                hargaBaru = input.nextInt();
                                h53 = hargaBaru;
                                System.out.println("Harga Cappucino berhasil diubah menjadi Rp." + h53);
                                break;
                            case 24:
                                System.out.print("Masukkan harga baru untuk Milo: Rp.");
                                hargaBaru = input.nextInt();
                                h54 = hargaBaru;
                                System.out.println("Harga Milo berhasil diubah menjadi Rp." + h54);
                                break;
                            case 25:
                                System.out.print("Masukkan harga baru untuk Gooday Freeze: Rp.");
                                hargaBaru = input.nextInt();
                                h55 = hargaBaru;
                                System.out.println("Harga Gooday Freeze berhasil diubah menjadi Rp." + h55);
                                break;
                            case 26:
                                System.out.print("Masukkan harga baru untuk Greentea: Rp.");
                                hargaBaru = input.nextInt();
                                h56 = hargaBaru;
                                System.out.println("Harga Greentea berhasil diubah menjadi Rp." + h56);
                                break;
                            case 27:
                                System.out.print("Masukkan harga baru untuk Es Teh Manis: Rp.");
                                hargaBaru = input.nextInt();
                                h57 = hargaBaru;
                                System.out.println("Harga Es Teh Manis berhasil diubah menjadi Rp." + h57);
                                break;
                            case 28:
                                System.out.print("Masukkan harga baru untuk Teh Panas: Rp.");
                                hargaBaru = input.nextInt();
                                h58 = hargaBaru;
                                System.out.println("Harga Teh Panas berhasil diubah menjadi Rp." + h58);
                                break;
                            case 29:
                                System.out.print("Masukkan harga baru untuk Es Cao: Rp.");
                                hargaBaru = input.nextInt();
                                h59 = hargaBaru;
                                System.out.println("Harga Es Cao berhasil diubah menjadi Rp." + h59);
                                break;
                            case 30:
                                System.out.print("Masukkan harga baru untuk Es Cao Jumbo: Rp.");
                                hargaBaru = input.nextInt();
                                h510 = hargaBaru;
                                System.out.println("Harga Es Cao Jumbo berhasil diubah menjadi Rp." + h510);
                                break;
                            case 31:
                                System.out.print("Masukkan harga baru untuk Aqua: Rp.");
                                hargaBaru = input.nextInt();
                                h511 = hargaBaru;
                                System.out.println("Harga Aqua berhasil diubah menjadi Rp." + h511);
                                break;
                            case 32:
                                System.out.print("Masukkan harga baru untuk Nutrisari: Rp.");
                                hargaBaru = input.nextInt();
                                h512 = hargaBaru;
                                System.out.println("Harga Nutrisari berhasil diubah menjadi Rp." + h512);
                                break;
                            case 33:
                                System.out.print("Masukkan harga baru untuk Es Jeruk Peras: Rp.");
                                hargaBaru = input.nextInt();
                                h513 = hargaBaru;
                                System.out.println("Harga Es Jeruk Peras berhasil diubah menjadi Rp." + h513);
                                break;
                            case 34:
                                System.out.print("Masukkan harga baru untuk Teh Tarik: Rp.");
                                hargaBaru = input.nextInt();
                                h514 = hargaBaru;
                                System.out.println("Harga Teh Tarik berhasil diubah menjadi Rp." + h514);
                                break;
                            case 35:
                                System.out.print("Masukkan harga baru untuk Pop Ice Coklat: Rp.");
                                hargaBaru = input.nextInt();
                                h515 = hargaBaru;
                                System.out.println("Harga Pop Ice Coklat berhasil diubah menjadi Rp." + h515);
                                break;
                            case 36:
                                System.out.print("Masukkan harga baru untuk Beng-Beng: Rp.");
                                hargaBaru = input.nextInt();
                                h516 = hargaBaru;
                                System.out.println("Harga Beng-Beng berhasil diubah menjadi Rp." + h516);
                                break;
                            case 37:
                                System.out.print("Masukkan harga baru untuk Tai Tea: Rp.");
                                hargaBaru = input.nextInt();
                                h517 = hargaBaru;
                                System.out.println("Harga Tai Tea berhasil diubah menjadi Rp." + h517);
                                break;
                            case 38:
                                System.out.print("Masukkan harga baru untuk Kopi Kapal Api: Rp.");
                                hargaBaru = input.nextInt();
                                h518 = hargaBaru;
                                System.out.println("Harga Kopi Kapal Api berhasil diubah menjadi Rp." + h518);
                                break;
                            case 39:
                                System.out.print("Masukkan harga baru untuk Aqua 1,5L: Rp.");
                                hargaBaru = input.nextInt();
                                h519 = hargaBaru;
                                System.out.println("Harga Aqua 1,5L berhasil diubah menjadi Rp." + h519);
                                break;
                            case 40:
                                System.out.print("Masukkan harga baru untuk Marimas: Rp.");
                                hargaBaru = input.nextInt();
                                h520 = hargaBaru;
                                System.out.println("Harga Marimas berhasil diubah menjadi Rp." + h520);
                                break;
                            case 41:
                                System.out.print("Masukkan harga baru untuk Teh Pucuk: Rp.");
                                hargaBaru = input.nextInt();
                                h521 = hargaBaru;
                                System.out.println("Harga Teh Pucuk berhasil diubah menjadi Rp." + h521);
                                break;
                            default:
                                System.out.println("Kode barang tidak valid.");
                                break;
                            }if(kodeBarang < 1 || kodeBarang > 41){
                                    break;}
                    }
                    break;
            case 3:
                    System.out.println("\n========================================");
                    System.out.println("         SUB MENU OWNER (LAPORAN)");
                    System.out.println("========================================");
                    System.out.println("Total Diskon yang diberikan: Rp." + grandDiskon);
                    System.out.println("Total Pemasukan Keseluruhan: Rp." + totalPemasukanGlobal);
                    System.out.println("enter untuk kembali ke menu utama");
                    input.nextLine(); // Clear the newline 
                    input.nextLine(); // Wait for user to press Enter
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
