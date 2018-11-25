package com.example.raiza.semanacomputacao.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialEvento;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompContract;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class InscreverParticipanteEventoActivity extends AppCompatActivity {
    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;
    private Button btnInscrever;
    private SemCompDbHelper dbHelper;
    private long posicao;
    private long posicaoEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_inscricao_layout);

        txtTitulo = (TextView) findViewById(R.id.evt_txt_titulo_inscricao);
        txtData = (TextView) findViewById(R.id.evt_txt_dia_inscricao);
        txtHora = (TextView) findViewById(R.id.evt_txt_hora_inscricao);
        txtFacilitador = (TextView) findViewById(R.id.evt_txt_facilitador_inscricao);
        txtDescricao = (TextView) findViewById(R.id.evt_txt_descricao_inscricao);
        btnInscrever = (Button) findViewById(R.id.evt_btn_inscricao);

        final Intent intent = getIntent();
        Bundle bundleResultado = intent.getExtras();
        posicao = bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE);
        posicaoEvento = bundleResultado.getLong(SelecionaEventoActivity.POSICAO_EVENTO);
        preencherCampos();

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle resultado = getIntent().getExtras();
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,posicao);
                SemCompDbHelper.InserirParticipanteEvento(dbHelper.getReadableDatabase(),String.valueOf(posicao),String.valueOf(posicaoEvento));
                setResult(Activity.RESULT_OK,intent);
                Toast.makeText(InscreverParticipanteEventoActivity.this, txtTitulo.getText() + " foi adicionado.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void preencherCampos(){

        dbHelper = new SemCompDbHelper(getApplicationContext());

        Cursor cursor = SemCompDbHelper.getCursorEventoId(dbHelper.getReadableDatabase(),String.valueOf(posicaoEvento));

        int idxTitulo = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_TITULO);
        int idxHora = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_HORA);
        int idxData = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_DATA);
        int idxFacilitador = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_FACILITADOR);
        int idxDescricao = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_DESCRICAO);

        cursor.moveToFirst();

        txtTitulo.setText(cursor.getString(idxTitulo));
        txtHora.setText( String.valueOf(cursor.getString(idxHora)));
        txtData.setText(cursor.getString(idxData));
        txtFacilitador.setText(cursor.getString(idxFacilitador));
        txtDescricao.setText(cursor.getString(idxDescricao));


    }
}
