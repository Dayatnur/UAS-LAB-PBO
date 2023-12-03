import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Nama : Dinda Maharani
 *         NPM : 2208107010081
 * 
 * @author2 Nama : Nashed Bayazed Ali
 *          NPM : 2208107010049
 * 
 * @author3 Nama : Hidayat Nur Hakim
 *          NPM : 2208107010063
 * 
 *          Kelas {@code Main} merupakan kelas utama yang mengatur jalannya
 *          program.
 *          Menyediakan menu untuk login sebagai admin, login sebagai pelanggan,
 *          registrasi, dan menyimpan data pengguna.
 */
public class Main {
    private static final String FILE_PATH = "user_data.txt";
    public static Scanner scanner = new Scanner(System.in);
    TransaksiSelesai transaksiSelesai;
    ListBarang listBarang;

    /**
     * Metode utama untuk menjalankan program.
     * Membuat objek Main dan memanggil metode run().
     *
     * @param args Argumen baris perintah yang mungkin digunakan (tidak digunakan
     *             dalam program ini).
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    /**
     * Metode untuk menjalankan program dengan menampilkan menu utama.
     * Pengguna dapat memilih untuk login sebagai admin, login sebagai pelanggan,
     * registrasi, atau keluar dari program.
     */
    public void run() {
        int choice;
        listBarang = new ListBarang().createSampleListBarang();
        transaksiSelesai = new TransaksiSelesai();

        do {
            System.out.println("+---------------------------+");
            System.out.println("|        Menu Login         |");
            System.out.println("+---------------------------+");
            System.out.println("| 1. Login as Admin        |");
            System.out.println("| 2. Login as Customer     |");
            System.out.println("| 3. Register              |");
            System.out.println("| 0. Keluar                |");
            System.out.println("+---------------------------+");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginAdmin(listBarang);
                    break;
                case 2:
                    login(listBarang);
                    break;
                case 3:
                    register();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (choice != 0);
    }
