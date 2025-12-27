package ui.ft.ccit.faculty.transaksi.detailtransaksi.model;

import jakarta.persistence.*;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;

@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {

    @EmbeddedId
    private DetailTransaksiId id;

    @ManyToOne
    @MapsId("kodeTransaksi")
    @JoinColumn(name = "kode_transaksi", nullable = false)
    private Transaksi transaksi;

    @ManyToOne
    @MapsId("idBarang")
    @JoinColumn(name = "id_barang", nullable = false)
    private Barang barang;

    @Column(nullable = false)
    private Integer jumlah;

    public DetailTransaksi() {}

    public DetailTransaksiId getId() {
        return id;
    }

    public void setId(DetailTransaksiId id) {
        this.id = id;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
