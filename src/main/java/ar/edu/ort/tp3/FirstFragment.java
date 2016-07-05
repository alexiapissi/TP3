package ar.edu.ort.tp3;
import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class FirstFragment extends Fragment implements View.OnClickListener {

    public GameButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    public int ganaste=0;
    public int clicks = 0;
    ArrayList<Jugada> listajugadas;
    public String secuencia="";



    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity ma = (MainActivity)getActivity();

        listajugadas= ma.getListajugadas();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        btn1 = (GameButton) view.findViewById(R.id.btn1);
        btn2 = (GameButton) view.findViewById(R.id.btn2);
        btn3 = (GameButton) view.findViewById(R.id.btn3);
        btn4 = (GameButton) view.findViewById(R.id.btn4);
        btn5 = (GameButton) view.findViewById(R.id.btn5);
        btn6 = (GameButton) view.findViewById(R.id.btn6);
        btn7 = (GameButton) view.findViewById(R.id.btn7);
        btn8 = (GameButton) view.findViewById(R.id.btn8);
        btn9 = (GameButton) view.findViewById(R.id.btn9);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.first, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_replay:
                Log.d("Replay", "ison");
                secuencia="";
                clicks=0;
                ganaste=0;
                btn1.reset();
                btn2.reset();
                btn3.reset();
                btn4.reset();
                btn5.reset();
                btn6.reset();
                btn7.reset();
                btn8.reset();
                btn9.reset();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (ganaste==1){

            return;
        }
        switch (view.getId()) {
            case R.id.btn1:
                btn1.flip();
                btn2.flip();
                btn4.flip();
                clicks++;
                secuencia+="1, ";
                break;
            case R.id.btn2:
                btn1.flip();
                btn2.flip();
                btn3.flip();
                btn5.flip();
                secuencia+="2, ";
                clicks++;
                break;
            case R.id.btn3:
                btn2.flip();
                btn3.flip();
                btn6.flip();
                secuencia+="3, ";
                clicks++;
                break;
            case R.id.btn4:
                btn4.flip();
                btn1.flip();
                btn5.flip();
                btn7.flip();
                clicks++;
                secuencia+="4, ";
                break;
            case R.id.btn5:
                btn5.flip();
                btn2.flip();
                btn4.flip();
                btn6.flip();
                btn8.flip();
                clicks++;
                secuencia+="5, ";
                break;
            case R.id.btn6:
                btn6.flip();
                btn3.flip();
                btn9.flip();
                btn5.flip();
                clicks++;
                secuencia+="6, ";
                break;
            case R.id.btn7:
                btn7.flip();
                btn4.flip();
                btn8.flip();
                clicks++;
                secuencia+="7, ";
                break;
            case R.id.btn8:
                btn8.flip();
                btn5.flip();
                btn7.flip();
                btn9.flip();
                clicks++;
                secuencia+="8, ";
                break;
            case R.id.btn9:
                btn9.flip();
                btn8.flip();
                btn6.flip();
                clicks++;
                secuencia+="9, ";
                break;
        }
        if ((btn1.checked == true && btn2.checked == true && btn3.checked == true && btn4.checked == true && btn5.checked == true && btn6.checked == true && btn7.checked == true && btn8.checked == true && btn9.checked == true) || (btn1.checked == false && btn2.checked == false && btn3.checked == false && btn4.checked == false && btn5.checked == false && btn6.checked == false && btn7.checked == false && btn8.checked == false && btn9.checked == false)) {
            Toast toast = Toast.makeText(getActivity(), "¡Ganaste! Movimientos: " + clicks, Toast.LENGTH_SHORT);
            toast.show();
            ganaste=1;
            MainActivity ma = (MainActivity)getActivity();
            Jugada j = new Jugada(ma.getUserName(),secuencia,clicks);
            listajugadas.add(j);
           SQLiteDatabase basedatos= ma.getBasedatos();

            ContentValues nuevoRegistro;
            nuevoRegistro=new ContentValues();
            nuevoRegistro.put("username", j.getUsername());
            nuevoRegistro.put("secuencia", j.getSecuencia());
            nuevoRegistro.put("jugada", j.getJugada());
            basedatos.insert("jugadas",null,nuevoRegistro);
            basedatos.close();
        }
    }
}
