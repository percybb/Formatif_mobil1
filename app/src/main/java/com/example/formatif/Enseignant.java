package com.example.formatif;

public class Enseignant {
    private int id;
    private String nom;
    private String prenom;
    private String bureau;
    private String departement;
    private String status;
    private String email;

    public Enseignant(int id, String nom, String prenom, String bureau, String departement, String status, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.bureau = bureau;
        this.departement = departement;
        this.status = status;
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

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
