package com.example.worldservice.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="city")
public class City {

    @Id
    private Integer ID;
    @Column(name="Name")
    private String name;
    @Column(name="code")
    private String countryCode;
    @Column(name="District")
    private String district;
    @Column(name="Population")
    private Integer population;
}
