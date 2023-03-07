package org.perpus.model.body;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.perpus.core.util.jackson.TimeDeserialize;
import org.perpus.entity.PeminjamBukuEntity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record PeminjamBukuBody(
        Long siswa,
        @JsonDeserialize(converter = TimeDeserialize.class)
        LocalDate tanggalMinjam,
        LocalDate taggalKembali,
        Integer jumlahBuku
) {

    public PeminjamBukuEntity mapToPeminjamBukuEntity() {
        var peminjam = new PeminjamBukuEntity();
        peminjam.tanggalMinjam = LocalDate.now();
        peminjam.tanggalKembali = peminjam.tanggalMinjam.plus(1, ChronoUnit.WEEKS);
        peminjam.jumlahBuku = jumlahBuku;
        return peminjam;
    }
}
