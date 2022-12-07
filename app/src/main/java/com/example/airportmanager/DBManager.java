package com.example.airportmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.classes.Vole;

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

        sqLiteDatabase.execSQL("create table pilote (" +
                "ID integer primary key not null," +
                "nom text," +
                "prenom text," +
                "age int," +
                "experience int )"
        );


        sqLiteDatabase.execSQL("create table vole (" +
                "ID integer primary key not null," +
                "depart text," +
                "destination text," +
                "date text," +
                "pilote text," +
                "avion text )"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    ///////////////////////////////////////////// avion

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

    public Avion modifierAvion(Avion v){
        ContentValues cv= new ContentValues();
        cv.put("ID", v.getID());
        cv.put("nom", v.getNom());
        cv.put("capacite", v.getCapacite());
        cv.put("entreprise", v.getEntreprise());
        SQLiteDatabase q = getWritableDatabase();
        q.update("avion",cv,"ID=?", new String[]{v.getID()+""});
        q= getReadableDatabase();
        Cursor c = q.rawQuery("select * from avion where ID like ? ",new String[]{""+v.getID()});
        Avion newV = null;
        while (c.moveToNext())
            newV = new Avion(c.getInt(0),c.getString(1),c.getInt(2), c.getString(3));
        return newV;
    }

    public boolean supprimerAvion(int ID){
        SQLiteDatabase q = getWritableDatabase();
        return q.delete("avion","ID=?",new String[]{Integer.toString(ID)}) > 0 ;

    }

    public ArrayList<Avion> viderAvions(){
        SQLiteDatabase q = getWritableDatabase();
        q.execSQL("delete from avion");
        return loadAvions();
    }

////////////////////////////////////////////////// vole

    public ArrayList<Vole> loadVoles(){
        ArrayList<Vole>  voles = new ArrayList<Vole>() ;
        SQLiteDatabase q = getWritableDatabase();
        Cursor c = q.rawQuery("select * from vole where 1 like ? ",new String[]{"%"+1+"%"});
        while (c.moveToNext())
            voles.add(new Vole(c.getInt(0),c.getString(1),c.getString(2), c.getString(3), c.getString(4),  c.getString(5)));

        return voles;
    }

    public ArrayList<Vole> ajouterVole(Vole a){
        SQLiteDatabase q = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", a.getID());
        cv.put("depart", a.getDepart());
        cv.put("destination", a.getDestination());
        cv.put("date", a.getDate());
        cv.put("avion", a.getAvion());
        cv.put("pilote", a.getPilote());
        q.insert("vole", null,cv);
        return loadVoles();
    }


    public Vole modifierVole(Vole v){
        ContentValues cv= new ContentValues();
        cv.put("ID", v.getID());
        cv.put("depart", v.getDepart());
        cv.put("destination", v.getDestination());
        cv.put("date", v.getDate());
        cv.put("avion", v.getAvion());
        cv.put("pilote", v.getPilote());
        SQLiteDatabase q = getWritableDatabase();
        q.update("vole",cv,"ID=?", new String[]{v.getID()+""});
        q= getReadableDatabase();
        Cursor c = q.rawQuery("select * from vole where ID like ? ",new String[]{""+v.getID()});
        Vole newV = null;
        while (c.moveToNext())
            newV = new Vole(c.getInt(0),c.getString(1),c.getString(2), c.getString(3), c.getString(4), c.getString(5));
        return newV;
    }


    public boolean supprimerVole(int ID){
        SQLiteDatabase q = getWritableDatabase();
        return q.delete("vole","ID=?",new String[]{Integer.toString(ID)}) > 0 ;

    }

    public ArrayList<Vole> viderVoles(){
        SQLiteDatabase q = getWritableDatabase();
        q.execSQL("delete from vole");
        return loadVoles();
    }

    ////////////////////////////////////////////////// pilote

    public ArrayList<Pilote> loadPilotes(){
        ArrayList<Pilote>  pilotes = new ArrayList<Pilote>() ;
        SQLiteDatabase q = getWritableDatabase();
        Cursor c = q.rawQuery("select * from pilote where 1 like ? ",new String[]{"%"+1+"%"});
        while (c.moveToNext())
            pilotes.add(new Pilote(c.getInt(0),c.getString(1),c.getString(2), c.getInt(3), c.getInt(4)));

        return pilotes;
    }

    public ArrayList<Pilote> ajouterPilote(Pilote p){
        SQLiteDatabase q = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", p.getID());
        cv.put("nom", p.getNom());
        cv.put("prenom", p.getPrenom());
        cv.put("age", p.getAge());
        cv.put("experience", p.getExperience());
        q.insert("pilote", null,cv);
        return loadPilotes();
    }

    public Pilote modifierPilote(Pilote p){
        ContentValues cv= new ContentValues();
        cv.put("ID", p.getID());
        cv.put("nom", p.getNom());
        cv.put("prenom", p.getPrenom());
        cv.put("age", p.getAge());
        cv.put("experience", p.getExperience());
        SQLiteDatabase q = getWritableDatabase();
        q.update("pilote",cv,"ID=?", new String[]{p.getID()+""});
        q= getReadableDatabase();
        Cursor c = q.rawQuery("select * from pilote where ID like ? ",new String[]{""+p.getID()});
        Pilote newP = null;
        while (c.moveToNext())
            newP = new Pilote(c.getInt(0),c.getString(1),c.getString(2), c.getInt(3), c.getInt(4));
        return newP;
    }

    public boolean supprimerPilote(int ID){
        SQLiteDatabase q = getWritableDatabase();
        return q.delete("pilote","ID=?",new String[]{Integer.toString(ID)}) > 0 ;

    }


    public ArrayList<Pilote> viderPilotes(){
        SQLiteDatabase q = getWritableDatabase();
        q.execSQL("delete from pilote ");
        return loadPilotes();
    }

}
