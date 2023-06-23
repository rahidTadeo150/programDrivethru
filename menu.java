package finalprogram;

class menu {
    static menuStorage menuStorage = new menuStorage();
    private String namaMenu;
    private int hargaMenu;
    private int idKategori;

    menu(String namaMenu, int hargaMenu, int idKategori) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.idKategori = idKategori;
    }

    String getNamaMenu() {
        return namaMenu;
    }

    int getHargaMenu() {
        return hargaMenu;
    }

    int getKategoriMenu() {
        return idKategori;
    }
}
