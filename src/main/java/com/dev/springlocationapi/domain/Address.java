package com.dev.springlocationapi.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String countryCode;
    private String city;
    private String district;
    private String street;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(){

    }

    public Address(Long id, String country, String countryCode, String city, String district, String street) {
        this.id = id;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) && country.equals(address.country) && countryCode.equals(address.countryCode) && city.equals(address.city) && district.equals(address.district) && street.equals(address.street) && user.equals(address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, countryCode, city, district, street, user);
    }
}
