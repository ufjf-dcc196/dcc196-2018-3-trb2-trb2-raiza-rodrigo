package com.example.raiza.semanacomputacao.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class CadastrarParticipanteActivity extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCpf;
    private Button btnSalvar;
    private TextView teste;
    private SemCompDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_cadastro_layout);
        edtNome = (EditText) findViewById(R.id.ptc_edt_nome);
        edtEmail = (EditText) findViewById(R.id.ptc_edt_email);
        edtCpf = (EditText) findViewById(R.id.ptc_edt_cpf);
        dbHelper = new SemCompDbHelper(getApplicationContext());

        btnSalvar = findViewById(R.id.btn_ptc_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                SemCompDbHelper.InserirParticipante(db,String.valueOf(edtNome.getText()),String.valueOf(edtEmail.getText()),String.valueOf(edtCpf.getText()));
                Toast.makeText(CadastrarParticipanteActivity.this, edtNome.getText() + " Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                edtCpf.setText("");
                edtEmail.setText("");
                edtNome.setText("");
                edtNome.requestFocus();
            }
        });


    }
}
