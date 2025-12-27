# Aplikasi Transaksi Penjualan (Spring Boot)

Project ini merupakan aplikasi REST API Transaksi menggunakan **Spring Boot** sebagai bagian dari pembelajaran REST API CEP-CCIT FTUI. Dengan relasi antar tabel, manajemen stok otomatis, keamanan token, Swagger, dan GitHub Actions.

---

## Fitur Utama
- CRUD lengkap (POST, GET, PUT, DELETE) untuk semua tabel
- Relasi database (Transaksi ↔ Detail ↔ Barang)
- Stok otomatis:
  - Berkurang saat detail transaksi ditambah
  - Kembali saat detail / transaksi dihapus
- Validasi bisnis (stok tidak boleh minus, barang tidak boleh duplicate)
- Security menggunakan JWT Token
- Dokumentasis API menggunakan Swagger
- CI otomatis menggunakan GitHub Actions

---

## Teknologi
- Java 25  
- Spring Boot 4  
- Spring Data JPA  
- MySQL  
- Swagger (springdoc-openapi)  
- GitHub Actions  

---

## Swagger
http://localhost:8080/swagger-ui/index.html

---

## Token (Demo)
Gunakan token berikut untuk testing di Swagger:
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkb3NlbiIsIm5hbWUiOiJST0xFX1VTRVIifQ.edbUQbRjQ632M63OM3kJnPVTIT1bYExYxKei4oIJ5F8