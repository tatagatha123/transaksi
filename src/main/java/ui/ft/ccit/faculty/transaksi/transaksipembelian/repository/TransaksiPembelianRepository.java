package ui.ft.ccit.faculty.transaksi.transaksipembelian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ui.ft.ccit.faculty.transaksi.transaksipembelian.model.TransaksiPembelian;
import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;

public interface TransaksiPembelianRepository
        extends JpaRepository<TransaksiPembelian, String> {

    boolean existsByPemasok(Pemasok pemasok);
}
