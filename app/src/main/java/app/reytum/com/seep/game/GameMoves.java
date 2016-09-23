package app.reytum.com.seep.game;

import java.util.ArrayList;

import app.reytum.com.seep.utils.Card;

/**
 * Created by reytum on 15/9/16.
 */
public class GameMoves {

    public GameMoves() {

    }

    public static ArrayList<Integer> calculateTotalCombinations(ArrayList<Card> cards) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            result.add(cards.get(i).getValue());
        }
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                result.add(cards.get(i).getValue() + cards.get(j).getValue());
            }
        }
        return result;
    }

}
