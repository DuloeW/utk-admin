package org.perpus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.perpus.entity.enums.JurusanEnum;
import org.perpus.entity.enums.KelasEnum;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "siswa")
public class SiswaEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @Column(name = "id")
    public Long id;

    @Column(name = "nama_siswa")
    @NotNull
    public String nama;

    @Column(name = "nisn")
    @NotNull
    public String nisn;

    @Column(name = "kelas", columnDefinition = "smallint")
    @NotNull
    public KelasEnum kelas;

    @Column(name = "jurusan", columnDefinition = "smallint")
    @NotNull
    public JurusanEnum jurusan;

    public static Optional<SiswaEntity> findSiswaById(Long id) {
        return find("id =? 1", id).firstResultOptional();
    }

    public static List<SiswaEntity> findAllSiswa() {
        return SiswaEntity.listAll();
    }
}
