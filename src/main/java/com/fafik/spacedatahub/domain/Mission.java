package com.fafik.spacedatahub.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String name;

    @Enumerated(EnumType.STRING)
    private ImageryType imageryType;
    private LocalDateTime missionDateFrom;
    private LocalDateTime missionDateTo;

    @OneToMany(mappedBy = "mission",fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    public Mission() {}

    public Mission(String name, ImageryType imageryType) {
        this.name = name;
        this.imageryType = imageryType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Mission setName(String name) {
        this.name = name;
        return this;
    }

    public ImageryType getImageryType() {
        return imageryType;
    }

    public Mission setImageryType(ImageryType imageryType) {
        this.imageryType = imageryType;
        return this;
    }

    public LocalDateTime getMissionDateFrom() {
        return missionDateFrom;
    }

    public Mission setMissionDateFrom(LocalDateTime missionDateFrom) {
        this.missionDateFrom = missionDateFrom;
        return this;
    }

    public LocalDateTime getMissionDateTo() {
        return missionDateTo;
    }

    public Mission setMissionDateTo(LocalDateTime missionDateTo) {
        this.missionDateTo = missionDateTo;
        return this;
    }

    public void addProduct(Product product) {
        product.setMission(this);
        this.products.add(product);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mission other = (Mission) obj;
        return Objects.equals(name, other.getName());
    }

}
