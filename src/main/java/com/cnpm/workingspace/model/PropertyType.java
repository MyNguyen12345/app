package com.cnpm.workingspace.model;

import javax.persistence.*;

@Entity
@Table(name = "property_type")
public class PropertyType {
    @Id
    @Column(name = "property_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyTypeId;
    @Column(name = "property_type_name")
    private String propertyTypeName;
    @Column(name = "image")
    private String image;

    public PropertyType() {
    }

    public PropertyType(String propertyTypeName, String image) {
        this.propertyTypeName = propertyTypeName;
        this.image = image;
    }

    public int getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(int propertyTypeId) {
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
