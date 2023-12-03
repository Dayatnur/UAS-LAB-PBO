/**
 * Class CustomerDriver merupakan sebuah driver untuk operasi-operasi terkait pelanggan dalam sistem belanja.
 * Class ini mengextend Class Driver dan mencakup fungsionalitas untuk berinteraksi dengan daftar barang (ListBarang),
 * mengelola keranjang belanja pelanggan, melakukan proses checkout, dan melihat riwayat belanja.
 */
class CustomerDriver extends Driver {
    
     /** Daftar barang yang tersedia untuk dibeli. 
     */
    ListBarang listBarang;
    /** Pelanggan yang terkait dengan driver ini. 
    */
    Customer customer;
     /** AdminDriver untuk menangani tugas administratif. 
     */
    AdminDriver adminDriver; // Tambahkan atribut AdminDriver

     /**
     * Konstruktor CustomerDriver dengan ListBarang, Customer, dan AdminDriver tertentu.
     *
     * @param listBarang   Daftar barang yang tersedia untuk dibeli.
     * @param customer     Pelanggan yang terkait dengan driver ini.
     * @param adminDriver  AdminDriver untuk menangani tugas administratif.
     */
    public CustomerDriver(ListBarang listBarang, Customer customer, AdminDriver adminDriver) {
        this.listBarang = listBarang;
        this.customer = customer;
        this.adminDriver = adminDriver; // Inisialisasi atribut AdminDriver
    }

    /**
     * Menampilkan daftar barang yang tersedia.
     */
    @Override
    void ListBarang() {
        listBarang.displayListBarang();
    }

    /**
     * Menambahkan barang yang dipilih ke keranjang belanja pelanggan.
     */
    public void tambahBarangKeKeranjang() {
        customer.tambahBarangKeKeranjang(listBarang);
    }

    /**
     * Menampilkan isi keranjang belanja pelanggan.
     */
    public void lihatIsiKeranjang() {
        customer.lihatIsiKeranjang();
    }

     /**
     * Memulai proses checkout, melibatkan interaksi dengan admin driver.
     */
    public void prosesCheckout() {
        customer.prosesCheckout(adminDriver);
    }

    /**
     * Menampilkan riwayat belanja pelanggan.
     */
    public void lihatHistoryPembelanjaan() {
        customer.lihatHistoryPembelanjaan();
    }

    /**
     * Menyediakan menu pengguna untuk berinteraksi dengan sistem belanja.
     * Menu ini mencakup opsi untuk melihat daftar barang, menambahkan barang ke keranjang,
     * melakukan checkout, melihat keranjang belanja, dan memeriksa riwayat belanja.
     * Pengguna dapat keluar dari menu dengan memilih opsi "Keluar".
     */
    public void userMenu() {
        int choice;

        do {
            System.out.println("+---------------------------+");
            System.out.println("|           Menu            |");
            System.out.println("+---------------------------+");
            System.out.println("| 1. List Barang           |");
            System.out.println("| 2. Tambah Barang         |");
            System.out.println("| 3. Lihat Keranjang       |");
            System.out.println("| 4. Checkout              |");
            System.out.println("| 5. Lihat History         |");
            System.out.println("| 0. Keluar                |");
            System.out.println("+---------------------------+");
            System.out.print("Pilih opsi: ");
            choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (choice) {
                case 1:
                    ListBarang();
                    break;
                case 2:
                    tambahBarangKeKeranjang();
                    break;
                case 3:
                    lihatIsiKeranjang();
                    break;
                case 4:
                    prosesCheckout();
                    break;
                case 5:
                    lihatHistoryPembelanjaan();
                    break;
                case 0:
                    System.out.println("Keluar dari menu user.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (choice != 0);
    }
}
