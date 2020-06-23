package com.fafik.spacedatahub.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Mission mission;
    private LocalDateTime acquisitionDate;
    private String productFootprint;
    private BigDecimal price;
    private String url;

    public Product() {
    }

    public Product(Mission mission, LocalDateTime acquisitionDate) {
        this.mission = mission;
        this.acquisitionDate = acquisitionDate;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public Mission getMission() {
        return mission;
    }

    public Product setMission(Mission mission) {
        this.mission = mission;
        return this;
    }

    public LocalDateTime getAcquisitionDate() {
        return acquisitionDate;
    }

    public Product setAcquisitionDate(LocalDateTime acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
        return this;
    }

    public String getProductFootprint() {
        return productFootprint;
    }

    public Product setProductFootprint(String productFootprint) {
        this.productFootprint = productFootprint;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Product setUrl(String url) {
        this.url = url;
        return this;
    }
}
