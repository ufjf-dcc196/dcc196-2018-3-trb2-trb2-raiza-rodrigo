package com.example.raiza.semanacomputacao;

import java.util.ArrayList;
import java.util.List;

public class ListaInicialEvento {

    private static List<Evento> evento;

    public static List<Evento> getInstance() {
        if(evento == null){

            evento = new ArrayList<>();
            evento.add(new Evento("Ciências de Dados e Aplicações em Bancos","10/10/2010","11:00","Tales Lima","Os clientes bancários movimentam uma grande parcela da economia brasileira, a 8ª maior economia do mundo, gerando uma grande quantidade de dados que são utilizados para atender cada vez melhor os seus clientes."));
            evento.add(new Evento("Como lidar com grande volume de dados no dia-a-dia","11/11/2011","11:00","Frederick Moschkowich","Muito se fala em persistência e consistência de dados, mas como isso funciona no dia-a-dia da Indústria?"));

        }

        return evento;

    }
}
