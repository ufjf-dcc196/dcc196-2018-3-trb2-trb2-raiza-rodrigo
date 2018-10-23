package com.example.raiza.semanacomputacao;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class SelecionaEventoActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private static final int REQUEST_INSERCAO = 1;
    private RecyclerView rvEvento;
    private int posicao;
    private Participante participante;
    private List<Evento> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_seleciona_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_cadastrados);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));

        final Intent intent = getIntent();
        listarEventosNaoInscritos(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_INSERCAO && resultCode == Activity.RESULT_OK && data != null){
            listarEventosNaoInscritos(data);
        }
    }

    private void listarEventosNaoInscritos(Intent data) {
        Bundle bundleResultado = data.getExtras();
        posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
        participante = ListaInicialParticipante.getInstance().get(posicao);
        lista = ListaInicialEvento.getEventosParticipante(participante);

        final EventoAdapter adapter = new EventoAdapter(lista);
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = getIntent().setClass(SelecionaEventoActivity.this, InscreverParticipanteEventoActivity.class);
                intent.putExtra(SelecionaEventoActivity.EVENTO, lista.get(position));
                startActivityForResult(intent, SelecionaEventoActivity.REQUEST_INSERCAO);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
