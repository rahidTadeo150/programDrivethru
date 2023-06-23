package finalprogram;

class akunStorage {
    private akun[] akun = new akun[1];

    akun[] getAkunList() {
        return akun;
    }

    void addOnStorage(akun akunInsert) {
        if (akun[0] == null) {
            akun[0] = akunInsert;
        } else {
            akun[] akuntemp = akun;
            akun = new akun[akun.length + 1];
            int i = 0;
            while (i < akuntemp.length) {
                akun[i] = akuntemp[i];
                i++;
            }
            akun[akuntemp.length] = akunInsert;
        }
    }

    void cekAkun(String username, String password) {
        int i = 0;
        while (i < akun.length) {
            if (akun[i].getUsername().equals(username)
                    && akun[i].getPassword().equals(password)) {
                if (akun[i].getIdJenisAkun() == 1) {
                    akunKaryawan cast = (akunKaryawan) akun[i];
                    cast.displayOpsiKaryawan();
                }
                if (akun[i].getIdJenisAkun() == 2) {
                    akunManager cast = (akunManager) akun[i];
                    cast.displayOpsiManager();
                }
            }
            i++;
        }
        System.out.println("\nAkun Tidak Di Ketahui...");
    }

    void showAkunKaryawan() {
        int i = 0;
        while (i < akun.length) {
            if (akun[i].getIdJenisAkun() == 1) {
                System.out.println();
                System.out.println(i + ". Username: " + akun[i].getUsername());
                System.out.println("   Password: " + akun[i].getPassword());
            }
            i++;
        }
    }

    void deleteStorage(int urutan) {
        int i = 0;
        int j = 0;
        if (akun[i].getUsername() != null) {
            akun[] akunTemp = akun;
            akunTemp[urutan - 1] = null;
            akun = new akun[akun.length - 1];
            while (j < akun.length) {
                if (akunTemp[i] == null) {
                    i++;
                } else {
                    akun[j] = akunTemp[i];
                    i++;
                    j++;
                }
            }
        } else {
            System.out.println("Maaf akun Masih Kosong");
        }
        akunKaryawan.setJumlahKaryawan(akunKaryawan.getJumlahKaryawan() - 1);
    }
}
