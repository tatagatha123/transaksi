package ui.ft.ccit.faculty.transaksi.pelanggan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;

public interface PelangganRepository
        extends JpaRepository<Pelanggan, String> {
}
