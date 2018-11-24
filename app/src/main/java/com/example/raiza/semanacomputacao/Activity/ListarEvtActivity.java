package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.raiza.semanacomputacao.Adapter.EventoAdapter;
import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.ListaInicialEvento;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompDbHelper;

public class ListarEvtActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    public SemCompDbHelper dbHelper;
    public RecyclerView rvEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_lista_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_lista);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new SemCompDbHelper(getApplicationContext());

        final EventoAdapter adapter = new EventoAdapter(SemCompDbHelper.getCursorEventos(dbHelper.getReadableDatabase()));
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = new Intent(ListarEvtActivity.this,DadosEventoActivity.class);
                intent.putExtra(ListarEvtActivity.EVENTO,(Evento) ListaInicialEvento.getInstance().get(position));
                startActivity(intent);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
