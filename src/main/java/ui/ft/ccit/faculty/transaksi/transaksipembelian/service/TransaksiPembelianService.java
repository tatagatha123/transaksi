package ui.ft.ccit.faculty.transaksi.transaksipembelian.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.repository.PemasokRepository;
import ui.ft.ccit.faculty.transaksi.transaksipembelian.model.TransaksiPembelian;
import ui.ft.ccit.faculty.transaksi.transaksipembelian.repository.TransaksiPembelianRepository;

@Service
public class TransaksiPembelianService {

    private final TransaksiPembelianRepository repository;
    private final PemasokRepository pemasokRepository;

    public TransaksiPembelianService(
            TransaksiPembelianRepository repository,
            PemasokRepository pemasokRepository) {
        this.repository = repository;
        this.pemasokRepository = pemasokRepository;
    }

    // CREATE
    public TransaksiPembelian create(String idTransaksi, String idPemasok) {

        Pemasok pemasok = pemasokRepository.findById(idPemasok)
                .orElseThrow(() ->
                        new DataNotFoundException("Pemasok", idPemasok));

        TransaksiPembelian t = new TransaksiPembelian();
        t.setIdTransaksi(idTransaksi);
        t.setTglTransaksi(LocalDate.now());
        t.setTotal(BigDecimal.ZERO);
        t.setPemasok(pemasok);

        return repository.save(t);
    }

    // READ ALL
    public List<TransaksiPembelian> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public TransaksiPembelian findById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException("TransaksiPembelian", id));
    }

    // UPDATE (ganti pemasok)
    public TransaksiPembelian update(String id, String idPemasok) {

        TransaksiPembelian t = findById(id);

        Pemasok pemasok = pemasokRepository.findById(idPemasok)
                .orElseThrow(() ->
                        new DataNotFoundException("Pemasok", idPemasok));

        t.setPemasok(pemasok);
        return repository.save(t);
    }

    // DELETE
    public void delete(String id) {
        repository.delete(findById(id));
    }
}
