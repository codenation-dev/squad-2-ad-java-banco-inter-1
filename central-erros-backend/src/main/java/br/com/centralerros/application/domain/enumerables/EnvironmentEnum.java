package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum EnvironmentEnum {
    EMPTY(0),
    DEVELOPMENT(1),
    TESTING(2),
    ACCEPTANCE(3),
    PRODUCTION(4),
    ALL(5); //para users

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (EnvironmentEnum environmentEnum : EnvironmentEnum.values()) {
            map.put(environmentEnum.value, environmentEnum);
        }
    }

    public static EnvironmentEnum valueOf(int environmentEnum) {
        return (EnvironmentEnum)map.get(environmentEnum);
    }

    EnvironmentEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
