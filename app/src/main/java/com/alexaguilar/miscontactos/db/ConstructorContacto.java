package com.alexaguilar.miscontactos.db;

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
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.user1, "Alejandro Aguilar","99998888","downvieri@gmail.com", 1 ));
        contactos.add(new Contacto(R.drawable.user2, "Pedro Sanchez","22298888","pedro@gmail.com", 2));
        contactos.add(new Contacto(R.drawable.user3, "Ana Perez", "11198888", "ana@gmail.com", 1));
        contactos.add(new Contacto(R.drawable.user4, "Luis Cabrera", "00098888", "luis@gmail.com", 3));

        return contactos;
    }
}
