package com.example.firsttry;

import static com.example.firsttry.MainActivity.text_money;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Saved extends AppCompatActivity {

    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    public Saved() {};
    public static void  init(Context context) {
        if (preferences == null){
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    void save() {
        editor.putInt("money", MainActivity.countMoney);
        editor.putInt("price1", Improve.price1);
        editor.putInt("price2", Improve.price2);
        editor.putInt("moneyplus", MainActivity.money);
        editor.commit();
    }
    void load_save() {
        MainActivity.countMoney = preferences.getInt("money", 0);
        Improve.price1 = preferences.getInt("price1", 50);
        Improve.price2 = preferences.getInt("price2", 100);
        MainActivity.money = preferences.getInt("moneyplus", 1);
        text_money.setText(MainActivity.countMoney + "");
    }
}
