package ui.ft.ccit.faculty.transaksi.transaksipembelian.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.transaksipembelian.model.TransaksiPembelian;
import ui.ft.ccit.faculty.transaksi.transaksipembelian.service.TransaksiPembelianService;

@RestController
@RequestMapping("/api/transaksi-pembelian")
public class TransaksiPembelianController {

    private final TransaksiPembelianService service;

    public TransaksiPembelianController(TransaksiPembelianService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public TransaksiPembelian create(
            @RequestParam String idTransaksi,
            @RequestParam String idPemasok) {

        return service.create(idTransaksi, idPemasok);
    }

    // GET ALL
    @GetMapping
    public List<TransaksiPembelian> findAll() {
        return service.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TransaksiPembelian findById(@PathVariable String id) {
        return service.findById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public TransaksiPembelian update(
            @PathVariable String id,
            @RequestParam String idPemasok) {

        return service.update(id, idPemasok);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
