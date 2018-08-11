package com.example.iossenac.appbd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.iossenac.appbd.bd.BancoDadoOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testeInsert();
        testeSelect();
    }

    private void testeInsert() {
        BancoDadoOpenHelper helper = new BancoDadoOpenHelper(this);
        SQLiteDatabase banco = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome","Fulano");
        values.put("email","fulano@mail.com");
        banco.insert("pessoa",null,values);

        ContentValues values2 = new ContentValues();
        values2.put("nome","Sicrano");
        values2.put("email","sicrano@mail.com");
        banco.insert("pessoa",null,values2);

        ContentValues values3 = new ContentValues();
        values3.put("nome","Beltrano");
        values3.put("email","beltrano@mail.com");
        banco.insert("pessoa",null,values3);

    }

    private void testeSelect() {
        BancoDadoOpenHelper helper = new BancoDadoOpenHelper(this);
        SQLiteDatabase banco = helper.getReadableDatabase();

        String[] colunas = new String[]{"id", "nome", "email"};

        Cursor cursor = banco.query("pessoa",colunas,null,null,null,null,null);

        while(cursor.moveToNext()){
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            Log.d("BD",nome+"-"+email);
        }
        cursor.close();
    }
}
