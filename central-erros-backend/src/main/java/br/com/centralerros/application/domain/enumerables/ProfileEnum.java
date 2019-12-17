package br.com.centralerros.application.domain.enumerables;

import java.util.HashMap;
import java.util.Map;

public enum ProfileEnum {
    ADMINISTRATOR(1),
    SUPPORT(2);

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (ProfileEnum profileEnum : ProfileEnum.values()) {
            map.put(profileEnum.value, profileEnum);
        }
    }

    public static ProfileEnum valueOf(int profileEnum) {
        return (ProfileEnum) map.get(profileEnum);
    }

    ProfileEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
