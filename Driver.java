/**
 * Kelas {@code Driver} adalah kelas abstrak yang mewakili seorang pengemudi
 * untuk mengelola daftar barang.
 * Subkelas harus mengimplementasikan metode {@code ListBarang} untuk menentukan
 * perilaku khusus dalam melakukan penulisan daftar barang.
 */
abstract class Driver {

    /**
     * Metode abstrak untuk menuliskan daftar barang.
     * Subkelas harus memberikan implementasi untuk metode ini untuk menentukan
     * bagaimana barang-barang dituliskan.
     */
    abstract void ListBarang();
}
