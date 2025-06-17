package com.cleanArchitected.cleanArch.core.interfaces;

import com.cleanArchitected.cleanArch.core.entities.Estudante;

public interface IEstudanteGateway {

    Estudante buscaPorNome(String nome);

    Estudante incluir(Estudante novoEstudante);
}
