package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
    EMPTY(0),
    ADMINISTRATOR(1),
    APPLICATION(2),
    DEVELOPER(3);

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            map.put(roleEnum.value, roleEnum);
        }
    }

    public static RoleEnum valueOf(int roleEnum) {
        return (RoleEnum)map.get(roleEnum);
    }

    RoleEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
