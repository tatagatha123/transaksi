package ui.ft.ccit.faculty.transaksi.jenisbarang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisbarang.service.JenisBarangService;

import java.util.List;

@Tag(name = "Jenis Barang", description = "CRUD Jenis Barang")
@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {

    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    @Operation(summary = "Ambil semua jenis barang")
    @GetMapping
    public List<JenisBarang> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Ambil jenis barang berdasarkan ID")
    @GetMapping("/{id}")
    public JenisBarang findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Operation(summary = "Tambah jenis barang (butuh token)")
    @PostMapping
    public JenisBarang create(@RequestBody JenisBarang body) {
        return service.save(body);
    }

    @Operation(summary = "Update jenis barang (butuh token)")
    @PutMapping("/{id}")
    public JenisBarang update(@PathVariable Integer id,
                              @RequestBody JenisBarang body) {
        return service.update(id, body);
    }

    @Operation(summary = "Hapus jenis barang (butuh token)")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
