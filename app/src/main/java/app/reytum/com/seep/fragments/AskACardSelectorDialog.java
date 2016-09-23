package app.reytum.com.seep.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;

import app.reytum.com.seep.R;
import app.reytum.com.seep.activities.MainActivity;
import app.reytum.com.seep.game.GameMoves;
import app.reytum.com.seep.game.GamePlay;
import app.reytum.com.seep.utils.Card;

/**
 * Created by reytum on 14/9/16.
 */
public class AskACardSelectorDialog extends DialogFragment {

    public static AskACardSelectorDialog getInstance() {
        AskACardSelectorDialog frag = new AskACardSelectorDialog();
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ask_a_card_layout, container);
        Window window = this.getDialog().getWindow();
        window.setGravity(Gravity.BOTTOM);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);

        ArrayList<Card> cards;
        cards = ((MainActivity) getActivity()).dealCards.getPlayerTwoCards();
        for (int i = 0; i < GameMoves.calculateTotalCombinations(cards).size(); i++) {
            Log.i("abcd", GameMoves.calculateTotalCombinations(cards).get(i).toString());
        }

        GamePlay gamePlay = new GamePlay(getActivity(), view);
        gamePlay.setAskACardLayout(gamePlay.askACard(cards), view, getDialog());
        return view;
    }
}
