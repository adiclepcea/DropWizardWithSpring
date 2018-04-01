package clepcea.gestiune.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "pricecategories")
@NamedQuery(name="clepcea.gestiune.PriceCategory.findAll",
query = "Select pc from PriceCategory pc")
public class PriceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    private long id;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String description;


    public PriceCategory(){
        id = 0;
        name = "";
        description = "";
    };

    public  PriceCategory(String name, String description){
        this.name = name;
        this.description = description;
    }
}
