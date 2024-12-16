/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.toko_perlengkapan_olahraga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produk {
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tampilkanDetail() {
        System.out.println("Nama Produk: " + nama);
        System.out.println("Harga: Rp " + harga);
        System.out.println("Stok: " + stok);
    }
}

class KeranjangBelanja {
    private List<Produk> produkList;

    // Constructor
    public KeranjangBelanja() {
        produkList = new ArrayList<>();
    }

    // Menambahkan produk ke keranjang
    public void tambahProduk(Produk produk) {
        produkList.add(produk);
    }

    // Menghitung total harga
    public double hitungTotal() {
        double total = 0;
        for (Produk produk : produkList) {
            total += produk.getHarga();
        }
        return total;
    }

    // Menampilkan produk dalam keranjang
    public void tampilkanKeranjang() {
        System.out.println("Produk dalam Keranjang:");
        for (Produk produk : produkList) {
            System.out.println("- " + produk.getNama() + " | Harga: Rp " + produk.getHarga());
        }
        System.out.println("Total Belanja: Rp " + hitungTotal());
    }
}

public class Toko_Perlengkapan_Olahraga {
    private static List<Produk> daftarProduk = new ArrayList<>();

    // Menambahkan produk ke toko
    public static void tambahProdukKeToko(String nama, double harga, int stok) {
        Produk produk = new Produk(nama, harga, stok);
        daftarProduk.add(produk);
    }

    // Menampilkan daftar produk
    public static void tampilkanDaftarProduk() {
        System.out.println("Daftar Produk di Toko:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk produk = daftarProduk.get(i);
            System.out.println((i + 1) + ". " + produk.getNama() + " | Harga: Rp " + produk.getHarga() + " | Stok: " + produk.getStok());
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeranjangBelanja keranjang = new KeranjangBelanja();
        // Menambahkan produk ke toko
        tambahProdukKeToko("Sepatu Running", 500000, 10);
        tambahProdukKeToko("Bola Sepak", 150000, 15);
        tambahProdukKeToko("Raket Badminton", 200000, 8);
        tambahProdukKeToko("Jersey Bola", 250000, 5);
        // Menampilkan menu utama
        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("\n=== Toko Perlengkapan Olahraga ===");
            System.out.println("1. Lihat Daftar Produk");
            System.out.println("2. Tambah Produk ke Keranjang");
            System.out.println("3. Lihat Keranjang Belanja");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    tampilkanDaftarProduk();
                    break;
                case 2:
                    System.out.print("Masukkan nomor produk yang ingin ditambahkan ke keranjang: ");
                    int nomorProduk = scanner.nextInt();
                    if (nomorProduk > 0 && nomorProduk <= daftarProduk.size()) {
                        Produk produkDipilih = daftarProduk.get(nomorProduk - 1);
                        keranjang.tambahProduk(produkDipilih);
                        System.out.println(produkDipilih.getNama() + " telah ditambahkan ke keranjang.");
                    } else {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 3:
                    keranjang.tampilkanKeranjang();
                    break;
                case 4:
                    System.out.println("Terima kasih telah berbelanja!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}
