/**
 * Kelas yang merepresentasikan sistem pembayaran menggunakan QRIS (Quick Response Code Indonesian Standard).
 * Kelas ini merupakan turunan dari kelas Pembayaran.
 */
class Qris extends Pembayaran {

    /**
     * Menentukan apakah pembayaran menggunakan QRIS berhasil atau tidak.
     *
     * @return True jika pembayaran berhasil, false jika tidak.
     */
    public boolean isPembayaranBerhasil() {
        // Implementasi logika untuk Qris
        return true; // Contoh sederhana, implementasi sebenarnya harus disesuaikan
    }
}
