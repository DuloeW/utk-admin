package org.perpus.model.body;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.perpus.core.util.jackson.TimeDeserialize;
import org.perpus.entity.PeminjamEntity;

public record PeminjamBody(
  String namaLengkap,
    @JsonDeserialize(converter = TimeDeserialize.class) 
  LocalDate tanggal_minjam,
  LocalDate tanggal_kembali,
  Integer jumlahBuku
) {
  public PeminjamEntity mapToPeminjamEntity() {
    var peminjam = new PeminjamEntity();
    peminjam.namaLengkap = namaLengkap;
    peminjam.tanggalMinjam = LocalDate.now();
    peminjam.tanggalKembali = peminjam.tanggalMinjam.plus(1, ChronoUnit.WEEKS);
    peminjam.jumlahBuku = jumlahBuku;
    return peminjam;
  }
}
