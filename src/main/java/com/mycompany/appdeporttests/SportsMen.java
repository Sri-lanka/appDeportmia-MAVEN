package com.mycompany.appdeporttests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SENA
 */
public class SportsMen {
    private int sportmanCode;
    private int identification; 
    private String fullNames;
    private String address; 
    private int phoneNumber;
    private int sportCode;
    private int gender;
    private String birthDate;

    public SportsMen() {
    }

    public SportsMen(int sportmanCode, int identification, String fullNames, String address, int phoneNumber, int sportCode, int gender, String birthDate) {
        this.sportmanCode = sportmanCode;
        this.identification = identification;
        this.fullNames = fullNames;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sportCode = sportCode;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public int getSportmanCode() {
        return sportmanCode;
    }

    public void setSportmanCode(int sportmanCode) {
        this.sportmanCode = sportmanCode;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSportCode() {
        return sportCode;
    }

    public void setSportCode(int sportCode) {
        this.sportCode = sportCode;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    
}
