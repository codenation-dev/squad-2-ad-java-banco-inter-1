package br.com.centralerros.application.domain.enumerables;

public enum StatusEnum {
        OPEN(1),
        VERIFYING(2),
        CLOSED(3);

        private final int value;

        StatusEnum(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }