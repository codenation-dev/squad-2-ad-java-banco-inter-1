package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum LevelEnum {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    FATAL(5);

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (LevelEnum levelEnum : LevelEnum.values()) {
            map.put(levelEnum.value, levelEnum);
        }
    }

    public static LevelEnum valueOf(int levelEnum) {
        return (LevelEnum) map.get(levelEnum);
    }

    LevelEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
