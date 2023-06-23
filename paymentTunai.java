package finalprogram;

class paymentTunai extends payment {
    private final String metodePayment = "Tunai";

    paymentTunai(int total) {
        super(total);
    }

    String getMetode() {
        return metodePayment;
    }

    boolean opsi() {
        boolean loopPayment = true;
        System.out.println(
                "\nHarap Membayar Ke loket Take Order Di depan, Terima Kasih Telah Menggunakan Pelayanan Kami.");
        while (loopPayment == true) {
            System.out.println("\nTotal Yang Harus Di Bayarkan: " + getTotal());
            System.out.println("Masukan Nominal Pembayaran");
            System.out.print(": ");
            int nominalPayment = Main.inpint.nextInt();
            setBayar(nominalPayment);
            loopPayment = setKembalian();
        }
        return true;
    }
}
