package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class SelecionaEventoActivity extends AppCompatActivity {
    public static final String EVENTO_TITULO = "Título Evento";
    public static final String EVENTO_DATA = "Data Evento";
    public static final String EVENTO_HORA = "Hora Evento";
    public static final String EVENTO_FACILITADOR = "Facilitador Evento";
    public static final String EVENTO_DESCRICAO = "Descrição Evento";
    private RecyclerView rvEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_seleciona_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_cadastrados);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));

        final EventoAdapter adapter = new EventoAdapter(ListaInicialEvento.getInstance());
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = new Intent(SelecionaEventoActivity.this, InscreverParticipanteEventoActivity.class);
                intent.putExtra(SelecionaEventoActivity.EVENTO_TITULO, ListaInicialEvento.getInstance().get(position).getTitulo());
                intent.putExtra(SelecionaEventoActivity.EVENTO_DATA, ListaInicialEvento.getInstance().get(position).getData());
                intent.putExtra(SelecionaEventoActivity.EVENTO_HORA, ListaInicialEvento.getInstance().get(position).getHora());
                intent.putExtra(SelecionaEventoActivity.EVENTO_FACILITADOR, ListaInicialEvento.getInstance().get(position).getFacilitador());
                intent.putExtra(SelecionaEventoActivity.EVENTO_DESCRICAO, ListaInicialEvento.getInstance().get(position).getDescricao());
                startActivity(intent);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
