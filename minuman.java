package finalprogram;

class minuman extends menu {
    private final String jenisMenu = "Minuman";

    minuman(String namaMenu, int hargaMenu) {
        super(namaMenu, hargaMenu, 2);
    }

    String getJenisMenu() {
        return jenisMenu;
    }
}
