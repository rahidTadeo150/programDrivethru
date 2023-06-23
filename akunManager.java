package finalprogram;

class akunManager extends akun {
    private final String jenisAkun = "Manager";

    akunManager(String username, String password) {
        super(username, password, 2);
    }

    void displayOpsiManager() {
        while (jenisAkun.equals("Manager")) {

            System.out.println("\n=====================");
            System.out.println("\nUsername: " + this.getUsername());
            System.out.println("Jenis Akun: " + this.jenisAkun);
            System.out.println("\n-> Statistik");
            System.out.println("\nJumlah Menu: " + menu.menuStorage.getMenuStorage().length);
            System.out.println("Jumlah Akun Karyawan: " + akunKaryawan.getJumlahKaryawan());

            System.out.println("1. Tambah Menu");
            System.out.println("2. Hapus Menu");
            System.out.println("3. Tambah Akun Karyawan");
            System.out.println("4. Hapus Akun Karyawan");
            System.out.println("5. Lihat Rekap");
            System.out.println("6. Keluar");
            System.out.print("\n: ");
            int opsiManager = Main.inpint.nextInt();
            switch (opsiManager) {
                case 1:
                    System.out.print("\nMasukan Menu Baru: ");
                    String menuBaru = Main.inpstr.nextLine();
                    System.out.print("Masukan Harga Baru: ");
                    int hargaBaru = Main.inpint.nextInt();
                    System.out.println("\nPilih Kategori Menu:");
                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.print("\n: ");
                    int kategoriMenu = Main.inpint.nextInt();
                    if (kategoriMenu == 1) {
                        menu menuMakanan = new makanan(menuBaru, hargaBaru);
                        menu.menuStorage.addOnStorage(menuMakanan);
                        System.out.println("\nMenu Berhasil di Tambahkan");
                        menu.menuStorage.showStorage();
                    }
                    if (kategoriMenu == 2) {
                        menu menuMinuman = new minuman(menuBaru, hargaBaru);
                        menu.menuStorage.addOnStorage(menuMinuman);
                        System.out.println("\nMenu Berhasil di Tambahkan");
                        menu.menuStorage.showStorage();
                    }
                    break;

                case 2:
                    menu.menuStorage.showStorage();
                    System.out.println("\nMasukan Urutan Menu Yang ingin di hapus");
                    System.out.print(": ");
                    int urutanHapus = Main.inpint.nextInt();
                    menu.menuStorage.deleteStorage(urutanHapus);
                    System.out.println("\nmenu saat ini:");
                    System.out.println();
                    menu.menuStorage.showStorage();
                    break;

                case 3:
                    System.out.print("\nBuat Username Karyawan Baru: ");
                    String usernameKaryawan = Main.inpstr.nextLine();
                    System.out.print("Buat Password Karyawan Baru: ");
                    String passwordKaryawan = Main.inpstr.nextLine();
                    akun newKaryawan = new akunKaryawan(usernameKaryawan, passwordKaryawan);
                    akun.akunStorage.addOnStorage(newKaryawan);
                    break;

                case 4:
                    akun.akunStorage.showAkunKaryawan();
                    System.out.println("Masukan Nomor Urut Yang Ingin di Hapus");
                    System.out.print("\n: ");
                    int nomorKaryawan = Main.inpint.nextInt();
                    akun.akunStorage.deleteStorage(nomorKaryawan + 1);
                    akun.akunStorage.showAkunKaryawan();
                    break;

                case 5:
                    System.out.println("Masukan Opsi Rekapan");
                    System.out.println("1. Dari yang Terbaru");
                    System.out.println("2. Dari yang Terlama");
                    int opsiRekap = Main.inpint.nextInt();
                    switch (opsiRekap) {
                        case 1:
                            akunKaryawan.rekapdata.shownodePrev();
                            break;
                        case 2:
                            akunKaryawan.rekapdata.shownode();
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }
}
