package finalprogram;

import java.util.*;

public class Main {
    static Scanner inpint = new Scanner(System.in);
    static Scanner inpstr = new Scanner(System.in);
    static orderan catatOrder = new orderan();
    static customer newCustomer = new customer();

    public static void main(String[] args) {
        akun akunManager = new akunManager("admin", "admin");
        akun.akunStorage.addOnStorage(akunManager);
        boolean loopMain = true;
        while (loopMain == true) {
            System.out.println("Masukan Program: ");
            System.out.println("1. Admmin Staff");
            System.out.println("2. Customer");
            System.out.print("\n: ");
            int opsiProgram = inpint.nextInt();
            if (opsiProgram == 1) {
                System.out.println("-------- Log In Field --------");
                System.out.print("\nMasukan Username: ");
                String inputUsername = inpstr.nextLine();
                System.out.print("Masukan Password: ");
                String inputPassword = inpstr.nextLine();
                akun.akunStorage.cekAkun(inputUsername, inputPassword);
            } else {
                System.out.println("Masukan Nama Anda");
                System.out.print(": ");
                String namaCustomer = inpstr.nextLine();
                double kode = 1 + Math.random() * 9999;
                int castKode = (int) kode;
                String kodeString = Integer.toString(castKode);
                newCustomer.setCustomer(namaCustomer, kodeString);
                boolean batal = newCustomer.opsiCustomer();
                if (batal == false) {
                    System.out.println("\n====================================");
                    System.out.println("            - B I L L -");
                    System.out.println("\nNama Customer\t: " + newCustomer.getNamaCust());
                    System.out.println("Kode Customer\t: " + newCustomer.getKodeCust());
                    System.out.println("====================================");
                    newCustomer.keranjangStorage.showKeranjang(1);
                    System.out.println("\n====================================");
                    System.out.println("\nTOTAL\t: " + customer.keranjangStorage.getTotal());
                    System.out.println("\nPilih Metode Payment");
                    System.out.println("1. Tunai/Cash");
                    System.out.println("2. Dompet Digital (Dana, Ovo, ShopeePay)");
                    System.out.print("\n: ");
                    int pilihPayment = Main.inpint.nextInt();
                    if (pilihPayment == 1) {
                        paymentTunai tunai = new paymentTunai(customer.keranjangStorage.getTotal());
                        boolean buktiBayar = tunai.opsi();
                        if (buktiBayar == true) {
                            catatOrder.addnode(customer.keranjangStorage, newCustomer, tunai.getMetode());
                            customer.keranjangStorage.deleteAll();
                        } else {
                            continue;
                        }
                    }
                    if (pilihPayment == 2) {
                        paymentDompet dompetDigital = new paymentDompet(customer.keranjangStorage.getTotal());
                        boolean buktiBayar = dompetDigital.opsi();
                        if (buktiBayar == true) {
                            catatOrder.addnode(customer.keranjangStorage, newCustomer, dompetDigital.getMetode());
                            customer.keranjangStorage.deleteAll();
                        } else {
                            continue;
                        }
                    }
                }
            }

        }
    }
}
