package com.example.ex11062;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner sP;
    TextView tV;
    Costume[] costumes;
    CostumeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sP = findViewById(R.id.sP);
        tV = findViewById(R.id.tV);

        initData();

        adapter = new CostumeAdapter(this, costumes);
        sP.setAdapter(adapter);

        sP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Costume selected = costumes[position];

                StringBuilder builder = new StringBuilder();
                builder.append("Accessories needed for ").append(selected.getName()).append(":\n");

                for (String accessory : selected.getAccessories()) {
                    builder.append("- ").append(accessory).append("\n");
                }

                tV.setText(builder.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tV.setText("");
            }
        });
    }

    private void initData() {
        costumes = new Costume[7];

        costumes[0] = new Costume(R.drawable.clown, "Clown", 2, "Funny",
                new String[]{"Red Nose", "Big Shoes", "Wig", "Makeup"});

        costumes[1] = new Costume(R.drawable.pirate, "Pirate", 3, "History",
                new String[]{"Eye Patch", "Sword", "Parrot", "Hat"});

        costumes[2] = new Costume(R.drawable.doctor, "Doctor", 1, "Profession",
                new String[]{"Stethoscope", "White Coat", "Mask"});

        costumes[3] = new Costume(R.drawable.superman, "Superman", 5, "Superhero",
                new String[]{"Cape", "Red Boots", "S Symbol"});

        costumes[4] = new Costume(R.drawable.princess, "Princess", 2, "Fairytale",
                new String[]{"Crown", "Dress", "Wand", "Glass Slippers"});

        costumes[5] = new Costume(R.drawable.wizard, "Wizard", 4, "Fantasy",
                new String[]{"Wand", "Cloak", "Pointy Hat", "Spellbook"});

        costumes[6] = new Costume(R.drawable.police, "Police", 2, "Profession",
                new String[]{"Badge", "Uniform", "Hat", "Whistle"});
    }
}