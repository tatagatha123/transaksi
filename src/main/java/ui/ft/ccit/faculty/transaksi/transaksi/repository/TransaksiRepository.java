package ui.ft.ccit.faculty.transaksi.transaksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;

public interface TransaksiRepository
        extends JpaRepository<Transaksi, String> {
}
