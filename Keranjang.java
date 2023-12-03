import java.util.ArrayList;

/**
 * Kelas Keranjang merepresentasikan keranjang belanja pelanggan yang berisi daftar barang.
 * Pelanggan dapat menambahkan barang ke dalam keranjang ini.
 */
class Keranjang {
    /**
     * ArrayList yang menyimpan daftar barang dalam keranjang.
     */
    public ArrayList<Barang> barang = new ArrayList<>();

    /**
     * Menambahkan barang ke dalam keranjang.
     *
     * @param barang Objek Barang yang akan ditambahkan ke dalam keranjang.
     */
    public void tambahBarang(Barang barang) {
        this.barang.add(barang);
        System.out.println(barang.getNama() + " ditambahkan ke keranjang.");
    }
}
