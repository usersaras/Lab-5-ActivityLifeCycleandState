package com.example.twoactivitylifecyclecodingchallenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public HashMap<String, Integer> map;
    private TextView item;
    private int list_order = 0;
    public static final int confirmation = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<String, Integer>();
    }

    public void showitems(View view) {
    Intent intent = new Intent(this,Items.class);
    startActivityForResult(intent,confirmation);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(confirmation == requestCode)
            if (resultCode == RESULT_OK) {
             String item_name = data.getStringExtra("item_id");
             if(!map.containsKey(item_name)){
                 list_order++;
                 map.put(item_name,list_order);
             }
             showitemlist();
            }
    }

    public void showitemlist(){
        for(HashMap.Entry<String,Integer> list : map.entrySet()){
            String item_name = list.getKey();
            int show_order = list.getValue();
            switch (show_order){
                case 1:
                    item = findViewById(R.id.item1);
                    break;
                case 2:
                    item = findViewById(R.id.item2);
                    break;
                case 3:
                    item = findViewById(R.id.item3);
                    break;
                case 4:
                    item = findViewById(R.id.item4);
                    break;
                case 5:
                    item = findViewById(R.id.item5);
                    break;
                case 6:
                    item = findViewById(R.id.item6);
                    break;
                case 7:
                    item = findViewById(R.id.item7);
                    break;
                case 8:
                    item = findViewById(R.id.item8);
                    break;
                case 9:
                    item = findViewById(R.id.item9);
                    break;
                case 10:
                    item = findViewById(R.id.item10);
                    break;
                default:
                    break;
            }
            item.setText(show_order+". "+item_name);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("item_list",map);
        outState.putInt("item_showorder",list_order);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            if(map.isEmpty()){
                list_order = savedInstanceState.getInt("item_showorder");
                map =(HashMap<String, Integer>) savedInstanceState.getSerializable("item_list");
                showitemlist();
            }
        }
    }
}
