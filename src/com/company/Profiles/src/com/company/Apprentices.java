package com.company;

public class Apprentices extends Employee {

    private boolean scholarship;

    public Apprentices(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }
}
