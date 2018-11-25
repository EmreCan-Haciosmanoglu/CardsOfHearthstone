package cardsofhearthstone.cardsofhearthstone;

public class HeroCard {
    String ID;
    String Type;
    String Rarity;
    String Name;
    String Artist;
    String CardClass;
    int armor;
    int Cost;
    int Health;

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

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setHealth(int health) {
        Health = health;
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

    public int getArmor() {
        return armor;
    }

    public int getCost() {
        return Cost;
    }

    public int getHealth() {
        return Health;
    }

    boolean Collectible;


}
