package ar.edu.ort.tp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    Jugada j;
    ArrayList<Jugada> listajugadas;
    ListView listVW;
    ScoreAdapter adapter;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        listVW = (ListView) view.findViewById(R.id.listVw);
        MainActivity ma = (MainActivity)getActivity();
        listajugadas=ma.getListajugadas();
        adapter = new ScoreAdapter(getContext(),listajugadas);
        listVW.setAdapter(adapter);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.second,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_delete:
                Log.d("Delete", "ison");
                listajugadas.clear();
                adapter.notifyDataSetChanged();
                adapter = new ScoreAdapter(getContext(),listajugadas);
                break;
        }
        return true;
    }
}