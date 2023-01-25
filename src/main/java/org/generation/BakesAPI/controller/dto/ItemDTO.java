package org.generation.BakesAPI.controller.dto;

public class ItemDTO {
    private String name;

    private String description;

    private String imageUrl;

    private double price;

    private String bakeType;

    public ItemDTO(String name, String description, String imageUrl, double price, String bakeType )
    {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.bakeType = bakeType;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl( String imageUrl )
    {
        this.imageUrl = imageUrl;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getBakeType() { return bakeType; }

    public void setBakeType(String bakeType) { this.bakeType = bakeType; }
}
