package org.perpus.model.body;

import java.time.LocalDate;

import org.perpus.core.util.jackson.TimeDeserialize;
import org.perpus.entity.BukuEntity;
import org.perpus.entity.enums.KategoriEnum;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record BukuBody(
    String judulBuku,
    String kodeBuku,
    Integer kategori,
        @JsonDeserialize(converter = TimeDeserialize.class)
    LocalDate tahunRilis,
    String deskripsi
) {

    public BukuEntity mapToBukuEntity() {
        var buku = new BukuEntity();
        buku.judulBuku = judulBuku;
        buku.kodeBuku = kodeBuku;
        buku.kategori = KategoriEnum.getKategoriEnum(kategori);
        buku.tahunRilis = tahunRilis;
        buku.deskripsi = deskripsi;
        return buku;
    }
    
}
