package ui.ft.ccit.faculty.transaksi.transaksi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.service.TransaksiService;
import java.util.List;


@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService service) {
        this.service = service;
    }

    @PostMapping
    public Transaksi create(
            @RequestParam String kode,
            @RequestParam String idPelanggan,
            @RequestParam String idKaryawan) {

        return service.create(kode, idPelanggan, idKaryawan);
    }

    @GetMapping
    public List<Transaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/{kode}")
    public Transaksi findById(@PathVariable String kode) {
        return service.findById(kode);
    }

    @DeleteMapping("/{kode}")
    public void delete(@PathVariable String kode) {
        service.delete(kode);
    }

    @PutMapping("/{kode}")
    public Transaksi update(
        @PathVariable String kode,
        @RequestParam String idPelanggan,
        @RequestParam String idKaryawan) {

    return service.update(kode, idPelanggan, idKaryawan);
}

}

