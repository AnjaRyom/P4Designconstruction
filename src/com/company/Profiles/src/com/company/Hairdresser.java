package com.company;

public class Hairdresser extends Employee {

    private String preferences;

    public Hairdresser(String preferences) {
        this.preferences = preferences;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}

