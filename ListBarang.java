import java.util.ArrayList;

/**
 * Kelas yang merepresentasikan daftar barang.
 * Menyimpan objek-objek Barang dalam sebuah ArrayList.
 */
class ListBarang {
    
    /**
     * ArrayList untuk menyimpan objek-objek Barang.
     */
    ArrayList<Barang> barang = new ArrayList<>();

    /**
     * Menampilkan daftar barang beserta nama dan harga.
     */
    public void displayListBarang() {
        System.out.println("List Barang:");
        for (Barang item : barang) {
            System.out.println(item.getNama() + " - Harga: " + item.getHarga());
        }
    }

    /**
     * Membuat dan mengembalikan contoh daftar barang.
     *
     * @return Objek ListBarang yang berisi contoh barang.
     */
    public ListBarang createSampleListBarang() {
        ListBarang listBarang = new ListBarang();
        listBarang.barang.add(new Barang("Laptop", 1500.0));
        listBarang.barang.add(new Barang("Smartphone", 800.0));
        listBarang.barang.add(new Barang("Headphones", 100.0));
        return listBarang;
    }
}
