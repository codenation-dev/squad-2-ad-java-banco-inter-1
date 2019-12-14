package br.com.centralerros.application.domain.enumerables;

public enum LevelEnum {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    FATAL(5);

    private final int value;

    LevelEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
