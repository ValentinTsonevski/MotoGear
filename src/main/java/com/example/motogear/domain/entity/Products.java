package com.example.motogear.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products extends BaseEntity{

    @OneToOne
    private BootsEntity boots;

    @OneToOne
    private GlovesEntity gloves;

    @OneToOne
    private HelmetEntity helmet;

    @OneToOne
    private JacketEntity jacket;

    @OneToOne
    private PantsEntity pants;

    public Products() {
    }

    public Products(BootsEntity boots, GlovesEntity gloves, HelmetEntity helmet, JacketEntity jacket, PantsEntity pants) {
        this.boots = boots;
        this.gloves = gloves;
        this.helmet = helmet;
        this.jacket = jacket;
        this.pants = pants;
    }

    public BootsEntity getBoots() {
        return boots;
    }

    public Products setBoots(BootsEntity boots) {
        this.boots = boots;
        return this;
    }

    public GlovesEntity getGloves() {
        return gloves;
    }

    public Products setGloves(GlovesEntity gloves) {
        this.gloves = gloves;
        return this;
    }

    public HelmetEntity getHelmet() {
        return helmet;
    }

    public Products setHelmet(HelmetEntity helm) {
        this.helmet = helm;
        return this;
    }

    public JacketEntity getJacket() {
        return jacket;
    }

    public Products setJacket(JacketEntity jacket) {
        this.jacket = jacket;
        return this;
    }

    public PantsEntity getPants() {
        return pants;
    }

    public Products setPants(PantsEntity legs) {
        this.pants = legs;
        return this;
    }

}
