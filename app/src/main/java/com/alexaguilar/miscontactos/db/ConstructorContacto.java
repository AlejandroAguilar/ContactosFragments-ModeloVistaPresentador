package com.alexaguilar.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.alexaguilar.miscontactos.R;
import com.alexaguilar.miscontactos.pojo.Contacto;
import java.util.ArrayList;


/**
 * Created by Alex on 04/08/16.
 */

// Clase interactor
// Clase que consulta la BD

public class ConstructorContacto {

    private Context context;
    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        /*
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.user1, "Alejandro Aguilar","99998888","downvieri@gmail.com", 1 ));
        contactos.add(new Contacto(R.drawable.user2, "Pedro Sanchez","22298888","pedro@gmail.com", 2));
        contactos.add(new Contacto(R.drawable.user3, "Ana Perez", "11198888", "ana@gmail.com", 1));
        contactos.add(new Contacto(R.drawable.user4, "Luis Cabrera", "00098888", "luis@gmail.com", 3));

        return contactos;
        */


        BaseDatos db = new BaseDatos(context);

        insertarTresContactos(db);

        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Alex A");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "2345643");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "alex@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.user1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Pedro G");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "65143434");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "pedro@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.user2);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Luis R");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "2345643");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "luis@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.user3);

        db.insertarContacto(contentValues);


    }
}
