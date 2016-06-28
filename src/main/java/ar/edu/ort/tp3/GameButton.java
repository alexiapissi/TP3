package ar.edu.ort.tp3;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created by 41471933 on 21/6/2016.
 */
public class GameButton extends ImageButton {
    public boolean checked;
    Random random;

    public GameButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        random = new Random();
        this.checked = random.nextBoolean();
        pintar();
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private void pintar() {
        if(checked) {
            this.setImageResource(R.drawable.ic_location_on_black_24dp);
        }else{
            this.setImageResource(R.drawable.ic_color_lens_black_24dp);
        }
    }

    public void flip()
    {
        checked = !checked;
        pintar();
    }

    public void reset(){
        this.checked = random.nextBoolean();
        pintar();
    }
}

