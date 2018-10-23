package com.example.raiza.semanacomputacao;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarParticipanteActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private static final int REQUEST_INSCRICAO = 1;
    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtEmail;
    private Button btnInscrever;
    private Button btnListaEvento;
    private Participante participante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_detalhes_layout);
        edtNome = findViewById(R.id.ptc_edt_nome);
        edtEmail = findViewById(R.id.ptc_edt_cpf);
        edtCpf = findViewById(R.id.ptc_edt_email);
        btnInscrever = findViewById(R.id.btn_ptc_inscricao_evt);
        final Intent intent = getIntent();

        participante = (Participante)  intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);
        edtNome.setText(participante.getUsuario());
        edtCpf.setText(participante.getCpf());
        edtEmail.setText(participante.getEmail());

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarParticipanteActivity.this, SelecionaEventoActivity.class);
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,participante);
                startActivity(intent);
            }
        });

        btnListaEvento = findViewById(R.id.ptc_lista_evt);
        btnListaEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarParticipanteActivity.this, ListaEventoCadastradoActivity.class);
                for(int i = 0; i < ListaInicialParticipante.getInstance().size();i++) {
                    if (participante.getCpf().equals(ListaInicialParticipante.getInstance().get(i).getCpf())) {
                        participante = ListaInicialParticipante.getInstance().get(i);
                        break;
                    }
                }
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,participante);
                startActivity(intent);
            }
        });

    }


}
