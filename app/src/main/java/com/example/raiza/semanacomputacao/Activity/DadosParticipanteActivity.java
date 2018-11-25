package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.raiza.semanacomputacao.Adapter.EventoAdapter;
import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.MainActivity;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompContract;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class DadosParticipanteActivity extends AppCompatActivity {
    private RecyclerView rvEvento;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtCPF;
    private SemCompDbHelper dbHelper;
    private Intent intent;
    private Bundle bundleResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participante);

        dbHelper = new SemCompDbHelper(getApplicationContext());
        intent = getIntent();
        bundleResultado = intent.getExtras();
        txtNome = (TextView) findViewById(R.id.txt_nome);
        txtEmail= (TextView) findViewById(R.id.txt_email);
        txtCPF = (TextView) findViewById(R.id.txt_cpf);
        rvEvento = (RecyclerView) findViewById(R.id.rcl_evento_participante_dados);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));
        final EventoAdapter adapter = new EventoAdapter(SemCompDbHelper.getCursorEventosParticipante(dbHelper.getReadableDatabase(),String.valueOf(bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE))));
        rvEvento.setAdapter(adapter);
        preencherCampos();
    }

    private void preencherCampos(){

        Cursor cursor = SemCompDbHelper.getCursorParticipanteId(dbHelper.getReadableDatabase(),String.valueOf(bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE)));

        int idxNome = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_NOME);
        int idxEmail = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_EMAIL);
        int idxCpf = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_CPF);

        cursor.moveToFirst();

        txtNome.setText(cursor.getString(idxNome));
        txtEmail.setText( String.valueOf(cursor.getString(idxEmail)));
        txtCPF.setText(cursor.getString(idxCpf));

    }
}
