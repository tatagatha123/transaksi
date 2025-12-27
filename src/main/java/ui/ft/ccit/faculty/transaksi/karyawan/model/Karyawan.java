package ui.ft.ccit.faculty.transaksi.karyawan.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "telepon")
    private String telepon;

    @Column(name = "tgl_lahir")
    private LocalDate tglLahir;

    @Column(name = "gaji")
    private Double gaji;

    public Karyawan() {
    }

    // getter & setter
    public String getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(String idKaryawan) { this.idKaryawan = idKaryawan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }

    public LocalDate getTglLahir() { return tglLahir; }
    public void setTglLahir(LocalDate tglLahir) { this.tglLahir = tglLahir; }

    public Double getGaji() { return gaji; }
    public void setGaji(Double gaji) { this.gaji = gaji; }
}