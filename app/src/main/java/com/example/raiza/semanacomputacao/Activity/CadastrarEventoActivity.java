package com.example.raiza.semanacomputacao.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.ListaInicialEvento;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class CadastrarEventoActivity extends AppCompatActivity {
    private EditText edtTitulo;
    private EditText edtData;
    private EditText edtHora;
    private EditText edtFacilitador;
    private EditText edtDescricao;
    private Button btnSalvar;
    private SemCompDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_cadastro_layout);
        edtTitulo = (EditText) findViewById(R.id.evt_edt_titulo);
        edtData = (EditText) findViewById(R.id.evt_edt_dia);
        edtHora = (EditText) findViewById(R.id.evt_txt_hora_inscricao);
        edtFacilitador = (EditText) findViewById(R.id.evt_txt_facilitador_inscricao);
        edtDescricao = (EditText) findViewById(R.id.evt_txt_descricao_inscricao);
        dbHelper = new SemCompDbHelper(getApplicationContext());

        btnSalvar = findViewById(R.id.evt_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                SemCompDbHelper.InserirEvento(db,String.valueOf(edtTitulo.getText()),String.valueOf(edtData.getText()),String.valueOf(edtHora.getText()),String.valueOf(edtFacilitador.getText()),String.valueOf(edtDescricao.getText()));
                Toast.makeText(CadastrarEventoActivity.this, edtTitulo.getText() + " Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                edtTitulo.setText("");
                edtData.setText("");
                edtHora.setText("");
                edtFacilitador.setText("");
                edtDescricao.setText("");
                edtTitulo.requestFocus();
            }
        });
    }
}
