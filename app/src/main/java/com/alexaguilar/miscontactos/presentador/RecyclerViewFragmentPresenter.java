package com.alexaguilar.miscontactos.presentador;

import android.content.Context;

import com.alexaguilar.miscontactos.adapter.ContactoAdaptador;
import com.alexaguilar.miscontactos.db.ConstructorContacto;
import com.alexaguilar.miscontactos.fragment.IRecyclerViewFragmentView;
import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Alex on 04/08/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContacto constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContacto(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactoRV();
    }

    @Override
    public void mostrarContactoRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
