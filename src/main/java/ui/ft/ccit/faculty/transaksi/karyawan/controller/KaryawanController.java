package ui.ft.ccit.faculty.transaksi.karyawan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.karyawan.service.KaryawanService;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService service;

    public KaryawanController(KaryawanService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return service.create(karyawan);
    }

    // GET ALL
    @GetMapping
    public List<Karyawan> findAll() {
        return service.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Karyawan findById(@PathVariable String id) {
        return service.findById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Karyawan update(
            @PathVariable String id,
            @RequestBody Karyawan karyawan) {

        return service.update(id, karyawan);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
