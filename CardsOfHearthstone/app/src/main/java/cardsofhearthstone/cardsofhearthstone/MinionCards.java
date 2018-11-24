package cardsofhearthstone.cardsofhearthstone;

public class MinionCards {
    String ID;
    String Type;
    String Rarity;
    String Name;
    String Artist;
    String CardClass;
    boolean Collectible;
    int Cost;
    int Health;
    int Attack;

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

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
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
}
