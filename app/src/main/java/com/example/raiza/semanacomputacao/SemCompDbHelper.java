package com.example.raiza.semanacomputacao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SemCompDbHelper extends  SQLiteOpenHelper{

    public final static int DATABASE_VERSION = 1;
    public final static String  DATABASE_NAME = "SemComp.db";

    public SemCompDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SemCompContract.Evento.DROP_Evento);
        db.execSQL(SemCompContract.Participante.DROP_Participante);
        db.execSQL(SemCompContract.EventoParticipante.DROP_EventoParticipante);
        db.execSQL(SemCompContract.Evento.CREATE_Evento);
        db.execSQL(SemCompContract.Participante.CREATE_Participante);
        db.execSQL(SemCompContract.EventoParticipante.CREATE_EventoParticipante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SemCompContract.Evento.DROP_Evento);
        db.execSQL(SemCompContract.Participante.DROP_Participante);
        db.execSQL(SemCompContract.EventoParticipante.DROP_EventoParticipante);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }

    public static void InserirParticipante(SQLiteDatabase db,String nome, String email, String cpf){
        ContentValues values = new ContentValues();
        values.put(SemCompContract.Participante.COLUMN_NAME_NOME,nome);
        values.put(SemCompContract.Participante.COLUMN_NAME_EMAIL,email);
        values.put(SemCompContract.Participante.COLUMN_NAME_CPF,cpf);
        long id = db.insert(SemCompContract.Participante.TABLE_NAME,null, values);
        values.put(SemCompContract.Participante._ID, Long.valueOf(id));
        Log.i("DBINFO","registro criado com id: " + id);
    }

    public static void InserirParticipanteEvento(SQLiteDatabase db,String idParticipante, String idEvento){
        ContentValues values = new ContentValues();
        values.put(SemCompContract.EventoParticipante.COLUMN_NAME_PARTICIPANTE,idParticipante);
        values.put(SemCompContract.EventoParticipante.COLUMN_NAME_EVENTO,idEvento);
        long id = db.insert(SemCompContract.EventoParticipante.TABLE_NAME,null, values);
        values.put(SemCompContract.EventoParticipante._ID, Long.valueOf(id));
        Log.i("DBINFO","registro criado com id: " + id);
    }

    public static void InserirEvento(SQLiteDatabase db,String titulo, String data, String hora, String facilitador, String descricao){
        ContentValues values = new ContentValues();
        values.put(SemCompContract.Evento.COLUMN_NAME_TITULO,titulo);
        values.put(SemCompContract.Evento.COLUMN_NAME_DATA,data);
        values.put(SemCompContract.Evento.COLUMN_NAME_HORA,hora);
        values.put(SemCompContract.Evento.COLUMN_NAME_FACILITADOR, facilitador);
        values.put(SemCompContract.Evento.COLUMN_NAME_DESCRICAO,descricao);
        long id = db.insert(SemCompContract.Evento.TABLE_NAME,null, values);
        values.put(SemCompContract.Evento._ID, Long.valueOf(id));
        Log.i("DBINFO","registro criado com id: " + id);
    }

    public static Cursor getCursorEventos(SQLiteDatabase db) {
        String[] visao = {
                SemCompContract.Evento._ID,
                SemCompContract.Evento.COLUMN_NAME_TITULO
        };
        return db.query(
                SemCompContract.Evento.TABLE_NAME,
                visao,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public static Cursor getCursorParticipante(SQLiteDatabase db) {
        String[] visao = {
                SemCompContract.Participante._ID,
                SemCompContract.Participante.COLUMN_NAME_NOME
        };
        return db.query(
                SemCompContract.Participante.TABLE_NAME,
                visao,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public static Cursor getCursorParticipanteId(SQLiteDatabase db,String id) {

        String[] visao = {
                SemCompContract.Participante._ID,
                SemCompContract.Participante.COLUMN_NAME_NOME,
                SemCompContract.Participante.COLUMN_NAME_CPF,
                SemCompContract.Participante.COLUMN_NAME_EMAIL,
        };
        String select = SemCompContract.Participante._ID+"=?";
        String[] selectionArgs = {(id)};
        return db.query(
                SemCompContract.Participante.TABLE_NAME,
                visao,
                select,
                selectionArgs,
                null,
                null,
                null,
                null);
    }

    public static Cursor getCursorEventoId(SQLiteDatabase db,String id) {

        String[] visao = {
                SemCompContract.Evento._ID,
                SemCompContract.Evento.COLUMN_NAME_TITULO,
                SemCompContract.Evento.COLUMN_NAME_HORA,
                SemCompContract.Evento.COLUMN_NAME_DATA,
                SemCompContract.Evento.COLUMN_NAME_DESCRICAO,
                SemCompContract.Evento.COLUMN_NAME_FACILITADOR

        };
        String select = SemCompContract.Evento._ID+"=?";
        String[] selectionArgs = {(id)};
        return db.query(
                SemCompContract.Evento.TABLE_NAME,
                visao,
                select,
                selectionArgs,
                null,
                null,
                null,
                null);
    }

    public static Cursor getCursorEventosParticipanteNãoInscrito(SQLiteDatabase db,String id) {

        String[] visao = {
                SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID
        };
        String select = SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID+" =?";
        String[] selectionArgs = {(id)};
        String sql = "SELECT " + SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID+","+SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento.COLUMN_NAME_TITULO +" from " +SemCompContract.Evento.TABLE_NAME +" where "+ SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID + " not in (SELECT " + SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID +" from "+ SemCompContract.Evento.TABLE_NAME + " LEFT JOIN "+ SemCompContract.EventoParticipante.TABLE_NAME +" on " + SemCompContract.Evento.TABLE_NAME +"." +SemCompContract.Evento._ID +" = "  + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_EVENTO
                + " LEFT JOIN "+ SemCompContract.Participante.TABLE_NAME +" on " + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_PARTICIPANTE +" = "  + SemCompContract.Participante.TABLE_NAME +"." +SemCompContract.Participante._ID +" WHERE " + SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID + "=?)";
        return db.rawQuery(sql,selectionArgs);
    }

    public static Cursor getCursorEventosParticipante(SQLiteDatabase db,String id) {

        String[] visao = {
                SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID
        };
        String select = SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID+" =?";
        String[] selectionArgs = {(id)};
        String sql = "SELECT " + SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID +" , "+ SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento.COLUMN_NAME_TITULO +" from "+ SemCompContract.Evento.TABLE_NAME + " LEFT JOIN "+ SemCompContract.EventoParticipante.TABLE_NAME +" on " + SemCompContract.Evento.TABLE_NAME +"." +SemCompContract.Evento._ID +" = "  + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_EVENTO
                + " LEFT JOIN "+ SemCompContract.Participante.TABLE_NAME +" on " + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_PARTICIPANTE +" = "  + SemCompContract.Participante.TABLE_NAME +"." +SemCompContract.Participante._ID +" WHERE " + SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID + "=?";
        return db.rawQuery(sql,selectionArgs);
    }

    public static Cursor getCursorParticipantesEvento(SQLiteDatabase db,String id) {

        String[] visao = {
                SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID
        };
        String select = SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID+" =?";
        String[] selectionArgs = {(id)};
        String sql = "SELECT " + SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante._ID +" , "+ SemCompContract.Participante.TABLE_NAME+"."+SemCompContract.Participante.COLUMN_NAME_NOME +" from "+ SemCompContract.Participante.TABLE_NAME + " LEFT JOIN "+ SemCompContract.EventoParticipante.TABLE_NAME +" on " + SemCompContract.Participante.TABLE_NAME +"." +SemCompContract.Participante._ID +" = "  + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_PARTICIPANTE
                + " LEFT JOIN "+ SemCompContract.Evento.TABLE_NAME +" on " + SemCompContract.EventoParticipante.TABLE_NAME +"." +SemCompContract.EventoParticipante.COLUMN_NAME_EVENTO +" = "  + SemCompContract.Evento.TABLE_NAME +"." +SemCompContract.Evento._ID +" WHERE " + SemCompContract.Evento.TABLE_NAME+"."+SemCompContract.Evento._ID + "=?";
        Log.i("DBINFO", sql);
        Log.i("DBINFO",id);
        return db.rawQuery(sql,selectionArgs);
    }

    public static void UpdateParticipante(SQLiteDatabase db,String id,String nome, String email,String cpf){
        ContentValues values = new ContentValues();
        values.put(SemCompContract.Participante.COLUMN_NAME_NOME, nome);
        values.put(SemCompContract.Participante.COLUMN_NAME_EMAIL, email);
        values.put(SemCompContract.Participante.COLUMN_NAME_CPF, cpf);
        String whereClause = SemCompContract.Participante._ID+"=?";
        String[] whereArgs = {(id)};
        db.update(SemCompContract.Participante.TABLE_NAME,values,whereClause,whereArgs);
    }

    public static void deleteEventoParticipante(SQLiteDatabase db,String idParticipante,String idEvento){
        String select = SemCompContract.EventoParticipante.COLUMN_NAME_PARTICIPANTE+"=? AND " + SemCompContract.EventoParticipante.COLUMN_NAME_EVENTO+"=?";
        String[] selectArgs = {idParticipante,idEvento};
        db.delete(SemCompContract.EventoParticipante.TABLE_NAME,select,selectArgs);
    }
}
