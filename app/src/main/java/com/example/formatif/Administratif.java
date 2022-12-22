package com.example.formatif;

public class Administratif {

    private int id;
    private String nom;
    private String prenom;
    private String bureau;
    private String poste;
    private String description;
    private String email;

    public Administratif(int id, String nom, String prenom, String bureau, String poste, String description, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.bureau = bureau;
        this.poste = poste;
        this.description = description;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
