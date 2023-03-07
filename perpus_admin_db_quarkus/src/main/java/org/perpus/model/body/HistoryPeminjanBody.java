package org.perpus.model.body;

import org.perpus.entity.HistoryPeminjamEntity;

public record HistoryPeminjanBody(
        Long peminjamId
) {

    public HistoryPeminjamEntity mapToHistoryPeminjamEntity() {
        return new HistoryPeminjamEntity();
    }
}
