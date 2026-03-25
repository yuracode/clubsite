package com.example.clubsite.model;

public enum Category {
    PRACTICE("練習"),
    TOURNAMENT("大会"),
    HOLIDAY("休み"),
    OTHER("雑談");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
