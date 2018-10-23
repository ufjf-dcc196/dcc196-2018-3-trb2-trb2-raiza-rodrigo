package com.example.raiza.semanacomputacao;

import android.app.Activity;
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
    private int posicao;

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
        Bundle bundleResultado = intent.getExtras();
        evento = (Evento) intent.getSerializableExtra(SelecionaEventoActivity.EVENTO);
        posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
        participante =(Participante) intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);

        txtTitulo.setText(txtTitulo.getText()+evento.getTitulo());
        txtHora.setText(txtHora.getText()+evento.getHora());
        txtData.setText(txtData.getText()+evento.getData());
        txtFacilitador.setText(txtFacilitador.getText()+evento.getFacilitador());
        txtDescricao.setText(txtDescricao.getText()+evento.getDescricao());

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ListaInicialParticipante.getInstance().get(posicao).getEvento().add(evento);
                participante.getEvento().add(evento);
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,participante);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,posicao);
                setResult(Activity.RESULT_OK,intent);
                Toast.makeText(InscreverParticipanteEventoActivity.this, evento.getTitulo() + " " +ListaInicialParticipante.getInstance().get(posicao).getUsuario() + " foi adicionado ao Evento.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
