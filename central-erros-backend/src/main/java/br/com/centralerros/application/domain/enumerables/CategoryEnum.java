package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
    EMPTY(0),
    APPLICATION(1),
    BUSINESS(2);

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            map.put(categoryEnum.value, categoryEnum);
        }
    }

    public static CategoryEnum valueOf(int categoryEnum) {
        return (CategoryEnum)map.get(categoryEnum);
    }

    CategoryEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
