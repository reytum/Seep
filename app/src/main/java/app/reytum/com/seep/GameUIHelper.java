package app.reytum.com.seep;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by reytum on 16/9/16.
 */
public class GameUIHelper {

    private Context context;

    public GameUIHelper(Context context) {
        this.context = context;
    }

    public void setAsSelectedCard(ImageView cardImage) {
        cardImage.setForeground(context.getDrawable(R.drawable.card_borders));
    }

    public static void removeAsSelectedCard(ImageView cardImage) {

    }
}
