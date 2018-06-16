package com.example.salomoncastro.beta03;

import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Notice> lstNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstNotice = new ArrayList<>();
        lstNotice.add(new Notice("League of Legends","MOBA","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Ovewatch","MOBA","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Fortnite","FPS","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Zelda","Adventure","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("League of Legends","MOBA","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Ovewatch","MOBA","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Fortnite","FPS","Descripcion de juego",R.drawable.prueba));
        lstNotice.add(new Notice("Zelda","Adventure","Descripcion de juego",R.drawable.prueba));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstNotice);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    //DE ACA PARA ABAJOA LO DE BUSCAR XD

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        newText = newText.toLowerCase();
        ArrayList<Notice> newList = new ArrayList<>();
        for(Notice notice : lstNotice){

            String name = notice.getTitle().toLowerCase();
            if(name.contains(newText))

                newList.add(notice);

        }


        return true;
    }
}
