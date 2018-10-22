package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class SelecionaEventoActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private RecyclerView rvEvento;
    Participante participante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_seleciona_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_cadastrados);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));
        List<Evento> lista = ListaInicialEvento.getInstance();
        participante = (Participante) getIntent().getSerializableExtra(ListarPtcActivity.PARTICIPANTE);

        for(int j = 0; j < lista.size();j++){
            for(int i = 0 ; i < participante.getEvento().size();i++){
                if(lista.get(j).getTitulo().equals(participante.getEvento().get(i).getTitulo())){
                    lista.remove(i);
                }
            }
        }

        final EventoAdapter adapter = new EventoAdapter(lista);
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = new Intent(SelecionaEventoActivity.this, InscreverParticipanteEventoActivity.class);
                intent.putExtra(SelecionaEventoActivity.EVENTO, ListaInicialEvento.getInstance().get(position));
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,participante);
                startActivity(intent);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
