package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static public int countMoney = 0;
    static public int money = 1;
    ImageButton next_day;
    Button improve;
    static public TextView text_money;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_day = (ImageButton) findViewById(R.id.next_day);
        improve = (Button)findViewById(R.id.improve);
        text_money = (TextView)findViewById(R.id.money);
        Saved.init(getApplicationContext());
        new Saved().load_save();
        Next_day();
    }
    void Next_day() {
        next_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMoney += money;
                text_money.setText(countMoney + "");
                new Saved().save();
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });
    }

}