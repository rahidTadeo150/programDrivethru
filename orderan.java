package finalprogram;

class orderan extends singleLinkedList {
    private node head;
    private node tail;

    class node {
        private menu[] dataMenu;
        private int[] kuantitas;
        private String customer;
        private String kodeCustomer;
        private int total;
        private String pembayaran;
        private node next;

        node(keranjangStorage dataMenu, customer customer, String payment) {
            this.dataMenu = dataMenu.getKeranjangList();
            this.kuantitas = dataMenu.getKuantitasList();
            this.customer = customer.getNamaCust();
            this.kodeCustomer = customer.getKodeCust();
            this.total = dataMenu.getTotal();
            this.pembayaran = payment;
        }
    }

    String getCust(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.customer;
    }

    String getKodeCust(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.kodeCustomer;
    }

    int getTotal(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.total;
    }

    String getMetode(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.pembayaran;
    }

    menu[] getDataKeranjang(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.dataMenu;
    }

    int[] getDataKuantitas(int posisinode) {
        int i = 1;
        node posisi = head;
        while (i < posisinode) {
            posisi = posisi.next;
        }
        return posisi.kuantitas;
    }

    void addnode(keranjangStorage dataMenu, customer customer, String payment) {
        node newNode = new node(dataMenu, customer, payment);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        setLength(getLength() + 1);
    }

    // Delete First (head) -> Queue
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
            System.out.println("Metode Payment: " + posisi.pembayaran);
            System.out.println("-> Pesanan");
            while (i < posisi.dataMenu.length) {
                if (posisi.dataMenu[i].getKategoriMenu() == 1) {
                    makanan cast = (makanan) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem
                            + "\t\t" + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                if (posisi.dataMenu[i].getKategoriMenu() == 2) {
                    minuman cast = (minuman) posisi.dataMenu[i];
                    int totalPerItem = posisi.dataMenu[i].getHargaMenu() * posisi.kuantitas[i];
                    System.out.println();
                    System.out.println(i + 1 + ". " + cast.getNamaMenu() + "  [ " + cast.getJenisMenu() + " ]\t"
                            + posisi.kuantitas[i] + "x = " + totalPerItem
                            + "\t\t" + posisi.kuantitas[i] + "x = " + totalPerItem);
                    System.out.println("   Harga: " + cast.getHargaMenu());
                }
                i++;
            }
            i = 0;
            System.out.println("    TOTAL: " + posisi.total);
            posisi = posisi.next;
            j++;
        }
    }
}
