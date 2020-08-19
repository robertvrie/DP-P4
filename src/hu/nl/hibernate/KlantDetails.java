package hu.nl.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KLANT")
public class KlantDetails {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="voornaam")
    private String voornaam;

    @Column(name="tussenvoegsel")
    private String tussenvoegsel;

    @Column(name="achternaam")
    private String achternaam;

    public KlantDetails() {}
    public KlantDetails(int id, String voornaam, String tussenvoegsel, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
