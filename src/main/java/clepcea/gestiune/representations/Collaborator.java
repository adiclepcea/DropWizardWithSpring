package clepcea.gestiune.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "collaborators")
public class Collaborator {

    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String country;
    @JsonProperty
    private String currency;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String fax;
    @JsonProperty
    private String email;
    @JsonProperty
    private String CUI;
    @JsonProperty
    //@ManyToOne
    //@JoinColumn(name="price_category")
    @Transient
    private PriceCategory priceCategory;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getCUI() {
        return CUI;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public Collaborator(){
        id = 0;
        name = "";
        country = "Romania";
        currency = "RON";
        phone = "";
        fax = "";
        email = "";
        CUI = "";
        priceCategory = null;
    }

    public Collaborator(String name,
                        String country, String currency,
                        String phone, String fax,
                        String email, String CUI, PriceCategory priceCategory) {
        this.name = name;
        this.country = country;
        this.currency = currency;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.CUI = CUI;
        this.priceCategory = priceCategory;
    }



}
