package org.perpus.entity.enums;

import lombok.Getter;

public enum JurusanEnum {
    RPL(0),
    AKUTANSI(1),
    TATA_BOGA(2),
    TABLE_MANAGER(3),
    DKV(4),
    KULINER(5),
    NOT_A_JURUSAN(-1);

    @Getter
    private final Integer code;

    public static JurusanEnum getJurusanEnum(Integer code) {
        return switch (code) {
            case 0 -> JurusanEnum.RPL;
            case 1 -> JurusanEnum.AKUTANSI;
            case 2 -> JurusanEnum.TATA_BOGA;
            case 3 -> JurusanEnum.TABLE_MANAGER;
            case 4 -> JurusanEnum.DKV;
            case 5 -> JurusanEnum.KULINER;
            default -> JurusanEnum.NOT_A_JURUSAN;
        };
    }

    JurusanEnum(Integer code) {
        this.code = code;
    }
}
