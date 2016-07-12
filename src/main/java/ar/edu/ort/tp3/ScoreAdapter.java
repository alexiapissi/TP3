package ar.edu.ort.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 41471933 on 21/6/2016.
 */
public class ScoreAdapter extends BaseAdapter {

    ArrayList<Jugada> jugadas;
    Context context;

    public ScoreAdapter(Context context, ArrayList<Jugada> jugadas){
        this.context = context;
        this.jugadas=jugadas;
    }

    @Override
    public int getCount() {
        return jugadas.size();
    }

    @Override
    public Object getItem(int i) {
        return jugadas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
        }

        TextView usernameTV = (TextView)view.findViewById(R.id.username);
        TextView secuenciaTV = (TextView)view.findViewById(R.id.secuencia);
        TextView jugadaTV = (TextView)view.findViewById(R.id.jugada);

        Jugada j = jugadas.get(position);
        usernameTV.setText(String.valueOf(j.getUsername()));
        secuenciaTV.setText("Secuencia: "+j.getSecuencia());
        jugadaTV.setText("Jugadas: "+String.valueOf(j.getJugada()));
        return view;
    }
}
