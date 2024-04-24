package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("香蕉");
        list.add("橘子");
        list.add("芭樂");
        list.add("西瓜");
        list.add("葡萄");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        TextView tvshow = findViewById(R.id.tvshow);
        ListView lvFruit = findViewById(R.id.lvFruit);
        lvFruit.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        spinner.setAdapter(adapter);
        lvFruit.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvshow.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                tvshow.setText(list.get(position));
                String s = "";
                for (int i = 0; i < list.size();i++){
                    if (lvFruit.isItemChecked(i)){
                        s += list.get(i) + " ";
                    }
                }
                tvshow.setText(s);
            }
        });

    }

}