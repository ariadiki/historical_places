package com.example.historicalplaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import Adapter.Place_Adapter;
import Model.Place;

public class MainActivity extends AppCompatActivity {
    private static final String KEY = "share";
    private ListView listView;
    ArrayList<Place> list = new ArrayList<>();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        sharedPreferences = getSharedPreferences(KEY, Context.MODE_PRIVATE);

        list.add(new Place(R.string.place1,R.drawable.bahia));
        list.add(new Place(R.string.place2,R.drawable.toubkal));
        list.add(new Place(R.string.place3,R.drawable.hassan2));
        list.add(new Place(R.string.place4,R.drawable.ouzoud));
        list.add(new Place(R.string.place5,R.drawable.kasbah));
        list.add(new Place(R.string.place6,R.drawable.fna));
        list.add(new Place(R.string.place7,R.drawable.chefchaouen));
        load();
    }
    public void load()
    {
        Place_Adapter adapter = new Place_Adapter(list,getApplicationContext());
        listView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setRate(sharedPreferences.getInt("rate"+i,0));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < list.size(); i++) {
            sharedPreferences.edit().putInt("rate"+i,list.get(i).getRate()).apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.clear:
                for (int i = 0; i < list.size(); i++) {
                    sharedPreferences.edit().remove("rate"+i).commit();
                    list.get(i).initial();
                    load();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}