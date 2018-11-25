package com.example.raiza.semanacomputacao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ListaInicialParticipante {

    public static void getInstance(SQLiteDatabase db) {
        Cursor c = SemCompDbHelper.getCursorParticipante(db);
            if(!c.moveToPosition(0)){
                SemCompDbHelper.InserirParticipante(db,"Rodrigo Pituba de Souza","rodrigopituba@inventado.com","111.111.111-11");
                SemCompDbHelper.InserirParticipante(db,"Raiza Campos","raiza@inventado.com","222.222.222-22");
                SemCompDbHelper.InserirParticipante(db,"Bruno","bruno@inventado.com","333.333.333-33");
            }
    }
}
