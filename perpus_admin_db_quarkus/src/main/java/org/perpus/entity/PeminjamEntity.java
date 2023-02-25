package org.perpus.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "peminjam")
public class PeminjamEntity extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @Column(name = "id")
    public Long id;

    @Column(name = "nama_lengkap")
    @NotNull
    public String namaLengkap;

    @CreationTimestamp
    @Column(name = "tanggal_minjam")
    @NotNull
    public LocalDate tanggalMinjam;

    @Column(name = "tanggal_kembali")
    @NotNull
    public LocalDate tanggalKembali;

    @Column(name = "jumlah_buku", columnDefinition = "smallint")
    @NotNull
    public Integer jumlahBuku;

    public static Optional<PeminjamEntity> findPeminjamById(Long id) {
        return find("id =? 1", id).firstResultOptional();
    }

    public static Optional<PeminjamEntity> findPeminjamByName(String name) {
        String nameLowerCase = name.toLowerCase();
        return find("nama_lengkap", nameLowerCase).firstResultOptional();
    }

    public static List<PeminjamEntity> findAllPeminjam() {
        return PeminjamEntity.listAll();
    }
}
