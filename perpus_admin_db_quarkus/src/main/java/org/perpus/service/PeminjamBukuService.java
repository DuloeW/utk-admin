package org.perpus.service;

import org.perpus.entity.PeminjamBukuEntity;
import org.perpus.entity.SiswaEntity;
import org.perpus.exception.response.MessageResponse;
import org.perpus.model.body.PeminjamBukuBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class PeminjamBukuService {

    public PeminjamBukuEntity getPeminjamBukuById(Long id) {
        return PeminjamBukuEntity.findPemijamBukuById(id)
                .orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<PeminjamBukuEntity> getAllPeminjamBuku() {
        return PeminjamBukuEntity.findAllPeminjamBuku()
                .stream()
                .collect(Collectors.toList());
    }

    private SiswaEntity fetchSiswaEntityById(Long id) {
        return SiswaEntity.findSiswaById(id)
                .orElseThrow(() -> MessageResponse.fetchMessageException(id, "siswa"));
    }

    public PeminjamBukuEntity createRelasi(PeminjamBukuBody body, SiswaEntity siswa) {
        var peminjam = body.mapToPeminjamBukuEntity();
        peminjam.siswa = siswa;
        peminjam.persist();
        return peminjam;
    }

    public PeminjamBukuEntity createPeminjamBuku(PeminjamBukuBody body) {
        Objects.requireNonNull(body);
        var siswa = fetchSiswaEntityById(body.siswa());
        return createRelasi(body, siswa);
    }
}
