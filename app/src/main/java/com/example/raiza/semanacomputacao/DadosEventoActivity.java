package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DadosEventoActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_evento);

        Intent intent = getIntent();
        Evento evento = (Evento) intent.getSerializableExtra(ListarEvtActivity.EVENTO);
        txtTitulo = (TextView) findViewById(R.id.txt_titulo_evento);
        txtData= (TextView) findViewById(R.id.txt_data_evento);
        txtHora = (TextView) findViewById(R.id.txt_hora_evento);
        txtFacilitador = (TextView) findViewById(R.id.txt_facilitador_evento);
        txtDescricao = (TextView) findViewById(R.id.txt_descricao_evento);

        txtTitulo.setText(evento.getTitulo());
        txtData.setText(evento.getData());
        txtHora.setText(evento.getHora());
        txtFacilitador.setText(evento.getFacilitador());
        txtDescricao.setText(evento.getDescricao());
    }
}
