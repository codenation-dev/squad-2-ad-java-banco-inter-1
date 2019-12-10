package br.com.centralerros.application.domain.enumerables;

public enum RoleEnum {
    ADMINISTRATOR(1),
    APPLICATION(2),
    DEVELOPER(3);

    private final int value;

    RoleEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
