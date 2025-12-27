package ui.ft.ccit.faculty.transaksi.pemasok.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.repository.PemasokRepository;
import ui.ft.ccit.faculty.transaksi.transaksipembelian.repository.TransaksiPembelianRepository;

@Service
public class PemasokService {

    private final PemasokRepository pemasokRepository;
    private final TransaksiPembelianRepository transaksiPembelianRepository;

    public PemasokService(
            PemasokRepository pemasokRepository,
            TransaksiPembelianRepository transaksiPembelianRepository) {

        this.pemasokRepository = pemasokRepository;
        this.transaksiPembelianRepository = transaksiPembelianRepository;
    }

    public Pemasok save(Pemasok p) {
        return pemasokRepository.save(p);
    }

    public List<Pemasok> findAll() {
        return pemasokRepository.findAll();
    }

    public Pemasok findById(String id) {
        return pemasokRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pemasok tidak ditemukan"));
    }

    public void delete(String id) {

        Pemasok pemasok = findById(id);

        // VALIDASI RELASI (REAL CASE)
        if (transaksiPembelianRepository.existsByPemasok(pemasok)) {
            throw new IllegalStateException(
                    "Pemasok masih digunakan dalam transaksi pembelian");
        }

        pemasokRepository.delete(pemasok);
    }
}
