import java.util.Random;
import java.util.ArrayList;

/**
 * Kelas yang merepresentasikan sebuah transaksi dalam sistem pembayaran.
 * Setiap transaksi memiliki informasi pelanggan, daftar barang, jenis pembayaran,
 * dan ID transaksi yang unik.
 */
class Transaksi {
    
    /** Objek Customer yang terkait dengan transaksi. */
    public Customer akun;
    
    /** ArrayList untuk menyimpan objek-objek Barang yang dibeli dalam transaksi. */
    public ArrayList<Barang> barang = new ArrayList<>();
    
    /** Objek Pembayaran yang digunakan dalam transaksi. */
    private Pembayaran pembayaran;
    
    /** ID unik untuk transaksi. */
    private String id;

    /**
     * Konstruktor untuk membuat objek Transaksi dan menghasilkan ID transaksi secara acak.
     */
    public Transaksi() {
        this.id = generateRandomId();
    }

    /**
     * Mendapatkan ID transaksi.
     *
     * @return ID transaksi.
     */
    public String getId() {
        return id;
    }

    /**
     * Mendapatkan objek Pembayaran yang digunakan dalam transaksi.
     *
     * @return Objek Pembayaran.
     */
    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    /**
     * Mengatur objek Pembayaran yang digunakan dalam transaksi.
     *
     * @param pembayaran Objek Pembayaran yang akan diatur.
     */
    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    /**
     * Menghasilkan ID transaksi secara acak.
     *
     * @return ID transaksi yang terdiri dari karakter alfanumerik.
     */
    private String generateRandomId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 8;

        // Generate a random alphanumeric ID
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
