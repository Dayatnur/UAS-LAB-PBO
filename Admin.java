import java.util.ArrayList;

/**
 * Kelas yang merepresentasikan objek Admin.
 * Kelas ini merupakan turunan dari kelas Akun.
 */
class Admin extends Akun {
    
    /**
     * Daftar semua objek Admin yang telah dibuat.
     */
    private static ArrayList<Admin> adminList = new ArrayList<>();

    /**
     * Inisialisasi satu objek Admin sebagai contoh
     */
    static {
        Admin admin1 = new Admin();
        admin1.id = "admin";
        admin1.setPassword("0");
        adminList.add(admin1);
    }

    /**
     * Password untuk akun Admin.
     */
    private String password;

    /**
     * Mengembalikan password akun Admin.
     *
     * @return Password akun Admin.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mengatur password akun Admin.
     *
     * @param password Password baru untuk diatur.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Mengautentikasi akun Admin berdasarkan username dan password.
     *
     * @param username Username akun Admin.
     * @param password Password akun Admin.
     * @return Objek Admin jika autentikasi berhasil, null jika tidak.
     */
    public static Admin authenticateAdmin(String username, String password) {
        for (Admin admin : adminList) {
            if (admin.id.equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
}
