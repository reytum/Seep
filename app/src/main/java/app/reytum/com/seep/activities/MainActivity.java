package app.reytum.com.seep.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import app.reytum.com.seep.R;
import app.reytum.com.seep.fragments.SelectionDialog;
import app.reytum.com.seep.game.DealCards;

public class MainActivity extends AppCompatActivity {

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

    private RelativeLayout firstPlayerView;
    private RelativeLayout secondPlayerView;
    private RelativeLayout thirdPlayerView;
    private RelativeLayout fourthPlayerView;

    private LinearLayout overlappingLayout;
    private Button dealCardsButton;

    public DealCards dealCards;

    private ArrayList<ImageView> tableCards;
    public SelectionDialog dialog;
    private android.support.v4.app.FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

       /* tableCards = new ArrayList<>();

        tableCard1 = (ImageView) findViewById(R.id.tablecard1);
        tableCards.add(tableCard1);
        tableCard2 = (ImageView) findViewById(R.id.tablecard2);
        tableCards.add(tableCard2);
        tableCard3 = (ImageView) findViewById(R.id.tablecard3);
        tableCards.add(tableCard3);
        tableCard4 = (ImageView) findViewById(R.id.tablecard4);
        tableCards.add(tableCard4);
        tableCard5 = (ImageView) findViewById(R.id.tablecard5);
        tableCards.add(tableCard5);
        tableCard6 = (ImageView) findViewById(R.id.tablecard6);
        tableCards.add(tableCard6);
        tableCard7 = (ImageView) findViewById(R.id.tablecard7);
        tableCards.add(tableCard7);
        tableCard8 = (ImageView) findViewById(R.id.tablecard8);
        tableCards.add(tableCard8);
        tableCard9 = (ImageView) findViewById(R.id.tablecard9);
        tableCards.add(tableCard9);
        tableCard10 = (ImageView) findViewById(R.id.tablecard10);
        tableCards.add(tableCard10);
        tableCard11 = (ImageView) findViewById(R.id.tablecard11);
        tableCards.add(tableCard11);
        tableCard12 = (ImageView) findViewById(R.id.tablecard12);
        tableCards.add(tableCard12);

        firstPlayerView = (RelativeLayout) findViewById(R.id.firstPlayerView);
        secondPlayerView = (RelativeLayout) findViewById(R.id.secondPlayerView);
        thirdPlayerView = (RelativeLayout) findViewById(R.id.thirdPlayerView);
        fourthPlayerView = (RelativeLayout) findViewById(R.id.fourthPlayerView);*/

        dealCards = new DealCards();

        overlappingLayout = (LinearLayout) findViewById(R.id.overlappingLayout);
        dealCardsButton = (Button) findViewById(R.id.dealCards);

        manager = getSupportFragmentManager();

        dialog = SelectionDialog.newInstance();
        dialog.show(manager, "deal_button");
    }
}
