
/**
 * Class abstrak Pembayaran mewakili metode pembayaran generik dengan pengidentifikasi unik.
 * Subclass diharapkan memberikan implementasi untuk metode abstrak isPembayaranBerhasil(),
 * yang menunjukkan apakah pembayaran berhasil atau tidak.
 */
abstract class Pembayaran {
    /**
     * Pengidentifikasi unik untuk pembayaran.
     */
    public String id;

     /**
     * Metode abstrak yang harus diimplementasikan oleh subkelas untuk menentukan apakah pembayaran berhasil.
     *
     * @return True jika pembayaran berhasil, false jika sebaliknya.
     */
    abstract boolean isPembayaranBerhasil();
}
