package finalprogram;

class keranjangStorage {
    private menu[] menu = new menu[0];
    private int[] kuantitas = new int[0];
    private int total;

    menu[] getKeranjangList() {
        return menu;
    }

    int[] getKuantitasList() {
        return kuantitas;
    }

    void setMenudanKuantitas(menu[] menu, int[] kuantitas) {
        this.menu = menu;
        this.kuantitas = kuantitas;
    }

    int getTotal() {
        return total;
    }

    void addOnStorage(menu menuInsert, int kuantitas) {
        if (menu.length == 0) {
            menu = new menu[1];
            this.kuantitas = new int[1];
        }
        if (menu[0] == null) {
            menu[0] = menuInsert;
            this.kuantitas[0] = kuantitas;
        } else {
            menu[] menutemp = menu;
            int[] kuantitastemp = this.kuantitas;
            menu = new menu[menu.length + 1];
            this.kuantitas = new int[this.kuantitas.length + 1];
            int i = 0;
            while (i < menutemp.length) {
                menu[i] = menutemp[i];
                this.kuantitas[i] = kuantitastemp[i];
                i++;
            }
            menu[menutemp.length] = menuInsert;
            this.kuantitas[kuantitastemp.length] = kuantitas;
        }
    }

    void showKeranjang(int fasePayment) {
        int i = 0;
        if (menu.length != 0) {
            while (i < menu.length) {
                if (menu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) menu[i];
                    int totalPerItem = menu[i].getHargaMenu() * kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                    if (fasePayment == 1) {
                        total += totalPerItem;
                    }
                }
                if (menu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) menu[i];
                    int totalPerItem = menu[i].getHargaMenu() * kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                    if (fasePayment == 1) {
                        total += totalPerItem;
                    }
                }
                i++;
            }
        } else {
            System.out.println("Keranjang Masih Kosong");
        }
    }

    void deleteStorage(int urutan) {
        int i = 0;
        int j = 0;
        if (menu[i].getNamaMenu() != null) {
            menu[] menuTemp = menu;
            int[] kuantitasTemp = kuantitas;
            menuTemp[urutan - 1] = null;
            kuantitasTemp[urutan - 1] = 0;
            menu = new menu[menu.length - 1];
            kuantitas = new int[kuantitas.length - 1];
            while (j < menu.length) {
                if (menuTemp[i] == null) {
                    i++;
                } else {
                    menu[j] = menuTemp[i];
                    kuantitas[j] = kuantitasTemp[i];
                    i++;
                    j++;
                }
            }
        } else {
            System.out.println("Maaf Menu Masih Kosong");
        }
    }

    void deleteAll() {
        menu = new menu[1];
        kuantitas = new int[1];
        this.total = 0;
    }
}