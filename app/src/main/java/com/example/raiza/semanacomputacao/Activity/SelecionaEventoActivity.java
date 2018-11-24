package com.example.raiza.semanacomputacao.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.raiza.semanacomputacao.Adapter.EventoAdapter;
import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialEvento;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;

import java.util.List;

public class SelecionaEventoActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private static final int REQUEST_INSERCAO = 1;
    public static final String I =  "i";
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

       /* final EventoAdapter adapter = new EventoAdapter(lista);
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = getIntent().setClass(SelecionaEventoActivity.this, InscreverParticipanteEventoActivity.class);
                int i = ListaInicialEvento.getInstance().indexOf(lista.get(position));
                intent.putExtra(SelecionaEventoActivity.EVENTO, lista.get(position));
                intent.putExtra(SelecionaEventoActivity.I, i);
                startActivityForResult(intent, SelecionaEventoActivity.REQUEST_INSERCAO);
            }
        });
        rvEvento.setAdapter(adapter);*/
    }
}
