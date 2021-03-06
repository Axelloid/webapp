package com.rentalcar.webapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "automezzi")
public class Automezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "targa", unique = true)
    private String targa;

    @Column(name = "casacostruttrice")
    private String casacostruttrice;

    @Column(name = "modello")
    private String modello;

    @DateTimeFormat(pattern="yyyy-MM")
    @Column(name = "immatricolazione")
    private Date immatricolazione;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private TipologiaAutomezzo categoria;

    public Automezzo() {
    }

    public Automezzo(Long id, String targa, String casacostruttrice, String modello, Date immatricolazione, TipologiaAutomezzo categoria) {
        this.id = id;
        this.targa = targa;
        this.casacostruttrice = casacostruttrice;
        this.modello = modello;
        this.immatricolazione = immatricolazione;
        this.categoria = categoria;
    }

    public Automezzo(String targa, String casacostruttrice, String modello, Date immatricolazione, TipologiaAutomezzo categoria) {
        this.targa = targa;
        this.casacostruttrice = casacostruttrice;
        this.modello = modello;
        this.immatricolazione = immatricolazione;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCasacostruttrice() {
        return casacostruttrice;
    }

    public void setCasacostruttrice(String casacostruttrice) {
        this.casacostruttrice = casacostruttrice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Date getImmatricolazione() {
        return immatricolazione;
    }

    public void setImmatricolazione(Date immatricolazione) {
        this.immatricolazione = immatricolazione;
    }

    public TipologiaAutomezzo getCategoria() {
        return categoria;
    }

    public void setCategoria(TipologiaAutomezzo categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Automezzo{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", casacostruttrice='" + casacostruttrice + '\'' +
                ", modello='" + modello + '\'' +
                ", immatricolazione=" + immatricolazione +
                ", categoria=" + categoria +
                '}';
    }
}
