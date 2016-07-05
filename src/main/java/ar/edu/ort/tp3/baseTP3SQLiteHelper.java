package ar.edu.ort.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 41471933 on 5/7/2016.
 */
public class baseTP3SQLiteHelper extends SQLiteOpenHelper {
    public  baseTP3SQLiteHelper(Context contexto, String Nombre, SQLiteDatabase.CursorFactory fabrica,int Version) {
        super(contexto,Nombre, fabrica, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase basededatos) {
        String sqlCrearTablaJugadas;
        sqlCrearTablaJugadas= "create table jugadas (username text, secuencia text, jugada integer)";
        basededatos.execSQL(sqlCrearTablaJugadas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase basededatos, int i, int i1) {

    }
}
