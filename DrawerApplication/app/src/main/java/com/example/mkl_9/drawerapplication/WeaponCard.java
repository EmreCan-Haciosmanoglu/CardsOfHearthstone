package com.example.mkl_9.drawerapplication;

public class WeaponCard {
    String ID;
    String Type;
    String Rarity;
    String Name;
    String Artist;
    String cardClass;
    boolean Collectible;
    int Durability;
    int Cost;
    int Attack;
    private String imgURL;;

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRarity() {
        return Rarity;
    }

    public void setRarity(String rarity) {
        Rarity = rarity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isCollectible() {
        return Collectible;
    }

    public void setCollectible(boolean collectible) {
        Collectible = collectible;
    }

    public int getDurability() {
        return Durability;
    }

    public void setDurability(int durability) {
        Durability = durability;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }
}
