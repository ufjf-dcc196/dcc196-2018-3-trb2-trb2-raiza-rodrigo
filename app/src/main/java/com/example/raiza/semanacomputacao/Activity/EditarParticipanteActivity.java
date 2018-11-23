package com.example.raiza.semanacomputacao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raiza.semanacomputacao.Classes.Participante;
import com.example.raiza.semanacomputacao.ListaInicialParticipante;
import com.example.raiza.semanacomputacao.R;

public class EditarParticipanteActivity extends AppCompatActivity {
    public static final String EVENTO = "Evento";
    private static final int REQUEST_INSCRICAO = 1;
    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtEmail;
    private Button btnInscrever;
    private Button btnListaEvento;
    private Button btnEditar;
    private Participante participante;
    private int posicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptc_detalhes_layout);
        edtNome = findViewById(R.id.ptc_edt_nome);
        edtEmail = findViewById(R.id.ptc_edt_cpf);
        edtCpf = findViewById(R.id.ptc_edt_email);
        btnInscrever = findViewById(R.id.btn_ptc_inscricao_evt);

        final Intent intent = getIntent();
        Bundle bundleResultado = intent.getExtras();
        posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
        participante = (Participante)  intent.getSerializableExtra(ListarPtcActivity.PARTICIPANTE);

        edtNome.setText(participante.getUsuario());
        edtCpf.setText(participante.getCpf());
        edtEmail.setText(participante.getEmail());

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent().setClass(EditarParticipanteActivity.this, SelecionaEventoActivity.class);
                startActivity(intent);
            }
        });

        btnListaEvento = findViewById(R.id.ptc_lista_evt);
        btnListaEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarParticipanteActivity.this, ListaEventoCadastradoActivity.class);
                Bundle bundleResultado = getIntent().getExtras();
                posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
                participante = ListaInicialParticipante.getInstance().get(posicao);
                intent.putExtra(ListarPtcActivity.PARTICIPANTE,participante);
                intent.putExtra(ListarPtcActivity.POSICAO_PARTICIPANTE,posicao);
                startActivity(intent);
            }
        });

        btnEditar = findViewById(R.id.btn_ptc_editar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundleResultado = getIntent().getExtras();
                posicao = bundleResultado.getInt(ListarPtcActivity.POSICAO_PARTICIPANTE);
                ListaInicialParticipante.getInstance().get(posicao).setUsuario(String.valueOf(edtNome.getText()));
                ListaInicialParticipante.getInstance().get(posicao).setEmail(String.valueOf(edtEmail.getText()));
                ListaInicialParticipante.getInstance().get(posicao).setCpf(String.valueOf(edtCpf.getText()));
                Toast.makeText(EditarParticipanteActivity.this, "Edição Concluida", Toast.LENGTH_SHORT).show();


            }
        });

    }


}
