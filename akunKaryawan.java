package finalprogram;

class akunKaryawan extends akun {
    static rekapan rekapdata = new rekapan();
    private final String jenisAkun = "Employee";
    private static int jumlahKaryawan;

    akunKaryawan(String username, String password) {
        super(username, password, 1);
        jumlahKaryawan++;
    }

    static int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    static void setJumlahKaryawan(int jumlah) {
        jumlahKaryawan = jumlah;
    }

    void displayOpsiKaryawan() {
        boolean loopKaryawan = true;
        while (loopKaryawan == true) {
            System.out.println("\n============================================");
            System.out.println("\nUsername: " + this.getUsername());
            System.out.println("Jenis Akun: " + this.jenisAkun);
            System.out.println("Jumlah Orderan Saat Ini Belum Di Selesaikan: " + Main.catatOrder.getLength());
            System.out.println("\n====== O P S I ======");
            System.out.println("1. Orderan");
            System.out.println("2. Check Menu");
            System.out.println("3. Keluar");
            System.out.print("\n: ");
            int opsiKaryawan = Main.inpint.nextInt();
            switch (opsiKaryawan) {
                case 1:
                    Main.catatOrder.shownode();
                    System.out.println("\nNext Orderan? (y/n)");
                    System.out.print("\n: ");
                    String nextorder = Main.inpstr.nextLine();
                    if (nextorder.equalsIgnoreCase("y")) {
                        rekapdata.addnode(Main.catatOrder);
                        Main.catatOrder.deleteNode();
                        System.out.println("\nOrderan Telah Di Selesaikan!");
                    }
                    break;

                case 2:
                    menu.menuStorage.showStorage();
                    break;

                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}
