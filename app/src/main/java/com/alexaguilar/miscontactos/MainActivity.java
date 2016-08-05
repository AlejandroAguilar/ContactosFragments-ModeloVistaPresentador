package com.alexaguilar.miscontactos;

//import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/*

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;
*/

import com.alexaguilar.miscontactos.adapter.ContactoAdaptador;
import com.alexaguilar.miscontactos.adapter.PageAdapter;
import com.alexaguilar.miscontactos.fragment.PerfilFragment;
import com.alexaguilar.miscontactos.fragment.RecyclerViewFragment;
import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Toast.makeText(this,"Antes",Toast.LENGTH_SHORT).show();

        //setSupportActionBar(miActionBar);





        if ( toolBar != null ){
            setSupportActionBar(toolBar);
        }



        agregarFragments();
        setUpViewPager();

    }

    /* antes
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }*/


    // Nuevo
    /* */
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        //ArrayList fragments = new ArrayList<>();

        //Toast.makeText(this,"Aqui",Toast.LENGTH_SHORT).show();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }


    private void setUpViewPager(){
        //Toast.makeText(this,"Alla",Toast.LENGTH_SHORT).show();
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_hat);

    }




}
