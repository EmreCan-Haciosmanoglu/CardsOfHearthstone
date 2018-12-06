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

public class FetchCardsTask extends AsyncTask<String, Void, String[]>
{
    Context m_Context;
    RecyclerView m_TempRV;
    ListItemClickListener m_Listener;
    public EndPointTypes endPointType = EndPointTypes.AllCards;
    public String URL = "";



    public FetchCardsTask(Context c, RecyclerView rv, ListItemClickListener listener)
    {
        m_Context = c;
        m_TempRV = rv;
        m_Listener = listener;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        SetURL();
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
        Card.cards = new ArrayList<Card>();
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

                    Card c = new Card();

                    c.setID(card.getString(Helper.DATA_CARD_ID));
                    if (card.has(Helper.DATA_CARD_RARITY))
                        c.setRarity(card.getString(Helper.DATA_CARD_RARITY));
                    if (card.has(Helper.DATA_CARD_TYPE))
                        c.setType(card.getString(Helper.DATA_CARD_TYPE));
                    if (card.has(Helper.DATA_CARD_NAME))
                        c.setName(card.getString(Helper.DATA_CARD_NAME));
                    if (card.has(Helper.DATA_CARD_SET))
                        c.setCardClass(card.getString(Helper.DATA_CARD_SET));
                    if (card.has(Helper.DATA_CARD_IMG_URL))
                        c.setImgURL(card.getString(Helper.DATA_CARD_IMG_URL));
                    if (card.has(Helper.DATA_CARD_TEXT))
                        c.setText(card.getString(Helper.DATA_CARD_TEXT));
                    if (card.has(Helper.DATA_CARD_COST))
                        c.setCost(card.getInt(Helper.DATA_CARD_COST));
                    if (card.has(Helper.DATA_CARD_HEALTH))
                        c.setHealth(card.getInt(Helper.DATA_CARD_HEALTH));
                    if (card.has(Helper.DATA_CARD_ATTACK))
                        c.setAttack(card.getInt(Helper.DATA_CARD_ATTACK));
                    if (card.has(Helper.DATA_CARD_IS_COLLECTIBLE))
                        c.setCollectible(card.getBoolean(Helper.DATA_CARD_IS_COLLECTIBLE));
                    if (card.has(Helper.DATA_CARD_DURABILITY))
                        c.setDurability(card.getInt(Helper.DATA_CARD_DURABILITY));
                    if (card.has(Helper.DATA_CARD_ARMOR))
                        c.setArmor(card.getInt(Helper.DATA_CARD_ARMOR));

                    Card.cards.add(c);
/*
                    if (type.equals(Helper.CARD_TYPES[3])) {

                    } else if (type.equals(Helper.CARD_TYPES[4])) {

                    } else if (type.equals(Helper.CARD_TYPES[5])) {

                    } else {
                        Log.v("type", type);
                    }*/
                }
            }
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
        boolean collectible  = sharedPreferences.getBoolean("collectible" , false);
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
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case Search:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/"
                        +(name) + "?"
                        +(collectible               ?"":("collectible=1&"))
                        +(locale);
                break;
            case SearchBySet:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/"
                        +(set) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByClass:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/"
                        +(cls) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByFaction:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/"
                        +(faction) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByQuality:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/"
                        +(quality) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByRace:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/"
                        +(race) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
                        +(cost.equals("-1")         ?"":("cost="+cost+"&"))
                        +(durability.equals("-1")   ?"":("durability="+durability+"&"))
                        +(health.equals("-1")       ?"":("health="+health+"&"))
                        +(locale);
                break;
            case SearchByType:
                URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/"
                        +(type) + "?"
                        +(attack.equals("-1")       ?"":("attack="+attack+"&"))
                        +(collectible               ?"":("collectible=1&"))
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
