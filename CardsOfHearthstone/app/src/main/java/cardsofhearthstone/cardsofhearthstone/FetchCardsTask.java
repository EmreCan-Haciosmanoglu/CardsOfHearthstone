package cardsofhearthstone.cardsofhearthstone;

import android.database.DatabaseErrorHandler;
import android.os.AsyncTask;
import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.json.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;

public class FetchCardsTask extends AsyncTask<String, Void, String[]> {

    String cardData = null;
    ArrayList<MinionCard> minionCards = new ArrayList<MinionCard>();
    ArrayList<WeaponCard> weaponCards = new ArrayList<WeaponCard>();
    ArrayList<HeroCard> heroCards = new ArrayList<HeroCard>();
    ArrayList<SpellCard> spellCards = new ArrayList<SpellCard>();
    ArrayList<EnchantmentCard> enchantmentCards = new ArrayList<EnchantmentCard>();


    public int numberofCards=0;
    String[] CARD_GROUPS = {
            "Basic",
            "Classic",
            "Promo",
            "Hall of Fame",
            "Naxxramas",
            "Goblins vs Gnomes",
            "Blackrock Mountain",
            "The Grand Tournament",
            "The League of Explorers",
            "Whispers of the Old Gods",
            "One Night in Karazhan",
            "Mean Streets of Gadgetzan",
            "Journey to Un'Goro",
            "Knights of the Frozen Throne",
            "Kobolds & Catacombs",
            "The Witchwood",
            "The Boomsday Project",
            "Tavern Brawl",
            "Taverns of Time",
            "Hero Skins",
            "Missions",
            "Credits",
            "System",
            "Debug"
    };
    String DATA_CARD_TYPE = "type";
    final String[] CARD_TYPES = {
            "Minion",
            "Weapon",
            "Hero",
            "Spell",
            "Enchantment",
            "Hero Power"
    };
    String DATA_CARD_ID = "cardId";
    String DATA_CARD_RARITY = "rarity";
    String DATA_CARD_NAME = "name";
    String DATA_CARD_SET = "cardSet";
    String DATA_CARD_IMG_URL = "img"; //"imgGold";
    String DATA_CARD_TEXT = "text";
    String DATA_CARD_COST = "cost";
    String DATA_CARD_HEALTH = "health";
    String DATA_CARD_ATTACK = "attack";
    String DATA_CARD_IS_COLLECTIBLE = "collectible";
    String DATA_CARD_DURABILTY="durability";
    String DATA_CARD_ARMOR="armor";

    @Override
    protected String[] doInBackground(String... strings) {
        try {

            /////////////////////////////////////////////////////////

            HttpResponse<JsonNode> response;
            response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards?attack=1")
                    .header("X-Mashape-Key", "3BNNcA7YhAmshdhzxe2TulPnRS02p1OV7wQjsn3v2ADuMrMatn")
                    .asJson();
            getCards(response);
            ///////////////////////////////////
        }
        catch (Exception e)
        {

        }

        int a = 1;
        if(a == 1)
            return new String[]{""};

        HttpURLConnection urlConnection   = null;
        BufferedReader    reader          = null;


        try {
            URL weatherURL = new URL(strings[0]);
            urlConnection  = (HttpURLConnection) weatherURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer     = new StringBuffer();

            if (inputStream != null)
            {
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null)
                {
                    buffer.append(line + "\n");
                }
                if (buffer.length() != 0)
                {
                    cardData = buffer.toString();
                }
            }
        }
        catch (Exception e)
        {
            Log.e("MainActivity", "Error ", e);
        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (final IOException e)
                {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }
        }
        try
        {
            return getWeatherDataFromJson(cardData);
        }
        catch (Exception e)
        {
            Log.e("FetchWeatherTask", e.getMessage(), e);
        }
        return null;
    }

    private void getCards(HttpResponse<JsonNode> node)
    {
        try
        {
            JSONObject data = node.getBody().getObject();
            JSONArray[] cardArrays = {
                    data.getJSONArray(CARD_GROUPS[0]),
                    data.getJSONArray(CARD_GROUPS[1]),
                    data.getJSONArray(CARD_GROUPS[2]),
                    data.getJSONArray(CARD_GROUPS[3]),
                    data.getJSONArray(CARD_GROUPS[4]),
                    data.getJSONArray(CARD_GROUPS[5]),
                    data.getJSONArray(CARD_GROUPS[6]),
                    data.getJSONArray(CARD_GROUPS[7]),
                    data.getJSONArray(CARD_GROUPS[8]),
                    data.getJSONArray(CARD_GROUPS[9]),
                    data.getJSONArray(CARD_GROUPS[10]),
                    data.getJSONArray(CARD_GROUPS[11]),
                    data.getJSONArray(CARD_GROUPS[12]),
                    data.getJSONArray(CARD_GROUPS[13]),
                    data.getJSONArray(CARD_GROUPS[14]),
                    data.getJSONArray(CARD_GROUPS[15]),
                    data.getJSONArray(CARD_GROUPS[16]),
                    data.getJSONArray(CARD_GROUPS[17]),
                    data.getJSONArray(CARD_GROUPS[18]),
                    data.getJSONArray(CARD_GROUPS[19]),
                    data.getJSONArray(CARD_GROUPS[20]),
                    data.getJSONArray(CARD_GROUPS[21]),
                    data.getJSONArray(CARD_GROUPS[22]),
                    data.getJSONArray(CARD_GROUPS[23]),
            };

            for(int i = 0; i < cardArrays.length; i++)
            {
                for (int j = 0; j < cardArrays[i].length(); j++)
                {
                    JSONObject card = cardArrays[i].getJSONObject(j);
                    String type = card.getString(DATA_CARD_TYPE);
                    if(type.equals(CARD_TYPES[0]))
                    {
                        MinionCard minionCard = new MinionCard();

                        minionCard.setID(card.getString(DATA_CARD_ID));
                        //    "cardId":"GAME_002",
                        //    "dbfId":"1733",
                        //minionCard.setType(card.getString(DATA_CARD_TYPE));
                        //    "type":"Minion",
                        if(card.has(DATA_CARD_RARITY))
                        {
                            minionCard.setRarity(card.getString(DATA_CARD_RARITY));
                            //    "rarity":"Free",
                        }
                        else
                        {
                            minionCard.setRarity("Unknown");
                        }
                        if(card.has(DATA_CARD_NAME)){
                            minionCard.setName(card.getString(DATA_CARD_NAME));
                            //    "name":"Avatar of the Coin",
                        } else{
                            minionCard.setName("Unknown");
                        }
                        if(card.has(DATA_CARD_SET)){
                            minionCard.setCardClass(card.getString(DATA_CARD_SET));
                            //    "cardSet":"Basic",
                        } else{
                            minionCard.setCardClass("Unknown");
                        }
                        if(card.has(DATA_CARD_IMG_URL)){
                            minionCard.setImgURL(card.getString(DATA_CARD_IMG_URL));
                            //    "img":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/original\/GAME_002.png",
                            //    "imgGold":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/animated\/GAME_002_premium.gif",
                            //    "attack":1,
                        } else{
                            minionCard.setImgURL("Unknown");
                        }

                        if(card.has(DATA_CARD_TEXT))
                        {
                            minionCard.setText(card.getString(DATA_CARD_TEXT));
                            //    "text":"<i>You lost the coin flip, but gained a friend.<\/i>",
                        }
                        else
                        {
                            minionCard.setText("");
                        }
                        if(card.has(DATA_CARD_COST))
                        {
                            minionCard.setCost(card.getInt(DATA_CARD_COST));
                        }
                        else
                        {
                            minionCard.setCost(0);
                        }
                        //    "cost":0,"playerClass":"Neutral",
                        minionCard.setHealth(card.getInt(DATA_CARD_HEALTH));
                        //    "health":1,
                        minionCard.setAttack(card.getInt(DATA_CARD_ATTACK));
                        //    "attack":1,
                        if(card.has(DATA_CARD_IS_COLLECTIBLE))
                        {
                            minionCard.setCollectible(card.getBoolean(DATA_CARD_IS_COLLECTIBLE));
                        }
                        else
                        {
                            minionCard.setCollectible(false);
                        }
                        minionCards.add(minionCard);
                    }
                    else if(type.equals(CARD_TYPES[1]))
                    {
                        WeaponCard weaponCard=new WeaponCard();

                        weaponCard.setID(card.getString(DATA_CARD_ID));
                        if(card.has(DATA_CARD_NAME)){
                            weaponCard.setName(card.getString(DATA_CARD_NAME));
                        } else{
                            weaponCard.setName("unknown");
                        }
                        if(card.has(DATA_CARD_IMG_URL)){
                            weaponCard.setImgURL(card.getString(DATA_CARD_IMG_URL));
                        } else{
                            weaponCard.setImgURL("unknown");
                        }
                        if(card.has(DATA_CARD_SET)){
                            weaponCard.setCardClass(card.getString(DATA_CARD_SET));
                        } else{
                            weaponCard.setCardClass("unknown");
                        }
                        if(card.has(DATA_CARD_COST)){
                            weaponCard.setCost(card.getInt(DATA_CARD_COST));
                        } else{
                            weaponCard.setCost(0);
                        }
                        if(card.has(DATA_CARD_ATTACK)){
                            weaponCard.setAttack(card.getInt(DATA_CARD_ATTACK));
                        } else{
                            weaponCard.setAttack(0);
                        }
                        if(card.has(DATA_CARD_DURABILTY)){
                            weaponCard.setDurability(card.getInt(DATA_CARD_DURABILTY));
                        } else{
                            weaponCard.setDurability(0);
                        }
                        if(card.has(DATA_CARD_RARITY)){
                            weaponCard.setRarity(card.getString(DATA_CARD_RARITY));

                        } else{
                            weaponCard.setRarity("unknown");
                        }

                        weaponCard.setCollectible(card.getBoolean(DATA_CARD_IS_COLLECTIBLE));
                        weaponCards.add(weaponCard);

                    }
                    else if(type.equals(CARD_TYPES[2]))
                    {
                        HeroCard heroCard=new HeroCard();

                        heroCard.setID(card.getString(DATA_CARD_ID));
                        heroCard.setName(card.getString(DATA_CARD_NAME));
                        heroCard.setCardClass(card.getString(DATA_CARD_SET));
                        heroCard.setRarity(card.getString(DATA_CARD_RARITY));
                        heroCard.setArmor(card.getInt(DATA_CARD_ARMOR));
                        heroCard.setCollectible(card.getBoolean(DATA_CARD_IS_COLLECTIBLE));
                        heroCard.setHealth(card.getInt(DATA_CARD_HEALTH));
                        heroCard.setCost(card.getInt(DATA_CARD_COST));


                    }
                    else if(type.equals(CARD_TYPES[3]))
                    {

                    }
                    else if(type.equals(CARD_TYPES[4]))
                    {

                    }
                    else if(type.equals(CARD_TYPES[5]))
                    {

                    }
                    else
                    {
                        Log.v("type",type);
                    }
                }
            }
            Log.v("minion", "" + minionCards.size());
        }
        catch(Exception e)
        {
            Log.v("ERROR", e.getMessage());
        }
    }

    private String[] getWeatherDataFromJson(String forecastJsonStr)  {
        Log.v("HACIOSMANOGLU",forecastJsonStr);

        JSONArray mainArray= null;
        try
        {
            mainArray = new JSONArray(cardData);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        Log.v("carddata", String.valueOf(mainArray.length()));
        for(int i=0;i<mainArray.length();i++)
        {
            String cardType=null;
            JSONObject card=null;
            try
            {
                card=mainArray.getJSONObject(i);
                cardType=card.getString("type");
            }
            catch (Exception e) {}

            if(cardType.equals("HERO"))
            {
                HeroCard Card=new HeroCard();
                try
                {
                    Card.setCost(card.getInt("cost"));
                }
                catch (Exception e)
                {
                    Card.setCost(0);
                }
                try
                {
                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));
                    Card.setCardClass(card.getString("cardClass"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setArmor(card.getInt("armor"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setHealth(card.getInt("health"));
                }
                catch (Exception e){ }

                heroCards.add(Card);
                numberofCards++;
            }
            try
            {
                if(cardType.equals("SPELL"))
                {
                    SpellCard Card=new SpellCard();

                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setID(card.getString("id"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setName(card.getString("name"));

                    spellCards.add(Card);
                    numberofCards++;
                }
                if(cardType.equals("MINION"))
                {
                    MinionCard Card=new MinionCard();

                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));
                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setHealth(card.getInt("health"));
                    Card.setAttack(card.getInt("attack"));

                    minionCards.add(Card);
                    numberofCards++;
                }
                if(cardType.equals("WEAPON"))
                {
                    WeaponCard Card=new WeaponCard();

                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));
                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setAttack(card.getInt("attack"));
                    Card.setDurability(card.getInt("durability"));

                    weaponCards.add(Card);
                    numberofCards++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return new String[]{"fsaf"};
    }

    @Override
    protected void onPostExecute(String[] aString) {
        super.onPostExecute(aString);

        /*
        Log.v("carddata","finished");
        Log.v("caddata",String.valueOf(heroIndex));
        Log.v("caddata",String.valueOf(minionIndex));
        Log.v("caddata",String.valueOf(spellIndex));
        Log.v("caddata",String.valueOf(weaponIndex));
        Log.v("carddata",String.valueOf(numberofCards));
        */
    }
}