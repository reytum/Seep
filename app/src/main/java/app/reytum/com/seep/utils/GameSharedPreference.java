package app.reytum.com.seep.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by reytum on 15/9/16.
 */
public class GameSharedPreference {

    private static String GAME_ID = "gameId";
    private static String ASKED_CARD = "askedCard";
    private static GameSharedPreference gameSharedPreference;

    private Context context;
    public SharedPreferences sharedPreferences;

    private GameSharedPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(GAME_ID, context.MODE_PRIVATE);
    }

    public static GameSharedPreference newInstance(Context context) {

        if (gameSharedPreference == null) {
            gameSharedPreference = new GameSharedPreference(context);
        }
        return gameSharedPreference;
    }

    public void setAskedCard(String askedCard) {
        sharedPreferences.edit().putString(ASKED_CARD, askedCard).commit();
    }

    public String getAskedCard() {
        return sharedPreferences.getString(ASKED_CARD, null);
    }
}
