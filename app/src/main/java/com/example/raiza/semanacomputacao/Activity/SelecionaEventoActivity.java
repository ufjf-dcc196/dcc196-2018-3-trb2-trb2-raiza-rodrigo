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
import com.example.raiza.semanacomputacao.SemCompDbHelper;

import java.util.List;

public class SelecionaEventoActivity extends AppCompatActivity {
    public static final String POSICAO_EVENTO = "Evento";
    private static final int REQUEST_INSERCAO = 1;
    private RecyclerView rvEvento;
    private long posicao;
    private SemCompDbHelper dbHelper;

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
        final Bundle bundleResultado = data.getExtras();
        posicao = bundleResultado.getLong(ListarPtcActivity.POSICAO_PARTICIPANTE);
        dbHelper = new SemCompDbHelper(getApplicationContext());
        final EventoAdapter adapter = new EventoAdapter(SemCompDbHelper.getCursorEventosParticipanteNãoInscrito(dbHelper.getReadableDatabase(),String.valueOf(posicao)));
        adapter.setOnShortEventoClickListener(new EventoAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = new Intent(SelecionaEventoActivity.this, InscreverParticipanteEventoActivity.class);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,posicao);
                intent.putExtra(SelecionaEventoActivity.POSICAO_EVENTO, adapter.getItemId(position));
                startActivityForResult(intent, SelecionaEventoActivity.REQUEST_INSERCAO);
            }
        });
        rvEvento.setAdapter(adapter);
    }
}
