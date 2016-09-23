package app.reytum.com.seep.game;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import app.reytum.com.seep.GameUIHelper;
import app.reytum.com.seep.R;
import app.reytum.com.seep.utils.Card;

/**
 * Created by reytum on 16/9/16.
 */
public class Player {

    private Activity context;
    private GameUIHelper gameUIHelper;
    private int tableCardCounter;
    private RelativeLayout firstPlayerView;
    private RelativeLayout secondPlayerView;
    private RelativeLayout thirdPlayerView;
    private RelativeLayout fourthPlayerView;
    private ArrayList<ImageView> tableCards;
    private ImageView tableCard1;
    private ImageView tableCard2;
    private ImageView tableCard3;
    private ImageView tableCard4;
    private ImageView tableCard5;
    private ImageView tableCard6;
    private ImageView tableCard7;
    private ImageView tableCard8;
    private ImageView tableCard9;
    private ImageView tableCard10;
    private ImageView tableCard11;
    private ImageView tableCard12;

    public Player(Activity context) {
        this.context = context;
        gameUIHelper = new GameUIHelper(context);

        firstPlayerView = (RelativeLayout) context.findViewById(R.id.firstPlayerView);
        secondPlayerView = (RelativeLayout) context.findViewById(R.id.secondPlayerView);
        thirdPlayerView = (RelativeLayout) context.findViewById(R.id.thirdPlayerView);
        fourthPlayerView = (RelativeLayout) context.findViewById(R.id.fourthPlayerView);

        tableCards = new ArrayList<>();

        tableCard1 = (ImageView) context.findViewById(R.id.tablecard1);
        tableCards.add(tableCard1);
        tableCard2 = (ImageView) context.findViewById(R.id.tablecard2);
        tableCards.add(tableCard2);
        tableCard3 = (ImageView) context.findViewById(R.id.tablecard3);
        tableCards.add(tableCard3);
        tableCard4 = (ImageView) context.findViewById(R.id.tablecard4);
        tableCards.add(tableCard4);
        tableCard5 = (ImageView) context.findViewById(R.id.tablecard5);
        tableCards.add(tableCard5);
        tableCard6 = (ImageView) context.findViewById(R.id.tablecard6);
        tableCards.add(tableCard6);
        tableCard7 = (ImageView) context.findViewById(R.id.tablecard7);
        tableCards.add(tableCard7);
        tableCard8 = (ImageView) context.findViewById(R.id.tablecard8);
        tableCards.add(tableCard8);
        tableCard9 = (ImageView) context.findViewById(R.id.tablecard9);
        tableCards.add(tableCard9);
        tableCard10 = (ImageView) context.findViewById(R.id.tablecard10);
        tableCards.add(tableCard10);
        tableCard11 = (ImageView) context.findViewById(R.id.tablecard11);
        tableCards.add(tableCard11);
        tableCard12 = (ImageView) context.findViewById(R.id.tablecard12);
        tableCards.add(tableCard12);
    }

    public void createFirstPlayerView(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelToDip(40), RelativeLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(i * pixelToDip(30), 0, 0, 0);

            final ImageView singleCard = new ImageView(context);
            singleCard.setLayoutParams(params);

            singleCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameUIHelper.setAsSelectedCard(singleCard);
                }
            });
            setCardImage(singleCard, cards.get(i));
            firstPlayerView.addView(singleCard);
        }
    }

    public void createSecondPlayerView(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, pixelToDip(54));
            params.setMargins(0, i * pixelToDip(20), 0, 0);

            final ImageView singleCard = new ImageView(context);
            singleCard.setLayoutParams(params);

            singleCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameUIHelper.setAsSelectedCard(singleCard);
                }
            });

            setCardImage(singleCard, cards.get(i));
            secondPlayerView.addView(singleCard);
        }
    }

    public void createThirdPlayerView(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pixelToDip(40), RelativeLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(i * pixelToDip(30), 0, 0, 0);

            final ImageView singleCard = new ImageView(context);
            singleCard.setLayoutParams(params);

            singleCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameUIHelper.setAsSelectedCard(singleCard);
                }
            });

            setCardImage(singleCard, cards.get(i));
            thirdPlayerView.addView(singleCard);
        }
    }

    public void createFourthPlayerView(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, pixelToDip(54));
            params.setMargins(0, i * pixelToDip(20), 0, 0);

            final ImageView singleCard = new ImageView(context);
            singleCard.setLayoutParams(params);

            singleCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameUIHelper.setAsSelectedCard(singleCard);
                   /* if (singleCard.getForeground() == getDrawable(0)) {
                        singleCard.setForeground(getDrawable(R.drawable.card_borders));
                    } else
                        singleCard.setForeground(getDrawable(0));*/
                }
            });

            setCardImage(singleCard, cards.get(i));
            fourthPlayerView.addView(singleCard);
        }
    }

    public void setTableView(ArrayList<Card> cards) {
        for (tableCardCounter = 0; tableCardCounter < cards.size(); tableCardCounter++) {
            setCardImage(tableCards.get(tableCardCounter), cards.get(tableCardCounter));
            tableCards.get(tableCardCounter).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameUIHelper.setAsSelectedCard(tableCards.get(tableCardCounter));
                }
            });
        }
    }

    private int pixelToDip(int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
    }

    private void setCardImage(ImageView cardImage, Card card) {
        cardImage.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(Card.getCardBitmap(card), "drawable", context.getPackageName())));
    }
}
