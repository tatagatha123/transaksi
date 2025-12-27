package ui.ft.ccit.faculty.transaksi.detailtransaksi.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetailTransaksiId implements Serializable {

    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "id_barang", length = 4)
    private String idBarang;

    public DetailTransaksiId() {}

    public DetailTransaksiId(String kodeTransaksi, String idBarang) {
        this.kodeTransaksi = kodeTransaksi;
        this.idBarang = idBarang;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    // WAJIB untuk composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailTransaksiId)) return false;
        DetailTransaksiId that = (DetailTransaksiId) o;
        return kodeTransaksi.equals(that.kodeTransaksi)
                && idBarang.equals(that.idBarang);
    }

    @Override
    public int hashCode() {
        return kodeTransaksi.hashCode() + idBarang.hashCode();
    }
}
