package ar.edu.ort.tp3;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by 41471933 on 28/6/2016.
 */
public class ColoresDialog extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colores, container);

        ArrayAdapter<String> colorAdapter;
        final MainActivity mainActivity  = (MainActivity) getActivity(); // Politicamente incorrecto
        final Button btnOK = (Button) view.findViewById(R.id.btnOK);
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //codigo cambia color
                int color = spinner.getSelectedItemPosition();
                ((MainActivity) getActivity()).setColor(color);
                Log.d("Click","OK");
                dismiss();
            }
        });
        ArrayList<String> colores = new ArrayList<>();
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Verde");
        colores.add("Rosa");
        colores.add("Celeste");


        colorAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, colores);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(colorAdapter);
        getDialog().setTitle("Seleccione el color");

        return view;
    }
}
