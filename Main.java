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
     /**
     * Metode untuk melakukan login sebagai pelanggan.
     * Meminta username dan password, melakukan autentikasi, dan membuka menu
     * pelanggan jika berhasil.
     *
     * @param listBarang Objek ListBarang untuk digunakan dalam menu pelanggan.
     */
    public void login(ListBarang listBarang) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Login berhasil!");
            this.listBarang = new ListBarang().createSampleListBarang();
            TransaksiSelesai transaksiSelesai = new TransaksiSelesai();
            AdminDriver adminDriver = new AdminDriver(listBarang, transaksiSelesai);
            CustomerDriver customerDriver = new CustomerDriver(listBarang, new Customer(), adminDriver);
            customerDriver.userMenu();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    /**
     * Metode untuk melakukan login sebagai admin.
     * Meminta username dan password admin, melakukan autentikasi, dan membuka menu
     * admin jika berhasil.
     *
     * @param listBarang Objek ListBarang untuk digunakan dalam menu admin.
     */
    private void loginAdmin(ListBarang listBarang) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        Admin admin = Admin.authenticateAdmin(username, password);

        if (admin != null) {
            System.out.println("Login admin berhasil!");
            this.listBarang = new ListBarang().createSampleListBarang();
            TransaksiSelesai transaksiSelesai = new TransaksiSelesai();
            AdminDriver adminDriver = new AdminDriver(this.listBarang, transaksiSelesai);

            // Memanggil adminMenu dengan memberikan objek AdminDriver dan TransaksiSelesai
            adminDriver.adminMenu(adminDriver, transaksiSelesai);
        } else {
            System.out.println("Login admin gagal. Username atau password salah.");
        }
    }

    /**
     * Metode untuk melakukan registrasi.
     * Meminta username dan password baru, menyimpan data pengguna, dan memberikan
     * konfirmasi registrasi berhasil.
     */
    private void register() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        saveUserData(username, password);

        System.out.println("Registrasi berhasil! Silakan login.");
        run();
    }
    /**
     * Metode untuk menyimpan data pengguna (username dan password) ke dalam file.
     *
     * @param username Username pengguna yang akan disimpan.
     * @param password Password pengguna yang akan disimpan.
     */
    private void saveUserData(String username, String password) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(username + " " + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metode untuk melakukan autentikasi pengguna berdasarkan username dan
     * password.
     *
     * @param username Username yang akan diotentikasi.
     * @param password Password yang akan diotentikasi.
     * @return True jika autentikasi berhasil, false jika gagal.
     */
    private boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 2 && data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
