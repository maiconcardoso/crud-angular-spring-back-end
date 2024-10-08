package com.maicon.crud_spring.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Category {

    @JsonProperty("back-end")
    BACK_END("back-end"),
    @JsonProperty("front-end")
    FRONT_END("front-end");

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
