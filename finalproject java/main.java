import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class main {
        static Scanner input = new Scanner(System.in);
        static LocalDateTime now = LocalDateTime.now();
        private static final String Product = "Product.txt";
        private static final String Record = "Record.txt";
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");




// utility
public static String salamWaktu() {
        // Mendapatkan objek LocalDateTime saat ini
LocalDateTime sekarang = LocalDateTime.now();
int jam = sekarang.getHour();
if (jam >= 5 && jam < 12) {
        return "Selamat pagi";
} else if (jam >= 12 && jam < 15) {
        return "Selamat siang";
} else if (jam >= 15 && jam < 18) {
        return "Selamat sore";
} else {
        return "Selamat malam";
}
}
        //SELECTION SHORT!!!
public static List<String[]> selectionSort(List<String[]> arrList,String ketentuan) {
switch (ketentuan) {
        case    "harga_tertinggi"-> {

                int n = arrList.size();
                for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                        int valJ = Integer.parseInt(arrList.get(j)[2]);
                        int valMin = Integer.parseInt(arrList.get(minIndex)[2]);
        
                        if (valJ < valMin) {
                        minIndex = j;
                        }
                }String []temp = arrList.get(minIndex);
                arrList.set(minIndex, arrList.get(i));
                arrList.set(i, temp);
        }}

        case "jenis_a_z"-> {
                int n = arrList.size();
                for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                        String valJ = arrList.get(j)[0];
                        String valMin = arrList.get(minIndex)[0];
        
                        if (valJ.compareTo(valMin) < 0) {
                        minIndex = j;
                        }
                }String []temp = arrList.get(minIndex);
                arrList.set(minIndex, arrList.get(i));
                arrList.set(i, temp);
        }
}
        case "qty_tertinggi"-> {
                int n = arrList.size();
                for (int i = 0; i < n - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < n; j++) {
                        int valJ = Integer.parseInt(arrList.get(j)[1]);
                        int valMax = Integer.parseInt(arrList.get(maxIndex)[1]);
        
                        if (valJ > valMax) {
                        maxIndex = j;
                        }
                }String []temp = arrList.get(maxIndex);
                arrList.set(maxIndex, arrList.get(i));
                arrList.set(i, temp);
        }}
}return arrList;
}

public static void welcome() {
        // header
        System.out.println("=".repeat(100));
        System.out.println(" ".repeat(30)+"SELAMAT DATANG DI SISTEM KASIR KELOMPOK 6"+" ".repeat(30));
        System.out.println("=".repeat(100));
}

private static void cls(){
try {
if (System.getProperty("os.name").contains("Windows")){
new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
} else {
System.out.print("\033\143");
}
} catch (Exception ex){
System.err.println("tidak bisa clear screen");
}
}

private static boolean getYesorNo(String Perintah) {
        //keluar
System.out.print(Perintah + " (1. iya, 2. tidak): ");
int user_input = input.nextInt();
if (user_input == 1) {
return false;
} else {
return true;
}
}


//inciate 
public static void initConsole(String nama_file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nama_file))) {
        } catch (FileNotFoundException e) {
        createFirst(nama_file);
        } catch (IOException e) {
        System.out.println("Gagal membaca database Product");
        }
}

public static void createFirst(String nama_file){
        //membuat database 
try (FileWriter fileWriter = new FileWriter(nama_file, false);
        PrintWriter printWriter = new PrintWriter(fileWriter)) {} catch (IOException e) {
        System.out.println("Gagal membuat Database Product");
}
}


//operasi 
public static List<String[]> read(String fileName) {
        //read product
List<String[]> dataList = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
        // Pisahkan berdasarkan koma
        String[] parts = line.split(",");
        dataList.add(parts); // append ke ArrayList
        }
} catch (IOException e) {
        e.printStackTrace();
        }
        return dataList;
}
        // read dengan index
public static String[] read(String fileName, Integer index) {
List<String[]> dataList = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
String line;
while ((line = br.readLine()) != null) {
        // Pisahkan berdasarkan koma
        String[] parts = line.split(",");
        dataList.add(parts);
}if (index != null) {
        int indexMenu = index - 1; // sama seperti Python: index-1
        if (indexMenu < 0 || indexMenu >= dataList.size()) {
        return null; // False di Python → null di Java
        } else {
        return dataList.get(indexMenu);
        }
} else {
        // Jika tidak ada index, kembalikan semua data sebagai array 2D
        return dataList.toArray(new String[0]);
}} catch (IOException e) {
System.out.println("Gagal membaca Database");
return null;
}
}
private static List<String> pesanan(String jenis_menu){
        //pesanan
        List<String[]> data_menu = read(Product);
        List<String[]> filtered_menu = new ArrayList<>();
        List<String> pesanan_sekarang ;
        pesanan_sekarang = new ArrayList<>();
        for (String[] item : data_menu) {
                if (item[0].equals(jenis_menu)) {
                        filtered_menu.add(item);
                }
        }
        filtered_menu = selectionSort(filtered_menu,"harga_tertinggi");
        displayProduct(filtered_menu);
        System.out.print("masukkan nomor menu yang ingin dipesan (0 untuk batal): ");
        int indexMenu = input.nextInt();
        String harga_satuan;
        String nama_menu;
        if (indexMenu == 0) {
                System.out.println("batal menambahkan pesanan");
                return null;
        }else if (indexMenu < 1 || indexMenu > filtered_menu.size()) {
                System.out.println("Nomor menu tidak valid. Silakan coba lagi.");
                return null;
        }else{
                String[] selectedMenu = filtered_menu.get(indexMenu - 1);
                //siapkan pesanan sekarang
                nama_menu = selectedMenu[1];
                harga_satuan = selectedMenu[2];
                String[] orderItem = {nama_menu, harga_satuan};
                pesanan_sekarang.addAll(Arrays.asList(orderItem));
                
        }
        return pesanan_sekarang;
}
private static void update_structured_product(){
        //mengurutkan product berdasarkan jenis a-z
        List<String[]> allData = read(Product);
        allData = selectionSort(allData,"jenis_a_z");
        try (FileWriter fileWriter = new FileWriter(Product, false);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
                for (String[] item : allData) {
                        String line = String.join(",", item);
                        printWriter.println(line);
                }
        } catch (IOException e) {
                System.out.println("Gagal memperbarui menu di database.");
        }
}
        // display product tanpa parameter
private static void displayProduct(){
        update_structured_product();
        int nomor = 1;
        System.out.println(" "+"-".repeat(86));
        System.out.println("| NO |"+" ".repeat(5)+"JENIS"+" ".repeat(5)+"|"+" ".repeat(18)+"NAMA"+" ".repeat(18)+"|"+" ".repeat(9)+"HARGA"+" ".repeat(10)+"|");
        System.out.println("|"+"----+"+"-".repeat(15)+"+"+"-".repeat(40)+"+"+"-".repeat(24)+"|");
        List<String[]> data_menu = read(Product);
        for (String[] item : data_menu) {
                int itemHarga = Integer.parseInt(item[2]);
                System.out.printf("| %-2d | %-13s | %-38s | Rp.%,-19d |\n", nomor, item[0], item[1], itemHarga);
                nomor++;
        }
        System.out.println(" "+"-".repeat(86));
}
        // display product dengan parameter
private static void displayProduct(List<String[]> data_menu ){
        int nomor = 1;
        System.out.println(" "+"-".repeat(70));
        System.out.println("| NO |"+" ".repeat(18)+"NAMA"+" ".repeat(18)+"|"+" ".repeat(9)+"HARGA"+" ".repeat(10)+"|");
        System.out.println("|"+"----+"+"-".repeat(40)+"+"+"-".repeat(24)+"|");
        for (String[] item : data_menu) {
                System.out.printf("| %-2d | %-38s | Rp.%-19s |\n", nomor, item[1], item[2]);
                nomor++;
        }
        System.out.println(" "+"-".repeat(70));
}
//campur rekaman
private static List<String[]> campur_rekaman(List<String[]> record_list){
        List<String[]> merged_list = new ArrayList<>();
        for (String[] record : record_list) {
                String namaMenu = record[1];
                int jumlah = Integer.parseInt(record[3]);
                int hargaSatuan = Integer.parseInt(record[2]);
                boolean found = false;
                for (String[] mergedOrder : merged_list) {
                        if (mergedOrder[0].equals(namaMenu) && mergedOrder[2].equals(String.valueOf(hargaSatuan))) {
                                int existingJumlah = Integer.parseInt(mergedOrder[1]);
                                mergedOrder[1] = String.valueOf(existingJumlah + jumlah);
                                found = true;
                                break;
                        }
                }
                if (!found) {
                        merged_list.add(new String[]{namaMenu, String.valueOf(jumlah), String.valueOf(hargaSatuan)});
                }
        }
        return merged_list;
}
        //campur pesanan
private static List<String[]> campur(List<String[]> order_list){
        List<String[]> merged_list = new ArrayList<>();
        for (String[] order : order_list) {
                String namaMenu = order[0];
                int jumlah = Integer.parseInt(order[1]);
                int hargaSatuan = Integer.parseInt(order[2]);
                boolean found = false;
                for (String[] mergedOrder : merged_list) {
                        if (mergedOrder[0].equals(namaMenu) && mergedOrder[2].equals(String.valueOf(hargaSatuan))) {
                                int existingJumlah = Integer.parseInt(mergedOrder[1]);
                                mergedOrder[1] = String.valueOf(existingJumlah + jumlah);
                                found = true;
                                break;
                        }
                }
                if (!found) {
                        merged_list.add(new String[]{namaMenu, String.valueOf(jumlah), String.valueOf(hargaSatuan)});
                }
        }
        return merged_list;
}
        //simpan trx
private static void simpanTRX(List<String[]> order_list){
        String timestamp = now.format(formatter);
        for (String[] order : order_list) {
                String namaMenu = order[0];
                int jumlah = Integer.parseInt(order[1]);
                int hargaSatuan = Integer.parseInt(order[2]);
                String record_line = timestamp + "," + namaMenu + "," + hargaSatuan + "," + jumlah;
                try (FileWriter fileWriter = new FileWriter(Record, true);
                        PrintWriter printWriter = new PrintWriter(fileWriter)) {
                        printWriter.println(record_line);
                } catch (IOException e) {
                        System.out.println("Gagal menyimpan transaksi ke database.");
                }
}
}
//rekapan penjualan
private static void rekapan_penjualan(){
        List<String[]> record_list = read(Record);
        if (record_list.isEmpty()) {
                System.out.println("Belum ada transaksi yang tercatat.");
                return;
        }
        LocalDateTime sevenDaysAgo = now.minusDays(7);
        List<String[]> filtered_record = new ArrayList<>();
        for (String[] record : record_list) {
                LocalDateTime recordTime = LocalDateTime.parse(record[0], formatter);
                if (recordTime.isAfter(sevenDaysAgo) || recordTime.isEqual(sevenDaysAgo)) {
                        filtered_record.add(record);
                }
        }
        filtered_record = campur_rekaman(filtered_record);
        filtered_record = selectionSort(filtered_record,"qty_tertinggi");
        if (filtered_record.isEmpty()) {
                System.out.println("Belum ada transaksi dalam 7 hari terakhir.");
                return;
        }
        System.out.println("Rekapan Penjualan (7 Hari Terakhir):\n");
        System.out.println(" "+"=".repeat(62));
        System.out.println("| NO |"+" ".repeat(15)+"NAMA"+" ".repeat(15)+"| QTY |    SUBTOTAL    |");
        System.out.println("|"+"----+"+"-".repeat(34)+"+-----+----------------|");
        int totalPendapatan = 0;
        int nomor = 1;
        for (String[] record : filtered_record) {
                String namaMenu = record[0];
                int hargaSatuan = Integer.parseInt(record[2]);
                int jumlah = Integer.parseInt(record[1]);
                int subtotal = hargaSatuan * jumlah;
                System.out.printf("| %-2d | %-32s | %-3d | Rp.%, -11d |\n", nomor, namaMenu, jumlah, subtotal);
                totalPendapatan += subtotal;
                nomor++;
        }
        System.out.println("|"+"-".repeat(45)+"+----------------|");
        System.out.printf("| TOTAL PENDAPATAN"+" ".repeat(28)+"| Rp.%, -11d |\n", totalPendapatan);
        System.out.println(" "+"=".repeat(62));
}

//log in
private static boolean login(String role){
        int pin;
        // tentukan PIN berdasarkan role
        switch (role) {
                case "kasir" -> pin = 1234;
                case "admin" -> pin = 4321;
                case "owner" -> pin = 4444;
                default -> {
                        System.out.println("Role tidak dikenal");
                        return false;
                }
        }
        int attemp = 1;
        // loop validasi PIN
        while (true) {
                System.out.printf("Mohon masukkan PIN %s:\n",role);
                int pin_input = input.nextInt();
                if (pin_input == pin) {
                        return true;
                } else {
                        System.out.println("PIN salah, coba lagi.");
                        System.out.println("sisa percobaan: "+(3-attemp));
                        attemp++;
                }
                if (attemp == 4){
                        System.out.println("tidak dapat log in mohon mulai ulang sistem");
                        return false;
                }
        }
        
}

// kasir
public static void kasir_console() {
        cls();
        welcome();
        System.out.println();
        System.out.println(salamWaktu()+" kasir\n");
        boolean status_order = true;
        List<String[]> order_list = new ArrayList<>();
        while (status_order){
                System.out.println(" --------------------------------------------------------");
                System.out.println("| NO |               DAFTAR MENU                         |");
                System.out.println("|----+---------------------------------------------------|");
                System.out.println("|  1 |  Nasi                                             |");
                System.out.println("|  2 |  Mie                                              |");
                System.out.println("|  3 |  Paket Hemat, Rp.13.000/Free Esteh Atau Nutrisari |");
                System.out.println("|  4 |  Snack                                            |");
                System.out.println("|  5 |  Minuman                                          |");
                System.out.println(" --------------------------------------------------------\n");
                System.out.print("masukkan nomor menu yang ingin dipesan (0 untuk batal): ");
                int menuNumber = input.nextInt();
                List<String> pesanan_sekarang;
                switch(menuNumber){
                        case 1 -> pesanan_sekarang = pesanan("Nasi");
                        case 2 -> pesanan_sekarang = pesanan("Mie");
                        case 3 -> pesanan_sekarang = pesanan("Paket_Hemat");
                        case 4 -> pesanan_sekarang = pesanan("Snack");
                        case 5 -> pesanan_sekarang = pesanan("Minuman");
                        case 0 -> {
                                System.out.println("keluar dari menu Kasir");
                                return;
                        }
                        default -> {
                                System.out.println("mohon masukkan sesuai opsi yang tersedia");
                                continue;
                        }
                }
                int quantity = 0;
                if (pesanan_sekarang != null){
                        System.out.print("Masukkan jumlah pesanan: ");
                        quantity = input.nextInt();
                        if (quantity <= 0){
                                System.out.println("jumlah pesanan harus lebih dari 0");
                                continue;
                        }
                        
                }else{
                        continue;
                }pesanan_sekarang.add(String.valueOf(quantity));
                String[] orderItem = {pesanan_sekarang.get(0), pesanan_sekarang.get(2), pesanan_sekarang.get(1)};
                System.out.println(orderItem[0]+" sebanyak "+orderItem[1]+" telah ditambahkan ke daftar pesanan.");
                order_list.add(orderItem);
                status_order = !getYesorNo("Tambah pesanan lain?");
        }
        if (order_list.size()>1){
                order_list = campur(order_list);
        }
      // Tampilkan ringkasan pesanan
        System.out.println("Ringkasan Pesanan:\n");
        System.out.println(" "+"-".repeat(87));
        System.out.println("| NO |"+" ".repeat(16)+"NAMA MENU"+" ".repeat(15)+"|"+" ".repeat(4)+"JUMLAH"+" ".repeat(5)+"|"+" ".repeat(6)+"HARGA SATUAN"+" ".repeat(7)+"|");
        System.out.println("|"+"----+"+"-".repeat(40)+"+"+"-".repeat(15)+"+"+"-".repeat(25)+"|");
        int nomor = 1;
        int totalHarga = 0;
        for (String[] order : order_list) {
                String namaMenu = order[0];
                int jumlah = Integer.parseInt(order[1]);
                int hargaSatuan = Integer.parseInt(order[2]);
                int subtotal = jumlah * hargaSatuan;
                totalHarga += subtotal;
                System.out.printf("| %-2d | %-38s | %-13d | Rp.%, -20d |\n", nomor, namaMenu, jumlah, hargaSatuan);
                nomor++;
        }
        System.out.println("|"+"-".repeat(61)+"+"+"-".repeat(25)+"|");
        System.out.printf("| Total Harga"+" ".repeat(49)+"| Rp.%, -20d |\n", totalHarga);
        System.out.println(" "+"-".repeat(87));
        System.out.print("silahkan masukkan jumlah uang yang dibayarkan: ");
        int uangDibayarkan = input.nextInt();
        while (uangDibayarkan < totalHarga) {
                System.out.println("Uang yang dibayarkan tidak cukup. Silakan masukkan jumlah yang valid.");
                System.out.print("silahkan masukkan jumlah uang yang dibayarkan(0. untuk batal): ");
                uangDibayarkan = input.nextInt();
                if (uangDibayarkan == 0) {
                        System.out.println("Transaksi dibatalkan.");
                        return;
                }
        }
        int kembalian = uangDibayarkan - totalHarga;
        System.out.printf("Kembalian: Rp.%,d\n", kembalian);
        System.out.println("Terima kasih telah berbelanja!");
        simpanTRX(order_list);
}



// admin
private static void addConsole(){
        Boolean status = true;
        while(status){
                cls();
                welcome();
                System.out.println();
                System.out.println(" ".repeat(40)+"=== Tambah Menu Baru ==="+" ".repeat(39));
                System.out.println("-".repeat(100));
                System.out.println("\n masukan jenis menu:"+
                                "\n1. Nasi" +
                                "\n2. Mie" +
                                "\n3. Paket Hemat, Rp.13000/Free Es Teh Atau Nutrisari " +
                                "\n4. Snack"+
                                "\n5. Minuman\n"+
                                "-".repeat(51));
        System.out.print("masukkan jenis menu(0.batal): ");
        int user_chose = input.nextInt();
        String jenis_menu = null;
        while (user_chose < 0 || user_chose > 5) {
                System.out.println("mohon masukkan sesuai opsi yang tersedia");
                System.out.print("masukkan jenis menu(0.batal): ");
                user_chose = input.nextInt();
        }
                switch (user_chose) {
                        case 1 -> jenis_menu = "Nasi";
                        case 2 -> jenis_menu = "Mie";
                        case 3 -> jenis_menu = "Paket_Hemat";
                        case 4 -> jenis_menu = "Snack";
                        case 5 -> jenis_menu = "Minuman";
                        case 0 -> {
                        System.out.println("keluar dari menu utama");
                        return;
                }
        }input.nextLine();
        System.out.print("masukkan nama menu : ");
        String nama_menu = input.nextLine();
        System.out.print("masukkan harga menu: ");
        int harga_menu = input.nextInt();
        while(harga_menu < 1000){
                System.out.println("harga tidak boleh negatif atau kurang dari 1000");
                System.out.print("masukkan harga menu: ");
                harga_menu = input.nextInt();
        }
        String new_menu =jenis_menu+","+nama_menu+","+harga_menu;
        try (FileWriter fileWriter = new FileWriter(Product, true);
        PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(new_menu);
                System.out.println("Menu berhasil ditambahkan.");
        } catch (IOException e) {
                System.out.println("Gagal menambahkan menu ke database.");
        }
                System.out.println("Berikut data menu terbaru:");
                displayProduct();
                status = !getYesorNo("Tambah menu lagi?");
        }
}

private static void updateConsole(){
        //mengubah menu
        cls();
        welcome();
        boolean status = true;
        while (status) {
                System.out.println(" ".repeat(40)+"=== Ubah Menu ==="+" ".repeat(39)+"\nBerikut data menu:\n");
                displayProduct();
                System.out.print("Masukkan nomor menu yang ingin diubah (0 untuk keluar): ");
                int menuNumber = input.nextInt();
                if (menuNumber == 0) {
                        status = false;
                        continue;
                }
                String[] data_menu = read(Product,menuNumber);
                if (data_menu == null) {
                        System.out.println("Nomor menu tidak valid. Silakan coba lagi.");
                        continue;
                }boolean isDone = true;
                while(isDone){
                System.out.printf("""
                        PIlih data yang ingin diubah:\n
                        1. Jenis\t:%s \n
                        2. Nama\t\t:%s\n
                        3. Harga\t:%s\n
                        """, data_menu[0], data_menu[1], data_menu[2]);
                System.out.print("Masukkan pilihan: ");
                int user_option = input.nextInt();
                input.nextLine();
                switch (user_option) {
                        case 1 -> {
                                System.out.print("Masukkan jenis baru:\n\t1. Nasi\n\t2. Mie\n\t3. Paket Hemat\n\t4. Snack\n\t5. Minuman\nPilihan: ");
                                int newJenis = input.nextInt();
                                switch (newJenis) {
                                        case 1-> data_menu[0] = "Nasi";
                                        case 2-> data_menu[0] = "Mie";
                                        case 3-> data_menu[0] = "Paket_Hemat";
                                        case 4-> data_menu[0] = "Snack";
                                        case 5-> data_menu[0] = "Minuman";
                                        default -> {
                                                System.out.println("Pilihan tidak valid.");
                                                continue;
                                        }
                                }
                        }
                        case 2 -> {
                                System.out.print("Masukkan nama baru: ");
                                String newNama = input.nextLine();
                                data_menu[1] = newNama;
                        }
                        case 3 -> {
                                System.out.print("Masukkan harga baru: ");
                                String newHarga = input.nextLine();
                                data_menu[2] = newHarga;
                        }
                        
                        default -> {
                                System.out.println("Pilihan tidak valid.");
                                continue;
                        }
                }
                System.out.printf("PIlih data baru yang diubah:\n1. Jenis\t:%s \n2. Nama\t\t:%s\n3. Harga\t:%s\n", data_menu[0], data_menu[1], data_menu[2]);
                isDone = !getYesorNo("Apakah Anda ingin mengubah data lain untuk menu ini?");
                }
                boolean confirm = !getYesorNo("Apakah Anda yakin ingin menyimpan perubahan?");
                if (confirm) {
                        List<String[]> allData = read(Product);
                        allData.set(menuNumber - 1, data_menu);
                        try (FileWriter fileWriter = new FileWriter(Product, false);
                                PrintWriter printWriter = new PrintWriter(fileWriter)) {
                                for (String[] item : allData) {
                                        String line = String.join(",", item);
                                        printWriter.println(line);
                                }
                                System.out.println("Menu berhasil diperbarui.");
                        } catch (IOException e) {
                                System.out.println("Gagal memperbarui menu di database.");
                        }
                } else {
                        System.out.println("Perubahan dibatalkan.");
                }
        }
}

private static void deleteConsole(){
        //menghapus menu
        cls();
        welcome();
        boolean status = true;
        while (status) {
                System.out.println(" ".repeat(40)+"=== Hapus Menu ==="+" ".repeat(39)+"\nBerikut data menu :\n");
                displayProduct();
                System.out.print("Masukkan nomor menu yang ingin diubah (0 untuk keluar): ");
                int menuNumber = input.nextInt();
                if (menuNumber == 0) {
                        status = false;
                        continue;
                }
                String[] data_menu = read(Product,menuNumber);
                if (data_menu == null) {
                        System.out.println("Nomor menu tidak valid. Silakan coba lagi.");
                        continue;
                }
                System.out.printf("PIlih data yang ingin diubah:\n1. Jenis\t:%s \n2. Nama\t\t:%s\n3. Harga\t:%s\n", data_menu[0], data_menu[1], data_menu[2]);
                boolean confirm = !getYesorNo("Apakah Anda yakin ingin menghapus menu ini?");
                if (confirm) {
                        List<String[]> allData = read(Product);
                        allData.remove(menuNumber - 1);
                        try (FileWriter fileWriter = new FileWriter(Product, false);
                                PrintWriter printWriter = new PrintWriter(fileWriter)) {
                                for (String[] item : allData) {
                                        String line = String.join(",", item);
                                        printWriter.println(line);
                                }
                                System.out.println("Menu berhasil dihapus.");
                        } catch (IOException e) {
                                System.out.println("Gagal menghapus menu di database.");
                        }
                } else {
                        System.out.println("Penghapusan dibatalkan.");
                }
        }
}


//owner
public static void owner_console() {
        cls();
        welcome();
        System.out.println();
        System.out.println(salamWaktu()+" owner");
        System.out.println();
        rekapan_penjualan();
}


// main
public static void main(String[] args) {
        boolean status = true; 
        initConsole(Product);
        initConsole(Record);
        while(status){
                cls();
                welcome();
                System.out.println();
                System.out.println("1. Kasir\n2. Admin\n3. Owner\n0. Exit\n");
                System.out.print("pilihan anda: ");
                int user_chose = input.nextInt();
                switch(user_chose){
                        case 1 -> {
                                boolean status2 = login("kasir");
                                if (status2==false){
                                        System.out.println("keluar dari system");
                                        return;
                                }
                                while(status2){
                                        kasir_console();
                                        status2 = getYesorNo("Keluar dari menu kasir");
                                }
                        }
                        case 2 ->{
                                boolean status2 = login("admin");
                                if (status2==false){
                                        System.out.println("keluar dari system");
                                        return;
                                }
                                while(status2){
                                        cls();
                                        welcome();
                                        System.out.println();
                                                System.out.println(salamWaktu()+" admin");
                                                System.out.println();
                                                System.out.println("1. Tambah menu  \n2. Ubah menu \n3. Hapus menu \n0. Exit\n");
                                                System.out.print("masukkan pilihan: ");
                                                int user_option = input.nextInt();
                                                switch (user_option) {
                                                        case 1 -> addConsole();
                                                        case 2 -> updateConsole();
                                                        case 3 -> deleteConsole();
                                                        case 0 -> {System.out.println("keluar dari menu utama");
                                                        status2 = false;
                                                        }
                                                        default->{
                                                                System.out.println("mohon masukkan sesuai opsi yang tersedia");
                                                                continue;
                                                        }
                                                }
                                        }
                                        }
                                        case 3 ->{
                                boolean status2 = login("owner");
                                if (status2==false){
                                        System.out.println("keluar dari system");
                                        return;
                                }
                                while(status2){
                                        owner_console();
                                        status2 = getYesorNo("Keluar dari menu Owner");
                                }
                        }
                        case 0 ->{
                                System.out.println("baybay");
                                status = false;
                                }
                        default->{
                                continue;
                        }
                        }
                }
        System.out.println("akhir program");
input.close();
        }
}