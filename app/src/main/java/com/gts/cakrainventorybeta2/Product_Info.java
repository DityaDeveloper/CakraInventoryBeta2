package com.gts.cakrainventorybeta2;

public class Product_Info {

    private String nik;
    private String name;
    private String jeniskelamin;
    private String status;
    private String jabatan;
    private String usia;

    public Product_Info() {
    }

    public Product_Info(String nik, String name, String status,String jabatan, String usia, String jeniskelamin) {
        this.nik = nik;
        this.name = name;
        this.jeniskelamin = jeniskelamin;
        this.status = status;
        this.usia = usia;
        this.jabatan = jabatan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJenisKelamin() {
        return jeniskelamin;
    }

    public void setJenisKelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

}