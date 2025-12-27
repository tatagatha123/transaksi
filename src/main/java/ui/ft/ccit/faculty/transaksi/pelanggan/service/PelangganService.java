package ui.ft.ccit.faculty.transaksi.pelanggan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.pelanggan.repository.PelangganRepository;

@Service
public class PelangganService {

    private final PelangganRepository repository;

    public PelangganService(PelangganRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Pelanggan create(Pelanggan pelanggan) {
        return repository.save(pelanggan);
    }

    // READ ALL
    public List<Pelanggan> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Pelanggan findById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException("Pelanggan", id));
    }

    // UPDATE
    public Pelanggan update(String id, Pelanggan request) {

        Pelanggan p = findById(id);

        p.setNama(request.getNama());
        p.setJenisKelamin(request.getJenisKelamin());
        p.setAlamat(request.getAlamat());
        p.setTelepon(request.getTelepon());
        p.setTglLahir(request.getTglLahir());
        p.setJenisPelanggan(request.getJenisPelanggan());

        return repository.save(p);
    }

    // DELETE
    public void delete(String id) {
        Pelanggan p = findById(id);
        repository.delete(p);
    }
}
