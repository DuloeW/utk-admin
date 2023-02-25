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
import org.perpus.entity.enums.KategoriEnum;

import static org.perpus.core.util.ManipulateUtil.changeItOrNot;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "buku")
public class BukuEntity extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @Column(name = "id")
    @NotNull
    public Long id;

    @Column(name = "judul_buku")
    @NotNull
    public String judulBuku;

    @Column(name = "kode_buku", columnDefinition = "char")
    @NotNull
    public String kodeBuku;

    @Column(name = "kategori", columnDefinition = "smallint")
    @NotNull
    public KategoriEnum kategori;

    @CreationTimestamp
    @Column(name = "tahun_rilis")
    @NotNull
    public LocalDate tahunRilis;

    @Column(name = "deskripsi", columnDefinition = "text")
    @NotNull
    public String deskripsi;

    public static Optional<BukuEntity> findBukuById(Long id) {
        return find("id =? 1", id).firstResultOptional();
    }

    public static Optional<BukuEntity> findBukuByTitle(String judul) {
        String judulLowerCase = judul.toLowerCase();
        return find("judul_buku", judulLowerCase).firstResultOptional();
    }

    public static List<BukuEntity> findAllBuku() {
        return BukuEntity.listAll();
    }

    public BukuEntity updateBuku(BukuEntity buku) {
        buku.judulBuku = changeItOrNot(judulBuku, buku.judulBuku);
        buku.kodeBuku = changeItOrNot(kodeBuku, buku.kodeBuku);
        buku.kategori = changeItOrNot(kategori, buku.kategori);
        buku.tahunRilis = changeItOrNot(tahunRilis, buku.tahunRilis);
        buku.deskripsi = changeItOrNot(deskripsi, buku.deskripsi);
        return buku;
    }
}
