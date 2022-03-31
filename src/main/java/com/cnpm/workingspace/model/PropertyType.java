package com.cnpm.workingspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="property_type")
public class PropertyType {
    @JsonIgnore
    @Id
    @Column(name = "property_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String propertyTypeId;
    @Column(name = "property_type_name")
    private String propertyTypeName;
    @Column(name = "image")
    private String image;

    public PropertyType(String propertyTypeId, String propertyTypeName, String image) {
        this.propertyTypeId = propertyTypeId;
        this.propertyTypeName = propertyTypeName;
        this.image = image;
    }

    public String getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(String propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
