package com.alexaguilar.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Alex on 04/08/16.
 */
public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {




/* */
        String queryCrearTablaContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_CONTACTS + "("+
                                        ConstanteBaseDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, "+
                                        ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, "+
                                        ConstanteBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, "+
                                        ConstanteBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER "+
                                        ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_CONTACT + "(" +
                                        ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, "+
                                        ConstanteBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, "+
                                        "FOREING KEY ("+ ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO +") " +
                                        "REFERENCES "+ ConstanteBaseDatos.TABLE_CONTACTS + "("+ ConstanteBaseDatos.TABLE_CONTACTS_ID +")"+
                                        ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);


        /*
        String queryCrearTablaContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_CONTACTS + "(" +
                ConstanteBaseDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_CONTACT + "(" +
                ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstanteBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstanteBaseDatos.TABLE_CONTACTS + "(" + ConstanteBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST "+ConstanteBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST "+ConstanteBaseDatos.TABLE_LIKES_CONTACT);

        onCreate(db);

    }

    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);
        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_CONTACTS,null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;

        String query = "SELECT COUNT ("+ ConstanteBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES +")" +
                " FROM " + ConstanteBaseDatos.TABLE_LIKES_CONTACT +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " +
                contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if ( registros.moveToNext() ){
            // indice de la columna del resultado del query
          likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }



    /*
    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM "+ConstanteBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        return contactos;
    }
    */


}
