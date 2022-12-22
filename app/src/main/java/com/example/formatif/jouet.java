package com.example.formatif;

import java.io.Serializable;

public class jouet implements Serializable {

    private String marque;
    private String modele;
    private int age;
    private String Description;
    private Double prix;

    public jouet(String marque, String modele, int age, String description, Double prix) {
        this.marque = marque;
        this.modele = modele;
        this.age = age;
        Description = description;
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
