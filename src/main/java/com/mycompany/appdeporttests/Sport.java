package com.mycompany.appdeporttests;

/**
 *
 * @author SENA
 */
public class Sport {
    private int sportCode;
    private String name;

    public Sport() {
    }

    public Sport(int sportCode, String name) {
        this.sportCode = sportCode;
        this.name = name;
    }

    public int getSportCode() {
        return sportCode;
    }

    public void setSportCode(int sportCode) {
        this.sportCode = sportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
