package com.example.mkl_9.drawerapplication;

public class SpellCard {
    String ID;
    String Type;
    String Name;
    String Artist;
    String CardClass;
    boolean Collectible;
    int Cost;
    String Rarity;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setRarity(String rarity) {
        Rarity = rarity;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public void setCardClass(String cardClass) {
        CardClass = cardClass;
    }

    public void setCollectible(boolean collectible) {
        Collectible = collectible;
    }

    public void setCost(int cost) {
        Cost = cost;
    }



    public String getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }

    public String getRarity() {
        return Rarity;
    }

    public String getName() {
        return Name;
    }

    public String getArtist() {
        return Artist;
    }

    public String getCardClass() {
        return CardClass;
    }

    public boolean isCollectible() {
        return Collectible;
    }

    public int getCost() {
        return Cost;
    }


}
