package finalprogram;

class rekapan extends singleLinkedList {
    private node head;
    private node tail;

    class node {
        private String customer;
        private String kodeCustomer;
        private menu[] dataMenu;
        private int[] kuantitas;
        private String pembayaran;
        private int total;
        private node next;
        private node prev;

        node(orderan dataPesanan) {
            this.customer = dataPesanan.getCust(getLength());
            this.kodeCustomer = dataPesanan.getKodeCust(getLength());
            this.dataMenu = dataPesanan.getDataKeranjang(getLength());
            this.kuantitas = dataPesanan.getDataKuantitas(getLength());
            this.pembayaran = dataPesanan.getMetode(getLength());
            this.total = dataPesanan.getTotal(getLength());
        }
    }

    void addnode(orderan dataPesanan) {
        node newNode = new node(dataPesanan);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        setLength(getLength() + 1);
    }

    void deleteNode() {
        node temp = head;
        head = head.next;
        temp = null;
        setLength(getLength() - 1);
    }

    void shownode() {
        int i = 0;
        int j = 1;
        node posisi = head;
        while (j <= getLength()) {
            System.out.println();
            System.out.println(
                    j + ". Nama Customer: " + posisi.customer + " (" + posisi.kodeCustomer + ")");
            System.out.println("Metode Pembayaran: " + posisi.pembayaran);
            System.out.println("\n-> History Pesanan");
            while (i < posisi.dataMenu.length) {
                if (posisi.dataMenu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem
                            + "\t\t" + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                    System.out.println("TOTAL: " + posisi.total);
                }
                if (posisi.dataMenu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                    System.out.println("TOTAL: " + posisi.total);
                }
                i++;
            }
            i = 0;
            System.out.println("    TOTAL: " + posisi.total);
            posisi = posisi.next;
            j++;
        }
    }

    void shownodePrev() {
        int i = 0;
        int j = 1;
        node posisi = tail;
        while (j <= getLength()) {
            System.out.println();
            System.out.println(
                    j + ". Nama Customer: " + posisi.customer + " (" + posisi.kodeCustomer + ")");
            System.out.println("Metode Pembayaran: " + posisi.pembayaran);
            System.out.println("\n-> History Pesanan");
            while (i < posisi.dataMenu.length) {
                if (posisi.dataMenu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                if (posisi.dataMenu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                i++;
            }
            i = 0;
            System.out.println("    TOTAL: " + posisi.total);
            posisi = posisi.prev;
            j++;
        }
    }

}
