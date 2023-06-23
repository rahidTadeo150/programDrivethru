package finalprogram;

class customer {
    static keranjangStorage keranjangStorage = new keranjangStorage();
    private String namaCustomer;
    private String kodeCustomer;

    String getNamaCust() {
        return namaCustomer;
    }

    String getKodeCust() {
        return kodeCustomer;
    }

    void setCustomer(String namaCustomer, String kodeCustomer) {
        this.namaCustomer = namaCustomer;
        this.kodeCustomer = kodeCustomer;
    }

    boolean opsiCustomer() {
        boolean loopMainCust = true;
        while (loopMainCust == true) {
            System.out.println("\nSelamat Datang '" + namaCustomer + "' di Drive Thru By Kemet");
            System.out.println("\n===========================================");
            System.out.println("               - M E N U S -");
            System.out.println("===========================================");
            menu.menuStorage.showStorage();
            System.out.println("\nSilahkan Memesan Menu, Pilih sesuai Nomor Urut");
            System.out.print(": ");
            int pilihMenu = Main.inpint.nextInt();
            if (pilihMenu == 0) {
                System.out.println("Opsi Menu Customer");
                System.out.println("1. Cari Menu");
                System.out.println("2. Cek Keranjang");
                System.out.println("3. Keluar");
                System.out.println("3. Kembali ke Menu");
                System.out.println("\n: ");
                int pilihOpsi = Main.inpint.nextInt();
                switch (pilihOpsi) {
                    case 1:
                        System.out.println("Masukan Nama Menu yang di Cari");
                        System.out.print(": ");
                        String keywordCari = Main.inpstr.nextLine();
                        menu dataCari = menu.menuStorage.showStorageByName(keywordCari);
                        System.out.println("\nIngin Memesan Menu Yang di Cari?(y/n)");
                        System.out.print(": ");
                        String PesanCari = Main.inpstr.nextLine();
                        if (PesanCari.equalsIgnoreCase("y")) {
                            System.out.println("Masukan Kuantitas");
                            System.out.print(": ");
                            int kuantitas = Main.inpint.nextInt();
                            keranjangStorage.addOnStorage(dataCari, kuantitas);
                        }
                        if (PesanCari.equalsIgnoreCase("n")) {
                            break;
                        }
                        break;

                    case 2:
                        System.out.println("\n        - Keranjang Saya -");
                        keranjangStorage.showKeranjang(0);
                        System.out.println("====== OPSI ======");
                        System.out.println("1. Hapus Menu");
                        System.out.println("2. Kembali");
                        int opsiKeranjang = Main.inpint.nextInt();
                        if (opsiKeranjang == 1) {
                            System.out.println("Masukan No urut Yang Ingin di Hapus");
                            System.out.print(": ");
                            int pilihHapus = Main.inpint.nextInt();
                            keranjangStorage.deleteStorage(pilihHapus);
                        }
                        break;

                    case 3:
                        return true;
                    default:
                        break;
                }
            } else {
                System.out.println("Masukan Kuantitas");
                System.out.print(": ");
                int kuantitas = Main.inpint.nextInt();
                keranjangStorage.addOnStorage(menu.menuStorage.getMenuByPosition(pilihMenu), kuantitas);
                System.out.println("Ingin Melanjutkan Pesanan?(y/n)");
                System.out.print(": ");
                String lanjutPesan = Main.inpstr.nextLine();
                if (lanjutPesan.equalsIgnoreCase("n")) {
                    return false;
                }
            }
        }
        return true;
    }
}
