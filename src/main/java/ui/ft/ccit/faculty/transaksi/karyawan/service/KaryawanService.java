package ui.ft.ccit.faculty.transaksi.karyawan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.karyawan.repository.KaryawanRepository;

@Service
public class KaryawanService {

    private final KaryawanRepository repository;

    public KaryawanService(KaryawanRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Karyawan create(Karyawan karyawan) {
        return repository.save(karyawan);
    }

    // READ ALL
    public List<Karyawan> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Karyawan findById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException("Karyawan", id));
    }

    // UPDATE
    public Karyawan update(String id, Karyawan request) {

        Karyawan k = findById(id);

        k.setNama(request.getNama());
        k.setJenisKelamin(request.getJenisKelamin());
        k.setAlamat(request.getAlamat());
        k.setTelepon(request.getTelepon());
        k.setTglLahir(request.getTglLahir());
        k.setGaji(request.getGaji());

        return repository.save(k);
    }

    // DELETE
    public void delete(String id) {
        Karyawan k = findById(id);
        repository.delete(k);
    }
}
