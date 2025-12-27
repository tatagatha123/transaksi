# Aplikasi Transaksi Penjualan (Spring Boot)

REST API transaksi penjualan menggunakan **Spring Boot** dan **MySQL** dengan relasi antar tabel, manajemen stok otomatis, keamanan token, Swagger, dan GitHub Actions.

---

## Fitur Utama
- CRUD lengkap (POST, GET, PUT, DELETE) untuk semua tabel
- Relasi database (Transaksi ↔ Detail ↔ Barang)
- Stok otomatis:
  - Berkurang saat detail transaksi ditambah
  - Kembali saat detail / transaksi dihapus
- Validasi bisnis (stok tidak boleh minus, barang tidak boleh duplicate)
- JWT Token
- Swagger UI
- GitHub Actions (CI)

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
# Aplikasi Transaksi Penjualan (Spring Boot)

REST API transaksi penjualan menggunakan **Spring Boot** dan **MySQL** dengan relasi antar tabel, manajemen stok otomatis, keamanan token, Swagger, dan GitHub Actions.

---

## Fitur Utama
- CRUD lengkap (POST, GET, PUT, DELETE) untuk semua tabel
- Relasi database (Transaksi ↔ Detail ↔ Barang)
- Stok otomatis:
  - Berkurang saat detail transaksi ditambah
  - Kembali saat detail / transaksi dihapus
- Validasi bisnis (stok tidak boleh minus, barang tidak boleh duplicate)
- JWT Token
- Swagger UI
- GitHub Actions (CI)

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

---

## GitHub Actions
CI berjalan otomatis saat **push / pull request ke branch `main`** dengan perintah: ./mvnw clean verify
