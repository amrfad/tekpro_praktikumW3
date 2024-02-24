public class Makanan {
    // Always keep data private
    private String nama;
    private double harga;
    private int stok;
    
    // Constructor
    public Makanan(String nama_makanan, double harga_makanan, int stok) {
        this.nama = nama_makanan;
        this.harga = harga_makanan;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama_makanan) {
        this.nama = nama_makanan;
    }
    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga_makanan) {
        this.harga = harga_makanan;
    }
    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    
    
}
