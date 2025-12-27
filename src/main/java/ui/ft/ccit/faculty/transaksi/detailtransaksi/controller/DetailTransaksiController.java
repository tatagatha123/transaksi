package ui.ft.ccit.faculty.transaksi.detailtransaksi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.service.DetailTransaksiService;

@RestController
@RequestMapping("/api/detail-transaksi")
public class DetailTransaksiController {

    private final DetailTransaksiService service;

    public DetailTransaksiController(DetailTransaksiService service) {
        this.service = service;
    }

    // ================= CREATE =================
    @PostMapping
    public DetailTransaksi create(
            @RequestParam String kodeTransaksi,
            @RequestParam String idBarang,
            @RequestParam Integer jumlah) {

        return service.create(kodeTransaksi, idBarang, jumlah);
    }

    // ================= READ =================
    @GetMapping
    public List<DetailTransaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/transaksi/{kode}")
    public List<DetailTransaksi> findByTransaksi(
            @PathVariable String kode) {

        return service.findByKodeTransaksi(kode);
    }

    // ================= UPDATE =================
    @PutMapping
    public DetailTransaksi update(
            @RequestParam String kodeTransaksi,
            @RequestParam String idBarang,
            @RequestParam Integer jumlah) {

        return service.update(kodeTransaksi, idBarang, jumlah);
    }

    // ================= DELETE =================
    @DeleteMapping
    public void delete(
            @RequestParam String kodeTransaksi,
            @RequestParam String idBarang) {

        service.delete(kodeTransaksi, idBarang);
    }
}
