package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.raiza.semanacomputacao.Adapter.EventoAdapter;
import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialEvento;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;


public class ListaEventoCadastradoActivity extends AppCompatActivity {
        private RecyclerView rvEvento;
        private Participante participante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_inscritos_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_inscritos);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        participante = (Participante)intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);


        /*final EventoAdapter adapter = new EventoAdapter(participante.getEvento());

        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Bundle bundleResultado = getIntent().getExtras();
                int posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
                int i= ListaInicialEvento.getInstance().indexOf(ListaInicialParticipante.getInstance().get(posicao).getEvento().get(position));

                ListaInicialEvento.getInstance().get(i).getParticipante().remove(ListaInicialParticipante.getInstance().get(posicao));
                ListaInicialParticipante.getInstance().get(posicao).getEvento().remove(position);
                participante.getEvento().remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        rvEvento.setAdapter(adapter);*/
    }
}
