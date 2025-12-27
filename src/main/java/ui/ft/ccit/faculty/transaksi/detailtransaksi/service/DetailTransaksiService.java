package ui.ft.ccit.faculty.transaksi.detailtransaksi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksiId;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.repository.DetailTransaksiRepository;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.repository.TransaksiRepository;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.model.BarangRepository;

@Service
@Transactional
public class DetailTransaksiService {

    private final DetailTransaksiRepository repository;
    private final TransaksiRepository transaksiRepository;
    private final BarangRepository barangRepository;

    public DetailTransaksiService(
            DetailTransaksiRepository repository,
            TransaksiRepository transaksiRepository,
            BarangRepository barangRepository) {

        this.repository = repository;
        this.transaksiRepository = transaksiRepository;
        this.barangRepository = barangRepository;
    }

    // ================= CREATE =================
    public DetailTransaksi create(
            String kodeTransaksi,
            String idBarang,
            Integer jumlah) {

        Transaksi transaksi = transaksiRepository.findById(kodeTransaksi)
                .orElseThrow(() ->
                        new DataNotFoundException("Transaksi", kodeTransaksi));

        Barang barang = barangRepository.findById(idBarang)
                .orElseThrow(() ->
                        new DataNotFoundException("Barang", idBarang));

        if (barang.getStok() < jumlah) {
            throw new IllegalArgumentException("Stok barang tidak mencukupi");
        }

        DetailTransaksiId id = new DetailTransaksiId(kodeTransaksi, idBarang);

        if (repository.existsById(id)) {
            throw new IllegalStateException("Barang sudah ada di transaksi ini");
        }

        // kurangi stok
        short stokBaru = (short) (barang.getStok() - jumlah);
        barang.setStok(stokBaru);
        barangRepository.save(barang);

        DetailTransaksi detail = new DetailTransaksi();
        detail.setId(id);
        detail.setTransaksi(transaksi);
        detail.setBarang(barang);
        detail.setJumlah(jumlah);

        return repository.save(detail);
    }

    // ================= READ =================
    public List<DetailTransaksi> findAll() {
        return repository.findAll();
    }

    public List<DetailTransaksi> findByKodeTransaksi(String kode) {
        return repository.findById_KodeTransaksi(kode);
    }

    // ================= UPDATE =================
    public DetailTransaksi update(
            String kodeTransaksi,
            String idBarang,
            Integer jumlahBaru) {

        DetailTransaksiId id =
                new DetailTransaksiId(kodeTransaksi, idBarang);

        DetailTransaksi detail = repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "DetailTransaksi",
                                kodeTransaksi + "-" + idBarang));

        Barang barang = detail.getBarang();
        int selisih = jumlahBaru - detail.getJumlah();

        if (barang.getStok() < selisih) {
            throw new IllegalArgumentException("Stok barang tidak mencukupi");
        }

        // update stok
        short stokBaru = (short) (barang.getStok() - selisih);
        barang.setStok(stokBaru);
        barangRepository.save(barang);

        detail.setJumlah(jumlahBaru);
        return repository.save(detail);
    }

    // ================= DELETE =================
    public void delete(String kodeTransaksi, String idBarang) {

        DetailTransaksiId id =
                new DetailTransaksiId(kodeTransaksi, idBarang);

        DetailTransaksi detail = repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "DetailTransaksi",
                                kodeTransaksi + "-" + idBarang));

        // kembalikan stok
        Barang barang = detail.getBarang();
        short stokBaru = (short) (barang.getStok() + detail.getJumlah());
        barang.setStok(stokBaru);
        barangRepository.save(barang);

        repository.delete(detail);
    }
}
