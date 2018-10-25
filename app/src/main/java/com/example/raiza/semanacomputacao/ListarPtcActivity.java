package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;



public class ListarPtcActivity extends AppCompatActivity {
    public static final String PARTICIPANTE = "Participante";
    public static final String POSICAO_PARTICIPANTE = "Posição Participante";


    public RecyclerView rvParticipante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_lista_layout);
        rvParticipante = (RecyclerView) findViewById(R.id.ptc_rcl_lista);
        rvParticipante.setLayoutManager(new LinearLayoutManager(this));



        final ParticipanteAdapter adapter = new ParticipanteAdapter(ListaInicialParticipante.getInstance());
        adapter.setOnParticipanteClickListener(new ParticipanteAdapter.OnParticipanteClickListener() {
            @Override
            public void onParticipanteClick(View view, int position) {
                Intent intent = new Intent(ListarPtcActivity.this,DadosParticipanteActivity.class);
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,(Participante) ListaInicialParticipante.getInstance().get(position));
                startActivity(intent);
            }

            @Override
            public void onLongParticipanteClick(View view, int position) {
                Intent intent = new Intent(ListarPtcActivity.this, EditarParticipanteActivity.class);
                intent.putExtra(ListarPtcActivity.PARTICIPANTE, (Participante) ListaInicialParticipante.getInstance().get(position));
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE, position);
                startActivity(intent);
            }
        });

        rvParticipante.setAdapter(adapter);
    }
}
