package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DadosEventoActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;
    private RecyclerView rvParticipante;

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
        rvParticipante = (RecyclerView) findViewById(R.id.TESTE);
        rvParticipante.setLayoutManager(new LinearLayoutManager(this));
        final ParticipanteAdapter adapter = new ParticipanteAdapter(evento.getParticipante());
        rvParticipante.setAdapter(adapter);
        txtTitulo.setText(txtTitulo.getText() + evento.getTitulo());
        txtData.setText(txtData.getText()+evento.getData());
        txtHora.setText(txtHora.getText()+evento.getHora());
        txtFacilitador.setText(txtFacilitador.getText()+evento.getFacilitador());
        txtDescricao.setText(txtDescricao.getText()+evento.getDescricao());
    }
}
