public class RestaurantMain2 {
    public static void main(String[] args){
        // Menginisialisasi Menu
        Menu menu = new Menu();
        menu.tambahMenuMakanan("Bala-Bala", 1_000, 20);
        menu.tambahMenuMakanan("Gehu", 1_000, 25);
        menu.tambahMenuMakanan("Tahu", 1_000, 15);
        menu.tambahMenuMakanan("Molen", 1_500, 10);
        menu.tambahMenuMakanan("Cireng", 1_000, 15);
        menu.tambahMenuMakanan("Telor Dadar", 4_000, 12);
        menu.tambahMenuMakanan("Tempe", 1_000, 20);
        menu.tambahMenuMakanan("Ayam Goreng", 6_000, 10);
        menu.tambahMenuMakanan("Ikan Mas", 7_000, 7);
        menu.tambahMenuMakanan("Telor Asin", 5_000, 15);

        menu.tampilMenuMakanan();

        // Pemesanan Menu
        Pemesanan order = new Pemesanan(menu);
        order.buatPesanan();

        order.konfirmasiPesanan();
    }
}
