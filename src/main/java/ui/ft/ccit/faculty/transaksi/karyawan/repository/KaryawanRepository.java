package ui.ft.ccit.faculty.transaksi.karyawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;

public interface KaryawanRepository
        extends JpaRepository<Karyawan, String> {
}
