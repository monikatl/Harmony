package com.example.harmony.practise;

public class Practise {

    private String name;
    private String description;
    private int number;
    private int image;
    private boolean isClomplete;


    public Practise(String name, String description, int number, int image, boolean isClomplete) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.image = image;
        this.isClomplete = isClomplete;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isClomplete() {
        return isClomplete;
    }

    public void setClomplete(boolean clomplete) {
        isClomplete = clomplete;
    }




}
