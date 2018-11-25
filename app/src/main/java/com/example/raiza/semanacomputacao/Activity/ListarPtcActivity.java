package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.raiza.semanacomputacao.Adapter.ParticipanteAdapter;
import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompDbHelper;


public class ListarPtcActivity extends AppCompatActivity {
    public static final String PARTICIPANTE = "Participante";
    public static final String POSICAO_PARTICIPANTE = "Posição Participante";
    private static final int REQUEST_EDICAO = 1;
    private SemCompDbHelper dbHelper;
    private ParticipanteAdapter adapter;



    public RecyclerView rvParticipante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_lista_layout);
        rvParticipante = (RecyclerView) findViewById(R.id.ptc_rcl_lista);
        rvParticipante.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new SemCompDbHelper(getApplicationContext());

        adapter = new ParticipanteAdapter(SemCompDbHelper.getCursorParticipante(dbHelper.getReadableDatabase()));
        adapter.setOnParticipanteClickListener(new ParticipanteAdapter.OnParticipanteClickListener() {
            @Override
            public void onParticipanteClick(View view, int position) {
                Intent intent = new Intent(ListarPtcActivity.this,DadosParticipanteActivity.class);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,adapter.getItemId(position));
                startActivity(intent);
            }

            @Override
            public void onLongParticipanteClick(View view, int position) {
                Intent intent = new Intent(ListarPtcActivity.this, EditarParticipanteActivity.class);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,adapter.getItemId(position));
                startActivityForResult(intent,ListarPtcActivity.REQUEST_EDICAO);
            }
        });

        rvParticipante.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.SetCursor(SemCompDbHelper.getCursorParticipante(dbHelper.getReadableDatabase()));
    }
}
