package finalprogram;

class payment {
    private int total;
    private int bayar;
    private int kembalian;

    payment(int total) {
        this.total = total;
    }

    int getTotal() {
        return total;
    }

    int getBayar() {
        return bayar;
    }

    boolean setKembalian() {
        if (bayar >= total) {
            this.kembalian = bayar - total;
            System.out.println("\nPembayaran: " + bayar);
            System.out.println("Kembalian Anda: " + kembalian);
            System.out.println(
                    "\nPayment Anda Berhasil Silahkan Menuju Ke Loket Take Order Dan selamat Menikmati Makanan Anda");
            return false;
        } else {
            System.out.println("Payment Gagal Pembayaran Anda Kurang");
            return true;
        }
    }

    void setBayar(int bayar) {
        this.bayar = bayar;
    }
}
