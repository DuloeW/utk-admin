package org.perpus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "history_peminjam")
public class HistoryPeminjamEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @NotNull
    @Column(name = "id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peminjam_id")
    @NotNull
    public PeminjamBukuEntity pemijamId;

    public static Optional<HistoryPeminjamEntity> findHistoryPeminjamById(Long id) {
        return find("id =? 1", id).firstResultOptional();
    }

    public static List<HistoryPeminjamEntity> findAllHistoryPeminjam() {
        return HistoryPeminjamEntity.listAll();
    }
}
