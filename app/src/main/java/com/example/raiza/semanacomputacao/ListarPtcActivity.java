package com.example.raiza.semanacomputacao;

import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class ListarPtcActivity extends AppCompatActivity {
    public RecyclerView rvParticipante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_lista_layout);
        rvParticipante = (RecyclerView) findViewById(R.id.ptc_rcl_lista);
        rvParticipante.setLayoutManager(new LinearLayoutManager(this));
        final ParticipanteAdapter adapter = new ParticipanteAdapter(ListaParticipante.getInstance());
        adapter.setOnShortParticipanteClickListener(new ParticipanteAdapter.OnParticipanteClickListener() {
            @Override
            public void onParticipanteClick(View view, int position) {
                Toast.makeText(ListarPtcActivity.this, ListaParticipante.getInstance().get(position).getUsuario(), Toast.LENGTH_SHORT).show();
                ListaParticipante.getInstance().set(position, ListaParticipante.getInstance().get(position));
                ListaParticipante.getInstance().add(new Participante("item","",""));
                adapter.notifyItemChanged(position);
                ListaParticipante.getInstance().add(new Participante("item","",""));
                adapter.notifyItemChanged(ListaParticipante.getInstance().size()-1);
            }
        });
        rvParticipante.setAdapter(adapter);
    }
}
