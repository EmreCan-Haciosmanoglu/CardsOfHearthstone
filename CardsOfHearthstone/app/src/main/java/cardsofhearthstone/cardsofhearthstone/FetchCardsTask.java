package cardsofhearthstone.cardsofhearthstone;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
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


    Context m_Context;
    public EndPointTypes endPointType = EndPointTypes.AllCards;
    public String URL = "";



    public FetchCardsTask(Context c)
    {
        m_Context = c;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        try
        {
            HttpResponse<JsonNode> response;
            response = Unirest.get(URL)
                    .header("X-Mashape-Key", "3BNNcA7YhAmshdhzxe2TulPnRS02p1OV7wQjsn3v2ADuMrMatn")
                    .asJson();
            getCards(response);
        }
        catch (Exception e)
        {
            Log.v("LOG_ERROR","doInBackground :: " + e.getMessage());
        }
        return new String[] {"","","",""};
    }

    private void getCards(HttpResponse<JsonNode> node) {
        try {
            JSONObject data = node.getBody().getObject();
            JSONArray[] cardArrays = {
                    data.getJSONArray(Helper.CARD_GROUPS[0]),
                    data.getJSONArray(Helper.CARD_GROUPS[1]),
                    data.getJSONArray(Helper.CARD_GROUPS[2]),
                    data.getJSONArray(Helper.CARD_GROUPS[3]),
                    data.getJSONArray(Helper.CARD_GROUPS[4]),
                    data.getJSONArray(Helper.CARD_GROUPS[5]),
                    data.getJSONArray(Helper.CARD_GROUPS[6]),
                    data.getJSONArray(Helper.CARD_GROUPS[7]),
                    data.getJSONArray(Helper.CARD_GROUPS[8]),
                    data.getJSONArray(Helper.CARD_GROUPS[9]),
                    data.getJSONArray(Helper.CARD_GROUPS[10]),
                    data.getJSONArray(Helper.CARD_GROUPS[11]),
                    data.getJSONArray(Helper.CARD_GROUPS[12]),
                    data.getJSONArray(Helper.CARD_GROUPS[13]),
                    data.getJSONArray(Helper.CARD_GROUPS[14]),
                    data.getJSONArray(Helper.CARD_GROUPS[15]),
                    data.getJSONArray(Helper.CARD_GROUPS[16]),
                    data.getJSONArray(Helper.CARD_GROUPS[17]),
                    data.getJSONArray(Helper.CARD_GROUPS[18]),
                    data.getJSONArray(Helper.CARD_GROUPS[19]),
                    data.getJSONArray(Helper.CARD_GROUPS[20]),
                    data.getJSONArray(Helper.CARD_GROUPS[21]),
                    data.getJSONArray(Helper.CARD_GROUPS[22]),
                    data.getJSONArray(Helper.CARD_GROUPS[23]),
            };

            for (int i = 0; i < cardArrays.length; i++) {
                for (int j = 0; j < cardArrays[i].length(); j++) {
                    JSONObject card = cardArrays[i].getJSONObject(j);
                    String type = card.getString(Helper.DATA_CARD_TYPE);
                    if (type.equals(Helper.CARD_TYPES[0])) {
                        MinionCard minionCard = new MinionCard();

                        minionCard.setID(card.getString(Helper.DATA_CARD_ID));
                        //    "cardId":"GAME_002",
                        //    "dbfId":"1733",
                        //minionCard.setType(card.getString(DATA_CARD_TYPE));
                        //    "type":"Minion",
                        if (card.has(Helper.DATA_CARD_RARITY)) {
                            minionCard.setRarity(card.getString(Helper.DATA_CARD_RARITY));
                            //    "rarity":"Free",
                        } else {
                            minionCard.setRarity("Unknown");
                        }
                        if (card.has(Helper.DATA_CARD_NAME)) {
                            minionCard.setName(card.getString(Helper.DATA_CARD_NAME));
                            //    "name":"Avatar of the Coin",
                        } else {
                            minionCard.setName("Unknown");
                        }
                        if (card.has(Helper.DATA_CARD_SET)) {
                            minionCard.setCardClass(card.getString(Helper.DATA_CARD_SET));
                            //    "cardSet":"Basic",
                        } else {
                            minionCard.setCardClass("Unknown");
                        }
                        if (card.has(Helper.DATA_CARD_IMG_URL)) {
                            minionCard.setImgURL(card.getString(Helper.DATA_CARD_IMG_URL));
                            //    "img":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/original\/GAME_002.png",
                            //    "imgGold":"http:\/\/wow.zamimg.com\/images\/hearthstone\/cards\/enus\/animated\/GAME_002_premium.gif",
                            //    "attack":1,
                        } else {
                            minionCard.setImgURL("Unknown");
                        }

                        if (card.has(Helper.DATA_CARD_TEXT)) {
                            minionCard.setText(card.getString(Helper.DATA_CARD_TEXT));
                            //    "text":"<i>You lost the coin flip, but gained a friend.<\/i>",
                        } else {
                            minionCard.setText("");
                        }
                        if (card.has(Helper.DATA_CARD_COST)) {
                            minionCard.setCost(card.getInt(Helper.DATA_CARD_COST));
                        } else {
                            minionCard.setCost(0);
                        }
                        //    "cost":0,"playerClass":"Neutral",
                        minionCard.setHealth(card.getInt(Helper.DATA_CARD_HEALTH));
                        //    "health":1,
                        minionCard.setAttack(card.getInt(Helper.DATA_CARD_ATTACK));
                        //    "attack":1,
                        if (card.has(Helper.DATA_CARD_IS_COLLECTIBLE)) {
                            minionCard.setCollectible(card.getBoolean(Helper.DATA_CARD_IS_COLLECTIBLE));
                        } else {
                            minionCard.setCollectible(false);
                        }
                        minionCards.add(minionCard);
                    } else if (type.equals(Helper.CARD_TYPES[1])) {
                        WeaponCard weaponCard = new WeaponCard();

                        weaponCard.setID(card.getString(Helper.DATA_CARD_ID));
                        if (card.has(Helper.DATA_CARD_NAME)) {
                            weaponCard.setName(card.getString(Helper.DATA_CARD_NAME));
                        } else {
                            weaponCard.setName("unknown");
                        }
                        if (card.has(Helper.DATA_CARD_IMG_URL)) {
                            weaponCard.setImgURL(card.getString(Helper.DATA_CARD_IMG_URL));
                        } else {
                            weaponCard.setImgURL("unknown");
                        }
                        if (card.has(Helper.DATA_CARD_SET)) {
                            weaponCard.setCardClass(card.getString(Helper.DATA_CARD_SET));
                        } else {
                            weaponCard.setCardClass("unknown");
                        }
                        if (card.has(Helper.DATA_CARD_COST)) {
                            weaponCard.setCost(card.getInt(Helper.DATA_CARD_COST));
                        } else {
                            weaponCard.setCost(0);
                        }
                        if (card.has(Helper.DATA_CARD_ATTACK)) {
                            weaponCard.setAttack(card.getInt(Helper.DATA_CARD_ATTACK));
                        } else {
                            weaponCard.setAttack(0);
                        }
                        if (card.has(Helper.DATA_CARD_DURABILITY)) {
                            weaponCard.setDurability(card.getInt(Helper.DATA_CARD_DURABILITY));
                        } else {
                            weaponCard.setDurability(0);
                        }
                        if (card.has(Helper.DATA_CARD_RARITY)) {
                            weaponCard.setRarity(card.getString(Helper.DATA_CARD_RARITY));

                        } else {
                            weaponCard.setRarity("unknown");
                        }
                        if (card.has(Helper.DATA_CARD_IS_COLLECTIBLE)) {
                            weaponCard.setCollectible(card.getBoolean(Helper.DATA_CARD_IS_COLLECTIBLE));
                        } else {
                            weaponCard.setCollectible(false);
                        }
                        weaponCards.add(weaponCard);

                    } else if (type.equals(Helper.CARD_TYPES[2])) {/*
                        HeroCard heroCard = new HeroCard();

                        heroCard.setID(card.getString(Helper.DATA_CARD_ID));
                        heroCard.setName(card.getString(Helper.DATA_CARD_NAME));
                        heroCard.setCardClass(card.getString(Helper.DATA_CARD_SET));
                        heroCard.setRarity(card.getString(Helper.DATA_CARD_RARITY));
                        heroCard.setArmor(card.getInt(Helper.DATA_CARD_ARMOR));
                        heroCard.setCollectible(card.getBoolean(Helper.DATA_CARD_IS_COLLECTIBLE));
                        heroCard.setHealth(card.getInt(Helper.DATA_CARD_HEALTH));
                        heroCard.setCost(card.getInt(Helper.DATA_CARD_COST));

*/
                    } else if (type.equals(Helper.CARD_TYPES[3])) {

                    } else if (type.equals(Helper.CARD_TYPES[4])) {

                    } else if (type.equals(Helper.CARD_TYPES[5])) {

                    } else {
                        Log.v("type", type);
                    }
                }
            }
            Log.v("minion", "" + minionCards.size());
        } catch (Exception e) {
            Log.v("ERROR", e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String[] aString) {
        super.onPostExecute(aString);
    }

    private void SetURL()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(m_Context);
        String attack       = sharedPreferences.getString("attack"      , "-1");
        String collectible  = sharedPreferences.getString("collectible" , "-1");
        String cost         = sharedPreferences.getString("cost"        , "-1");
        String durability   = sharedPreferences.getString("durability"  , "-1");
        String health       = sharedPreferences.getString("health"      , "-1");
        String locale       = sharedPreferences.getString("locale"      , "enUS");

        String name         = sharedPreferences.getString("name"        , "");
        String set          = sharedPreferences.getString("set"         , "");
        String cls          = sharedPreferences.getString("cls"         , "");
        String faction      = sharedPreferences.getString("faction"     , "");
        String quality      = sharedPreferences.getString("quality"     , "");
        String race         = sharedPreferences.getString("race"        , "");
        String type         = sharedPreferences.getString("type"        , "");

        switch (endPointType)
        {
            case AllCards:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case Search:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/"
                        +(name) + "?"
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(locale);
                break;
            case SearchBySet:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/"
                        +(set) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByClass:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/"
                        +(cls) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByFaction:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/"
                        +(faction) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByQuality:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/"
                        +(quality) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByRace:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/"
                        +(race) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByType:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/"
                        +(type) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible.equals("-1")  ?"":("collectible="+collectible+"&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
        }
    }


}

enum EndPointTypes {
    AllCards,
    Search,
    SearchBySet,
    SearchByClass,
    SearchByFaction,
    SearchByQuality,
    SearchByRace,
    SearchByType
}
