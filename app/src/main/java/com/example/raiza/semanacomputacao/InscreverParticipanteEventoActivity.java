package com.example.raiza.semanacomputacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InscreverParticipanteEventoActivity extends AppCompatActivity {
    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtFacilitador;
    private TextView txtDescricao;
    private Button btnInscrever;
    private Participante participante;
    private Evento evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_inscricao_layout);
        txtTitulo = (TextView) findViewById(R.id.evt_txt_titulo_inscricao);
        txtData = (TextView) findViewById(R.id.evt_txt_dia_inscricao);
        txtHora = (TextView) findViewById(R.id.evt_txt_hora_inscricao);
        txtFacilitador = (TextView) findViewById(R.id.evt_txt_facilitador_inscricao);
        txtDescricao = (TextView) findViewById(R.id.evt_txt_descricao_inscricao);
        btnInscrever = (Button) findViewById(R.id.evt_btn_inscricao);
        final Intent intent = getIntent();
        evento = (Evento) intent.getSerializableExtra(SelecionaEventoActivity.EVENTO);
        participante =(Participante) intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);
        txtTitulo.setText(txtTitulo.getText()+evento.getTitulo());
        txtHora.setText(txtHora.getText()+evento.getHora());
        txtData.setText(txtData.getText()+evento.getData());
        txtFacilitador.setText(txtFacilitador.getText()+evento.getFacilitador());
        txtDescricao.setText(txtDescricao.getText()+evento.getDescricao());

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTitulo.setText("");
                for (Participante p: ListaInicialParticipante.getInstance()) {
                    if(p.getCpf().equals(participante.getCpf())){
                        p.getEvento().add(evento);
                        Toast.makeText(InscreverParticipanteEventoActivity.this, p.getUsuario() + " foi adicionado ao Evento.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });

    }
}
