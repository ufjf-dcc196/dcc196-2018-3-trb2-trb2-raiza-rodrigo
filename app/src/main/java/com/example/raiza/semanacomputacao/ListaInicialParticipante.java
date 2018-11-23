package com.example.raiza.semanacomputacao;

import com.example.raiza.semanacomputacao.Classes.Participante;

import java.util.ArrayList;
import java.util.List;

public class ListaInicialParticipante {

    private static List<Participante> participante;

    public static List<Participante> getInstance() {
            if(participante == null){

                participante = new ArrayList<>();
                participante.add(new Participante("Rodrigo Pituba de Souza","rodrigopituba@inventado.com","111.111.111-11"));
                participante.add(new Participante("Raiza Campos","raiza@inventado.com","222.222.222-22"));
                participante.add(new Participante("Bruno","bruno@inventado.com","333.333.333-33"));

            }

        return participante;

    }
}
