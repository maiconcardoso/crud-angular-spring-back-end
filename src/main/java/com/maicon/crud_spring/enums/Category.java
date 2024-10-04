package com.maicon.crud_spring.enums;

public enum Category {

    BACK_END("back_end"),
    FRONT_END("front_end");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
