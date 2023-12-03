import java.util.ArrayList;

/**
 * Kelas yang merepresentasikan daftar transaksi yang telah selesai.
 * Menyimpan objek-objek Invoice dalam sebuah ArrayList.
 */
class TransaksiSelesai {

    /** ArrayList untuk menyimpan objek-objek Invoice transaksi yang telah selesai. */
    public ArrayList<Invoice> invoices = new ArrayList<>();

    /**
     * Menambahkan objek Invoice ke dalam daftar transaksi selesai.
     *
     * @param invoice Objek Invoice yang akan ditambahkan.
     */
    public void tambahInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}
