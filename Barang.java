/**
 * Kelas {@code Barang} merepresentasikan suatu barang dalam sistem, dengan
 * informasi mengenai nama dan harga.
 */
public class Barang {

    /**
     * Nama dari barang.
     */
    private String nama;

    /**
     * Harga dari barang.
     */
    private double harga;

    /**
     * Konstruktor untuk membuat objek {@code Barang} dengan nama dan harga
     * tertentu.
     *
     * @param nama  Nama dari barang.
     * @param harga Harga dari barang.
     */
    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mengatur nama barang.
     *
     * @param nama Nama baru untuk barang.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mengatur harga barang.
     *
     * @param harga Harga baru untuk barang.
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * Mendapatkan nama barang.
     *
     * @return Nama dari barang.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga barang.
     *
     * @return Harga dari barang.
     */
    public double getHarga() {
        return harga;
    }
}
