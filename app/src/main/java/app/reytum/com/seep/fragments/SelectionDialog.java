package app.reytum.com.seep.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import app.reytum.com.seep.R;
import app.reytum.com.seep.activities.MainActivity;
import app.reytum.com.seep.game.DealCards;
import app.reytum.com.seep.game.Player;

/**
 * Created by reytum on 5/9/16.
 */
public class SelectionDialog extends DialogFragment {

    private View view;
    private LinearLayout dealButtonLayout;
    private LinearLayout askACardMainLayout;
    private DealCards dealCards;

    public SelectionDialog() {
    }

    public static SelectionDialog newInstance() {

        SelectionDialog frag = new SelectionDialog();
        /*Bundle args = new Bundle();
        args.putString("type", title);
        frag.setArguments(args);*/
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.deal_button_layout, container);
        Button dealButton = (Button) view.findViewById(R.id.dealCards);

        dealCards = ((MainActivity) getActivity()).dealCards;

        Window window = this.getDialog().getWindow();

        dealButtonLayout = (LinearLayout) view.findViewById(R.id.dealButtonLayout);
        askACardMainLayout = (LinearLayout) view.findViewById(R.id.askACardMainLayout);

        if (!dealCards.getTableDealtCards().isEmpty()) {
        }

        // after that, setting values for x and y works "naturally"
        /*WindowManager.LayoutParams params = window.getAttributes();
        params.x = 300;
        params.y = 100;
        window.setAttributes(params);*/
        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                dealCards.dealOpeningCards();
                dealCards.dealTableCards();

                Player player = new Player(getActivity());

                player.createFirstPlayerView(dealCards.getPlayerOneCards());

                AskACardSelectorDialog askACardSelectorDialog = AskACardSelectorDialog.getInstance();
                askACardSelectorDialog.show(getActivity().getSupportFragmentManager(), "ask_a_card");

                player.createSecondPlayerView(dealCards.getPlayerTwoCards());
                player.createThirdPlayerView(dealCards.getPlayerThreeCards());
                player.createFourthPlayerView(dealCards.getPlayerFourCards());
                player.setTableView(dealCards.getTableDealtCards());
            }
        });

        // set "origin" to top left corner, so to speak
        window.setGravity(Gravity.BOTTOM);
        //window.setBackgroundDrawableResource(R.drawable.dialog_fragment_shape);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
