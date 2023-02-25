package org.perpus.entity.enums;

import lombok.Getter;

public enum KategoriEnum {
    HIBURAN(0),
    BERITA(1),
    PENDIDIKAN(2);

    @Getter
    private final Integer code;

    public static KategoriEnum getKategoriEnum(Integer code) {
        switch(code) {
            case 0: 
                return KategoriEnum.HIBURAN;
            case 1: 
                return KategoriEnum.BERITA;
            case 2:
                return KategoriEnum.PENDIDIKAN;
            default:
                return KategoriEnum.PENDIDIKAN;
        }
    }

    KategoriEnum(Integer code) {
        this.code = code;
    }
}
