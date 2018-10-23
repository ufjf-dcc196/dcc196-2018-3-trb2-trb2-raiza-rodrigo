package com.example.raiza.semanacomputacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarEventoActivity extends AppCompatActivity {
    private EditText edtTitulo;
    private EditText edtData;
    private EditText edtHora;
    private EditText edtFacilitador;
    private EditText edtDescricao;
    private Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evt_cadastro_layout);
        edtTitulo = (EditText) findViewById(R.id.evt_edt_titulo);
        edtData = (EditText) findViewById(R.id.evt_edt_dia);
        edtHora = (EditText) findViewById(R.id.evt_txt_hora_inscricao);
        edtFacilitador = (EditText) findViewById(R.id.evt_txt_facilitador_inscricao);
        edtDescricao = (EditText) findViewById(R.id.evt_txt_descricao_inscricao);

        btnSalvar = findViewById(R.id.evt_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListaInicialEvento.getInstance().add(new Evento(String.valueOf(edtTitulo.getText()),String.valueOf(edtData.getText()),String.valueOf(edtHora.getText()),String.valueOf(edtFacilitador.getText()),String.valueOf(edtDescricao.getText())));
                Toast.makeText(CadastrarEventoActivity.this, edtTitulo.getText() + " Cadastrado com sucesso, O numero de cadastrados é " + ListaInicialEvento.getInstance().size(), Toast.LENGTH_SHORT).show();
                edtTitulo.setText("");
                edtData.setText("");
                edtHora.setText("");
                edtFacilitador.setText("");
                edtDescricao.setText("");
                edtTitulo.requestFocus();
            }
        });
    }
}
