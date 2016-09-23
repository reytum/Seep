package app.reytum.com.seep.game;

import java.io.Serializable;
import java.util.ArrayList;

import app.reytum.com.seep.utils.Card;
import app.reytum.com.seep.utils.Deck;

/**
 * Created by reytum on 3/9/16.
 */
public class DealCards implements Serializable {

    ArrayList<Card> playerOneCards;
    ArrayList<Card> playerTwoCards;
    ArrayList<Card> playerThreeCards;
    ArrayList<Card> playerFourCards;
    ArrayList<Card> tableDealtCards;

    private Deck deck;

    public DealCards() {
        deck = new Deck();
        deck.shuffle();

        playerOneCards = new ArrayList<>();
        playerTwoCards = new ArrayList<>();
        playerThreeCards = new ArrayList<>();
        playerFourCards = new ArrayList<>();
        tableDealtCards = new ArrayList<>();
    }

    public ArrayList<Card> getPlayerOneCards() {
        return playerOneCards;
    }

    public ArrayList<Card> getPlayerTwoCards() {
        return playerTwoCards;
    }

    public ArrayList<Card> getPlayerThreeCards() {
        return playerThreeCards;
    }

    public ArrayList<Card> getPlayerFourCards() {
        return playerFourCards;
    }

    public ArrayList<Card> getTableDealtCards() {
        return tableDealtCards;
    }

    public void dealOpeningCards() {
        for (int i = 0; i < 4; i++) {
            playerTwoCards.add(deck.dealCard());
            playerThreeCards.add(deck.dealCard());
            playerFourCards.add(deck.dealCard());
        }
        for (int i = 0; i < 12; i++) {
            playerOneCards.add(deck.dealCard());
        }
    }

    public void dealTableCards() {
        for (int i = 0; i < 4; i++) {
            tableDealtCards.add(deck.dealCard());
        }
    }

    public void dealAllCards() {
        for (int i = 0; i < 8; i++) {
            playerTwoCards.add(deck.dealCard());
            playerThreeCards.add(deck.dealCard());
            playerFourCards.add(deck.dealCard());
        }
    }

    public static Boolean inValidCardsDealt(ArrayList<Card> cards) {
        int pointsCounter = 0;
        int faceCardCounter = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit() == Card.SPADES) {
                pointsCounter++;
            }
            if (((cards.get(i).getValue() == 9) && (cards.get(i).getSuit() == Card.SPADES)) || (cards.get(i).getValue() == 10) || (cards.get(i).getValue() == Card.JACK) || (cards.get(i).getValue() == Card.QUEEN) || (cards.get(i).getValue() == Card.KING)) {
                faceCardCounter++;
            }
        }
        if ((pointsCounter == 0) || (faceCardCounter == 0)) {
            return true;
        } else
            return false;
    }
}
