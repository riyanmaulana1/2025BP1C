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
        static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");




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
public static List<String[]> selectionSort(List<String[]> arrList) {
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

public static String[] read(String fileName, Integer index) {
List<String[]> dataList = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
String line;
while ((line = br.readLine()) != null) {
        // Pisahkan berdasarkan koma
        String[] parts = line.split(",");
        dataList.add(parts);
}

if (index != null) {
        int indexMenu = index - 1; // sama seperti Python: index-1
        if (indexMenu < 0 || indexMenu >= dataList.size()) {
        return null; // False di Python → null di Java
        } else {
        return dataList.get(indexMenu);
        }
} else {
        // Jika tidak ada index, kembalikan semua data sebagai array 2D
        return dataList.toArray(new String[0]);
}

} catch (IOException e) {
System.out.println("Gagal membaca Database");
return null;
}
}

private static void displayProduct(){
        int nomor = 1;
        System.out.println(" "+"-".repeat(100));
        System.out.println("| NO |"+" ".repeat(5)+"JENIS"+" ".repeat(5)+"|"+" ".repeat(18)+"NAMA"+" ".repeat(18)+"|"+" ".repeat(9)+"HARGA"+" ".repeat(10)+"|"+" ".repeat(4)+"STOK"+" ".repeat(5)+"|");
        System.out.println("|"+"----+"+"-".repeat(15)+"+"+"-".repeat(40)+"+"+"-".repeat(24)+"+"+"-".repeat(13)+"|");
        List<String[]> data_menu = read(Product);
        for (String[] item : data_menu) {
                System.out.printf("| %-2d | %-13s | %-38s | Rp.%-19s | %-11s |\n", nomor, item[0], item[1], item[2], item[3]);
                nomor++;
        }
        System.out.println(" "+"-".repeat(100));
}
        //eksperimen display product dengan parameter
private static void displayProduct(List<String[]> data_menu ){
        int nomor = 1;
        System.out.println(" "+"-".repeat(100));
        System.out.println("| NO |"+" ".repeat(5)+"JENIS"+" ".repeat(5)+"|"+" ".repeat(18)+"NAMA"+" ".repeat(18)+"|"+" ".repeat(9)+"HARGA"+" ".repeat(10)+"|"+" ".repeat(4)+"STOK"+" ".repeat(5)+"|");
        System.out.println("|"+"----+"+"-".repeat(15)+"+"+"-".repeat(40)+"+"+"-".repeat(24)+"+"+"-".repeat(13)+"|");
        for (String[] item : data_menu) {
                System.out.printf("| %-2d | %-13s | %-38s | Rp.%-19s | %-11s |\n", nomor, item[0], item[1], item[2], item[3]);
                nomor++;
        }
        System.out.println(" "+"-".repeat(100));
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
                        System.out.println("PIN benar, akses diberikan.");
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
        System.out.println(salamWaktu()+" kasir");
        List<String[]> data_menu = read(Product);
        data_menu = selectionSort(data_menu); 
        displayProduct(data_menu);

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
        String jenis_menu;
        while (user_chose < 0 || user_chose > 5) {
                System.out.println("mohon masukkan sesuai opsi yang tersedia");
                System.out.print("masukkan jenis menu: ");
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
                default -> {
                        System.out.println("mohon masukkan sesuai opsi yang tersedia");
                        continue;
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
        System.out.print("masukkan stok menu : ");
        int stok_menu = input.nextInt();
        while(stok_menu < 0){
                System.out.println("stok tidak boleh negatif");
                System.out.print("masukkan stok menu: ");
                stok_menu = input.nextInt();
        }
        String new_menu =jenis_menu+","+nama_menu+","+harga_menu+","+stok_menu;
        try (FileWriter fileWriter = new FileWriter(Product, true);
        PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(new_menu);
                System.out.println("Menu berhasil ditambahkan.");
        } catch (IOException e) {
                System.out.println("Gagal menambahkan menu ke database.");}
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
                        4. Stok\t\t:%s\n
                        """, data_menu[0], data_menu[1], data_menu[2], data_menu[3]);
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
                        case 4 -> {
                                System.out.print("Masukkan stok baru: ");
                                String newStok = input.nextLine();
                                data_menu[3] = newStok;
                        }
                        default -> {
                                System.out.println("Pilihan tidak valid.");
                                continue;
                        }
                }
                System.out.printf("PIlih data baru yang diubah:\n1. Jenis\t:%s \n2. Nama\t\t:%s\n3. Harga\t:%s\n4. Stok\t\t:%s\n", data_menu[0], data_menu[1], data_menu[2], data_menu[3]);
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
                System.out.printf("PIlih data yang ingin diubah:\n1. Jenis\t:%s \n2. Nama\t\t:%s\n3. Harga\t:%s\n4. Stok\t\t:%s\n", data_menu[0], data_menu[1], data_menu[2], data_menu[3]);
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
        //pass
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
                                        status2 = getYesorNo("Keluar dari menu Utama");
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
                                        status2 = getYesorNo("Keluar dari menu Utama");
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
