package org.lessons.java.spring_la_mia_pizzeria_webapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

// entità che rappresenta una pizza/
@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id auto-generato

    @NotBlank(message = "il campo nome non può essere vuoto")
    private String nome; // nome pizza

    @NotBlank(message = "aggiungere la descrizione della pizza")
    private String descrizione; // descrizione pizza

    @NotBlank(message = "inserisci url immagine")
    private String foto; // url immagine pizza

    @Positive(message = "il prezzo non può essere negativo")
    private Double prezzo; // prezzo pizza

    // costruttore vuoto richiesto da JPA
    public Pizza() {
    }

    // costruttore con parametri
    public Pizza(String nome, String descrizione, String foto, Double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.foto = foto;
        this.prezzo = prezzo;
    }

    // getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
