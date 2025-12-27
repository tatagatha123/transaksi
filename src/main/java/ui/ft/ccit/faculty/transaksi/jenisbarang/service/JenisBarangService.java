package ui.ft.ccit.faculty.transaksi.jenisbarang.service;

import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarangRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisBarangService {

    private final JenisBarangRepository repository;

    public JenisBarangService(JenisBarangRepository repository) {
        this.repository = repository;
    }

    public List<JenisBarang> findAll() {
        return repository.findAll();
    }

    public JenisBarang findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jenis barang tidak ditemukan"));
    }

    public JenisBarang save(JenisBarang jenisBarang) {
        return repository.save(jenisBarang);
    }

    public JenisBarang update(Integer id, JenisBarang jenisBarang) {
        JenisBarang existingJenisBarang = findById(id);
        existingJenisBarang.setNamaJenis(jenisBarang.getNamaJenis());
        return repository.save(existingJenisBarang);
    }

    public void delete(Integer id) {
        JenisBarang existingJenisBarang = findById(id);
        repository.delete(existingJenisBarang);
    }
}