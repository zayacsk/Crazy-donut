package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Improve extends AppCompatActivity {

    static public int countMoney2 = MainActivity.countMoney;
    static public int money_2 = MainActivity.money;

    Button laptop, laptop2, back;
    static public TextView text_money;

    public static int price1 = 50;
    public static int price2 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        laptop = (Button)findViewById(R.id.laptop);
        laptop.setText("Улучшить +1     " + price1 + "");
        text_money = (TextView)findViewById(R.id.money_2);
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.countMoney >= price1) {
                    MainActivity.money += 1;
                    MainActivity.countMoney -= price1;
                    price1 += 50;
                    MainActivity.text_money.setText(MainActivity.countMoney + "");
                    laptop.setText("Улучшить +1     " + price1 + "");
                    new Saved().save();
                }
            }
        });
        laptop2 = (Button)findViewById(R.id.laptop2);
        laptop2.setText("Улучшить +2    " + price2 + "");
        laptop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.countMoney >= price2) {
                    MainActivity.money += 2;
                    MainActivity.countMoney -= price2;
                    price2 += 100;
                    MainActivity.text_money.setText(MainActivity.countMoney + "");
                    laptop2.setText("Улучшить +2    " + price2 + "");
                    new Saved().save();
                }
            }
        });
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Improve.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}