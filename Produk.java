public class Produk {
    private String nama;
    private int qty;

    // Constructor
    public Produk(String nama, int qty) {
        this.nama = nama;
        this.qty = qty;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
