/**
 * Kelas {@code Invoice} merepresentasikan sebuah tagihan yang terkait dengan
 * suatu transaksi dan metode pembayaran.
 */
public class Invoice {

    /**
     * Objek {@code Transaksi} yang terkait dengan invoice ini.
     */
    public Transaksi transaksi;

    /**
     * Objek {@code Pembayaran} yang digunakan untuk membayar transaksi.
     */
    public Pembayaran pembayaran;

    /**
     * Konstruktor untuk membuat objek {@code Invoice} dengan transaksi dan metode
     * pembayaran tertentu.
     *
     * @param transaksi  Objek {@code Transaksi} yang terkait dengan invoice ini.
     * @param pembayaran Objek {@code Pembayaran} yang digunakan untuk membayar
     *                   transaksi.
     */
    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }
}
