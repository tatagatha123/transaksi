package ui.ft.ccit.faculty.transaksi.pelanggan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return service.create(pelanggan);
    }

    // GET ALL
    @GetMapping
    public List<Pelanggan> findAll() {
        return service.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Pelanggan findById(@PathVariable String id) {
        return service.findById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Pelanggan update(
            @PathVariable String id,
            @RequestBody Pelanggan pelanggan) {

        return service.update(id, pelanggan);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
