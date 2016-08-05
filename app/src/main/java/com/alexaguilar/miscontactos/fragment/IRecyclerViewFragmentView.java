package com.alexaguilar.miscontactos.fragment;

import com.alexaguilar.miscontactos.adapter.ContactoAdaptador;
import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Alex on 04/08/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
