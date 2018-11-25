package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.raiza.semanacomputacao.Adapter.ParticipanteAdapter;
import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompContract;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class DadosEventoActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;
    private RecyclerView rvParticipante;
    private SemCompDbHelper dbHelper;
    private Bundle bundleResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_evento);
        dbHelper = new SemCompDbHelper(getApplicationContext());

        Intent intent = getIntent();
        txtTitulo = (TextView) findViewById(R.id.txt_titulo_evento);
        txtData= (TextView) findViewById(R.id.txt_data_evento);
        txtHora = (TextView) findViewById(R.id.txt_hora_evento);
        txtFacilitador = (TextView) findViewById(R.id.txt_facilitador_evento);
        txtDescricao = (TextView) findViewById(R.id.txt_descricao_evento);
        bundleResultado = getIntent().getExtras();
        rvParticipante = (RecyclerView) findViewById(R.id.TESTE);
        rvParticipante.setLayoutManager(new LinearLayoutManager(this));
        final ParticipanteAdapter adapter = new ParticipanteAdapter(SemCompDbHelper.getCursorParticipantesEvento(dbHelper.getReadableDatabase(),String.valueOf(bundleResultado.getLong(ListarEvtActivity.POSICAO_EVENTO))));
        rvParticipante.setAdapter(adapter);
        preencherCampos();

    }

    private void preencherCampos(){

        Cursor cursor = SemCompDbHelper.getCursorEventoId(dbHelper.getReadableDatabase(),String.valueOf(bundleResultado.getLong(ListarEvtActivity.POSICAO_EVENTO)));

        int idxNome = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_TITULO);
        int idxHora = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_HORA);
        int idxData = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_DATA);
        int idxDescricao = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_DESCRICAO);
        int idxFacilitador = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_FACILITADOR);

        cursor.moveToFirst();

        txtTitulo.setText(cursor.getString(idxNome));
        txtHora.setText( String.valueOf(cursor.getString(idxHora)));
        txtData.setText(cursor.getString(idxData));
        txtDescricao.setText(cursor.getString(idxDescricao));
        txtFacilitador.setText(cursor.getString(idxFacilitador));

    }
}
