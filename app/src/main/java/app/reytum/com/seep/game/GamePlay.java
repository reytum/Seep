package app.reytum.com.seep.game;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import app.reytum.com.seep.R;
import app.reytum.com.seep.utils.Card;
import app.reytum.com.seep.utils.GameSharedPreference;

/**
 * Created by reytum on 13/9/16.
 */
public class GamePlay {

    private Context context;
    private View view;

    private GameSharedPreference gameSharedPreference;

    public GamePlay() {
    }

    public GamePlay(Context context, View view) {
        this.context = context;
        this.view = view;

        gameSharedPreference = GameSharedPreference.newInstance(context);
    }

    public ArrayList<String> askACard(ArrayList<Card> cards) {
        ArrayList<String> askACardList;
        Set<String> set = new TreeSet();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue() > 8) {
                set.add(cards.get(i).getValueAsString());
            }
        }
        askACardList = new ArrayList<>(set);
        return askACardList;
    }

    public View setAskACardLayout(ArrayList<String> cards, final View view, final Dialog dialog) {
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.askACardLayout);

        if (cards.isEmpty()) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            TextView cardValueSelector = new TextView(context);
            cardValueSelector.setTextColor(Color.WHITE);
            cardValueSelector.setText("Invalid Cards dealt! \nThe dealer is dealing again!!");
            cardValueSelector.setLayoutParams(params);
            layout.addView(cardValueSelector);
        } else {
            for (int i = 0; i < cards.size(); i++) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 0, pixelToDip(8), 0);

                final TextView cardValueSelector = new TextView(context);
                cardValueSelector.setPadding(pixelToDip(8), pixelToDip(8), pixelToDip(8), pixelToDip(8));
                cardValueSelector.setClickable(true);
                cardValueSelector.setTextColor(Color.WHITE);
                cardValueSelector.setBackground(context.getDrawable(R.drawable.dialog_fragment_shape));
                cardValueSelector.setText(cards.get(i));

                cardValueSelector.setLayoutParams(params);
                layout.addView(cardValueSelector);

                cardValueSelector.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gameSharedPreference.setAskedCard(cardValueSelector.getText().toString());
                        dialog.dismiss();
                    }
                });
            }
        }
        return layout;
    }

    public void startTheGame() {

    }

    private int pixelToDip(int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
    }
}
