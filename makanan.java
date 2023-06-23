package finalprogram;

class makanan extends menu {
    private final String jenisMenu = "Makanan";

    makanan(String namaMenu, int hargaMenu) {
        super(namaMenu, hargaMenu, 1);
    }

    String getJenisMenu() {
        return jenisMenu;
    }
}
