package org.perpus.entity.enums;

import lombok.Getter;

public enum KelasEnum {
    X(0),
    XI(1),
    XII(2),
    NOT_A_CLASS(-1);

    @Getter
    private final Integer code;


    public static KelasEnum getKelasEnum(Integer code) {
        return switch (code) {
            case 0 -> KelasEnum.X;
            case 1 -> KelasEnum.XI;
            case 2 -> KelasEnum.XII;
            default -> KelasEnum.NOT_A_CLASS;
        };
    }

    KelasEnum(Integer code) {
        this.code = code;
    }
}
