import java.util.ArrayList;

/**
 * Kelas {@code Customer} merepresentasikan pelanggan dalam sistem. Pelanggan
 * dapat menambahkan barang ke keranjang,
 * melihat isi keranjang, melakukan checkout, memilih metode pembayaran, dan
 * melihat riwayat pembelanjaan.
 */
class Customer extends Akun {

    /**
     * Objek {@code Keranjang} yang digunakan oleh pelanggan untuk menyimpan barang
     * saat berbelanja.
     */
    public Keranjang keranjang = new Keranjang();

    /**
     * Daftar {@code Invoice} yang telah selesai dan disimpan oleh pelanggan.
     */
    public ArrayList<Invoice> invoiceSelesai = new ArrayList<>();

    /**
     * Menambahkan barang ke keranjang berdasarkan daftar barang yang disediakan.
     *
     * @param listBarang Daftar barang yang tersedia.
     */
    public void tambahBarangKeKeranjang(ListBarang listBarang) {
        listBarang.displayListBarang();
        System.out.print("Masukkan nama barang yang ingin ditambahkan ke keranjang: ");
        String namaBarang = Main.scanner.nextLine();

        Barang barangDitambahkan = null;
        for (Barang barang : listBarang.barang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                barangDitambahkan = barang;
                break;
            }
        }

        if (barangDitambahkan != null) {
            keranjang.tambahBarang(barangDitambahkan);
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    /**
     * Menampilkan isi dari keranjang pelanggan.
     */
    public void lihatIsiKeranjang() {
        System.out.println("Isi Keranjang:");
        for (Barang barang : keranjang.barang) {
            System.out.println(barang.getNama() + " - Harga: " + barang.getHarga());
        }
    }

    /**
     * Memproses checkout untuk transaksi yang ada di dalam keranjang.
     *
     * @param adminDriver Objek {@code AdminDriver} yang digunakan untuk menyimpan
     *                    transaksi yang telah selesai.
     */
    public void prosesCheckout(AdminDriver adminDriver) {
        if (!keranjang.barang.isEmpty()) {
            Transaksi transaksi = new Transaksi();
            transaksi.akun = this;
            transaksi.barang.addAll(keranjang.barang);

            Pembayaran pembayaran = pilihMetodePembayaran();
            transaksi.setPembayaran(pembayaran);

            Invoice invoice = new Invoice(transaksi, pembayaran);
            invoiceSelesai.add(invoice);

            // Tambahkan invoice ke daftar transaksi selesai
            adminDriver.transaksiSelesai.tambahInvoice(invoice);

            keranjang.barang.clear();

            System.out.println("Checkout berhasil! ID Transaksi: " + transaksi.getId());
        } else {
            System.out.println("Keranjang kosong. Tidak dapat melakukan checkout.");
        }
    }

    /**
     * Memilih metode pembayaran dari opsi yang disediakan.
     *
     * @return Objek {@code Pembayaran} yang dipilih oleh pelanggan.
     */
    private Pembayaran pilihMetodePembayaran() {
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Qris");
        System.out.println("2. Bank");
        System.out.println("3. COD");
        System.out.print("Masukkan pilihan (1-3): ");

        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine(); // Consuming the newline character

        switch (choice) {
            case 1:
                return new Qris();
            case 2:
                return new Bank();
            case 3:
                return new COD();
            default:
                System.out.println("Pilihan tidak valid. Menggunakan Qris sebagai metode pembayaran default.");
                return new Qris();
        }
    }

    /**
     * Menampilkan riwayat pembelanjaan pelanggan, termasuk detail setiap transaksi.
     */
    public void lihatHistoryPembelanjaan() {
        System.out.println("Riwayat Pembelanjaan Anda :");
        for (Invoice invoice : invoiceSelesai) {
            System.out.println("ID Transaksi            : " + invoice.transaksi.getId());
            System.out.println("Total Harga             : " + calculateTotalHarga(invoice.transaksi.barang));
            System.out.println("Metode Pembayaran       : " + invoice.pembayaran.getClass().getSimpleName());
            System.out.println("Status Pembayaran       : " +
                    (invoice.pembayaran.isPembayaranBerhasil() ? "Berhasil" : "Belum Berhasil"));
            System.out.println("Barang yang Dibeli   :");
            for (Barang barang : invoice.transaksi.barang) {
                System.out.println("  Nama: " + barang.getNama() + " | Harga: " + barang.getHarga());
            }
            System.out.println("-------------------------");
        }
    }

    /**
     * Menghitung total harga dari suatu daftar barang.
     *
     * @param barangList Daftar barang untuk dihitung total harganya.
     * @return Total harga dari daftar barang.
     */
    private double calculateTotalHarga(ArrayList<Barang> barangList) {
        double totalHarga = 0;
        for (Barang barang : barangList) {
            totalHarga += barang.getHarga();
        }
        return totalHarga;
    }
}
