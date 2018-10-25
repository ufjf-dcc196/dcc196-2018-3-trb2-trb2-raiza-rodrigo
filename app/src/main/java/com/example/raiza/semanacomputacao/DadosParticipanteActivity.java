package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DadosParticipanteActivity extends AppCompatActivity {
    private RecyclerView rvEvento;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtCPF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participante);
        Intent intent = getIntent();
        Participante participante = (Participante) intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);
        txtNome = (TextView) findViewById(R.id.txt_nome);
        txtEmail= (TextView) findViewById(R.id.txt_email);
        txtCPF = (TextView) findViewById(R.id.txt_cpf);
        rvEvento = (RecyclerView) findViewById(R.id.rcl_evento_participante_dados);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));
        final EventoAdapter adapter = new EventoAdapter(participante.getEvento());
        rvEvento.setAdapter(adapter);
        txtNome.setText(participante.getUsuario());
        txtEmail.setText(participante.getEmail());
        txtCPF.setText(participante.getCpf());
    }
}
