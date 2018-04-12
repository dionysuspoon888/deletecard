package com.example.deletecard;




//Set up JSON Object and Constructor
public class JSONItem {
    private String imageUrl;
    private String creator;

    public JSONItem(String imageUrls, String creators) {
        imageUrl = imageUrls;
        creator = creators;

    }

    //Method to retrieve the data
    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreator() {
        return creator;

    }
}