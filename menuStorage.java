package finalprogram;

class menuStorage {
    private menu[] menu = new menu[0];

    menu[] getMenuStorage() {
        return menu;
    }

    menu getMenuByPosition(int posisi) {
        return menu[posisi - 1];
    }

    void addOnStorage(menu menuInsert) {
        if (menu.length == 0) {
            menu = new menu[1];
        }
        if (menu[0] == null) {
            menu[0] = menuInsert;
        } else {
            menu[] menutemp = menu;
            menu = new menu[menu.length + 1];
            int i = 0;
            while (i < menutemp.length) {
                menu[i] = menutemp[i];
                i++;
            }
            menu[menutemp.length] = menuInsert;
        }
    }

    void deleteStorage(int urutan) {
        int i = 0;
        int j = 0;
        if (menu[i].getNamaMenu() != null) {
            menu[] menuTemp = menu;
            menuTemp[urutan - 1] = null;
            menu = new menu[menu.length - 1];
            while (j < menu.length) {
                if (menuTemp[i] == null) {
                    i++;
                } else {
                    menu[j] = menuTemp[i];
                    i++;
                    j++;
                }
            }
        } else {
            System.out.println("Maaf Menu Masih Kosong");
        }
    }

    void showStorage() {
        int i = 0;
        if (menu.length != 0) {
            while (i < menu.length) {
                if (menu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) menu[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]");
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                if (menu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) menu[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]");
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                i++;
            }
        } else {
            System.out.println("Maaf Menu Masih Kosong");
        }
    }

    menu showStorageByName(String keyword) {
        menu kembalianPosisi = null;
        int indikator = 0;
        int i = 0;
        while (i < menu.length) {
            if (menu[i].getNamaMenu().equalsIgnoreCase(keyword)) {
                if (menu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) menu[i];
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]");
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                if (menu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) menu[i];
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]");
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                kembalianPosisi = menu[i];
                indikator++;
            }
            i++;
        }
        if (indikator == 0) {
            System.out.println("\nPencarian Anda Gagal, Keyword Tidak ada yang cocok");
        }
        return kembalianPosisi;
    }
}
