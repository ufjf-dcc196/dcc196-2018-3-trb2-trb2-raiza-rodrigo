package com.example.raiza.semanacomputacao;

import android.provider.BaseColumns;

public class SemCompContract {
    public final class Evento implements BaseColumns {
        public final static String TABLE_NAME = "TB_EVENTOS";
        public final static String COLUMN_NAME_TITULO = "TITULO";
        public final static String COLUMN_NAME_DATA = "DATA";
        public final static String COLUMN_NAME_HORA = "HORA";
        public final static String COLUMN_NAME_FACILITADOR = "FACILITADOR";
        public final static String COLUMN_NAME_DESCRICAO = "DESCRICAO";
        public final static String CREATE_Evento =
                "CREATE TABLE " + Evento.TABLE_NAME + " ("
                        + Evento._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Evento.COLUMN_NAME_TITULO+ " TEXT, "
                        + Evento.COLUMN_NAME_DATA+ " TEXT, "
                        + Evento.COLUMN_NAME_HORA+ " TEXT, "
                        + Evento.COLUMN_NAME_FACILITADOR+ " TEXT, "
                        + Evento.COLUMN_NAME_DESCRICAO+ " TEXT "
                        +")";
        public final static String DROP_Evento = "DROP TABLE IF EXISTS "
                + Evento.TABLE_NAME;
    }
    public final class Participante implements BaseColumns{
        public final static String TABLE_NAME = "TB_PARTICIPANTE";
        public final static String COLUMN_NAME_NOME = "NOME";
        public final static String COLUMN_NAME_EMAIL = "EMAIL";
        public final static String COLUMN_NAME_CPF = "CPF";

        public final static String CREATE_Participante =
                "CREATE TABLE " + Participante.TABLE_NAME + " ("
                        + Participante._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Participante.COLUMN_NAME_NOME+ " TEXT, "
                        + Participante.COLUMN_NAME_EMAIL+ " INTEGER, "
                        + Participante.COLUMN_NAME_CPF+ " INTEGER "
                        +")";
        public final static String DROP_Participante = "DROP TABLE IF EXISTS "
                + Participante.TABLE_NAME;

    }

    public final class EventoParticipante implements BaseColumns{
        public final static String TABLE_NAME = "TB_EVENTOPARTICIPANTE";
        public final static String COLUMN_NAME_PARTICIPANTE = "ID_PARTICIPANTE";
        public final static String COLUMN_NAME_EVENTO = "ID_EVENTO";
        public final static String CREATE_EventoParticipante =
                "CREATE TABLE " + EventoParticipante.TABLE_NAME + " ("
                        + EventoParticipante._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + EventoParticipante.COLUMN_NAME_PARTICIPANTE+ " INTEGER, "
                        + EventoParticipante.COLUMN_NAME_EVENTO+ " INTEGER, "
                        +"CONSTRAINT FK_PARTICIPANTE_ID FOREIGN KEY("+EventoParticipante.COLUMN_NAME_PARTICIPANTE+") " +
                        "REFERENCES "+Evento.TABLE_NAME+"("+Evento._ID+"), "
                        +"CONSTRAINT FK_EVENTO_ID FOREIGN KEY("+EventoParticipante.COLUMN_NAME_EVENTO+") " +
                        "REFERENCES "+Participante.TABLE_NAME+"("+Participante._ID+"));";

        public final static String DROP_EventoParticipante = "DROP TABLE IF EXISTS "
                + EventoParticipante.TABLE_NAME;

    }
}
