package ui.ft.ccit.faculty.transaksi.detailtransaksi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksiId;

public interface DetailTransaksiRepository
        extends JpaRepository<DetailTransaksi, DetailTransaksiId> {

    List<DetailTransaksi> findById_KodeTransaksi(String kodeTransaksi);
}
