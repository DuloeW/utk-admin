package org.perpus.model.body;

import org.perpus.entity.SiswaEntity;
import org.perpus.entity.enums.JurusanEnum;
import org.perpus.entity.enums.KelasEnum;

public record SiswaBody(
        String nama,
        String nisn,
        Integer kelas,
        Integer jurusan
) {

    public SiswaEntity mapToSiswaEntity() {
        var siswa = new SiswaEntity();
        siswa.nama = nama;
        siswa.nisn = nisn;
        siswa.kelas = KelasEnum.getKelasEnum(kelas);
        siswa.jurusan = JurusanEnum.getJurusanEnum(jurusan);
        return siswa;
    }
}
