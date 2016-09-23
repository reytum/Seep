package app.reytum.com.seep.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import app.reytum.com.seep.R;
import app.reytum.com.seep.utils.Card;

/**
 * Created by reytum on 2/9/16.
 */
public class FirstPlayerCardAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<Card> cardsDealt = new ArrayList<Card>();
    Context context;

    public FirstPlayerCardAdapter(Context context, ArrayList<Card> cardsDealt) {
        this.context = context;
        this.cardsDealt = cardsDealt;
    }

    @Override
    public int getCount() {
        return cardsDealt.size();
    }

    @Override
    public Object getItem(int position) {
        return cardsDealt.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.first_player_single_card_view, parent, false);
        }
        Card cardDealt = (Card) getItem(position);
        ((ImageView) convertView.findViewById(R.id.first_player_single_card)).setImageBitmap(BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(Card.getCardBitmap(cardDealt), "drawable", context.getPackageName())));

        return convertView;
    }
}

