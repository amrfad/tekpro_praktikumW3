import java.util.Scanner;

public class Pemesanan {
    private Menu menu;
    private Pesanan[] pesanan;
    private byte jumlah=0;
    private double hargatotal=0;

    // Cosntructor
    public Pemesanan(Menu menu) {
        this.menu = menu;
        this.pesanan = new Pesanan[10];
    }

    public void tambahPesanan(String nama, int qty){
        if (getMenuId(nama) == -1){
            System.out.println(nama + " tidak ada di menu.");
        } else {
            this.pesanan[jumlah] = new Pesanan(nama, qty);
            jumlah++;
        }
    }

    public void konfirmasiPesanan(){
        System.out.println("\nPesanan Anda adalah sebagai berikut:");
        tampilPesanan();
        System.out.println("Total yang harus kamu bayar adalah: " + hargatotal);
    }

    public void tampilPesanan(){
        byte id;
        for (byte i=0; i < jumlah; i++){
            id = getMenuId(pesanan[i].getNama());
            if (isOutOfStock(id, i)){
                System.out.println("Stok ["+ pesanan[i].getNama() + "] tidak cukup.");
            } else {
                System.out.println("["+ pesanan[i].getNama() + ", " + pesanan[i].getQty() + "]\tTotal: Rp." + menu.getMakanan()[i].getHarga() * pesanan[i].getQty());
                this.hargatotal +=  menu.getMakanan()[i].getHarga() * pesanan[i].getQty();
                kurangiStok(id, pesanan[i].getQty());
            }
        }
    }

    public boolean isOutOfStock(byte id, byte i){
        if (menu.getMakanan()[id].getStok() < pesanan[i].getQty()){
            return true;
        } else {
            return false;
        }
    }

    public byte getMenuId(String nama){
        for (byte i=0; i < menu.getId(); i++){
            if (menu.getMakanan()[i].getNama().equals(nama)){
                return i;
            }
        }
        return -1;
    }

    public void kurangiStok(byte id, int qty){
        menu.getMakanan()[id].setStok(menu.getMakanan()[id].getStok() - qty);
    }

    public void buatPesanan(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Masukkan Pesananmu.");
            System.out.print("Nama Makanan: ");
            String nama = sc.nextLine();
            System.out.print("Kuantitas: ");
            int qty = sc.nextInt();
            this.tambahPesanan(nama, qty);
            System.out.print("Apakah ingin menambah pesanan? (Y/N): ");
            String choice = sc.next();
            if (choice.charAt(0) == 'n' || choice.charAt(0) == 'N'){
                sc.close();
                break;
            }
            sc.nextLine();
        }
    }
}
