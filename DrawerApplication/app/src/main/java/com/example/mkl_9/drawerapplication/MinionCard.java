package com.example.mkl_9.drawerapplication;

public class MinionCard {
    private String ID;
    //    "cardId":"GAME_002",
    //    "dbfId":"1733",
    private String Type = "Minion";
    //    "type":"Minion",
    private String Rarity;
    //    "rarity":"Free",
    private String Name;
    //    "name":"Avatar of the Coin",
    private String CardClass;
    //    "cardSet":"Basic",
    private String imgURL;
    //    "img":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/original\/GAME_002.png",
    //    "imgGold":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/animated\/GAME_002_premium.gif",
    private String text;
    //    "text":"<i>You lost the coin flip, but gained a friend.<\/i>",
    private int Cost;
    //    "cost":0,"playerClass":"Neutral",
    private int Health;
    //    "health":1,
    private int Attack;
    //    "attack":1,
    private boolean Collectible;
    // if exist in data

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

    public String getCardClass() {
        return CardClass;
    }

    public void setCardClass(String cardClass) {
        CardClass = cardClass;
    }

    public boolean isCollectible() {
        return Collectible;
    }

    public void setCollectible(boolean collectible) {
        Collectible = collectible;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
