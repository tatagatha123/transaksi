package ui.ft.ccit.faculty.transaksi.transaksipembelian.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;

@Entity
@Table(name = "transaksi_pembelian")
public class TransaksiPembelian {

    @Id
    @Column(name = "id_transaksi")
    private String idTransaksi;

    @Column(name = "tgl_transaksi")
    private LocalDate tglTransaksi;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_pemasok", nullable = false)
    private Pemasok pemasok;

    // ===== GETTER SETTER =====
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public LocalDate getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(LocalDate tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }
}
