package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditarParticipanteActivity extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtEmail;
    private String nome;
    private String email;
    private String cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_detalhes_layout);
        edtNome = findViewById(R.id.ptc_edt_nome);
        edtEmail = findViewById(R.id.ptc_edt_cpf);
        edtCpf = findViewById(R.id.ptc_edt_email);
        final Intent intent = getIntent();
        Bundle bundleIntent = intent.getExtras();
        nome = (String) bundleIntent.getString(ListarPtcActivity.PARTICIPANTE_NOME);
        cpf = (String) bundleIntent.getString(ListarPtcActivity.PARTICIPANTE_CPF);
        email = (String) bundleIntent.getString(ListarPtcActivity.PARTICIPANTE_EMAIL);
        edtNome.setText(nome);
        edtCpf.setText(cpf);
        edtEmail.setText(email);

    }
}
