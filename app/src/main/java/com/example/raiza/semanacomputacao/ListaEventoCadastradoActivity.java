package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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


        final EventoAdapter adapter = new EventoAdapter(participante.getEvento());
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Toast.makeText(ListaEventoCadastradoActivity.this, "Entrou", Toast.LENGTH_SHORT).show();
                participante.getEvento().remove(position);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
