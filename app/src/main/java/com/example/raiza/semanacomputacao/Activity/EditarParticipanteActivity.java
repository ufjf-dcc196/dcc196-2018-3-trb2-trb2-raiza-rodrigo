package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompContract;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class EditarParticipanteActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private static final int REQUEST_INSCRICAO = 1;
    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtEmail;
    private Button btnInscrever;
    private Button btnListaEvento;
    private Button btnEditar;
    private long posicao;
    private SemCompDbHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_detalhes_layout);
        dbHelper = new SemCompDbHelper(getApplicationContext());
        edtNome = findViewById(R.id.ptc_edt_nome);
        edtEmail = findViewById(R.id.ptc_edt_email);
        edtCpf = findViewById(R.id.ptc_edt_cpf);
        btnInscrever = findViewById(R.id.btn_ptc_inscricao_evt);

        final Intent intent = getIntent();
        Bundle bundleResultado = intent.getExtras();
        posicao = bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE);

        preencherCampos();

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent().setClass(EditarParticipanteActivity.this, SelecionaEventoActivity.class);
                startActivity(intent);
            }
        });

        btnListaEvento = findViewById(R.id.ptc_lista_evt);
        btnListaEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarParticipanteActivity.this, ListaEventoCadastradoActivity.class);
                Bundle bundleResultado = getIntent().getExtras();
                posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,posicao);
                startActivity(intent);
            }
        });

        btnEditar = findViewById(R.id.btn_ptc_editar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ListaInicialParticipante.getInstance().get(posicao).setUsuario(String.valueOf(edtNome.getText()));
                //ListaInicialParticipante.getInstance().get(posicao).setEmail(String.valueOf(edtEmail.getText()));
                //ListaInicialParticipante.getInstance().get(posicao).setCpf(String.valueOf(edtCpf.getText()));
                //Toast.makeText(EditarParticipanteActivity.this, "Edição Concluida", Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void preencherCampos(){

        Cursor cursor = SemCompDbHelper.getCursorParticipanteId(dbHelper.getReadableDatabase(),String.valueOf(posicao));

        int idxNome = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_NOME);
        int idxEmail = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_EMAIL);
        int idxCpf = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_CPF);

        cursor.moveToFirst();

        edtNome.setText(cursor.getString(idxNome));
        edtEmail.setText( String.valueOf(cursor.getString(idxEmail)));
        edtCpf.setText(cursor.getString(idxCpf));

    }

}
