package br.com.centralerros.application.domain.enumerables;

public enum CategoryEnum {
    APPLICATION(1),
    BUSINESS(2);

    private final int value;

    CategoryEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
