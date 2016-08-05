package com.alexaguilar.miscontactos.fragment;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.alexaguilar.miscontactos.R;
import com.alexaguilar.miscontactos.adapter.ContactoAdaptador;
import com.alexaguilar.miscontactos.pojo.Contacto;
import com.alexaguilar.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.alexaguilar.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Alex on 28/07/16.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        //inicializarListaContactos();
        //inicializarAdaptador();
        //inicializarAdaptadorRV();

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }


    /*
    //public void inicializarListaContactos(){
    public void inicializarDatos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.user1, "Alejandro Aguilar","99998888","downvieri@gmail.com", 1));
        contactos.add(new Contacto(R.drawable.user2,"Pedro Sanchez","22298888","pedro@gmail.com", 2));
        contactos.add(new Contacto(R.drawable.user3, "Ana Perez", "11198888", "ana@gmail.com", 1));
        contactos.add(new Contacto(R.drawable.user4, "Luis Cabrera", "00098888", "luis@gmail.com", 3));
    }
    */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        ///GridLayoutManager glm = new GridLayoutManager(this, 2);
        ///listaContactos.setLayoutManager(glm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {

        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
