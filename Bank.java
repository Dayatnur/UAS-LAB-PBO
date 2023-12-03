/**
 * Kelas {@code Bank} merupakan turunan dari kelas {@code Pembayaran} dan
 * merepresentasikan metode pembayaran
 * menggunakan layanan perbankan.
 */
public class Bank extends Pembayaran {

    /**
     * Memeriksa apakah pembayaran menggunakan layanan perbankan berhasil.
     *
     * @return {@code true} jika pembayaran berhasil; {@code false} jika pembayaran
     *         tidak berhasil.
     */
    public boolean isPembayaranBerhasil() {
      
        return true; // Nilai sementara, seharusnya sesuai dengan logika implementasi yang
                     // sebenarnya.
    }
}
