package cardsofhearthstone.cardsofhearthstone;

import android.os.AsyncTask;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class FetchCardsTask extends AsyncTask<String, Void, String[]> {

    String cardData = null;
    WeaponCards[] weaponCards=new WeaponCards[10000];
    HeroCards[] heroCards=new HeroCards[10000];
    SpellCards[] spellCards=new SpellCards[10000];
    MinionCards[] minionCards=new MinionCards[10000];
    int weaponIndex=0,heroIndex=0,spellIndex=0, minionIndex=0;
    public int numberofCards=0;






    @Override
    protected String[] doInBackground(String... strings) {
        HttpURLConnection urlConnection   = null;
        BufferedReader    reader          = null;


        try {
            URL weatherURL = new URL(strings[0]);
            urlConnection  = (HttpURLConnection) weatherURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();



            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer     = new StringBuffer();

            if (inputStream != null) {
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() != 0) {
                    cardData = buffer.toString();


                }
            }
        } catch (IOException e) {
            Log.e("MainActivity", "Error ", e);
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }
        }

        try {

            return getWeatherDataFromJson(cardData);
        } catch (Exception e) {
            Log.e("FetchWeatherTask", e.getMessage(), e);
        }

        // This will only happen if there was an error getting or parsing the forecast.

        return null;


    }

    private String[] getWeatherDataFromJson(String forecastJsonStr)  {
        Log.v("HACIOSMANOGLU",forecastJsonStr);
        JSONArray mainArray= null;
        try {
            mainArray = new JSONArray(cardData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("carddata", String.valueOf(mainArray.length()));
        for(int i=0;i<mainArray.length();i++){
            String cardType=null;
            JSONObject card=null;
            try {
                card=mainArray.getJSONObject(i);
                cardType=card.getString("type");

            } catch (Exception e){

            }


            if(cardType.equals("HERO")){
                HeroCards Card=new HeroCards();
                 try {
                    Card.setCost(card.getInt("cost"));

                } catch (Exception e){
                    Card.setCost(0);
                }
                try {
                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));



                    Card.setCardClass(card.getString("cardClass"));

                    Card.setRarity(card.getString("rarity"));
                    Card.setArmor(card.getInt("armor"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setHealth(card.getInt("health"));

                } catch (Exception e){

                }




                heroCards[heroIndex]=Card;
                heroIndex++;
                numberofCards++;

            }



            try {
                if(cardType.equals("SPELL")){
                    SpellCards Card=new SpellCards();


                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setID(card.getString("id"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setName(card.getString("name"));


                    spellCards[spellIndex]=Card;
                    spellIndex++;
                    numberofCards++;


                }
                if(cardType.equals("MINION")){
                    MinionCards Card=new MinionCards();

                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));

                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));

                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setHealth(card.getInt("health"));
                    Card.setAttack(card.getInt("attack"));


                    minionCards[minionIndex]=Card;
                    minionIndex++;
                    numberofCards++;

                }
                if(cardType.equals("WEAPON")){
                    WeaponCards Card=new WeaponCards();
                    Card.setID(card.getString("id"));
                    Card.setName(card.getString("name"));

                    Card.setCardClass(card.getString("cardClass"));
                    Card.setCost(card.getInt("cost"));
                    Card.setRarity(card.getString("rarity"));
                    Card.setCollectible(card.getBoolean("collectible"));
                    Card.setAttack(card.getInt("attack"));
                    Card.setDurability(card.getInt("durability"));


                    weaponCards[weaponIndex]=Card;
                    weaponIndex++;
                    numberofCards++;

                }

            } catch (Exception e){
                e.printStackTrace();
            }


        }




        return new String[]{"fsaf"};
    }

    @Override
    protected void onPostExecute(String[] aString) {
        super.onPostExecute(aString);
        Log.v("carddata","finished");
        Log.v("caddata",String.valueOf(heroIndex));
        Log.v("caddata",String.valueOf(minionIndex));
        Log.v("caddata",String.valueOf(spellIndex));
        Log.v("caddata",String.valueOf(weaponIndex));

        Log.v("carddata",String.valueOf(numberofCards));



    }
}
