package com.example.twoactivitylifecyclecodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Items extends AppCompatActivity {
    public Button item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void additem(View view) {
        Intent intent = new Intent();
        item = (Button) view;
        String buttonText = item.getText().toString();
        intent.putExtra("item_id",buttonText);
        setResult(RESULT_OK,intent);
        finish();
    }
}