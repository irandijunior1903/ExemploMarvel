package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

public class CharacterSummary {
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;
    @SerializedName("role")
    private String role;

    public CharacterSummary(String resourceURI, String name, String role) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.role = role;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

