import java.util.Scanner;

public class Pemesanan {
    private Menu menu;
    private Produk[] produk;
    private byte jumlah = 0;
    private double hargatotal = 0;

    // Cosntructor
    public Pemesanan(Menu menu) {
        this.menu = menu;
        this.produk = new Produk[10];
    }

    public void tambahPesanan(String nama, int qty) {
        if (getMenuId(nama) == -1) {
            System.out.println(nama + " tidak ada di menu.");
        } else {
            this.produk[jumlah] = new Produk(nama, qty);
            jumlah++;
        }
    }

    public void konfirmasiPesanan() {
        System.out.println("\nPesanan Anda adalah sebagai berikut:");
        tampilPesanan();
        System.out.println("Total yang harus kamu bayar adalah: " + hargatotal);
    }

    public void tampilPesanan() {
        byte id;
        for (byte i = 0; i < jumlah; i++) {
            id = getMenuId(produk[i].getNama());
            if (isOutOfStock(id, i)) {
                System.out.println("Stok [" + produk[i].getNama() + "] tidak cukup.");
            } else {
                System.out.println("[" + produk[i].getNama() + ", " + produk[i].getQty() + "]\tTotal: Rp."
                        + menu.getMakanan()[id].getHarga() * produk[i].getQty());
                this.hargatotal += menu.getMakanan()[id].getHarga() * produk[i].getQty();
                menu.kurangiStok(id, produk[i].getQty());
            }
        }
    }

    public boolean isOutOfStock(byte id, byte i) {
        if (menu.getMakanan()[id].getStok() < produk[i].getQty()) {
            return true;
        } else {
            return false;
        }
    }

    public byte getMenuId(String nama) {
        for (byte i = 0; i < menu.getId(); i++) {
            if (menu.getMakanan()[i].getNama().equals(nama)) {
                return i;
            }
        }
        return -1;
    }

    public void buatPesanan() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMasukkan Pesananmu.");
            System.out.print("Nama Makanan: ");
            String nama = sc.nextLine();
            System.out.print("Kuantitas: ");
            int qty = sc.nextInt();
            this.tambahPesanan(nama, qty);
            System.out.print("Apakah ingin menambah pesanan? (Y/N): ");
            String choice = sc.next();
            if (choice.charAt(0) == 'n' || choice.charAt(0) == 'N') {
                sc.close();
                break;
            }
            sc.nextLine();
        }
    }
}
