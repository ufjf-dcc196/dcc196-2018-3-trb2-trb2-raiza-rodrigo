package com.example.raiza.semanacomputacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class ListarEvtActivity extends AppCompatActivity {
    public RecyclerView rvEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_lista_layout);
        rvEvento = (RecyclerView) findViewById(R.id.evt_rcl_lista);
        rvEvento.setLayoutManager(new LinearLayoutManager(this));


        final EventoAdapter adapter = new EventoAdapter(ListaInicialEvento.getInstance());
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {

            }
        });
        rvEvento.setAdapter(adapter);
    }
}
