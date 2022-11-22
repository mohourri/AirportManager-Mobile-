package com.example.airportmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.airportmanager.classes.Avion;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {


    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table avion (" +
                "ID integer primary key not null," +
                "nom text," +
                "capacite int," +
                "entreprise text )"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Avion> loadAvions(){
        ArrayList<Avion>  avs = new ArrayList<Avion>() ;
        SQLiteDatabase q = getWritableDatabase();
        Cursor c = q.rawQuery("select * from avion where 1 like ? ",new String[]{"%"+1+"%"});
        while (c.moveToNext())
            avs.add(new Avion(c.getInt(0),c.getString(1), c.getInt(2), c.getString(3)));

        return avs;
    }

    public ArrayList<Avion> ajouterAvion(Avion a){
        SQLiteDatabase q = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", a.getID());
        cv.put("nom", a.getNom());
        cv.put("capacite", a.getCapacite());
        cv.put("entreprise", a.getEntreprise());
        q.insert("avion", null,cv);
        return loadAvions();
    }
}
