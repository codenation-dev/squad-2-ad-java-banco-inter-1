package br.com.centralerros.application.domain.enumerables;

public enum EnvironmentEnum {
    DEVELOPMENT(1),
    TESTING(2),
    ACCEPTANCE(3),
    PRODUCTION(4);

    private final int value;

    EnvironmentEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
