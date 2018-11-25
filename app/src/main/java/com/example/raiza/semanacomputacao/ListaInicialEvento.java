package com.example.raiza.semanacomputacao;



import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ListaInicialEvento {

    public static void getInstance(SQLiteDatabase db) {
        Cursor c = SemCompDbHelper.getCursorEventos(db);
        if(!c.moveToPosition(0)){
            SemCompDbHelper.InserirEvento(db,"Ciências de Dados e Aplicações em Bancos","10/10/2010","11:00","Tales Lima","Os clientes bancários movimentam uma grande parcela da economia brasileira, a 8ª maior economia do mundo, gerando uma grande quantidade de dados que são utilizados para atender cada vez melhor os seus clientes.");
            SemCompDbHelper.InserirEvento(db,"Como lidar com grande volume de dados no dia-a-dia","11/11/2011","11:00","Frederick Moschkowich","Muito se fala em persistência e consistência de dados, mas como isso funciona no dia-a-dia da Indústria?");
            //SemCompDbHelper.InserirParticipanteEvento(db,"0","2");
            //SemCompDbHelper.InserirParticipanteEvento(db,"0","3");
            //SemCompDbHelper.InserirParticipanteEvento(db,"1","0");
            //SemCompDbHelper.InserirParticipanteEvento(db,"2","1");
        }

    }

}
