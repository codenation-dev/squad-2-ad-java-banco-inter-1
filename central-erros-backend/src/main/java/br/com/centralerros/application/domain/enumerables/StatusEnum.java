package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    OPEN(1),
    VERIFYING(2),
    CLOSED(3);

    private final int value;
    private static Map map = new HashMap<>();


    static {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            map.put(statusEnum.value, statusEnum);
        }
    }

    public static StatusEnum valueOf(int statusEnum) {
        return (StatusEnum)map.get(statusEnum);
    }

    StatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}