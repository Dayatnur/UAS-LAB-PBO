/**
 * Kelas COD (Cash On Delivery) merupakan metode pembayaran di mana pembayaran dilakukan
 * secara langsung oleh pelanggan saat barang diterima.
 */
class COD extends Pembayaran {
     /**
     * Menentukan apakah pembayaran COD berhasil atau tidak.
     *
     * @return Mengembalikan nilai true jika pembayaran COD berhasil, dan false jika tidak.
     */
    public boolean isPembayaranBerhasil() {
        // Implementasi logika untuk COD
        return true;
    }
}
