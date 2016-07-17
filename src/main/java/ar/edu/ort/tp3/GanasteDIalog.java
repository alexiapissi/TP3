package ar.edu.ort.tp3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 41824471 on 12/7/2016.
 */
public class GanasteDIalog extends DialogFragment {

    public GanasteDIalog() {
    }
    int clicks;
    public void set_clicks(int click){
        clicks= click;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ganaste, container);

        getDialog().setCanceledOnTouchOutside(false);
        final Button OK = (Button) view.findViewById(R.id.btnOKAY);
        final TextView movimientos = (TextView) view.findViewById(R.id.movimientos);
        MediaPlayer reproductor= MediaPlayer.create(getActivity().getApplicationContext(),R.raw.win);
        reproductor.start();

        set_clicks(clicks);
        movimientos.setText("Movimientos: "+clicks);


        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment ff =(FirstFragment)getTargetFragment();
                ff.reiniciar();
                dismiss();
            }
        });
        getDialog().setTitle("¡Ganaste!");

        return view;
    }

}
