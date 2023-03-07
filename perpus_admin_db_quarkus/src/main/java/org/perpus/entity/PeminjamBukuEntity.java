package org.perpus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "peminjam_buku")
public class PeminjamBukuEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @NotNull
    @Column(name = "id")
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "siswa")
    @NotNull
    public SiswaEntity siswa;

    @CreationTimestamp
    @Column(name = "tgl_minjam")
    @NotNull
    public LocalDate tanggalMinjam;

    @Column(name = "tgl_kembali")
    @NotNull
    public LocalDate tanggalKembali;

    @Column(name = "jumlah_buku")
    @NotNull
    public Integer jumlahBuku;

    public static Optional<PeminjamBukuEntity> findPemijamBukuById(Long id) {
        return find("id =? 1", id).firstResultOptional();
    }

    public static List<PeminjamBukuEntity> findAllPeminjamBuku() {
        return PeminjamBukuEntity.listAll();
    }
}
