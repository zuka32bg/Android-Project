package com.example.cs330_pz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> lista;
    ArrayAdapter<String> adapter;
    SearchView pregled;
    ListView listalekova;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pregled = (SearchView) findViewById(R.id.txtsrc);
        listalekova = (ListView) findViewById(R.id.recylview);

        lista = new ArrayList<String>();
        lista.add("Espumisal");
        lista.add("Diklofen");
        lista.add("Rapidol S");
        lista.add("Panadol");
        lista.add("Nimulid");
        lista.add("Brufen");
        lista.add("Anbol");
        lista.add("Paracetamol");
        lista.add("Bensedin");
        lista.add("Glaumol");
        lista.add("Xyzal");


        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listalekova.setAdapter(adapter);
        pregled.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
               adapter.getFilter().filter(s);
                return false;
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }else
        if(id == R.id.action_lokacija) {
            Intent intent = new Intent(MainActivity.this, LokacijaActivity.class);
            startActivity(intent);
            return true;
        }else
        if(id == R.id.action_lista) {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

