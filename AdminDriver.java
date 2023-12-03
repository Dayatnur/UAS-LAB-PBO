import java.util.ArrayList;

/**
 * Kelas AdminDriver merupakan kelas yang menyediakan fungsionalitas untuk Admin.
 * Admin dapat melakukan operasi seperti melihat list barang, menambah barang baru,
 * menghapus barang, mengedit informasi barang, melihat daftar transaksi, dan menerima transaksi.
 */
class AdminDriver extends Driver {
    ListBarang listBarang;
    TransaksiSelesai transaksiSelesai;

    /**
     * Konstruktor untuk AdminDriver.
     *
     * @param listBarang        Objek ListBarang yang digunakan oleh Admin.
     * @param transaksiSelesai   Objek TransaksiSelesai yang menyimpan daftar transaksi selesai.
     */
    public AdminDriver(ListBarang listBarang, TransaksiSelesai transaksiSelesai) {
        this.listBarang = listBarang;
        this.transaksiSelesai = transaksiSelesai;
    }

     /**
     * Menampilkan list barang untuk Admin.
     */
    @Override
    void ListBarang() {
        System.out.println("List Barang untuk Admin");
        listBarang.displayListBarang();
    }

    
    /**
     * Method untuk menambah barang baru ke list barang.
     */
    public void tambahBarang() {
        System.out.print("Masukkan nama barang baru: ");
        String namaBarang = Main.scanner.nextLine();
        System.out.print("Masukkan harga barang baru: ");
        double hargaBarang = Main.scanner.nextDouble();
        Main.scanner.nextLine(); // Consuming the newline character

        Barang barangBaru = new Barang(namaBarang, hargaBarang);
        listBarang.barang.add(barangBaru);

        System.out.println("Barang berhasil ditambahkan!");
    }

     /**
     * Method untuk menghapus barang dari list barang.
     */
    public void hapusBarang() {
        System.out.print("Masukkan nama barang yang ingin dihapus: ");
        String namaBarang = Main.scanner.nextLine();

        Barang barangDihapus = null;
        for (Barang barang : listBarang.barang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                barangDihapus = barang;
                break;
            }
        }

        if (barangDihapus != null) {
            listBarang.barang.remove(barangDihapus);
            System.out.println("Barang berhasil dihapus!");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

   /**
     * Method untuk mengedit informasi barang pada list barang.
     */
    public void editBarang() {
        System.out.print("Masukkan nama barang yang ingin diedit: ");
        String namaBarang = Main.scanner.nextLine();

        Barang barangDiedit = null;
        for (Barang barang : listBarang.barang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                barangDiedit = barang;
                break;
            }
        }

        if (barangDiedit != null) {
            System.out.print("Masukkan nama baru untuk barang: ");
            String newNama = Main.scanner.nextLine();
            System.out.print("Masukkan harga baru untuk barang: ");
            double newHarga = Main.scanner.nextDouble();
            Main.scanner.nextLine(); // Consuming the newline character

            barangDiedit.setNama(newNama);
            barangDiedit.setHarga(newHarga);

            System.out.println("Barang berhasil diedit!");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    /**
     * Menampilkan daftar transaksi.
     *
     * @param invoices ArrayList yang berisi objek Invoice yang akan ditampilkan.
     */
    public void lihatTransaksi(ArrayList<Invoice> invoices) {
        System.out.println("Daftar Transaksi:");
        if (!invoices.isEmpty()) {
            for (Invoice invoice : invoices) {
                // Pastikan bahwa objek Transaksi dan Invoice tidak null
                if (invoice != null && invoice.transaksi != null) {
                    System.out.println("ID Transaksi: " + invoice.transaksi.akun.id);
                    System.out.println("Total Harga: " + calculateTotalHarga(invoice.transaksi.barang));
                    System.out.println("Metode Pembayaran: " + invoice.pembayaran.getClass().getSimpleName());
                    System.out.println("Status Pembayaran: "
                            + (invoice.pembayaran.isPembayaranBerhasil() ? "Berhasil" : "Belum Berhasil"));
                    System.out.println("=====================================");
                } else {
                    System.out.println("Error: Objek Transaksi atau Invoice null.");
                }
            }
        } else {
            System.out.println("Daftar Transaksi kosong.");
        }
    }

    /**
     * Menghitung total harga dari suatu daftar barang.
     *
     * @param barangList ArrayList yang berisi objek Barang.
     * @return Total harga dari daftar barang.
     */
    private double calculateTotalHarga(ArrayList<Barang> barangList) {
        double totalHarga = 0;
        for (Barang barang : barangList) {
            totalHarga += barang.getHarga();
        }
        return totalHarga;
    }

    /**
     * Menerima transaksi dari customer dan menambahkannya ke daftar transaksi selesai.
     *
     * @param invoice Objek Invoice yang akan ditambahkan ke daftar transaksi selesai.
     */
    public void terimaTransaksi(Invoice invoice) {
        transaksiSelesai.tambahInvoice(invoice);
        System.out.println("Transaksi diterima!");
    }

     /**
     * Menampilkan menu admin yang memungkinkan Admin untuk melakukan berbagai operasi.
     *
     * @param adminDriver      Objek AdminDriver yang digunakan untuk memanggil metode-metode Admin.
     * @param transaksiSelesai Objek TransaksiSelesai yang menyimpan daftar transaksi selesai.
     */
    public void adminMenu(AdminDriver adminDriver, TransaksiSelesai transaksiSelesai) {
        int choice;

        do {
            System.out.println("+---------------------------+");
            System.out.println("|       Menu Admin         |");
            System.out.println("+---------------------------+");
            System.out.println("| 1. List Barang           |");
            System.out.println("| 2. Tambah Barang         |");
            System.out.println("| 3. Hapus Barang          |");
            System.out.println("| 4. Edit Barang           |");
            System.out.println("| 5. Lihat Transaksi       |");
            System.out.println("| 0. Keluar                |");
            System.out.println("+---------------------------+");
            System.out.print("Pilih opsi: ");
            choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (choice) {
                case 1:
                    adminDriver.ListBarang();
                    break;
                case 2:
                    adminDriver.tambahBarang();
                    break;
                case 3:
                    adminDriver.hapusBarang();
                    break;
                case 4:
                    adminDriver.editBarang();
                    break;
                case 5:
                    adminDriver.lihatTransaksi(transaksiSelesai.invoices);
                    break;
                case 0:
                    System.out.println("Keluar dari menu admin.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (choice != 0);
    }
}
