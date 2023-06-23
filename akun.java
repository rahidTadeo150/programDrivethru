package finalprogram;

public class akun {
    static akunStorage akunStorage = new akunStorage();
    private String username;
    private String password;
    private int idJenisAkun;

    akun(String username, String password, int idJenisAkun) {
        this.username = username;
        this.password = password;
        this.idJenisAkun = idJenisAkun;
    }

    int getIdJenisAkun() {
        return this.idJenisAkun;
    }

    String getUsername() {
        return this.username;
    }

    String getPassword() {
        return this.password;
    }

    void addAccount(akun akun) {
        akunStorage.addOnStorage(akun);
    }
}
