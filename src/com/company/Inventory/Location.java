package com.company;

/**
 * The location class represents a physical location in the inventory.
 * I will (maybe) add more info later.
 */
public class Location {
    private String description;

    public Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
