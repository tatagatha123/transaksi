package ui.ft.ccit.faculty.transaksi.transaksi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.repository.TransaksiRepository;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.repository.DetailTransaksiRepository;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.model.BarangRepository;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.pelanggan.repository.PelangganRepository;
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.karyawan.repository.KaryawanRepository;

@Service
@Transactional
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;
    private final PelangganRepository pelangganRepository;
    private final KaryawanRepository karyawanRepository;
    private final DetailTransaksiRepository detailTransaksiRepository;
    private final BarangRepository barangRepository;

    public TransaksiService(
            TransaksiRepository transaksiRepository,
            PelangganRepository pelangganRepository,
            KaryawanRepository karyawanRepository,
            DetailTransaksiRepository detailTransaksiRepository,
            BarangRepository barangRepository) {

        this.transaksiRepository = transaksiRepository;
        this.pelangganRepository = pelangganRepository;
        this.karyawanRepository = karyawanRepository;
        this.detailTransaksiRepository = detailTransaksiRepository;
        this.barangRepository = barangRepository;
    }

    // ================= CREATE =================
    public Transaksi create(String kode, String idPelanggan, String idKaryawan) {

        Pelanggan pelanggan = pelangganRepository.findById(idPelanggan)
                .orElseThrow(() ->
                        new DataNotFoundException("Pelanggan", idPelanggan));

        Karyawan karyawan = karyawanRepository.findById(idKaryawan)
                .orElseThrow(() ->
                        new DataNotFoundException("Karyawan", idKaryawan));

        Transaksi t = new Transaksi();
        t.setKodeTransaksi(kode);
        t.setTglTransaksi(LocalDateTime.now());
        t.setPelanggan(pelanggan);
        t.setKaryawan(karyawan);

        return transaksiRepository.save(t);
    }

    // ================= READ =================
    public List<Transaksi> findAll() {
        return transaksiRepository.findAll();
    }

    public Transaksi findById(String kode) {
        return transaksiRepository.findById(kode)
                .orElseThrow(() ->
                        new DataNotFoundException("Transaksi", kode));
    }

    // ================= UPDATE =================
    public Transaksi update(String kode, String idPelanggan, String idKaryawan) {

        Transaksi t = findById(kode);

        Pelanggan pelanggan = pelangganRepository.findById(idPelanggan)
                .orElseThrow(() ->
                        new DataNotFoundException("Pelanggan", idPelanggan));

        Karyawan karyawan = karyawanRepository.findById(idKaryawan)
                .orElseThrow(() ->
                        new DataNotFoundException("Karyawan", idKaryawan));

        t.setPelanggan(pelanggan);
        t.setKaryawan(karyawan);

        return transaksiRepository.save(t);
    }

    // ================= DELETE (STOK KEMBALI) =================
    public void delete(String kode) {

        Transaksi transaksi = findById(kode);

        // 1. Ambil semua detail transaksi
        List<DetailTransaksi> details =
                detailTransaksiRepository.findById_KodeTransaksi(kode);

        // 2. Kembalikan stok barang
        for (DetailTransaksi detail : details) {
            Barang barang = detail.getBarang();
            short stokBaru = (short) (barang.getStok() + detail.getJumlah());
            barang.setStok(stokBaru);
            barangRepository.save(barang);
        }

        // 3. Hapus detail transaksi
        detailTransaksiRepository.deleteAll(details);

        // 4. Hapus transaksi
        transaksiRepository.delete(transaksi);
    }
}
