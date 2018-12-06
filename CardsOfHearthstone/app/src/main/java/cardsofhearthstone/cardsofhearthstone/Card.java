package cardsofhearthstone.cardsofhearthstone;

import java.util.ArrayList;

public class Card {

    static ArrayList<Card> cards = new ArrayList<>();
    private String ID ="";
    private String Type ="";
    private String Rarity ="";
    private String Name ="";
    private String CardClass ="";
    private String imgURL ="";
    private String text="";
    private int Cost = 0;
    private int Health = 0;
    private int Attack = 0;
    private int Durability = 0;
    private int Armor = 0;
    private boolean Collectible = false;

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

    public void setArmor(int armor) {
        Armor = armor;
    }

    public int getArmor() {
        return Armor;
    }

    public void setDurability(int durability) {
        Durability = durability;
    }

    public int getDurability() {
        return Durability;
    }
}
