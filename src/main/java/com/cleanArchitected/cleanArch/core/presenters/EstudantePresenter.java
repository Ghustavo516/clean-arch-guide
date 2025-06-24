package com.cleanArchitected.cleanArch.core.presenters;

import com.cleanArchitected.cleanArch.core.dto.EstudanteDTO;
import com.cleanArchitected.cleanArch.core.entities.Estudante;

public class EstudantePresenter {

    /* A responsabilidade da o presenter e realizar a formatação e deixar pronto para quem realizou a requisição*/

    public static EstudanteDTO toDTO(Estudante estudante){
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        EstudanteDTO estudanteDTO = new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEmail()
        );

        return estudanteDTO;
    }
}
