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
import com.example.raiza.semanacomputacao.SemCompDbHelper;


public class ListaEventoCadastradoActivity extends AppCompatActivity {
        private RecyclerView rvEvento;
        private long posicao;
        private SemCompDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_inscritos_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_inscritos);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundleResultado = getIntent().getExtras();
        posicao =  bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE);

        dbHelper = new SemCompDbHelper(getApplicationContext());

        final EventoAdapter adapter = new EventoAdapter(SemCompDbHelper.getCursorEventosParticipante(dbHelper.getReadableDatabase(),String.valueOf(posicao)));

        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                SemCompDbHelper.deleteEventoParticipante(dbHelper.getReadableDatabase(),String.valueOf(posicao),String.valueOf(adapter.getItemId(position)));
                adapter.notifyItemRemoved(position);
                adapter.SetCursor(SemCompDbHelper.getCursorEventosParticipante(dbHelper.getReadableDatabase(),String.valueOf(posicao)));
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
