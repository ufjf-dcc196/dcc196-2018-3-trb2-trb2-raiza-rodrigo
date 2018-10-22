package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InscreverParticipanteEventoActivity extends AppCompatActivity {
    private String titulo;
    private String data;
    private String hora;
    private String facilitador;
    private String descricao;
    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;
    private Button btnInscrever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_inscricao_layout);
        txtTitulo = findViewById(R.id.evt_txt_titulo_inscricao);
        txtData = findViewById(R.id.evt_txt_dia_inscricao);
        txtHora = findViewById(R.id.evt_txt_hora_inscricao);
        txtFacilitador = findViewById(R.id.evt_txt_facilitador_inscricao);
        txtDescricao = findViewById(R.id.evt_txt_descricao_inscricao);
        btnInscrever = findViewById(R.id.evt_btn_inscricao);
        final Intent intent = getIntent();
        Bundle bundleIntent = intent.getExtras();
        titulo = (String) bundleIntent.getString(SelecionaEventoActivity.EVENTO_TITULO);
        data = (String) bundleIntent.getString(SelecionaEventoActivity.EVENTO_DATA);
        hora = (String) bundleIntent.getString(SelecionaEventoActivity.EVENTO_HORA);
        facilitador = (String) bundleIntent.getString(SelecionaEventoActivity.EVENTO_FACILITADOR);
        descricao = (String) bundleIntent.getString(SelecionaEventoActivity.EVENTO_DESCRICAO);
        txtTitulo.setText(txtTitulo.getText()+titulo);
        txtHora.setText(txtHora.getText()+hora);
        txtData.setText(txtData.getText()+data);
        txtFacilitador.setText(txtFacilitador.getText()+facilitador);
        txtDescricao.setText(txtDescricao.getText()+descricao);
        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}
