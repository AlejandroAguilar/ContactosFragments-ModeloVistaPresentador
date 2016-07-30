package com.alexaguilar.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexaguilar.miscontactos.pojo.Contacto;
import com.alexaguilar.miscontactos.DetalleContacto;
import com.alexaguilar.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by Alex on 21/07/16.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    /*
    // antes
    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }
    */

    /* */
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }



    // Inflar el layout y lo pasara al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolderholder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolderholder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolderholder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolderholder.tvTelenoCV.setText(contacto.getTelefono());

        // On click
        /* */
        contactoViewHolderholder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();

                // Intent para Detalle contacto
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);

            }
        });


    }






    @Override
    public int getItemCount() {   // cantidad de elemenos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelenoCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelenoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);

        }
    }

}
