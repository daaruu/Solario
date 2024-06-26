package com.example.solario;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static customAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Adapter view
        listView = findViewById(R.id.listview);

        // Data Source
        planetArrayList = new ArrayList<>();

        Planet p1 = new Planet("Mercury", "0 Moons", R.drawable.mercury, "Mercury is the smallest planet in our solar system, and the nearest to the Sun.");
        Planet p2 = new Planet("Venus", "0 Moons", R.drawable.venus,"Venus is the second planet from the Sun, and Earth's closest planetary neighbor.");
        Planet p3 = new Planet("Earth", "1 Moons", R.drawable.earth, "Earth – our home planet – is the third planet from the Sun, and the fifth largest planet.");
        Planet p4 = new Planet("Mars", "2 Moons", R.drawable.mars ," Mars – the fourth planet from the Sun – is a dusty, cold, desert world with a very thin atmosphere."
        );
        Planet p5 = new Planet("Jupiter", "95 Moons", R.drawable.jupiter,"Jupiter is the largest planet in our solar system – if it were a hollow shell, 1,000 Earths could fit inside.");
        Planet p6 = new Planet("Saturn", "146 Moons", R.drawable.saturn,"Saturn is the sixth planet from the Sun, the second-largest planet in our solar system.");
        Planet p7 = new Planet("Uranus", "28 Moons", R.drawable.uranus,"The seventh planet from the Sun, Uranus has the third largest diameter of planets in our solar system.");
        Planet p8 = new Planet("Neptune", "16 Moons", R.drawable.neptune,"Neptune is the eighth and most distant planet in our solar system.");


        planetArrayList.add(p1);
        planetArrayList.add(p2);
        planetArrayList.add(p3);
        planetArrayList.add(p4);
        planetArrayList.add(p5);
        planetArrayList.add(p6);
        planetArrayList.add(p7);
        planetArrayList.add(p8);

        adapter = new customAdapter(planetArrayList, getApplicationContext());

        listView.setAdapter(adapter)
        ;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planet clickedPlanet = planetArrayList.get(position);
                String message = clickedPlanet.getDescription();

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }

        });
    }
}