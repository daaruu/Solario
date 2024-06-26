package com.example.solario;

public class Planet {

    //Atributes
    private String planetName;
    private String moonCount;
    private String description;
    private int planetImage;

     // Constructor

    public Planet(String planetName, String moonCount, int planetImage, String description) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
        this.description = description;
    }

    //Getter and Setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
