// Make the names of your classes and methods reflect their responsibilities
public class Menu {
    // Don’t use too many basic types in a class
    private Makanan[] makanan;
    private byte id=0;

    public Menu() {
        this.makanan = new Makanan[10];
    }

    // Getter and Setter
    public Makanan[] getMakanan() {
        return makanan;
    }
    public byte getId(){
        return id;
    }
    
    // Method
    public void tambahMenuMakanan(String nama_makanan, double harga, int stok){
        this.makanan[id] = new Makanan(nama_makanan, harga, stok);
        id++;
    }
    
    public void tampilMenuMakanan(){
        for (byte i=0; i < id; i++){
            if (!isOutOfStock(i)){
                System.out.println(i + ". " + makanan[i].getNama() + " \t["+ makanan[i].getStok() +"]\t" + "\t= Rp." + makanan[i].getHarga());
            }
        }
    }

    public boolean isOutOfStock(byte id){
        if (this.makanan[id].getStok() == 0){
            return true;
        } else {
            return false;
        }
    }


}
