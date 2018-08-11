package com.example.iossenac.appbd.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDadoOpenHelper extends SQLiteOpenHelper {
    public final static String nomeBanco = "appbd.db";
    public final static int VERSION = 1;

    public BancoDadoOpenHelper(Context context) {
        super(context, nomeBanco, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(30), email varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {
        sqLiteDatabase.execSQL("DELETE FROM pessoa");
        onCreate(sqLiteDatabase);
    }
}
