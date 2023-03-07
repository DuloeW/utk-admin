package org.perpus.service;

import org.perpus.entity.HistoryPeminjamEntity;
import org.perpus.entity.PeminjamBukuEntity;
import org.perpus.exception.response.MessageResponse;
import org.perpus.model.body.HistoryPeminjanBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class HistoryPeminjamService {

    public HistoryPeminjamEntity getHistoryPeminjamById(Long id) {
        return HistoryPeminjamEntity.findHistoryPeminjamById(id)
                .orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<HistoryPeminjamEntity>  getAllHistoryPeminjam() {
        return HistoryPeminjamEntity.findAllHistoryPeminjam()
                .stream()
                .collect(Collectors.toList());
    }

    private PeminjamBukuEntity fetchPeminjamBukuById(Long id) {
        return PeminjamBukuEntity.findPemijamBukuById(id)
                .orElseThrow(() -> MessageResponse.fetchMessageException(id, "peminjamId"));
    }

    public HistoryPeminjamEntity createRelasi(HistoryPeminjanBody body, PeminjamBukuEntity peminjamBuku) {
        var history = body.mapToHistoryPeminjamEntity();
        history.pemijamId = peminjamBuku;
        history.persist();
        return history;
    }

    public HistoryPeminjamEntity createHistoryPeminjam(HistoryPeminjanBody body) {
        Objects.requireNonNull(body);
        var peminjam = fetchPeminjamBukuById(body.peminjamId());
        return createRelasi(body, peminjam);
    }
}
