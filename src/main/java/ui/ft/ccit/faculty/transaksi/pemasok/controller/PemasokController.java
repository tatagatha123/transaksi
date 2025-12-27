package ui.ft.ccit.faculty.transaksi.pemasok.controller;
import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.service.PemasokService;

import java.util.List;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService service;

    public PemasokController(PemasokService service) {
        this.service = service;
    }

    @PostMapping
    public Pemasok create(@RequestBody Pemasok p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Pemasok update(
            @PathVariable String id,
            @RequestBody Pemasok p) {

        p.setIdPemasok(id);
        return service.save(p);
    }

    @GetMapping
    public List<Pemasok> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pemasok findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

