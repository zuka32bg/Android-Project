package com.example.cs330_pz;



import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String s1[], s2[];
    int images [] = {R.drawable.espumisal,R.drawable.diklofen,R.drawable.rapidols,R.drawable.panadol,R.drawable.nimulid,R.drawable.brufen,R.drawable.xyzal};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_listalekova);

         recyclerView = findViewById(R.id.recyclerView);

         s1 = getResources().getStringArray(R.array.lista_lekova);
        s2 = getResources().getStringArray(R.array.opis_lekova);


        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
          recyclerView.setAdapter(myAdapter);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

